<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>

<script type="text/javascript">
    function finalizaAgora(id) {
    	$("#btFinalizar_"+id).hide();
    	alert('aa'+$("#btFinalizar_"+id));
    	
    	$.post("finalizaTipoCategoriaOrcamento", {'id' : id}, function(resposta) {
			$("#tipoCategoriaOrcamento_"+id).html(resposta);
   	    });
    }
</script>
<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>
	<div>
		<a href="novaTipoCategoriaOrcamento">Criar nova tipoCategoriaOrcamento</a>
	</div>
	<div>
		<a href="reiniciarTipoCategoriaOrcamentos">Reiniciar</a>
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
			<c:forEach items="${tipoCategoriaOrcamentos}" var="tipoCategoriaOrcamento">
				<tr id="tipoCategoriaOrcamento_${tipoCategoriaOrcamento.id}">
					<td><a href="removeTipoCategoriaOrcamento?id=${tipoCategoriaOrcamento.id}">Alterar</a></td>
					<td><a href="removeTipoCategoriaOrcamento?id=${tipoCategoriaOrcamento.id}">Remover</a></td>

					<td>${tipoCategoriaOrcamento.id}</td>

					<td>${tipoCategoriaOrcamento.descricao}</td>

					<c:if test="${tipoCategoriaOrcamento.finalizado eq true}">
						<td>Finalizada</td>
					</c:if>

					<c:if test="${tipoCategoriaOrcamento.finalizado eq false}">
						<td><a href="#" onClick="finalizaAgora(${tipoCategoriaOrcamento.id})">Finalizar</a></td>
					</c:if>

					<td><div id="btFinalizar_${tipoCategoriaOrcamento.id}">
							<fmt:formatDate value="${tipoCategoriaOrcamento.dataFinalizacao.time}"
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