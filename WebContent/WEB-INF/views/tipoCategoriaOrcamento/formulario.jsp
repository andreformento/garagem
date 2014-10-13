<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<div>
		<h4>Cadastro</h4>
	</div>
	<form:errors path="entidade.descricao" />
	<form:form action="mergeTipoCategoriaOrcamento" method="post" commandName="entidade">
		<form:hidden path="codigo" />
		
		<form:input path="codigo" />
		<div>
			<label for="txtDescricao">Descrição:</label>
		</div>
		<div>
			<form:input path="descricao" />
		</div>
		<div>
			<form:errors path="descricao" cssStyle="color:red" />
		</div>
		<div>
			<input type="submit" value="Gravar" />
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form:form>
</body>
</html>