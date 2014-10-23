<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>

<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>
	
	<form:form action="mergeCarro" method="post" commandName="entidade" enctype="multipart/form-data" >
		<div class="formSobreposto">
			<div class="formInterno">
				<c:if test="${not empty param.mensagem}" >
					<div>${param.mensagem}</div>
				</c:if>
				<div id="dvFormulario" class="fields">
					<div class="title">
				        <p>Cadastro</p>
				    </div>
					
					<form:hidden path="codigo" />
					
					<div><label for="txtMarca">Marca</label></div>
					<div><form:input id="txtMarca" path="marca" /></div>
					<div><form:errors path="marca" cssStyle="color:red" /></div>
					
					<div><label for="txtModelo">Modelo</label></div>
					<div><form:input id="txtModelo" path="modelo" /></div>
					<div><form:errors path="modelo" cssStyle="color:red" /></div>
					
					<div><label for="txtAno">Ano</label></div>
					<div><form:input id="txtAno" path="ano" /></div>
					<div><form:errors path="ano" cssStyle="color:red" /></div>
					
					<div><label for="txtHistoria">História</label></div>
					<div><form:input id="txtHistoria" path="historia" /></div>
					<div><form:errors path="historia" cssStyle="color:red" /></div>
					
					<div><label for="txtMeta">Meta</label></div>
					<div><form:input id="txtMeta" path="Meta" /></div>
					<div><form:errors path="meta" cssStyle="color:red" /></div>
					
					<div><label for="txtCor">Cor</label></div>
					<div><form:input id="txtCor" path="cor" /></div>
					<div><form:errors path="cor" cssStyle="color:red" /></div>
					
					<div><label for="txtFile">Foto</label></div>
					<div>
						<input type="file" name="txtFile" id="txtFile" accept="image/*" />
					</div>
					
				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btCancelar" type="button" value="Cancelar" onclick="location.href='cadastraCarro?codigo=${entidade.codigo}'" />
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