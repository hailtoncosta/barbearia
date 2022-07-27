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

import com.barbershop.barbearia.model.Cliente;
import com.barbershop.barbearia.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/cadcliente")
	public ModelAndView iniciarCliente() {
		ModelAndView modelAndView = new ModelAndView("cadcliente");
		modelAndView.addObject("objcliente", new Cliente());
		return modelAndView;
	}
	
	@PostMapping("/salvarcliente")
	public ModelAndView salvarClientes(Cliente cliente) {
		clienteRepository.save(cliente);
		return iniciarCliente();
	}
	
	@GetMapping("/listarcliente")
	public ModelAndView listarcliente() {
		ModelAndView modelAndView = new ModelAndView("listarcliente");
		modelAndView.addObject("listarcliente", clienteRepository.findAll(PageRequest.of(0, 6, Sort.by("nome"))));
		return modelAndView;
	}
	
	@GetMapping("/editarcliente/{id}")
	public ModelAndView editarcliente(@PathVariable("id") Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		ModelAndView modelAndView = new ModelAndView("cadcliente");
		modelAndView.addObject("objcliente", cliente.get());
		return modelAndView;
	}
	
	@GetMapping("/excluircliente/{id}")
	public ModelAndView excluircliente(@PathVariable("id") Long id) {
		clienteRepository.deleteById(id);
		return new ModelAndView("redirect:/listarcliente");
	}
	
	@GetMapping("/clientepag")
	public ModelAndView carregarClientePorPaginacao(@PageableDefault(size = 6) Pageable pageable, ModelAndView modelAndView) {
		Page<Cliente> pageCliente = clienteRepository.findAll(pageable);
		modelAndView.addObject("listarcliente", pageCliente);
		modelAndView.addObject("objcliente", new Cliente());
		modelAndView.setViewName("listarcliente");
		return modelAndView;
	}
}
