package sliding_puzzle_IA;

import java.util.ArrayList;
import java.util.List;

import movimentos.Movimento;

public class No {
	public No pai;
	public List<No> filhos = new ArrayList<>();
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

	public No() {
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
	public List<No> getMelhoresNos() {
		List<No> melhoresNos = new ArrayList<>();
		for (No no : this.filhos) {
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

	public void addFilho(Estado estado, Movimento acao) {
		No novoFilho = new No();
		novoFilho.pai = this;
		novoFilho.estado = estado;
		novoFilho.profundidade = this.profundidade + 1;
		novoFilho.estado.movimento = acao;
		novoFilho.distanciaTotal = this.distanciaTotal + estado.distanciaTotal;
		
		this.filhos.add(novoFilho);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		No other = (No) obj;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		return true;
	}
	
	
}
