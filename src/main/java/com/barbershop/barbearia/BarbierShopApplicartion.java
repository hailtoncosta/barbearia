package com.barbershop.barbearia;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BarbierShopApplicartion {
	
	@GetMapping("/index")
	public ModelAndView inicioAplication() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@GetMapping("/login")
	public ModelAndView telaLogin() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
}
