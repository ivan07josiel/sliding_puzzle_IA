package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;
import sliding_puzzle_IA.Peca;

public class MovimentoEsquerda extends MovimentoImp implements Movimento {

	@Override
	public No mover(No noAtual) {
		Estado estadoMovimentado = noAtual.estado.clone();
		setPosicoes(noAtual.estado);
		
		setEspacoVazio(posX-1, posY, estadoMovimentado);
		Peca pecaMovimentada = noAtual.estado.pecas[posX-1][posY];
		setNovaPosicaoPecaMovimentada(posX, posY, estadoMovimentado, pecaMovimentada);
		
		return getNovoNo(noAtual, estadoMovimentado);
	}

	@Override
	public boolean isPermitidoMovimento(Estado estado) {
		return estado.posicaoVazia.posicaoFinalX - 1 < 0;
	}
	
}