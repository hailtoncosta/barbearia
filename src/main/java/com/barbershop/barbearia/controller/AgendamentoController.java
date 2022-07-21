package com.barbershop.barbearia.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.barbershop.barbearia.model.Agendamento;
import com.barbershop.barbearia.model.Cliente;
import com.barbershop.barbearia.model.Servico;
import com.barbershop.barbearia.repository.AgendamentoRepository;
import com.barbershop.barbearia.repository.ClienteRepository;
import com.barbershop.barbearia.repository.ServicoRepository;

@Controller
public class AgendamentoController {
	
	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ServicoRepository servicoRepository;
	
	@GetMapping("/cadagendamento")
	public ModelAndView iniciarAgendamento() {
		ModelAndView modelAndView = new ModelAndView("cadagendamento");
		modelAndView.addObject("objagendamento", new Agendamento());
		modelAndView.addObject("listaclientes", clienteRepository.findAll());
		modelAndView.addObject("listaservicos", servicoRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/salvaragendamento")
	public ModelAndView salvaragendamento(Agendamento agendamento) {
		agendamentoRepository.save(agendamento);
		return iniciarAgendamento();
	}
	
	@GetMapping("/listaragendamento")
	public ModelAndView listaragendamento() {
		ModelAndView modelAndView = new ModelAndView("listaragendamento");
		modelAndView.addObject("listaragendamento", agendamentoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/cadgendamento/{id}")
	public ModelAndView editarAgendamento(@PathVariable("id") Long id) {
		Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
		ModelAndView modelAndView = new ModelAndView("cadagendamento");
		modelAndView.addObject("objagendamento", agendamento.get());
		modelAndView.addObject("listaclientes", clienteRepository.findAll());
		modelAndView.addObject("listaservicos", servicoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/excluirAgendamento/{id}")
	public ModelAndView excluirAgendamento(@PathVariable("id") Long id) {
		agendamentoRepository.deleteById(id);
		return new ModelAndView("redirect:/listaragendamento");
	}
}
