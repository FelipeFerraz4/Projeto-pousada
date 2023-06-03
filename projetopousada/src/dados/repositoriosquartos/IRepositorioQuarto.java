package dados.repositoriosquartos;

import negocios.Quarto.Quarto;

public interface IRepositorioQuarto {
	
	int adicionarQuarto(Quarto quarto);
	int buscarQuarto(Quarto quarto);
	int deletarQuarto(Quarto quartos);
	int atualizarQuarto(Quarto quarto);
	
	void adicionarQuarto(int numeroQuarto, int tipoQuarto) throws Exception;
	int buscarQuarto(int numeroQuarto, int tipoQuarto);
	int deletarQuarto(int numeroQuarto, int tipoQuarto);
	int atualizarQuarto(int numeroQuarto, int tipoQuarto, 
			float consumo, boolean ocupado, int capacidade,
			float precoQuarto);
	
	int quartoVazio(int tipoQuarto);
	Quarto getQuarto(int indexQuarto);
	
}
