package dados.repositoriosquartos;

import negocios.*;
import negocios.Quarto.Quarto;

public interface IRepositorioQuarto {
	
	int adicionarQuarto(Quarto quarto);
	int buscarQuarto(Quarto quarto);
	int deletarQuarto(Quarto quartos);
	int atualizarQuarto(Quarto quarto);
	
	int adicionarQuarto(int numeroQuarto, int tipoQuarto);
	int buscarQuarto(int numeroQuarto, int tipoQuarto);
	int deletarQuarto(int numeroQuarto, int tipoQuarto);
	int atualizarQuarto(int numeroQuarto, int tipoQuarto, 
			float consumo, boolean ocupado, int capacidade);
	
	int quartoVazio(int tipoQuarto);
	Quarto getQuarto(int indexQuarto);
	
}
