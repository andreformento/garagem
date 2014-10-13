function finalizaAgora(codigo) {
	$("#btFinalizar_" + codigo).hide();
	alert('aa' + $("#btFinalizar_" + codigo));

	$.post("finalizaTipoCategoriaOrcamento", {
		'codigo' : codigo
	}, function(resposta) {
		$("#tipoCategoriaOrcamento_" + codigo).html(resposta);
	});
}