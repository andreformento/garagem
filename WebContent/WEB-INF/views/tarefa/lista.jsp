<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>

<script type="text/javascript">
    function finalizaAgora(id) {
    	$("#btFinalizar_"+id).hide();
    	alert('aa'+$("#btFinalizar_"+id));
    	
    	$.post("finalizaTarefa", {'id' : id}, function(resposta) {
			$("#tarefa_"+id).html(resposta);
   	    });
    }
</script>
<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>
	<div>
		<a href="novaTarefa">Criar nova tarefa</a>
	</div>
	<div>
		<a href="reiniciarTarefas">Reiniciar</a>
	</div>

	<div>
		<table>
			<tr>
				<th>Alterar</th>
				<th>Remover</th>
				<th>Id</th>
				<th>Descrição</th>
				<th>Finalizado?</th>
				<th>Data de finalização</th>
			</tr>
			<c:forEach items="${tarefas}" var="tarefa">
				<tr id="tarefa_${tarefa.id}">
					<td><a href="removeTarefa?id=${tarefa.id}">Alterar</a></td>
					<td><a href="removeTarefa?id=${tarefa.id}">Remover</a></td>

					<td>${tarefa.id}</td>

					<td>${tarefa.descricao}</td>

					<c:if test="${tarefa.finalizado eq true}">
						<td>Finalizada</td>
					</c:if>

					<c:if test="${tarefa.finalizado eq false}">
						<td><a href="#" onClick="finalizaAgora(${tarefa.id})">Finalizar</a></td>
					</c:if>

					<td><div id="btFinalizar_${tarefa.id}">
							<fmt:formatDate value="${tarefa.dataFinalizacao.time}"
								pattern="dd/MM/yyyy" />
						</div></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>