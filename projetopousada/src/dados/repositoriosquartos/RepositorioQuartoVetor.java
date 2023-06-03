package dados.repositoriosquartos;

import negocios.Quarto.Normal;
import negocios.Quarto.Prime;
import negocios.Quarto.Quarto;
import exceptionpousada.*;

public class RepositorioQuartoVetor implements IRepositorioQuarto {
	
	private Quarto[] quartos = new Quarto[50];
	private int size = 0;
	
	public Quarto getQuarto(int indexQuarto) {
		return this.quartos[indexQuarto];
	}
	
	public int quartoVazio(int tipoQuarto) {
		for(int i = 0; i < size; i++) {
			if (this.getQuarto(i).getTipoQuarto()==tipoQuarto) {
				if (this.getQuarto(i).isOcupado()==false) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	public void adicionarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoExisteException {
		Quarto quarto;
		if (tipoQuarto==1) {
			quarto = new Normal(numeroQuarto);
		}
		else{
			quarto = new Prime(numeroQuarto);
		}
		if (size <= 50) {
			quartos[size] = quarto;
			size++;
		}
		else {
			throw new QuartoNaoExisteException();
		}
		
	}
	public int adicionarQuarto(Quarto quarto) {
		if (size <= 50) {
			quartos[size] = quarto;
			size++;
			return 1;
		}
		else {
			return -1;
		}
	}
	
	public int buscarQuarto(Quarto quarto) {
		for (int i = 0; i < size; i++) {
			if (this.getQuarto(i).equals(quarto)) {
				return i;
			}
		}
		return -1;
	}
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) {
		for (int i = 0; i < size; i++) {
			if (this.getQuarto(i).getTipoQuarto()==tipoQuarto) {
				if (this.getQuarto(i).getNumeroQuato()==numeroQuarto) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int deletarQuarto(Quarto quarto) {
		int indexQuarto = this.buscarQuarto(quarto);
		if (indexQuarto != -1) {
			if (indexQuarto != size) {
				for(int i = indexQuarto; i < size; i++) {
					quartos[i] = quartos[i+1];
				}
			}
			else {
				quartos[size] = null;
			}
			size--;
			return 1;
		}
		return -1;
	}
	public int deletarQuarto(int numeroQuarto, int tipoQuarto) {
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto != -1) {
			if (indexQuarto != size) {
				for(int i = indexQuarto; i < size; i++) {
					quartos[i] = quartos[i+1];
				}
			}
			else {
				quartos[size] = null;
			}
			size--;
			return 1;
		}
		return -1;
	}
	
	public int atualizarQuarto(Quarto quarto) {
		int indexQuarto = this.buscarQuarto(quarto);
		if (indexQuarto!=-1) {
			this.getQuarto(indexQuarto).setOcupado(quarto.isOcupado());
			this.getQuarto(indexQuarto).setConta(quarto.getConta());
			this.getQuarto(indexQuarto).setCapacidade(quarto.getCapacidade());
			this.getQuarto(indexQuarto).setPrecoQuarto(quarto.getPrecoQuarto());
			return 1;
		}
		return -1;
	}
	public int atualizarQuarto(int numeroQuarto, int tipoQuarto, float consumo,
			boolean ocupado, int capacidade, float precoQuarto) {
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto!=-1) {
			this.getQuarto(indexQuarto).setOcupado(ocupado);
			this.getQuarto(indexQuarto).setConta(consumo);
			this.getQuarto(indexQuarto).setCapacidade(capacidade);
			this.getQuarto(indexQuarto).setPrecoQuarto(precoQuarto);
			return 1;
		}
		return -1;
	}
}
