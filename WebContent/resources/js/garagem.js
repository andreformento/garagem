// ajax
function carregarOrcamentos(codCategoriaOrcamento) {
	if (codCategoriaOrcamento > 0) {
		var divName = "dvlistaInterna";

		var divComponente = document.getElementById(divName);
		divComponente.innerHTML = "<div class='carregando'></div>";
		
		$.post("listaOrcamento", {
			'codCategoriaOrcamento' : codCategoriaOrcamento
		}, function(resposta) {
			divComponente.innerHTML = resposta;
		});
	}
}

function setEventCheck() {
	$("input[type=checkbox]").each(function() {
		var idName = $(this).attr('id');
		document.getElementById(idName).onclick = atualizarCheckTag;
	});

	$("input[type=text]").each(function() {
		var idName = $(this).attr('id');
		
		if (!document.getElementById(idName).readOnly) {
			document.getElementById(idName).onchange = atualizarTagBusca;
			document.getElementById(idName).onkeypress = atualizarTagBusca;
			document.getElementById(idName).onkeyup = atualizarTagBusca;
			document.getElementById(idName).onkeydown = atualizarTagBusca;
		}
	});
	
	var listTagBusca = document.getElementById('txtCheckBusca').value;
	listTagBusca.split(",").forEach(function (nomeCheck) {
		document.getElementById(nomeCheck).checked = true;
	});
}

function atualizarCheckTag() {
	var tagsSelecionadas = '';
	$("input[type=checkbox]:checked").each(function() {
		var valorCheck = $(this).attr('value');
		tagsSelecionadas += 'ck'+valorCheck+',';
	});
	
	document.getElementById('txtCheckBusca').value = tagsSelecionadas;
	atualizarTagBusca();
}

function atualizarTagBusca() {
	document.getElementById('txtTagBusca').value = '';
	
	var listTagBusca = document.getElementById('txtCheckBusca').value;
	listTagBusca.split(",").forEach(function (nomeCheck) {
		if (nomeCheck.trim().length > 0) {
			var valor = document.getElementById(nomeCheck).value;
			document.getElementById('txtTagBusca').value += document.getElementById('txt'+valor).value + ' ';
		}
	});

	document.getElementById('txtTagBusca').title = document.getElementById('txtTagBusca').value;
	document.getElementById('btSair').value = 'Sair sem salvar';
	document.getElementById('dvMensagem').innerHTML = '';
}

//ajax
function executarPesquisa(codTipoCategoriaOrcamento, codOrcamento) {
	var tagBusca = document.getElementById('txtTagBusca').value;
	
	if (tagBusca.trim().length == 0)
		alert('Nenhuma tag selecionada');
	else {
		var divName = "dvPesquisa";
		var divComponente = document.getElementById(divName);
		divComponente.innerHTML = "<div class='carregando'></div>";
		
		$.post('executarPesquisa', {
			'codTipoCategoriaOrcamento' : codTipoCategoriaOrcamento,
			'codOrcamento' : codOrcamento,
			'tagBusca' : tagBusca
		}, function(resposta) {
			divComponente.innerHTML = resposta;
		});
	}
}

function previewImage(inputFileName, inputImageName) {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById(inputFileName).files[0]);

	oFReader.onload = function(oFREvent) {
		document.getElementById(inputImageName).src = oFREvent.target.result;
	};
}

function validarSenha() {
	var input1 = 'txtPassword';
	var input2 = 'txtPassword2';
	var btRegistrar = 'btRegistrar';
	
	if (document.getElementById(input1).value.length > 0
			&& document.getElementById(input1).value == document
					.getElementById(input2).value)
		document.getElementById(btRegistrar).type = 'submit';
	else
		document.getElementById(btRegistrar).type = 'hidden';
}