<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<div>
	<h1>${categoriaOrcamento.descricao}</h1>
	<div class="botoes">
		<input 
			id="btNovoOrcamento" 
			type="button" 
			value="Novo orçamento"
			onclick="location.href='cadastraOrcamento?codCategoriaOrcamento=${categoriaOrcamento.codigo}'" />
	</div>
</div>

<c:if test="${not empty orcamentoList}">
	<div class="formInterno">
		<div id="dvFormulario" class="fields">
			<div class="table">
			    <div class="title">
			        <p>Orçamentos</p>
			    </div>
			    <div class="heading">
					<div class="cell"><p></p></div>
					<div class="cell"><p>Descrição</p></div>
					<div class="cell"><p>Valor</p></div>
			    </div>
			    
			    <c:forEach items="${orcamentoList}" var="orcamento" varStatus="uStatus">
					<div class="row" id="orcamento_${orcamento.codigo}">
						<div class="cell">
							<div class="miniBotoes">
								<div>
									<input id="btAlterar" type="button"
										onclick="window.location.href='cadastraOrcamento?codOrcamento=${orcamento.codigo}'"
										value="Alterar"
										title="Alterar orçamento" />
								</div>
							</div>
						</div>
						<div class="cell">
							${orcamento.acao}
						</div>
						<div class="cell">
							<c:if test="${orcamento.orcamentoValor.existeValor}">
								${orcamento.orcamentoValor.valorFormatado}
							</c:if>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</c:if>