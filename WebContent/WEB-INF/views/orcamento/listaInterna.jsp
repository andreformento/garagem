<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<!-- botoes, miniBotoes -->
<div>
	<div class="tituloSuperior">
		<div class="botoes">
			<input 
				id="btNovoOrcamento" 
				type="button" 
				value="Novo or�amento"
				onclick="location.href='cadastraOrcamento?codCategoriaOrcamento=${categoriaOrcamento.codigo}'" />
		</div>
	</div>
</div>

<div class="formInterno">
	<div id="dvFormulario" class="fields">
		<div class="table">
		    <c:if test="${not empty orcamentoList}">
			    <div class="title">
			        <p>${categoriaOrcamento.descricao}</p>
			    </div>
		    
			    <div class="heading">
					<div class="cell"><p></p></div>
					<div class="cell"><p>Descri��o</p></div>
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
										title="Alterar or�amento" />
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
			</c:if>
		</div>
	</div>
</div>
