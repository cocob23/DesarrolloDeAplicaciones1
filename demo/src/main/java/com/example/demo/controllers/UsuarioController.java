package com.example.demo.controllers;


import java.util.List;

import com.example.demo.models.Usuario;
import com.example.demo.services.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/todos")
	public List<Usuario> obtenerTodos(){
		return usuarioService.obtenerTodos();
	}
}
