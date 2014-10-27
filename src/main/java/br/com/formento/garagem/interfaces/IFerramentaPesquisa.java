package br.com.formento.garagem.interfaces;

import java.util.List;

import br.com.formento.garagem.model.MetodoPesquisaPreco;

public interface IFerramentaPesquisa {

	MetodoPesquisaPreco getMetodoPesquisaPreco();

	List<IResultadoPesquisa> gerarResultadoPesquisaList(String tagBusca);

}
