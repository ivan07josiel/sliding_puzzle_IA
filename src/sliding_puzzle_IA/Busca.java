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
			No no = nos.remove(nos.size() - 1);
			buscar(no);
		}

		imprimirSolucao();
	}

	private No getNoInicial(Estado estadoInicial) {
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
			if (isPossivelMovimentar(acao, no.estado)) {
				nosPossiveis.add(acao.mover(no));
				imprimirEstadoCabecalho(nosPossiveis.get(nosPossiveis.size() - 1));
			}
		}

		nos.addAll(No.getMelhoresNos(nosPossiveis));
	}

	private boolean isPossivelMovimentar(Movimento movimento, Estado estado) {
		return movimento.isMovimentoValido(estado) && movimento.isPossivelMovimento(estado);
	}

	private void imprimirEstado(No no) {
		for (int i = 0; i < no.estado.pecas.length; i++) {
			for (int j = 0; j < no.estado.pecas.length; j++) {
				String numero = no.estado.pecas[i][j].numero != null ? no.estado.pecas[i][j].numero.toString() : "-";
				System.out.print(numero + "  ");
				;
			}
			System.out.println();
		}

		System.out.println("\n\n");

	}

	private void imprimirEstadoCabecalho(No no) {
		imprimirCabecalho(no);
		imprimirEstado(no);
	}

	private void imprimirCabecalho(No no) {
		System.out.println("Profundidade: " + no.profundidade);
		System.out.println("Distância até o estado: " + no.distanciaTotal);
		System.out.println("Distância Manhattan total do estado: " + no.estado.distanciaTotal);
		System.out.println("Movimento executado: " + no.estado.movimento);
		System.out.println("***************\n");
	}

	private void imprimirSolucao() {
		System.out.println("\n******************************");
		System.out.println("	SOLUÇÃO");
		System.out.println("******************************");
		System.out.println("Profundidade: " + solucao.profundidade);
		System.out.println("Distância para solução: " + solucao.distanciaTotal);
		System.out.println("***************\n");
		imprimirEstado(solucao);
	}
}
