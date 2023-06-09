package dados.repositoriosquartos;

import exceptionpousada.QuartoNaoEncontradoException;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;
import negocios.Quarto.Quarto;

public class RepositorioQuartoVetor implements IRepositorioQuarto {
	
	private int sizeVetor = 50;
	private Quarto[] quartos = new Quarto[sizeVetor];
	private int size = 0;
	
	public Quarto getQuarto(int indexQuarto) {
		return this.quartos[indexQuarto];
	}
	
	public int quartoVazio(int tipoQuarto) throws QuartoNaoEncontradoException {
		for(int i = 0; i < size; i++) {
			if (this.getQuarto(i).getTipoQuarto()==tipoQuarto) {
				if (this.getQuarto(i).isOcupado()==false) {
					return i;
				}
			}
		}
		throw new QuartoNaoEncontradoException();
	}
	
	
	public void adicionarQuarto(int numeroQuarto, int tipoQuarto) 
			throws ArrayIndexOutOfBoundsException {
		Quarto quarto;
		if (tipoQuarto==1) {
			quarto = new Normal(numeroQuarto);
		}
		else{
			quarto = new Prime(numeroQuarto);
		}
		if (size <= sizeVetor-1) {
			quartos[size] = quarto;
			size++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
		
	}
	public void adicionarQuarto(Quarto quarto) throws ArrayIndexOutOfBoundsException{
		if (size < sizeVetor-1) {
			quartos[size] = quarto;
			size++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public int buscarQuarto(Quarto quarto) throws QuartoNaoEncontradoException{
		for (int i = 0; i < size; i++) {
			if (this.getQuarto(i).equals(quarto)) {
				return i;
			}
		}
		throw new QuartoNaoEncontradoException();
	}
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException{
		for (int i = 0; i < size; i++) {
			if (this.getQuarto(i).getTipoQuarto()==tipoQuarto) {
				if (this.getQuarto(i).getNumeroQuato()==numeroQuarto) {
					return i;
				}
			}
		}
		throw new QuartoNaoEncontradoException();
	}
	
	public void deletarQuarto(Quarto quarto) throws QuartoNaoEncontradoException{
		int indexQuarto = this.buscarQuarto(quarto);
		if (indexQuarto != sizeVetor-1) {
			for(int i = indexQuarto; i < size-1; i++) {
				quartos[i] = quartos[i+1];
			}
		}
		else {
			quartos[sizeVetor-1] = null;
		}
		size--;
	}
	public void deletarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException{
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto != sizeVetor-1) {
			for(int i = indexQuarto; i < size-1; i++) {
				quartos[i] = quartos[i+1];
			}
		}
		else {
			quartos[sizeVetor-1] = null;
		}
		size--;
	}
	
	public void atualizarQuarto(Quarto quarto) throws QuartoNaoEncontradoException{
		int indexQuarto = this.buscarQuarto(quarto);
		this.getQuarto(indexQuarto).setOcupado(quarto.isOcupado());
		this.getQuarto(indexQuarto).setConta(quarto.getConta());
		this.getQuarto(indexQuarto).setCapacidade(quarto.getCapacidade());
		this.getQuarto(indexQuarto).setPrecoQuarto(quarto.getPrecoQuarto());
	}
	public void atualizarQuarto(int numeroQuarto, int tipoQuarto, float consumo,
			boolean ocupado, int capacidade, float precoQuarto) 
					throws QuartoNaoEncontradoException{
		int indexQuarto = this.buscarQuarto(numeroQuarto, tipoQuarto);
		this.getQuarto(indexQuarto).setOcupado(ocupado);
		this.getQuarto(indexQuarto).setConta(consumo);
		this.getQuarto(indexQuarto).setCapacidade(capacidade);
		this.getQuarto(indexQuarto).setPrecoQuarto(precoQuarto);
	}
}
