package com.example.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.RecetaService;
import com.example.demo.models.Receta;
import com.example.demo.models.Usuario;

@RestController
@RequestMapping("/recetas")
public class RecetaController {
	@Autowired
	RecetaService recetaService;
	
	@PostMapping("/subir")
	public ResponseEntity<?> subirReceta(@RequestParam Long usuarioId, @RequestBody Receta receta) {
	    try {
	        Receta nuevaReceta = recetaService.subirReceta(usuarioId, receta.getNombre(), receta.getDescripcion(), receta.getPorciones());
	        return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED);
	    } catch (IllegalArgumentException e) {
	        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}
}
