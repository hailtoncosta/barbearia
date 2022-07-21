package com.barbershop.barbearia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.barbershop.barbearia.model.Servico;
import com.barbershop.barbearia.repository.ServicoRepository;

@Controller
public class ServicoController {
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping("/cadservico")
	public ModelAndView iniciarServico() {
		ModelAndView modelAndView = new ModelAndView("cadservico");
		return modelAndView;
	}
	
	@PostMapping("/salvarservico")
	public ModelAndView salvarservicos(Servico servico) {
		servicoRepository.save(servico);
		return iniciarServico();
	}
}
