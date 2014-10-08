package br.com.formento.garagem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InvestimentoController {

	@RequestMapping("investimentoServico")
	public String investimentoServico() {
		return "investimento/investimentoServico";
	}

	@RequestMapping("investimentoPeca")
	public String investimentoPeca() {
		return "investimento/investimentoPeca";
	}

}
