package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;
import sliding_puzzle_IA.Peca;

public abstract class MovimentoImp implements Movimento {
	protected int posX;
	protected int posY;
	
	public int getPosicaoVaziaX(Estado estado) {
		return estado.posicaoVazia.posicaoFinalX;
	}
	
	public int getPosicaoVaziaY(Estado estado) {
		return estado.posicaoVazia.posicaoFinalY;
	}
	
	protected void setPosicoes(Estado estado) {
		posX = getPosicaoVaziaX(estado);
		posY = getPosicaoVaziaY(estado);
	}
	
	/**
	 * Seta nova posição da peça livre no estado
	 * @param posicaoX
	 * @param posicaoY
	 * @param no
	 */
	public void setEspacoVazio(int posicaoX, int posicaoY, Estado estado) {
		Peca pecaVazia = Peca.getPecaVazia(posicaoX, posicaoY);
		estado.pecas[posicaoY][posicaoX] = pecaVazia;
		estado.posicaoVazia = pecaVazia;
	}
	
	public void setNovaPosicaoPecaMovimentada(int posicaoX, int posicaoY, Estado estado, Peca peca) {
		estado.pecas[posicaoY][posicaoX] = peca;
	}
	
	public No getNovoNo(No noAtual, Estado estadoMovimentado) {
		int novaProfundidade = noAtual.profundidade + 1;
		return new No(noAtual, estadoMovimentado, novaProfundidade);
	}
	
}
