package br.com.formento.garagem.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.garagem.enums.EMetodoCalculoMatriz;
import br.com.formento.garagem.modelo.Matriz;
import br.com.formento.garagem.modelo.MatrizParametro;

@Controller
public class MatrizController {

	@RequestMapping("matriz")
	public String matriz(Model model) {
		model.addAttribute("matrizParametro", new MatrizParametro(3, 3));

		return "calculo/matriz/inicio";
	}

	@RequestMapping("valoresMatriz")
	public String calcularMatriz(@Valid MatrizParametro matrizParametro, BindingResult result, Model model) {
		if (result.hasFieldErrors("tamanho"))
			return "calculo/matriz/inicio";

		Matriz matriz = new Matriz(matrizParametro);

		model.addAttribute("matriz", matriz);
		model.addAttribute("eMetodoCalculoMatriz", EMetodoCalculoMatriz.values());

		return "calculo/matriz/valores";
	}

}
