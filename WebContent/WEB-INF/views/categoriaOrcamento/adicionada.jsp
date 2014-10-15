<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<div>
		<h3>Nova tipoCategoriaOrcamento adicionada com sucesso!</h3>
	</div>
	
	<form:errors path="tipoCategoriaOrcamento.descricao" />
	<form action="listaTipoCategoriaOrcamentos" method="post">
		<div>
			<input type="submit" value="Listar" />
		</div>
	</form>
</body>
</html>