package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;
import sliding_puzzle_IA.Peca;

public class MovimentoCima extends MovimentoImp implements Movimento {

	@Override
	public No mover(No noAtual) {
		Estado estadoMovimentado = noAtual.estado.clone();
		setPosicoes(noAtual.estado);
		
		setEspacoVazio(posX, posY+1, estadoMovimentado);
		Peca pecaMovimentada = noAtual.estado.pecas[posX][posY+1];
		setNovaPosicaoPecaMovimentada(posX, posY, estadoMovimentado, pecaMovimentada);
		
		return getNovoNo(noAtual, estadoMovimentado);
	}

	@Override
	public boolean isPermitidoMovimento(Estado estado) {
		return estado.posicaoVazia.posicaoFinalY - 1 < 0;
	}
	
}
