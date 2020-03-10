package sliding_puzzle_IA;

public class Main {

	public static void main(String[] args) {
		Busca busca = new Busca(null);

		busca.realizarBusca(getEstadoInicial());
	}

	private static Estado getEstadoInicial() {
		Peca p1 = new Peca(0, 0, 1);
		Peca p2 = new Peca(1, 0, 2);
		Peca p3 = new Peca(2, 0, 3);
		Peca p4 = new Peca(2, 1, 4);
		Peca p5 = new Peca(2, 2, 5);
		Peca p6 = new Peca(1, 2, 6);
		Peca p7 = new Peca(0, 2, 7);
		Peca p8 = new Peca(0, 1, 8);
		Peca vazia = Peca.getPecaVazia(0, 0);

		Peca pecas[][] = { { vazia, p1, p2}, { p7, p8, p3 }, { p6, p5, p4 } };

		Estado e = new Estado(null, pecas, vazia);

		return e;
	}
	
	private static Estado getEstadoInicial2() {
		Peca p1 = new Peca(0, 0, 1);
		Peca p2 = new Peca(1, 0, 2);
		Peca p3 = new Peca(2, 0, 3);
		Peca p4 = new Peca(0, 1, 4);
		Peca p5 = new Peca(1, 1, 5);
		Peca p6 = new Peca(2, 1, 6);
		Peca p7 = new Peca(0, 2, 7);
		Peca p8 = new Peca(1, 2, 8);
		Peca vazia = Peca.getPecaVazia(1, 2);

		Peca pecas[][] = { { p2, p5, p8 }, { p1, p4, p7 }, { p3, vazia, p6} };

		Estado e = new Estado(null, pecas, vazia);

		return e;
	}
}
