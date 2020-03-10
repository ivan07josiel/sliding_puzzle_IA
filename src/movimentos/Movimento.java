package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;

public interface Movimento {
	/**
	 * Realiza um movimento sobre um estado de um nó e retorna um novo nó resultante desse movimento
	 * @param noMovimentado
	 * @return
	 */
	Estado mover(No noMovimentado);
	
	/**
	 * Informa se o movimento é permitido para aquele estado
	 * @return
	 */
	boolean isPermitidoMovimento(Estado estado);
	
	/**
	 * Informa se o movimento é válido levando em conta que não é permitido realizar o 
	 * movimento contrário ao executado anteriormente. EX: MovimentoCima -> MovimentoBaixo
	 */
	boolean isMovimentoValido(Estado estado);
	
}
