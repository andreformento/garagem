package br.com.formento.garagem.factory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.formento.garagem.enums.EMetodoCalculoMatriz;
import br.com.formento.garagem.modelo.CalculoMatriz;
import br.com.formento.garagem.modelo.Matriz;

public class CalculoMatrizFactory {

	private CalculoMatrizFactory() {
	}

	public static CalculoMatriz getInstance(EMetodoCalculoMatriz eMetodoCalculoMatriz, Matriz matriz) {
		Class<? extends CalculoMatriz> classe = eMetodoCalculoMatriz.getClasse();
		try {
			Constructor<? extends CalculoMatriz> cons = classe.getConstructor(Matriz.class);
			CalculoMatriz calculoMatriz = cons.newInstance(matriz);
			return calculoMatriz;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}

		return null;
	}

}
