package sliding_puzzle_IA;

import java.util.ArrayList;
import java.util.List;

import movimentos.Movimento;

public class Busca {
	private Estado estadoFinal;
	private No solucao;
	private boolean hasSolucao = false;
	private List<No> nos = new ArrayList<>();

	public Busca(Estado estadoFinal) {
		this.estadoFinal = estadoFinal;
	}
	
	public void realizarBusca(Estado estadoInicial) {
		
		nos.add(getNoInicial(estadoInicial));
		
		while (!nos.isEmpty()) {
			buscar(nos.remove(0));
		}
	}
	
	private No getNoInicial(Estado estadoInicial) {
		Estado estadoRaiz = new Estado(null, new Peca[3][3], null);
		return new No(null, estadoInicial, 0);
	}

	public void buscar(No no) {
		if (hasSolucao) {
			if (no.estado.distanciaTotal < solucao.distanciaTotal) {
				if (no.estado.isEstadoMeta()) {
					solucao = no;
				} else {
					expandirNos(no);
				}
			}
		} else {
			if (no.estado.isEstadoMeta()) {
				solucao = no;
			} else {
				expandirNos(no);
			}
		}
	}

	private void expandirNos(No no) {
		List<Movimento> acoes = new Acao().getAcoesPossiveis(no.estado);
		List<No> nosPossiveis = new ArrayList<>();
		
		for (Movimento acao : acoes) {
			nosPossiveis.add(acao.mover(no));
			imprimirEstado(nosPossiveis.get(nosPossiveis.size()-1).estado);
		}
		
		nos.add(No.getMelhorNo(nosPossiveis));
	}

	private void imprimirEstado(Estado estado) {
		System.out.println(estado.movimento);
		for (int i = 0; i < estado.pecas.length; i++) {
			for (int j = 0; j < estado.pecas.length; j++) {
				String numero = estado.pecas[i][j].numero != null ? estado.pecas[i][j].numero.toString() : "-"; 
				System.out.print(numero + "  ");;
			}
			System.out.println();
		}
		
		System.out.println("\n\n");
		
	}
}
