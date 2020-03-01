package sliding_puzzle_IA;

import java.util.List;

public class Busca {
	private Estado estadofinal;
	private No solucao;
	private boolean hasSolucao = false;
	private List<Estado> nos;
	
	
	boolean buscar(No no) {
		if (hasSolucao) {
			if (no.estado.distanciaTotal < solucao.distanciaTotal) {
				if (no.estado.equals(estadofinal)) {
					solucao = no;
				} else {
					expandirNos(no);
				}
			}
		} else {
			
		}
		
		return true;
	}


	private void expandirNos(No no) {
		// TODO Auto-generated method stub
		
	}
}
