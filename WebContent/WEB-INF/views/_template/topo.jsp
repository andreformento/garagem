<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="menu">
	<ul id="menu">
		<!-- <li onclick="location.href='index';">Início</li> -->
		<li>
			<div>Garagem</div>
			<ul>
				<li onclick="location.href='garagemLista';">Visão</li>
				<li onclick="location.href='garagemCadastro';">Novo</li>
			</ul>
		</li>
		<li>
			<div>A Fazer</div>
			<ul>
				<li onclick="location.href='investimentoServico';">Serviços</li>
				<li onclick="location.href='investimentoPeca';">Peças</li>
			</ul>
		</li>
	</ul>
	<div class="informacaoLogin">
		<div>
			<form id="frmLogout" action="logout" method="post">
			    <input type="submit" value="Sair" />
			    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
		<div>
			<label>Eduardo Ramalho</label>
		</div>
	</div>
</div>