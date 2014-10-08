package br.com.formento.garagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GaragemController {

	@RequestMapping("garagemCadastro")
	public String garagemCadastro() {
		return "garagem/garagemCadastro";
	}

	@RequestMapping("garagemLista")
	public String garagemLista() {
		return "garagem/garagemLista";
	}

}
