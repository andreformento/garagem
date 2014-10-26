<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
			<div class="Table">
			    <div class="title">
			        <p>Orçamentos</p>
			    </div>
			    <div class="heading">
			        <div class="cell"><p></p></div>
			        <div class="cell"><p>Descrição</p></div>
			    </div>
			    
			    <c:forEach items="${orcamentoList}" var="orcamento" varStatus="uStatus">
					<div class="row" id="orcamento_${orcamento.codigo}">
						<div class="cell">
							<div class="miniBotoes">
								<div>
									<input id="btAlterar" type="button"
										onclick="window.location.href='cadastraOrcamento?codOrcamento=${orcamento.codigo}'"
										value="Alterar" />
								</div>
							</div>
						</div>
						<div class="cell">
							<p>${orcamento.acao}</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</c:if>


<!-- 
<div id="dvOrcamentos">
	<div class="formInterno">
		<div id="dvFormulario" class="fields1">
			<div>
				<label for="txtAcao">Ação</label> 
				<input id="txtAcao" type="text" value="Pintura das portas" />
			</div>
			<div>
				<label for="txtHistoria">Observação</label>
				<textarea id="txtHistoria" rows="4" cols="35">Cor azul</textarea>
			</div>
		</div>
	</div>
</div> -->