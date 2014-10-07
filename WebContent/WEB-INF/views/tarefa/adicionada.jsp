<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<div>
		<h3>Nova tarefa adicionada com sucesso!</h3>
	</div>
	
	<form:errors path="tarefa.descricao" />
	<form action="listaTarefas" method="post">
		<div>
			<input type="submit" value="Listar" />
		</div>
	</form>
</body>
</html>