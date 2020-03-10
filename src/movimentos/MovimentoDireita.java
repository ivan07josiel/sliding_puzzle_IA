package movimentos;

import sliding_puzzle_IA.Estado;
import sliding_puzzle_IA.No;
import sliding_puzzle_IA.Peca;

public class MovimentoDireita extends MovimentoImp implements Movimento {

	@Override
	public Estado mover(No noAtual) {
		Estado estadoMovimentado = noAtual.estado.clone(this, noAtual.estado);
		setPosicoes(noAtual.estado);
		
		setEspacoVazio(posX+1, posY, estadoMovimentado);
		Peca pecaMovimentada = noAtual.estado.pecas[posY][posX+1];
		setNovaPosicaoPecaMovimentada(posX, posY, estadoMovimentado, pecaMovimentada);
		estadoMovimentado.atualizarDistanciaTotal();
		
		return estadoMovimentado;
	}

	@Override
	public boolean isPermitidoMovimento(Estado estado) {
		return estado.posicaoVazia.posicaoFinalX + 1 < estado.pecas.length;
	}
	
	@Override
	public boolean isMovimentoValido(Estado estado) {		
		return !(estado.movimento instanceof MovimentoEsquerda);
	}
	

	
	@Override
	public String toString() {
		return "Movimento para direita";
	}
}