<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<td><a href="mostraTipoCategoriaOrcamento?id=${tipoCategoriaOrcamento.id}">Alterar</a></td>
<td><a href="removeTipoCategoriaOrcamento?id=${tipoCategoriaOrcamento.id}">Remover</a></td>

<td>${tipoCategoriaOrcamento.id}</td>
<td>${tipoCategoriaOrcamento.descricao}</td>
<td>Finalizada</td>
<td><fmt:formatDate value="${tipoCategoriaOrcamento.dataFinalizacao.time}"
		pattern="dd/MM/yyyy" /></td>