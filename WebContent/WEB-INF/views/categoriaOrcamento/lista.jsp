<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>

<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>

	<form id="frmLista" action="cadastraCategoriaOrcamento">
		<div class="formSobreposto">
			<div class="formInterno">
				<div id="dvFormulario" class="fields">
					<div class="table">
					    <div class="title">
					        <h2>Lista</h2>
					    </div>
					    <div class="heading">
					        <div class="cell"><p></p></div>
					        <div class="cell"><p>Excluir</p></div>
					        <div class="cell"><p>Descrição</p></div>
					        <div class="cell"><p>Tipo</p></div>
					    </div>
					    
					    <c:forEach items="${entidades}" var="entidade" varStatus="uStatus">
							<div class="row" id="entidade_${entidade.codigo}">
								<div class="cell">
									<div class="miniBotoes">
										<div>
											<input id="btAlterar" type="button"
												onclick="window.location.href='cadastraCategoriaOrcamento?codigo=${entidade.codigo}'"
												value="Alterar" />
										</div>
									</div>
								</div>
								<div class="cell">
									<div class="miniBotoes">
										<div>
											<input id="btExcluir" type="button"
												onclick="window.location.href='removeCategoriaOrcamento?codigo=${entidade.codigo}'"
												value="Excluir" />
										</div>
									</div>
								</div>
								<div class="cell">
									${entidade.descricao}
								</div>
								<div class="cell">
									${entidade.tipoCategoriaOrcamento.descricao}
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btNovo" type="submit" value="Novo registro" />
				</div>
			</div>
		</div>
	</form>
	
	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>