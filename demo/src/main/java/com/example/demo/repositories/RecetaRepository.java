package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Long> {
	List<Receta> findByNombreContainingIgnoreCase(String nombre);
	Optional<Receta> findById(Long id);
	List<Receta> findByTipoIgnoreCase(String tipo);
	@Query("SELECT ri.receta FROM RecetaIngrediente ri WHERE LOWER(ri.ingrediente.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
	List<Receta> findRecetasByIngredienteNombre(@Param("nombre") String nombre);

}
