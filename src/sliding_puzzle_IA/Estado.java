package sliding_puzzle_IA;

import movimentos.Movimento;

/**
 * Classe que representa um estado do jogo
 * 
 * @author Ivan Josiel
 *
 */
public class Estado {
	public int distanciaTotal;
	public int pecasForaLugar;
	public Movimento movimento;
	public Peca pecas[][] = new Peca[3][3];
	public Peca posicaoVazia;

	public Estado(Movimento movimento, Peca[][] pecas, Peca posicaoVazia) {
		this.movimento = movimento;
		setPecas(pecas);
		this.posicaoVazia = posicaoVazia;
		this.distanciaTotal = getDistanciaTotal();
		this.pecasForaLugar = getPecasForaLugar();
	}

	private void setPecas(Peca[][] pecas) {
		for (int i = 0; i < pecas.length; i++) {
			this.pecas[i] = pecas[i].clone();
		}
	}
	
	public int getPecasForaLugar() {
		pecasForaLugar = 0;
		
		for (int i = 0; i < pecas.length; i++) {
			for (int j = 0; j < pecas[i].length; j++) {
				Peca peca = pecas[i][j];
				if (peca != null) {
					distanciaTotal += peca.isPecaPosicaoFinal() ? 0 : 1;
				}
			}
		}

		return pecasForaLugar;
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
				if (peca != null) {
					peca.setDistancia(j, i);
					distanciaTotal += peca.distancia;
				}
			}
		}

		return distanciaTotal;
	}
	
	public void atualizarDistanciaTotal() {
		this.distanciaTotal = getDistanciaTotal();
	}

	/**
	 * Indica se o estado atual é igual ao estado objetivo
	 */
	public boolean isEstadoMeta() {
		return getDistanciaTotal() == 0;
	}

    public Estado clone(Movimento movimento, Estado estado) {
        return new Estado(movimento, estado.pecas, estado.posicaoVazia);
    }
}
