function previewImage(inputFileName, inputImageName) {
	var oFReader = new FileReader();
	oFReader.readAsDataURL(document.getElementById(inputFileName).files[0]);

	oFReader.onload = function(oFREvent) {
		document.getElementById(inputImageName).src = oFREvent.target.result;
	};
}

function validarSenha() {
	var input1 = 'txtPassword';
	var input2 = 'txtPassword2';
	var btRegistrar = 'btRegistrar';
	
	if (document.getElementById(input1).value.length > 0
			&& document.getElementById(input1).value == document
					.getElementById(input2).value)
		document.getElementById(btRegistrar).type = 'submit';
	else
		document.getElementById(btRegistrar).type = 'hidden';
}
