package sliding_puzzle_IA;

import java.util.List;

public class No {
	public No pai;
	public Estado estado;
	public int profundidade;
	public int distanciaTotal;
		
	public No(No pai, Estado estado, int profundidade) {
		super();
		this.pai = pai;
		this.estado = estado;
		this.profundidade = profundidade;
		setDistanciaTotal(pai, estado);
	}

	private void setDistanciaTotal(No pai, Estado estado) {
		int distanciaAntecessor = pai != null ? pai.distanciaTotal : 0; 
		this.distanciaTotal = distanciaAntecessor + estado.distanciaTotal;
	}

	public static No getMelhorNo(List<No> nosPossiveis) {
		No melhorNo = nosPossiveis.get(0);
		for (No no : nosPossiveis) {
			if (no.distanciaTotal < melhorNo.distanciaTotal) {
				melhorNo = no;
			}
		}
		return melhorNo;
	}
	
}
