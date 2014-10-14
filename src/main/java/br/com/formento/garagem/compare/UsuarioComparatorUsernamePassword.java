package br.com.formento.garagem.compare;

import java.util.Comparator;

import br.com.formento.garagem.model.Usuario;

public class UsuarioComparatorUsernamePassword implements Comparator<Usuario> {

	@Override
	public int compare(Usuario o1, Usuario o2) {
		if (o1.getUsername() == null || o1.getPassword() == null)
			return -1;
		else if (o2.getUsername() == null || o2.getPassword() == null)
			return 1;
		else if (o1.getUsername().compareTo(o2.getUsername()) == 0 && o1.getPassword().compareTo(o2.getPassword()) == 0)
			return 0;
		else
			return -1;
	}
}
