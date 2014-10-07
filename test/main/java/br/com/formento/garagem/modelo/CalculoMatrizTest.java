package br.com.formento.garagem.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.formento.garagem.enums.EMetodoCalculoMatriz;
import br.com.formento.garagem.factory.CalculoMatrizFactory;
import br.com.formento.garagem.modelo.CalculoMatriz;
import br.com.formento.garagem.modelo.Matriz;
import br.com.formento.garagem.modelo.MatrizLinha;
import br.com.formento.garagem.modelo.MatrizParametro;
import br.com.formento.garagem.modelo.Valor;

public class CalculoMatrizTest {

	private Matriz matriz3x3;

	@Before
	public void instanciar() {
		MatrizParametro matrizParametro3x3 = new MatrizParametro(3, 3);
		matriz3x3 = new Matriz(matrizParametro3x3);
		matriz3x3.getListMatrizLinha().get(0).getMatrizSequencia().getValorPorColuna(0).setNumero(3d);
		matriz3x3.getListMatrizLinha().get(0).getMatrizSequencia().getValorPorColuna(1).setNumero(-2d);
		matriz3x3.getListMatrizLinha().get(0).getMatrizSequencia().getValorPorColuna(2).setNumero(5d);
		matriz3x3.getListMatrizLinha().get(0).getResultado().setNumero(20d);

		matriz3x3.getListMatrizLinha().get(1).getMatrizSequencia().getValorPorColuna(0).setNumero(6d);
		matriz3x3.getListMatrizLinha().get(1).getMatrizSequencia().getValorPorColuna(1).setNumero(-9d);
		matriz3x3.getListMatrizLinha().get(1).getMatrizSequencia().getValorPorColuna(2).setNumero(12d);
		matriz3x3.getListMatrizLinha().get(1).getResultado().setNumero(51d);

		matriz3x3.getListMatrizLinha().get(2).getMatrizSequencia().getValorPorColuna(0).setNumero(-5d);
		matriz3x3.getListMatrizLinha().get(2).getMatrizSequencia().getValorPorColuna(1).setNumero(0d);
		matriz3x3.getListMatrizLinha().get(2).getMatrizSequencia().getValorPorColuna(2).setNumero(2d);
		matriz3x3.getListMatrizLinha().get(2).getResultado().setNumero(1d);
	}

	@Test
	public void matriz3x3QuadradaTest() {
		assertTrue(matriz3x3.getParametro().isQuadrada());
	}

	@Test
	public void matriz3x3DiagonalPrincipalTest() {
		assertEquals(new Valor(3d), matriz3x3.getDiagonalPrincipal().get(0));
		assertEquals(new Valor(-9d), matriz3x3.getDiagonalPrincipal().get(1));
		assertEquals(new Valor(2d), matriz3x3.getDiagonalPrincipal().get(2));
	}

	@Test
	public void matriz3x3PivotTest() {
		assertEquals(new Valor(3d), matriz3x3.getPivot());
	}

	@Test
	public void matriz3x3Coluna1Test() {
		List<Valor> valoresColuna1 = matriz3x3.getValoresColuna(1);
		assertEquals(new Valor(-2d), valoresColuna1.get(0));
		assertEquals(new Valor(-9d), valoresColuna1.get(1));
		assertEquals(new Valor(0d), valoresColuna1.get(2));
	}

	@Test
	public void matriz3x3Linha2Test() {
		MatrizLinha valoresLinha2 = matriz3x3.getLinha(2);
		assertEquals(new Valor(-5d), valoresLinha2.getMatrizSequencia().getValorPorColuna(0));
		assertEquals(new Valor(0d), valoresLinha2.getMatrizSequencia().getValorPorColuna(1));
		assertEquals(new Valor(2d), valoresLinha2.getMatrizSequencia().getValorPorColuna(2));
	}

	@Test
	public void metodoGaussSeidelTest() {
		CalculoMatriz calculoMatriz = CalculoMatrizFactory.getInstance(EMetodoCalculoMatriz.TRIANGULACAO_DE_GAUSS,
				matriz3x3);
		assertNotNull(calculoMatriz);
	}

}
