package sliding_puzzle_IA;

import java.util.ArrayList;
import java.util.List;

import movimentos.Movimento;

public class Busca {
	private Estado estadofinal;
	private No solucao;
	private boolean hasSolucao = false;
	private List<No> nos;
	
	public void realizarBusca(Estado estadoInicial) {
		
		nos.add(getNoInicial(estadoInicial));
		
		while (!nos.isEmpty()) {
			buscar(nos.remove(0));
		}
	}
	
	private No getNoInicial(Estado estadoInicial) {
		Estado antecessor = new Estado(null, new Peca[0][0], null);
		return new No(antecessor, estadoInicial, 0);
	}

	public void buscar(No no) {
		if (hasSolucao) {
			if (no.estado.distanciaTotal < solucao.distanciaTotal) {
				if (no.estado.equals(estadofinal)) {
					solucao = no;
				} else {
					expandirNos(no);
				}
			}
		} else {
			if (no.estado.equals(estadofinal)) {
				solucao = no;
			} else {
				expandirNos(no);
			}
		}
	}

	private void expandirNos(No no) {
		// TODO Verificar ações possiveis -> expandir nos -> verificar qual o melhor -> inserir na fila
		List<Movimento> acoes = new Acao().getAcoesPossiveis(no.estado);
		List<No> nosPossiveis = new ArrayList<>();
		
		for (Movimento acao : acoes) {
			nosPossiveis.add(acao.mover(no));
		}
	}
}
