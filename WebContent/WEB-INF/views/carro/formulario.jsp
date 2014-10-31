<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>

<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>
	
	<form:form action="mergeCarro" method="post" commandName="entidade" enctype="multipart/form-data" >
		<div class="formSobreposto">
			<div class="formInterno">
				<div id="dvFormulario" class="fields">
					<div class="tela">
						<div class="table">
							<div class="title">
								<c:if test="${not empty param.mensagem}" >
									<div id="dvMensagem" class="mensagem">${param.mensagem}</div>
								</c:if>
						        <h2>Cadastro</h2>
						    </div>
						    
							<form:hidden path="codigo" />
							<div class="row">
								<div class="cellForm"><label for="txtMarca">Marca</label></div>
								<div class="cellForm"><form:input id="txtMarca" path="marca" /></div>
								<div class="cellForm"><form:errors path="marca" cssStyle="color:red" /></div>
							</div>
							
							<div class="row">
								<div class="cellForm"><label for="txtModelo">Modelo</label></div>
								<div class="cellForm"><form:input id="txtModelo" path="modelo" /></div>
								<div class="cellForm"><form:errors path="modelo" cssStyle="color:red" /></div>
							</div>
							
							<div class="row">
								<div class="cellForm"><label for="txtAno">Ano</label></div>
								<div class="cellForm"><form:input id="txtAno" path="ano" /></div>
								<div class="cellForm"><form:errors path="ano" cssStyle="color:red" /></div>
							</div>
								
							<div class="row">
								<div class="cellForm"><label for="txtHistoria">História</label></div>
								<div class="cellForm"><form:textarea id="txtHistoria" path="historia" rows="5" cols="45" /></div>
								<div class="cellForm"><form:errors path="historia" cssStyle="color:red" /></div>
							</div>
								
							<div class="row">
								<div class="cellForm"><label for="txtMeta">Meta</label></div>
								<div class="cellForm"><form:input id="txtMeta" path="Meta" /></div>
								<div class="cellForm"><form:errors path="meta" cssStyle="color:red" /></div>
							</div>
								
							<div class="row">
								<div class="cellForm"><label for="txtCor">Cor</label></div>
								<div class="cellForm"><form:input id="txtCor" path="cor" /></div>
								<div class="cellForm"><form:errors path="cor" cssStyle="color:red" /></div>
							</div>
							
							<div class="row">
								<div class="cellForm"><label for="txtFile">Foto</label></div>
								<div class="cellForm">
									<div class="inputFile">
										<input
											type="file" 
											name="txtFile" 
											id="txtFile" 
											accept="image/*" 
											onchange="previewImage('txtFile','txtImagem');"
										/>
									</div>
								</div>
							</div>
								
							<div class="row">
								<div class="cellForm"></div>
								<div class="cellForm">
									<jsp:include page="../_template/imagemPadrao.jsp"></jsp:include>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btCancelar" type="button" value="Cancelar" onclick="location.href='cadastraCarro?codigo=${entidade.codigo}'" />
					<input id="btNovo" type="submit" value="Gravar" />
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</div>
		</div>
	</form:form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>