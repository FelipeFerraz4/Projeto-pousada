package repositorio;

import dados.*;
import java.util.ArrayList;

public class RepositorioQuarto {
	
	ArrayList<Quarto> quartos = new ArrayList<Quarto>();
	
	public ArrayList<Quarto> getQuartos() {
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
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) {
		for (int i = 0; i < quartos.size(); i++) {
			if (quartos.get(i).getTipoQuarto()==tipoQuarto) {
				if (quartos.get(i).getNumeroQuato()==numeroQuarto) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int deletarQuarto(int indexQuarto) {
		if (indexQuarto > 0 || indexQuarto < this.quartos.size()) {
			quartos.remove(indexQuarto);
			return 1;
		}
		return -1;
	}
	public int deletarQuarto(int numeroQuarto, int tipoQuarto) {
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto > -1) {
			quartos.remove(indexQuarto);
			return 1;
		}
		return -1;
	}
	public void atualizarQuarto(Quarto quarto) {
		int indexQuarto = this.buscarQuarto(quarto);
		if (quartos.get(indexQuarto).isOcupado()!=quarto.isOcupado()) {
			quartos.get(indexQuarto).isOcupado();
		}
		quartos.get(indexQuarto).setConta(quarto.getConta());
		quartos.get(indexQuarto).setCapacidade(quarto.getCapacidade());
	}
	
	public int quartoVazio(int tipoQuarto) {
		int indexQuarto = -1;
		
		for(int i = 0; i < quartos.size(); i++) {
			if (quartos.get(i).getTipoQuarto()==tipoQuarto) {
				if (quartos.get(i).isOcupado()==false) {
					return i;
				}
			}
		}
		
		return indexQuarto;
	}

}
