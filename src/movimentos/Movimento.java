package movimentos;

import sliding_puzzle_IA.No;

public interface Movimento {
	/**
	 * Realiza um movimento sobre um estado de um nó e retorna um novo nó resultante desse movimento
	 * @param noMovimentado
	 * @return
	 */
	No mover(No noMovimentado);
}
