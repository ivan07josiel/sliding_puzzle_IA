package sliding_puzzle_IA;

/**
 * Classe que representa um estado do jogo
 * @author Ivan Josiel
 *
 */
public class Estado implements Cloneable {
	public int distanciaTotal;
	public Acao acao;
	public Peca pecas[][] = new Peca[3][3];
	public Peca posicaoVazia;
	
	
	public Estado(Acao acao, Peca[][] pecas, Peca posicaoVazia) {
		this.distanciaTotal = getDistanciaTotal();
		this.acao = acao;
		this.pecas = pecas;
		this.posicaoVazia = posicaoVazia;
	}

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
	
	public Estado clone(){
        try {
			return (Estado) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        return null;
 }
}
