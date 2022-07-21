package com.barbershop.barbearia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.barbershop.barbearia.model.Cliente;
import com.barbershop.barbearia.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cadcliente")
	public ModelAndView iniciarCliente() {
		ModelAndView modelAndView = new ModelAndView("cadcliente");
		return modelAndView;
	}
	
	@PostMapping("/salvarcliente")
	public ModelAndView salvarClientes(Cliente cliente) {
		clienteRepository.save(cliente);
		ModelAndView modelAndView = new ModelAndView("cadcliente");
		return modelAndView;
	}
	
}
