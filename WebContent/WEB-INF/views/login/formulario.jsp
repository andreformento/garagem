<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>

<jsp:include page="../_template/head.jsp"></jsp:include>
<body>
	<form:form action="adicionaUsuario" method="POST" commandName="entidade">
		<form:errors path="*" cssClass="errorblock" element="div" />
		
		<div class="formSobreposto">
			<div class="formInterno">
				<div id="dvFormulario" class="fields">
					<div class="tela">
						<div class="table">
							<div class="title">
								<c:if test="${not empty param.mensagem}">
									<div class="mensagem">${param.mensagem}</div>
								</c:if>
						        <h2>Cadastro</h2>
						    </div>

							<div class="row">
								<div class="cellForm"><label for="txtUsername">User (email)</label></div>
								<div class="cellForm"><form:input id="txtUsername" path="username" /></div>
								<div class="cellForm"><form:errors path="username" /></div>
							</div>
							
							<div class="row">
								<div class="cellForm"><label for="txtPassword">Password</label></div>
								<div class="cellForm"><form:password id="txtPassword" 
									path="password"
									title="Digite o password de no mínimo 4 caracteres" 
									onchange="validarSenha()" 
									onkeypress="validarSenha()" 
									onpaste="validarSenha()" 
									onkeyup="validarSenha()" 
									onkeydown="validarSenha()" 
									oncut="validarSenha()" /></div>
								<div class="cellForm"><form:errors path="password" /></div>
							</div>
			
							<div class="row">
								<div class="cellForm"><label for="txtPassword2" title="Digite o password novamente" >Novamente</label></div>
								<div class="cellForm"><input type="password" id="txtPassword2" 
									onchange="validarSenha()" 
									onkeypress="validarSenha()" 
									onkeyup="validarSenha()" 
									onkeydown="validarSenha()" 
									/>
								</div>
							</div>
		
						</div>
					</div>
				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btCancelar" type="button" value="Cancelar" onclick="location.href='loginPage'" />
					<input id="btRegistrar" type="hidden" value="Registrar" /> 
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</div>
			</div>
		</div>
	</form:form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</body>
</head>
</html>