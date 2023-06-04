package dados.repositoriosquartos;

import java.util.ArrayList;

import exceptionpousada.QuartoNaoEncontradoException;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;
import negocios.Quarto.Quarto;

public class RepositorioQuartoArrayList implements IRepositorioQuarto {
	
	private ArrayList<Quarto> quartos = new ArrayList<Quarto>();
/*	
	public ArrayList<Quarto> getQuartos() {
		return this.quartos;
	}
*/
	public Quarto getQuarto(int indexQuarto) {
		return this.quartos.get(indexQuarto);
	}
	
	public int quartoVazio(int tipoQuarto) throws QuartoNaoEncontradoException{
		//1 normal; 2 prime;
		for(int i = 0; i < quartos.size(); i++) {
			if (quartos.get(i).getTipoQuarto()==tipoQuarto) {
				if (quartos.get(i).isOcupado()==false) {
					return i;
				}
			}
		}
		throw new QuartoNaoEncontradoException();
	}
	
	public void adicionarQuarto(int numeroQuarto, int tipoQuarto) {
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
	
	public int buscarQuarto(Quarto quarto) throws QuartoNaoEncontradoException{
		for (int i = 0; i < quartos.size(); i++) {
			if (quartos.get(i).equals(quarto)) {
				return i;
			}
		}
		throw new QuartoNaoEncontradoException();
	}
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException {
		for (int i = 0; i < quartos.size(); i++) {
			if (quartos.get(i).getTipoQuarto()==tipoQuarto) {
				if (quartos.get(i).getNumeroQuato()==numeroQuarto) {
					return i;
				}
			}
		}
		throw new QuartoNaoEncontradoException();
	}
	
	public int deletarQuarto(Quarto quarto) throws QuartoNaoEncontradoException {
		int indexQuarto = this.buscarQuarto(quarto);
		if (indexQuarto != -1) {
			quartos.remove(indexQuarto);
			return 1;
		}
		return -1;
	}
	public int deletarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException {
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto > -1) {
			quartos.remove(indexQuarto);
			return 1;
		}
		return -1;
	}
	
	public int atualizarQuarto(Quarto quarto) throws QuartoNaoEncontradoException{
		int indexQuarto = this.buscarQuarto(quarto);
		if (indexQuarto!=-1) {
			quartos.get(indexQuarto).setOcupado(quarto.isOcupado());
			quartos.get(indexQuarto).setConta(quarto.getConta());
			quartos.get(indexQuarto).setCapacidade(quarto.getCapacidade());
			quartos.get(indexQuarto).setPrecoQuarto(quarto.getPrecoQuarto());
			return 1;
		}
		return -1;
	}
	public int atualizarQuarto(int numeroQuarto, int tipoQuarto, float consumo,
			boolean ocupado, int capacidade, float precoQuarto) 
					throws QuartoNaoEncontradoException{
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto!=-1) {
			quartos.get(indexQuarto).setOcupado(ocupado);
			quartos.get(indexQuarto).setConta(consumo);
			quartos.get(indexQuarto).setCapacidade(capacidade);
			quartos.get(indexQuarto).setPrecoQuarto(precoQuarto);
			return 1;
		}
		return -1;
	}
}
