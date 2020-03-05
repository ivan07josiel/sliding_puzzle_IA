package sliding_puzzle_IA;

import java.util.ArrayList;
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

	/**
	 * Retorna lista contendo nó(s) que tenham o menor valor de distância total
	 * @param nosPossiveis
	 * @return
	 */
	public static List<No> getMelhoresNos(List<No> nosPossiveis) {
		List<No> melhoresNos = new ArrayList<>();
		for (No no : nosPossiveis) {
			if (melhoresNos.isEmpty()) {
				melhoresNos.add(no);
			} else {
				if (melhoresNos.get(0).distanciaTotal >= no.distanciaTotal) {
					if (melhoresNos.get(0).distanciaTotal > no.distanciaTotal) {
						melhoresNos.clear();
						melhoresNos.add(no);
					} else {
						melhoresNos.add(no);
					}
				}
			}

		}
		return melhoresNos;
	}

}
