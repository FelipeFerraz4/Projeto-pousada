package repositorio;

import dados.*;
import java.util.ArrayList;

public class RepositorioQuarto {
	
	ArrayList<Quarto> quartos = new ArrayList();
	
	public ArrayList getQuartos() {
		return this.quartos;
	}
	
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
	public void adicionarQuarto(Quarto quarto) {
		quartos.add(quarto);
	}
	public int buscarQuarto(Quarto quarto) {
		for (int i = 0; i < quartos.size(); i++) {
			if (quartos.get(i).equals(quarto)) {
				return i;
			}
		}
		return -1;
	}
	public void deletarQuarto(int indexQuarto) {
		quartos.remove(indexQuarto);
	}
	public void atualizarQuarto() {
		
	}

}
