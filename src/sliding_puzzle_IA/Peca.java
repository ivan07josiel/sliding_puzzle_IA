package sliding_puzzle_IA;

/**
 * Classe que representa uma peça do jogo
 * @author Ivan Josiel
 *
 */
public class Peca {
	public int posicaoAtualX;
	public int posicaoAtualY;
	public int posicaoFinalX;
	public int posicaoFinalY;
	public int distancia;
	
	public Peca(int posicaoAtualX, int posicaoAtualY, int posicaoFinalX, int posicaoFinalY) {
		super();
		this.posicaoAtualX = posicaoAtualX;
		this.posicaoAtualY = posicaoAtualY;
		this.posicaoFinalX = posicaoFinalX;
		this.posicaoFinalY = posicaoFinalY;
		this.distancia = getDistancia();
	}
	
	public static Peca getPecaVazia(int posicaoX, int posicaoY) {
		return new Peca(posicaoY, posicaoY, posicaoX, posicaoY);
	}
	
	/**
	 * Retorna a distancia manhattan entre a posição atual e a posição final da peça
	 */
	public int getDistancia() {
		return getDistanciaManhattan();
	}

	private int getDistanciaManhattan() {
		return projecaoLinhaX() + projecaoLinhaY();
	}
	
	/**
	 * Retorna o comprimento da projecção da linha no eixo X
	 */
	private int projecaoLinhaX() {
		return Math.abs(posicaoFinalX - posicaoAtualX);
	}
	
	/**
	 * Retorna o comprimento da projecção da linha no eixo Y
	 */
	private int projecaoLinhaY() {
		return Math.abs(posicaoFinalY - posicaoAtualY);
	}
	
	

}
