package sliding_puzzle_IA;

import java.util.List;

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
