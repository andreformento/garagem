function finalizaAgora(codigo) {
	$("#btFinalizar_" + codigo).hide();
	alert('aa' + $("#btFinalizar_" + codigo));

	$.post("finalizaTipoCategoriaOrcamento", {
		'codigo' : codigo
	}, function(resposta) {
		$("#tipoCategoriaOrcamento_" + codigo).html(resposta);
	});
}

// ajax
function carregarOrcamentosAjax(url) {
	var nomeIdControle = "idComponente";
	$.post("exibirBotao", {
		'tipo' : "Expandir",
		'prefixo' : prefixo,
		'entidade' : entidade,
		'codigo' : codigo,
		'carregar' : true
	}, function(resposta) {
		$(nomeIdControle).html(resposta);
		$(nomeIdControle).fadeIn("fast");
	});
}

function carregarOrcamentos(codCategoriaOrcamento) {
	if (codCategoriaOrcamento > 0) {
		var nomeIdControle = "dvlistaInterna";
		
		var dvListaInterna=document.getElementById(nomeIdControle);
		dvListaInterna.innerHTML = "<div class='carregando'></div>";

		$.post("listaOrcamento", {
			'codCategoriaOrcamento' : codCategoriaOrcamento
		}, function(resposta) {
			dvListaInterna.innerHTML = resposta;
		});
	}
}