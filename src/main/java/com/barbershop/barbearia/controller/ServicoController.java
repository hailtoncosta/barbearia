package com.barbershop.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		modelAndView.addObject("objservicos", new Servico());
		return modelAndView;
	}
	
	@PostMapping("/salvarservico")
	public ModelAndView salvarservicos(Servico servico) {
		servicoRepository.save(servico);
		return iniciarServico();
	}
	
	@GetMapping("/listarservicos")
	public ModelAndView listarservicos() {
		ModelAndView modelAndView = new ModelAndView("listarservicos");
		modelAndView.addObject("listarservicos", servicoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/editarservicos/{id}")
	public ModelAndView editarservicos(@PathVariable("id") Long id) {
		
		Optional<Servico> servico = servicoRepository.findById(id);
		ModelAndView modelAndView = new ModelAndView("cadservico");
		modelAndView.addObject("objservicos", servico.get());
		return modelAndView;
	}
	
	@GetMapping("/excluirservicos/{id}")
	public ModelAndView excluirservicos(@PathVariable("id") Long id) {
		servicoRepository.deleteById(id);
		return new ModelAndView("redirect:/listarservicos");
	}
}
