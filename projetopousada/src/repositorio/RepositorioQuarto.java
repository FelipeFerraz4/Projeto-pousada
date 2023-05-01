package repositorio;

import dados.*;
import java.util.ArrayList;

public class RepositorioQuarto {
	
	ArrayList<Quarto> quartos = new ArrayList();
	
	public void criarQuarto(int numeroQuarto, int tipoQuarto) {
		Quarto quarto;
		if (tipoQuarto==1) {
			quarto = new Normal(numeroQuarto);
		}
		else{
			quarto = new Prime(numeroQuarto);
		}
		quartos.add(quarto);
		
	}
	public void buscarQuarto() {
		
	}
	public void deletarQuarto() {
		
	}
	public void atualizarQuarto() {
		
	}

}
