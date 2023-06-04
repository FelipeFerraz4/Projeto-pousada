package dados.repositoriosquartos;

import exceptionpousada.*;
import negocios.Quarto.Quarto;

public interface IRepositorioQuarto {
	
	void adicionarQuarto(Quarto quarto) throws ArrayIndexOutOfBoundsException;
	int buscarQuarto(Quarto quarto) throws QuartoNaoEncontradoException;
	int deletarQuarto(Quarto quartos) throws QuartoNaoEncontradoException;
	int atualizarQuarto(Quarto quarto) throws QuartoNaoEncontradoException;
	
	void adicionarQuarto(int numeroQuarto, int tipoQuarto) throws ArrayIndexOutOfBoundsException;
	int buscarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException;
	int deletarQuarto(int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException;
	int atualizarQuarto(int numeroQuarto, int tipoQuarto, 
			float consumo, boolean ocupado, int capacidade,
			float precoQuarto) throws QuartoNaoEncontradoException;
	
	int quartoVazio(int tipoQuarto) throws QuartoNaoEncontradoException;
	Quarto getQuarto(int indexQuarto);
	
}
