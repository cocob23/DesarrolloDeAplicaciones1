package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.LikeReceta;
import com.example.demo.models.Receta;
import com.example.demo.models.Usuario;

public interface LikeRecetaRepository extends JpaRepository<LikeReceta, Long> {
    boolean existsByUsuarioAndReceta(Usuario usuario, Receta receta);
    long countByReceta(Receta receta);
}
