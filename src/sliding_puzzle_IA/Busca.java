package sliding_puzzle_IA;

import java.util.ArrayList;
import java.util.List;

import movimentos.Movimento;

public class Busca {
	private Estado estadoFinal;
	private No solucao;
	private boolean hasSolucao = false;
	private List<No> nosFila = new ArrayList<>();
	private List<Estado> estadoVisitados = new ArrayList<>();
	private int qtdNos = 0;

	public Busca(Estado estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public void realizarBusca(Estado estadoInicial) {

		nosFila.add(getNoInicial(estadoInicial));

		while (!nosFila.isEmpty()) {
			No no = nosFila.remove(nosFila.size() - 1);
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

		for (Movimento acao : acoes) {
			if (acao.isMovimentoValido(no.estado)) {
				Estado novoEstado = acao.mover(no);
				if (isNovoEstado(novoEstado)) {
					estadoVisitados.add(novoEstado);
					no.addFilho(novoEstado, acao);
					imprimirEstadoCabecalho(no.filhos.get(no.filhos.size() - 1));
				}
			}
		}

		nosFila.addAll(no.getMelhoresNos());
	}

	private boolean isNovoEstado(Estado estado) {
		return !estadoVisitados.contains(estado);
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
		System.out.println("Quantidade de nós expandidos: " + estadoVisitados.size());
		System.out.println("***************\n");
		imprimirEstado(solucao);
	}
}
