<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>
<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>

	<form:form action="mergeOrcamento" method="post" commandName="entidade">
		<div class="formSobreposto">
			<div class="formInterno">
				<div id="dvFormulario" class="fields">
					<div class="title">
						<p>Cadastro</p>
					</div>

					<form:hidden path="codigo" />
					
					<div><label for="txtAcao">Ação</label></div>
					<div><form:input id="txtAcao" path="acao" /></div>
					<div><form:errors path="acao" cssStyle="color:red" /></div>

					<div><label for="txtDetalhe">Detalhe</label></div>
					<div><form:input id="txtDetalhe" path="detalhe" /></div>
					<div><form:errors path="detalhe" cssStyle="color:red" /></div>

					<div><label for="txtDataCriacao">Data de criação</label></div>
					<div class="somenteLeitura"><form:input id="txtDataCriacao" path="dataCriacao" readonly="true" /></div>
					<div><form:errors path="dataCriacao" cssStyle="color:red" /></div>

					<form:hidden path="categoriaOrcamento.tipoCategoriaOrcamento.codigo" id="categoriaOrcamento.tipoCategoriaOrcamento.codigo" />

					<form:hidden path="categoriaOrcamento.codigo" id="categoriaOrcamento.codigo" />
					<div><label for="txtCategoriaOrcamento">Categoria</label></div>
					<div class="somenteLeitura"><form:input id="txtCategoriaOrcamento" path="categoriaOrcamento.descricao" readonly="true" /></div>
					<div><form:errors path="categoriaOrcamento" cssStyle="color:red" /></div>

					<div><label for="selStatusOrcamento" title="Status do orçamento">Status</label></div>
					<div>
						<form:select id="selStatusOrcamento" path="statusOrcamento.codigo">
			           		<form:options items="${statusOrcamentos}" itemValue="codigo" itemLabel="descricao"/>
						</form:select>
					</div>

				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btCancelar" type="button" value="Cancelar"
						onclick="location.href='telaOrcamento?codTipoCategoriaOrcamento=${entidade.categoriaOrcamento.tipoCategoriaOrcamento.codigo}&codCategoriaOrcamento=${entidade.categoriaOrcamento.codigo}'" />
					<input id="btNovo" type="submit" value="Gravar" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</div>
		</div>
	</form:form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>