<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<jsp:include page="../_template/head.jsp"></jsp:include>
	<script type="text/javascript" src="resources/js/orcamento.js"></script>
</head>
<body onload="setEventCheck()">
	<jsp:include page="../_template/topo.jsp"></jsp:include>

	<div class="formSobreposto">
		<form:form action="mergeOrcamento" method="post" commandName="entidade">
			<div class="formInterno">
				<div id="dvMensagem">
					<c:if test="${not empty param.mensagem}" >
						<div>${param.mensagem}</div>
					</c:if>
				</div>
				<div id="dvFormulario" class="fields">
					<div class="title">
						<p>Orçamento</p>
					</div>

					<form:hidden id="codOrcamento" path="codigo" />
					
					<div><label for="txtAcao">O que</label></div>
					<div>
						<form:input id="txtAcao" path="acao" />
						<input type="checkbox" id="ckAcao" title="Incluir na tag de busca" value="Acao" />
					</div>
					<div><form:errors path="acao" cssStyle="color:red" /></div>

					<div><label for="txtDetalhe">Detalhe</label></div>
					<div>
						<form:input id="txtDetalhe" path="detalhe" />
						<input type="checkbox" id="ckDetalhe" title="Incluir na tag de busca" value="Detalhe" />
					</div>
					<div><form:errors path="detalhe" cssStyle="color:red" /></div>

					<form:hidden path="categoriaOrcamento.tipoCategoriaOrcamento.codigo" id="categoriaOrcamento.tipoCategoriaOrcamento.codigo" />

					<form:hidden path="categoriaOrcamento.codigo" id="categoriaOrcamento.codigo" />
					<div><label for="txtCategoriaOrcamento">Categoria</label></div>
					<div class="somenteLeitura">
						<form:input id="txtCategoriaOrcamento" path="categoriaOrcamento.descricao" readonly="true" />
						<input type="checkbox" id="ckCategoriaOrcamento" title="Incluir na tag de busca" value="CategoriaOrcamento" />
					</div>

					<div><label for="txtMarca">Marca</label></div>
					<div class="somenteLeitura">
						<form:input id="txtMarca" path="carro.marca" readonly="true" />
						<input type="checkbox" id="ckMarca" title="Incluir na tag de busca" value="Marca" />
					</div>

					<div><label for="txtModelo">Modelo</label></div>
					<div class="somenteLeitura">
						<form:input id="txtModelo" path="carro.modelo" readonly="true" />
						<input type="checkbox" id="ckModelo" title="Incluir na tag de busca" value="Modelo" />
					</div>

					<div><label for="txtAno">Ano</label></div>
					<div class="somenteLeitura">
						<form:input id="txtAno" path="carro.ano" readonly="true" />
						<input type="checkbox" id="ckAno" title="Incluir na tag de busca" value="Ano" />
					</div>

					<div><label for="txtTagBusca">Tag de busca</label></div>
					<div class="somenteLeitura">
						<form:input id="txtTagBusca" path="tagBusca" readonly="true" />
						<form:hidden id="txtCheckBusca" path="checkBusca" />
					</div>

					<div><label for="txtDataCriacao">Data de criação</label></div>
					<div class="somenteLeitura">
						<form:input title="Data de criação do registro" id="txtDataCriacao" path="dataCriacao" readonly="true" />
					</div>
					<div><form:errors path="dataCriacao" cssStyle="color:red" /></div>

					<div><label for="selStatusOrcamento" title="Status do orçamento">Status</label></div>
					<div>
						<form:select id="selStatusOrcamento" path="statusOrcamento.codigo" onchange="atualizarBotaoSalvar()">
			           		<form:options items="${statusOrcamentos}" itemValue="codigo" itemLabel="descricao"/>
						</form:select>
					</div>
				</div>
			</div>
			<div class="botoesInferiores">
				<div class="botoes">
					<input id="btSair" type="button" value="Sair"
						onclick="location.href='telaOrcamento?codTipoCategoriaOrcamento=${entidade.categoriaOrcamento.tipoCategoriaOrcamento.codigo}&codCategoriaOrcamento=${entidade.categoriaOrcamento.codigo}'"
					/>
						
					<input id="btGravar" type="submit" value="Gravar orçamento" />
						
					<input id="btPesquisar" type="button"
							onclick="executarPesquisa(${entidade.categoriaOrcamento.tipoCategoriaOrcamento.codigo}, ${entidade.codigo})"
							value="Nova pesquisa"
							/>
				</div>
			</div>
		</form:form>
		<div id="dvPesquisa"></div>
	</div>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</html>