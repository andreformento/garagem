<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="menu">
	<ul id="menu">
		<!-- <li onclick="location.href='index';">In�cio</li> -->
		<li>
			<div>Garagem</div>
			<ul>
				<li onclick="location.href='garagemLista';">Vis�o</li>
				<li onclick="location.href='garagemCadastro';">Novo</li>
			</ul>
		</li>
		<li>
			<div>A Fazer</div>
			<ul>
				<c:forEach items="${UsuarioSessao.listTipoCategoriaOrcamento}" var="tipoCategoriaOrcamento" varStatus="uStatus">
					<li onclick="location.href='orcamento?codTipoCategoriaOrcamento=${tipoCategoriaOrcamento.codigo}';">${tipoCategoriaOrcamento.descricao}</li>
				</c:forEach>
				<li onclick="location.href='investimentoServico';">Servi�os</li>
				<li onclick="location.href='investimentoPeca';">Pe�as</li>
			</ul>
		</li>
		<c:if test="${UsuarioSessao.permitidoAdministrar}" >
			<li>
				<div>Administra��o</div>
				<ul>
					<li onclick="location.href='listaTipoCategoriaOrcamentos';">Tipo de categoria</li>
					<li onclick="location.href='';">Categoria</li>
				</ul>
			</li>
		</c:if>
	</ul>
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