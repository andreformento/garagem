<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>


<c:if test="${not empty tagBusca}">
	<div><strong>Tag de busca: </strong>${tagBusca}</div>
</c:if>

<c:if test="${empty resultadoPesquisaList.lista}">
	<div>
		<p>Nenhum registro foi encontrado</p>
	</div>
</c:if>
<c:if test="${not empty resultadoPesquisaList.lista}">
	<form:form action="mergeResultadosPesquisa" method="post" modelAttribute="resultadoPesquisaList" commandName="resultadoPesquisaList">
		<form:input readonly="true" id="codOrcamentoList" path="orcamento.codigo" />
		<div class="formInterno">
			<div id="dvFormulario" class="fields">
				<div class="table">
					<div class="title">
						<p>Resultado da pesquisa</p>
					</div>
					<div class="heading">
						<div class="cell">
							<p>Imagem</p>
						</div>
						<div class="cell">
							<p>Data</p>
						</div>
						<div class="cell">
							<p>Valor</p>
						</div>
						<div class="cell">
							<p>Loja</p>
						</div>
					</div>
	
					<c:forEach items="${resultadoPesquisaList.lista}" var="resultadoPesquisa"
						varStatus="uStatus">
						<div class="row">
							<div class="cell">
								<img alt="" src="${resultadoPesquisa.caminhoImagem}" >
							</div>
							<div class="cell">
								<div class="valorAlinhadoDireita">
									<fmt:formatDate value="${resultadoPesquisa.dataPesquisa}" var="dataPesquisaFormat" pattern="dd/MM/yyyy" />
									${dataPesquisaFormat}
								</div>
							</div>
							<div class="cell">
								<div class="valorAlinhadoDireita">
									<fmt:formatNumber value="${resultadoPesquisa.valor}" var="valorFormat" minFractionDigits="2" />
									R$ ${valorFormat}
								</div>
							</div>
							<div class="cell">
								<a href='${resultadoPesquisa.link}' target="_blank">${resultadoPesquisa.metodoPesquisaPreco.descricao}</a>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<c:if test="${resultadoPesquisaList.orcamento.codigo gt 0}">
			<div class="botoesInferiores">
				<div class="botoes">
					<input id="btGravar" type="submit" value="Gravar resultados" />
				</div>
			</div>
		</c:if>
	</form:form>
</c:if>