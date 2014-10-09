package br.com.formento.garagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("login")
	public String login() {
		return "login";
	}

	@RequestMapping("fazerLogin")
	public String fazerLogin() {
		return "redirect:garagemLista";
	}

	@RequestMapping("fazerLogoff")
	public String fazerLogoff() {
		return "login";
	}

}