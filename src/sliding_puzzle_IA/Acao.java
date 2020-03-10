package sliding_puzzle_IA;

import java.util.ArrayList;
import java.util.List;

import movimentos.Movimento;
import movimentos.MovimentoBaixo;
import movimentos.MovimentoCima;
import movimentos.MovimentoDireita;
import movimentos.MovimentoEsquerda;

/**
 * Classe para representação dos movimentos de uma peça no jogo
 * 
 * @author Ivan Josiel
 *
 */
public class Acao {
	
	public List<Movimento> getAcoesPossiveis(Estado estado) {
		List<Movimento> movimentos = new ArrayList<>();

		if (isPermitidoMovimento(new MovimentoCima(), estado))
			movimentos.add(new MovimentoCima());
		if (isPermitidoMovimento(new MovimentoBaixo(), estado))
			movimentos.add(new MovimentoBaixo());
		if (isPermitidoMovimento(new MovimentoEsquerda(), estado))
			movimentos.add(new MovimentoEsquerda());
		if (isPermitidoMovimento(new MovimentoDireita(), estado))
			movimentos.add(new MovimentoDireita());

		return movimentos;
	}

	/**
	 * Indica se é possível realizar determinado tipo de movimento no estado recebido
	 * 
	 * @param tipoMovimento int que indica o tipo de movimento a ser realizado
	 * @param estado Estado atual
	 * @return boolean indicando a possibilidade do movimento
	 */
	public boolean isPermitidoMovimento(Movimento movimento, Estado estado) {
		boolean resultado = movimento.isPermitidoMovimento(estado);

		return resultado;
	}
}
