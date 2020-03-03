package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.Peca;

class EstadoTeste {
	private Estado estado;
	private Estado estadoFinal;
	
	@BeforeEach
	void setUp() throws Exception {
		estado = getEstado();
		estadoFinal = getEstadoFinal();
	}

	public Estado getEstadoFinal() {
		Peca p1 = new Peca(0, 0, 1);
		Peca p2 = new Peca(1, 0, 2);
		Peca p3 = new Peca(2, 0, 3);
		Peca p4 = new Peca(0, 1, 4);
		Peca p5 = new Peca(1, 1, 5);
		Peca p6 = new Peca(2, 1, 6);
		Peca p7 = new Peca(0, 2, 7);
		Peca p8 = new Peca(1, 2, 8);
		Peca vazia = Peca.getPecaVazia(2, 2);

		Peca pecas[][] = { { p1, p2, p3 }, { p4, p5, p6 }, { p7, p8, vazia } };

		Estado estado = new Estado(null, pecas, vazia);

		return estado;
	}
	
	private Estado getEstado() {
		Peca p1 = new Peca(0, 0, 1);
		Peca p2 = new Peca(1, 0, 2);
		Peca p3 = new Peca(2, 0, 3);
		Peca p4 = new Peca(0, 1, 4);
		Peca p5 = new Peca(1, 1, 5);
		Peca p6 = new Peca(2, 1, 6);
		Peca p7 = new Peca(0, 2, 7);
		Peca p8 = new Peca(1, 2, 8);
		Peca vazia = Peca.getPecaVazia(2, 2);

		Peca pecas[][] = { { p3, p4, p1 }, { p2, p5, p6 }, { p7, p8, vazia } };

		Estado e = new Estado(null, pecas, vazia);

		return e;
	}

	@Test
	void distanciaTotal() {
		int distanciaTotalCalculada = estado.distanciaTotal;
		int valorDistanciaTotal = 8;
		
		assertEquals(valorDistanciaTotal, distanciaTotalCalculada);
	}
	
	@Test
	void isEstadoMeta() {
		assertTrue(estadoFinal.isEstadoMeta());
	}

}
