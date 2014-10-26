<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="imagemFoto">
	<img id="txtImagem"
		<c:if test="${not empty carroFotoEncode}">
			src="data:image/jpeg;base64,${carroFotoEncode}"
		</c:if>
		<c:if test="${empty carroFotoEncode}">
			src="<c:url value='/images/gray.png'/>"
		</c:if>
	>
</div>