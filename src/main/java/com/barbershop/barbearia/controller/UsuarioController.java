package com.barbershop.barbearia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.barbershop.barbearia.model.Usuario;
import com.barbershop.barbearia.repository.UsuarioRepository;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/cadusuario")
	public ModelAndView inicioUsuario() {
		ModelAndView modelAndView = new ModelAndView("cadusuario");
		return modelAndView;
	}
	
	@PostMapping("/salvarusuario")
	public ModelAndView salvarUsuarios(Usuario usuario) {
		usuarioRepository.save(usuario);
		return inicioUsuario();
	}
}
