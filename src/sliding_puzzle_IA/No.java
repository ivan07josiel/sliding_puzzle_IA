package sliding_puzzle_IA;

public class No {
	public Estado estadoPai;
	public Estado estado;
	public int profundidade;
	public int distanciaTotal;
	
	
	public No(Estado estadoPai, Estado estado, int profundidade) {
		super();
		this.estadoPai = estadoPai;
		this.estado = estado;
		this.profundidade = profundidade;
	}
	
}
