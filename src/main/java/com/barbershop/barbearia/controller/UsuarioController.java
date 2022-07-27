package com.barbershop.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		modelAndView.addObject("objusuario", new Usuario());
		return modelAndView;
	}
	
	@PostMapping("/salvarusuario")
	public ModelAndView salvarUsuarios(Usuario usuario) {
		usuarioRepository.save(usuario);
		return inicioUsuario();
	}
	
	@GetMapping("/listarusuario")
	public ModelAndView listarusuario() {
		ModelAndView modelAndView = new ModelAndView("listarusuario");
		modelAndView.addObject("listarusuario", usuarioRepository.findAll(PageRequest.of(0, 6, Sort.by("nome"))));
		return modelAndView;
	}
	
	@GetMapping("/editarusuario/{id}")
	public ModelAndView editarcliente(@PathVariable("id") Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		ModelAndView modelAndView = new ModelAndView("cadusuario");
		modelAndView.addObject("objusuario", usuario.get());
		return modelAndView;
	}
	
	@GetMapping("/excluirusuario/{id}")
	public ModelAndView excluircliente(@PathVariable("id") Long id) {
		usuarioRepository.deleteById(id);
		return new ModelAndView("redirect:/listarusuario");
	}
	
	@GetMapping("/usuariopag")
	public ModelAndView carregarUsuarioPorPaginacao(@PageableDefault(size = 6) Pageable pageable, ModelAndView modelAndView) {
		Page<Usuario> pageUsuario = usuarioRepository.findAll(pageable);
		modelAndView.addObject("listarusuario", pageUsuario);
		modelAndView.addObject("objusuario", new Usuario());
		modelAndView.setViewName("listarusuario");
		return modelAndView;
	}
}
