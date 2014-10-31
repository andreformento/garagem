		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
		<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
		
		<c:if test="${UsuarioSessao.permitidoAdministrar}" >
			<li>
				<div>Administração</div>
				<ul>
					<li onclick="location.href='listaTipoCategoriaOrcamentos';">Tipo de categoria</li>
					<li onclick="location.href='listaCategoriaOrcamentos';">Categoria</li>
				</ul>
			</li>
		</c:if>