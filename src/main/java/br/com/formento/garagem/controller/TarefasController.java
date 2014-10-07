package br.com.formento.garagem.controller;

import java.util.Collection;
import java.util.HashSet;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.formento.garagem.modelo.Tarefa;

@Controller
public class TarefasController {

	private static final Collection<Tarefa> listaDeTarefas;
	private static long lastId = 0l;

	static {
		listaDeTarefas = new HashSet<Tarefa>();

		reiniciar();
	}

	private static void reiniciar() {
		listaDeTarefas.clear();

		merge(new Tarefa("Estudar"));
		merge(new Tarefa("Arrumar a casa"));
		merge(new Tarefa("XX"));
		merge(new Tarefa("Lavar a roupa"));
		merge(new Tarefa("Descansar"));
	}

	private static void merge(Tarefa tarefa) {
		if (tarefa.getId() == null) {
			lastId++;
			tarefa.setId(lastId);
		}
		listaDeTarefas.add(tarefa);
	}

	@RequestMapping("novaTarefa")
	public String form() {
		return "tarefa/formulario";
	}

	@RequestMapping("adicionaTarefa")
	public String adicionaTarefa(@Valid Tarefa tarefa, BindingResult result) {
		if (result.hasFieldErrors("descricao"))
			return "tarefa/formulario";

		merge(tarefa);

		return "tarefa/adicionada";
	}

	@RequestMapping("listaTarefas")
	public String lista(Model model) {
		model.addAttribute("tarefas", listaDeTarefas);
		return "tarefa/lista";
	}

	@RequestMapping("removeTarefa")
	public String remove(Tarefa tarefa) {
		listaDeTarefas.remove(tarefa);

		return "redirect:listaTarefas";
	}

	@RequestMapping("finalizaTarefa")
	public String finaliza(Long id, HttpServletResponse response, Model model) {
		for (Tarefa tarefa : listaDeTarefas)
			if (tarefa.getId().equals(id)) {
				tarefa.finalizar();
				model.addAttribute("tarefa", tarefa);
			}
		return "tarefa/finalizada";
	}

	@RequestMapping("reiniciarTarefas")
	public String reiniciarTarefas() {
		reiniciar();

		return "redirect:listaTarefas";
	}

}
