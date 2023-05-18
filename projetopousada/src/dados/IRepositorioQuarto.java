package dadosRepositorio;

import dados.*;

public interface IRepositorioQuarto {
	
	void adicionarQuarto(Quarto quarto);
	int buscarQuarto(Quarto quarto);
	int deletarQuarto(Quarto quartos);
	void atualizarQuarto(Quarto quarto);
	
	void adicionarQuarto(int numeroQuarto, int tipoQuarto);
	int buscarQuarto(int numeroQuarto, int tipoQuarto);
	int deletarQuarto(int numeroQuarto, int tipoQuarto);
	
}
