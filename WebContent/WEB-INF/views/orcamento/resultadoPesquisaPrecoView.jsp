<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<form:form action="mergeResultadosPesquisa" method="post" modelAttribute="resultadoPesquisaList" commandName="resultadoPesquisaList">
	<div><strong>Tag de busca: </strong>${resultadoPesquisaList.orcamento.tagBusca}</div>
	
	<c:if test="${empty resultadoPesquisaList.lista}">
		<div>
			<p>Nenhum registro foi encontrado</p>
		</div>
	</c:if>
	<c:if test="${not empty resultadoPesquisaList.lista}">
		<form:hidden id="codOrcamentoList" path="orcamento.codigo" />
		<form:hidden id="jsonListResultadoPesquisa" path="jsonListResultadoPesquisa" />
		<form:hidden id="txtIndicesRemovidos" path="indicesRemovidos" />
		<div class="formInterno">
			<div id="dvFormulario" class="fields">
				<div class="table">
					<div class="title">
						<p>Resultado da pesquisa</p>
					</div>
					<div class="heading">
						<div class="cell">
							<p></p>
						</div>
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
						<div id="linha_${uStatus.index}" class="row">
							<input type="hidden" value="${resultadoPesquisa.metodoPesquisaPreco.codigo}" />
							<div class="cell">
								<div class="miniBotoes">
									<div>
										<input id="btRemover_${uStatus.index}" type="button"
											onclick="removerResultado(${uStatus.index})"
											value="Remover"
											title="Remover resultado" />
									</div>
								</div>
							</div>
							<div class="cell">
								<img alt="" src="${resultadoPesquisa.caminhoImagem}" >
							</div>
							<div class="cell">
								<div class="valorAlinhadoDireita">
									<c:if test="${not empty resultadoPesquisa.dataPesquisa}">
										<fmt:formatDate value="${resultadoPesquisa.dataPesquisa}" var="dataPesquisaFormat" pattern="dd/MM/yyyy" />
										${dataPesquisaFormat}
									</c:if>
								</div>
							</div>
							<div class="cell">
								<div class="valorAlinhadoDireita">
									<c:if test="${not empty resultadoPesquisa.valor}">
										<fmt:formatNumber value="${resultadoPesquisa.valor}" var="valorFormat" minFractionDigits="2" />
										R$ ${valorFormat}
									</c:if>
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
	</c:if>
</form:form>