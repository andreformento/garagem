<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>

<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>
	
	<form:errors path="entidade.descricao" />
	<form:form action="mergeCategoriaOrcamento" method="post" commandName="entidade">
		<div class="formSobreposto">
			<div class="formInterno">
				<div id="dvFormulario" class="fields">
					<div class="title">
				        <p>Cadastro</p>
				    </div>
					
					<form:hidden path="codigo" />
					
					<div><label for="txtDescricao">Descri��o</label></div>
					<div><form:input id="txtDescricao" path="descricao" /></div>
					<div><form:errors path="descricao" cssStyle="color:red" /></div>
					
					<div><label for="selTipoCategoriaOrcamento" title="Tipo de categoria de or�amento">Tipo</label></div>
					<div>
						<form:select id="selTipoCategoriaOrcamento" path="tipoCategoriaOrcamento">
							<!--<form:option value="0" label="Selecionar"  />-->
			           		<form:options items="${tipoCategoriaOrcamentoList}" itemValue="codigo" itemLabel="descricao"/>
						</form:select>
					</div>
				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btCancelar" type="button" value="Cancelar" onclick="location.href='listaCategoriaOrcamentos'" />
					<input id="btNovo" type="submit" value="Gravar" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</div>
		</div>
	</form:form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>