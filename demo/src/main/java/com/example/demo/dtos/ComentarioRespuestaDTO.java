package com.example.demo.dtos;


import java.time.LocalDateTime;

public class ComentarioRespuestaDTO {
    public Long id;
    public String aliasUsuario;
    public String nombreReceta;
    public String comentario;
    public Integer puntuacion;
    public LocalDateTime fecha;
    public Boolean aprobado;

    public ComentarioRespuestaDTO(Long id, String aliasUsuario, String nombreReceta, String comentario, Integer puntuacion, LocalDateTime fecha, Boolean aprobado) {
        this.id = id;
        this.aliasUsuario = aliasUsuario;
        this.nombreReceta = nombreReceta;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
        this.fecha = fecha;
        this.aprobado = aprobado;
    }
}