<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="menu">
	<ul id="menu">
		<!-- <li onclick="location.href='index';">Início</li> -->
		<li>
			<div>Garagem</div>
			<ul>
				<c:if test="${not empty UsuarioSessao.carroSelecionado}" >
					<li onclick="location.href='cadastraCarro?codigo=${UsuarioSessao.carroSelecionado.codigo}';">Visão</li>
				</c:if>
				<li onclick="location.href='cadastraCarro';">Novo</li>
			</ul>
		</li>
		<c:if test="${not empty UsuarioSessao.carroSelecionado}" >
			<li>
				<div onclick="location.href='investimentoPeca';">A Fazer</div>
				<ul>
					<c:forEach items="${UsuarioSessao.listTipoCategoriaOrcamento}" var="tipoCategoriaOrcamento" varStatus="uStatus">
						<li onclick="location.href='telaOrcamento?codTipoCategoriaOrcamento=${tipoCategoriaOrcamento.codigo}';">${tipoCategoriaOrcamento.descricao}</li>
					</c:forEach>
					<!-- <li onclick="location.href='investimentoServico';">Serviços</li>
					<li onclick="location.href='investimentoPeca';">Peças</li> -->
				</ul>
			</li>
		</c:if>
		
		<!-- Do Admin -->
		
	</ul>
	
	<div class="informacaoLogin">
		<div>
			<div class="mesmaLinha">
				<c:if test="${not empty UsuarioSessao.listCarro}" >
					<select id="selCarro" onchange="window.location.href='selecionaCarro?codigo='+this.value;">
						<c:forEach items="${UsuarioSessao.listCarro}" var="carro" varStatus="uStatus">
							<option value="${carro.codigo}" 
							        ${carro == UsuarioSessao.carroSelecionado ? 'selected' : ''}
							        >
								${carro.modelo}
							</option>
						</c:forEach>
					</select>
				</c:if>
			</div>
			
			<div class="mesmaLinha">
				<form id="frmLogout" action="logout" method="post" class="formInformacaoLogin">
				    <input type="submit" value="Sair" />
				    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form>
			</div>
		</div>
		<div>
			<label>${UsuarioSessao.usuario.username}</label>
		</div>
	</div>
	
</div>