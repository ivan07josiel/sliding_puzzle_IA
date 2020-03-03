package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sliding_puzzle_IA.Peca;

class PecaTeste {

	@Test
	void testeCalculoDistancia() {
		Peca peca = new Peca(0, 0, 1);
		int distanciaCalculada = peca.getDistancia(2, 1);
		int valorDistancia = 3;
		
		assertEquals(valorDistancia, distanciaCalculada);
	}

}
