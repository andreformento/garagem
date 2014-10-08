<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>

<html>
<head>
<jsp:include page="../_template/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../_template/topo.jsp"></jsp:include>

	<form id="frmCadastro" action="gravarCarro">
		<div class="formSobreposto">
			<div class="formInterno">
				<div id="dvFormulario" class="fields">
					<div>
						<label for="txtMarca">Marca</label> <input id="txtMarca"
							type="text" value="Porsche" />
					</div>
					<div>
						<label for="txtModelo">Modelo</label> <input id="txtModelo"
							type="text" value="911" />
					</div>
					<div>
						<label for="txtAno">Ano</label> <input id="txtAno" type="text"
							value="1979" />
					</div>
					<div>
						<label for="txtHistoria">História</label>
						<textarea id="txtHistoria" rows="4" cols="70">Comprado de uma senhora viúva em 1983. Estava bem original, porém apresentava inúmeras marcas de uso, incluindo a troca das rodas originais.</textarea>
					</div>
					<div>
						<label for="txtMeta">Meta</label> <input id="txtMeta" type="text"
							value="Placa preta em 2015" />
					</div>
					<div>
						<label for="txtFoto">Foto</label> <img
							src="http://www.swadeology.com/wp-content/uploads/2013/03/1979-Porsche-911-SC-30-Coup+-1024.jpg"
							alt="" style="width: 304px; height: 228px">
					</div>
				</div>
			</div>
			<div class="botoes">
				<div>
					<input id="btOk" type="submit" value="OK" />
					<input id="btAtividades" type="button" value="Atividades" onclick="location.href='registrarAtividades'" />
				</div>
			</div>
		</div>
	</form>

	<jsp:include page="../_template/rodape.jsp"></jsp:include>
</html>
</body>