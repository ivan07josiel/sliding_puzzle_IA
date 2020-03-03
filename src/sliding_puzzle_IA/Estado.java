package sliding_puzzle_IA;

/**
 * Classe que representa um estado do jogo
 * 
 * @author Ivan Josiel
 *
 */
public class Estado implements Cloneable {
	public int distanciaTotal;
	public Acao acao;
	public Peca pecas[][] = new Peca[3][3];
	public Peca posicaoVazia;

	public Estado(Acao acao, Peca[][] pecas, Peca posicaoVazia) {
		this.acao = acao;
		this.pecas = pecas;
		this.posicaoVazia = posicaoVazia;
		this.distanciaTotal = getDistanciaTotal();
	}

	/**
	 * Retorna a soma das distancias entre posição atual e posição final de cada
	 * peça
	 */
	public int getDistanciaTotal() {
		distanciaTotal = 0;

		for (int i = 0; i < pecas.length; i++) {
			for (int j = 0; j < pecas[i].length; j++) {
				Peca peca = pecas[i][j];
				distanciaTotal += peca != null ? peca.getDistancia(j, i) : 0;
			}
		}

		return distanciaTotal;
	}

	/**
	 * Indica se o estado atual é igual ao estado objetivo
	 */
	public boolean isEstadoMeta() {
		return getDistanciaTotal() == 0;
	}

	public Estado clone() {
		try {
			return (Estado) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return null;
	}
}
