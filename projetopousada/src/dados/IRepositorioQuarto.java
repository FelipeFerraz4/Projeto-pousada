package dados;

import negocios.*;

public interface IRepositorioQuarto {
	
	void adicionarQuarto(Quarto quarto);
	int buscarQuarto(Quarto quarto);
	int deletarQuarto(Quarto quartos);
	int atualizarQuarto(Quarto quarto);
	
	void adicionarQuarto(int numeroQuarto, int tipoQuarto);
	int buscarQuarto(int numeroQuarto, int tipoQuarto);
	int deletarQuarto(int numeroQuarto, int tipoQuarto);
	
	int quartoVazio(int tipoQuarto);
	Quarto getQuarto(int indexQuarto);
	
}
