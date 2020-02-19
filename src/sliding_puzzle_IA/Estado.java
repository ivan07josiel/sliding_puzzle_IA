package sliding_puzzle_IA;

/**
 * Classe que representa um estado do jogo
 * @author Ivan Josiel
 *
 */
public class Estado {
	public int profundidade;
	public int distanciaTotal;
	public Estado antecessor;
	public Acao acao;
	public Peca pecas[][] = new Peca[3][3];
	
	
	/**
	 * Retorna a soma das distancias entre posição atual e posição final de cada peça
	 */
	public int getDistanciaTotal() {
		distanciaTotal = 0;

		for (int i = 0; i < pecas.length; i++) {
			for (Peca peca : pecas[i]) {
				distanciaTotal += peca.getDistancia();
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
}
