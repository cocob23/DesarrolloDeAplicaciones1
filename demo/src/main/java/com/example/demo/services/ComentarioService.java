package com.example.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ComentarioRespuestaDTO;
import com.example.demo.models.Comentario;
import com.example.demo.models.Receta;
import com.example.demo.models.Usuario;
import com.example.demo.repositories.ComentarioRepository;
import com.example.demo.repositories.RecetaRepository;
import com.example.demo.repositories.UsuarioRepository;

@Service
public class ComentarioService {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RecetaRepository recetaRepository;

    public ComentarioRespuestaDTO agregarComentario(Long usuarioId, Long recetaId, Integer puntuacion, String texto) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Receta receta = recetaRepository.findById(recetaId).orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        Comentario comentario = new Comentario();
        comentario.setUsuario(usuario);
        comentario.setReceta(receta);
        comentario.setPuntuacion(puntuacion);
        comentario.setComentario(texto);
        comentario.setAprobado(false);
        comentario.setFecha(LocalDateTime.now());

        comentarioRepository.save(comentario);

        return new ComentarioRespuestaDTO(
            comentario.getId(),
            usuario.getAlias(),
            receta.getNombre(),
            comentario.getComentario(),
            comentario.getPuntuacion(),
            comentario.getFecha(),
            comentario.getAprobado()
        );
    }

    public List<ComentarioRespuestaDTO> obtenerPendientes() {
        return comentarioRepository.findAll().stream()
            .filter(c -> !c.getAprobado())
            .map(c -> new ComentarioRespuestaDTO(
                c.getId(),
                c.getUsuario().getAlias(),
                c.getReceta().getNombre(),
                c.getComentario(),
                c.getPuntuacion(),
                c.getFecha(),
                c.getAprobado()
            ))
            .toList();
    }

    public void aprobarComentario(Long id) {
        Comentario c = comentarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Comentario no encontrado"));
        c.setAprobado(true);
        comentarioRepository.save(c);
    }

    public void eliminarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
    

public List<ComentarioRespuestaDTO> obtenerAprobadosPorReceta(Long recetaId) {
    List<Comentario> comentarios = comentarioRepository.findByRecetaIdAndAprobadoTrue(recetaId);
    return comentarios.stream()
        .map(c -> new ComentarioRespuestaDTO(
            c.getId(),
            c.getUsuario().getAlias(),
            c.getReceta().getNombre(),
            c.getComentario(),
            c.getPuntuacion(),
            c.getFecha(),
            c.getAprobado()
        ))
        .collect(Collectors.toList());
}
}
