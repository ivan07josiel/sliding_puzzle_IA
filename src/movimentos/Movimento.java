package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;

public interface Movimento {
	/**
	 * Realiza um movimento sobre um estado de um n� e retorna um novo n� resultante desse movimento
	 * @param noMovimentado
	 * @return
	 */
	Estado mover(No noMovimentado);
	
	/**
	 * Informa se o movimento � permitido para aquele estado
	 * @return
	 */
	boolean isPermitidoMovimento(Estado estado);
	
	/**
	 * Informa se o movimento � v�lido levando em conta que n�o � permitido realizar o 
	 * movimento contr�rio ao executado anteriormente. EX: MovimentoCima -> MovimentoBaixo
	 */
	boolean isMovimentoValido(Estado estado);
	
}
