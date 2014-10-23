<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<div>
		<h4>Adicionar tarefas</h4>
	</div>
	<form:errors path="tarefa.descricao" />
	<form action="adicionaTarefa" method="post">
		<input type="hidden" name="id" />
		
		<div><label for="txtDescricao">Descrição:</label></div>
		<div><textarea rows="5" cols="100" name="descricao" id="txtDescricao"></textarea></div>
		<div><form:errors path="tarefa.descricao" cssStyle="color:red" /></div>
		
		<div><input type="submit" value="Adicionar" /></div>
	</form>
</body>
</html>