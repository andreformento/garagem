<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<div>
		<h4>Adicionar tipoCategoriaOrcamentos</h4>
	</div>
	<form:errors path="tipoCategoriaOrcamento.descricao" />
	<form:form action="adicionaTipoCategoriaOrcamento" method="post" commandName="tipoCategoriaOrcamento">
		<input type="hidden" name="id" />
		<form:hidden path="codigo"/>
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
			<input type="submit" value="Adicionar" />
		</div>
	</form:form>
</body>
</html>