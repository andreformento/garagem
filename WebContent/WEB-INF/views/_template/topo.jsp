<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="menu">
	<ul id="menu">
		<!-- <li onclick="location.href='index';">Início</li> -->
		<li>
			<div>Garagem</div>
			<ul>
				<c:if test="${not empty UsuarioSessao.carroSelecionado}" >
					<li onclick="location.href='cadastraCarro?codigo${UsuarioSessao.carroSelecionado.codigo}';">Visão</li>
				</c:if>
				<li onclick="location.href='cadastraCarro';">Novo</li>
			</ul>
		</li>
		<c:if test="${not empty UsuarioSessao.carroSelecionado}" >
			<li>
				<div onclick="location.href='investimentoPeca';">A Fazer</div>
				<ul>
					<c:forEach items="${UsuarioSessao.listTipoCategoriaOrcamento}" var="tipoCategoriaOrcamento" varStatus="uStatus">
						<li onclick="location.href='orcamento?codTipoCategoriaOrcamento=${tipoCategoriaOrcamento.codigo}';">${tipoCategoriaOrcamento.descricao}</li>
					</c:forEach>
					<!-- <li onclick="location.href='investimentoServico';">Serviços</li>
					<li onclick="location.href='investimentoPeca';">Peças</li> -->
				</ul>
			</li>
		</c:if>
		<c:if test="${UsuarioSessao.permitidoAdministrar && false}" >
			<li>
				<div>Administração</div>
				<ul>
					<li onclick="location.href='listaTipoCategoriaOrcamentos';">Tipo de categoria</li>
					<li onclick="location.href='listaCategoriaOrcamentos';">Categoria</li>
				</ul>
			</li>
		</c:if>
	</ul>
	<c:if test="${not empty UsuarioSessao.carroSelecionado}" >
		<div class="informacaoLogin">
			<div>
				<select id="selCarro">
					<c:forEach items="${UsuarioSessao.listCarro}" var="carro" varStatus="uStatus">
						<option value="${carro.codigo}" ${carro == UsuarioSessao.carroSelecionado ? 'selected' : ''}>${carro.modelo}</option>
						
					</c:forEach>
				</select>
			</div>
		</div>
		  
	</c:if>
	<div class="informacaoLogin">
		<div>
			<form id="frmLogout" action="logout" method="post">
			    <input type="submit" value="Sair" />
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
		<div>
			<label>${UsuarioSessao.usuario.username}</label>
		</div>
	</div>
</div>