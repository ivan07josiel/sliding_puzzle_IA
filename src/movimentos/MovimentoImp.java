package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;
import sliding_puzzle_IA.Peca;

public abstract class MovimentoImp implements Movimento {
	protected int posX;
	protected int posY;
	
	public int getPosicaoVaziaX(Estado estado) {
		return estado.posicaoVazia.posicaoAtualX;
	}
	
	public int getPosicaoVaziaY(Estado estado) {
		return estado.posicaoVazia.posicaoAtualY;
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
		estado.pecas[posicaoX][posicaoY] = pecaVazia;
		estado.posicaoVazia = pecaVazia;
	}
	
	public void setNovaPosicaoPecaMovimentada(int posicaoX, int posicaoY, Estado estado, Peca peca) {
		estado.pecas[posicaoX][posicaoY] = peca;
	}
	
	public No getNovoNo(No noAtual, Estado estadoMovimentado) {
		return new No(noAtual.estado, estadoMovimentado, ++noAtual.profundidade);
	}
}
