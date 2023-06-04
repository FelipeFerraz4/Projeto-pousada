package negocios.Pessoa;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriosquartos.IRepositorioQuarto;
import exceptionpousada.QuartoJaExisteException;
import exceptionpousada.QuartoNaoEncontradoException;
import negocios.Quarto.Quarto;

public class Gerente extends Pessoa  {

	public Gerente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(2);
	}
	
	public Pessoa getPessoa(IRepositorioPessoa pessoas, int indexPessoa) {
		return pessoas.getPessoa(indexPessoa);
	}
	//Lembrar adicionar a excetion do Repositorio Lotado 
	public int addPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) {
		int indexPessoa = pessoas.buscarPessoa(pessoa); 
		if (indexPessoa != -1) {
			//adicionar exception Pessoa já existe
			return -1;
		}
		else {
			pessoas.addPessoa(pessoa);
			return 1;
		}
	}
	//Lembrar adicionar a excetion do Repositorio Lotado
	public int addPessoa(IRepositorioPessoa pessoas, int tipoPessoa, String nome, 
			String cpf, String senha) {
		int indexPessoa = pessoas.buscarPessoa(cpf); 
		if (indexPessoa != -1) {
			//adicionar exception Pessoa já existe
			return -1;
		}
		else {
			pessoas.criarPessoa(nome, cpf, senha, tipoPessoa);
			return 1;
		}
	}
	
	public int removerPessoa(IRepositorioPessoa pessoas, Pessoa pessoa){
		int result = pessoas.deletarPessoa(pessoa);
		if (result == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int removerPessoa(IRepositorioPessoa pessoas, String cpf) {
		int result = pessoas.deletarPessoa(cpf);
		if (result == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int consultarPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) {
		int indexPessoa = pessoas.buscarPessoa(pessoa);
		if (indexPessoa == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int consultarPessoa(IRepositorioPessoa pessoas, String cpf) {
		int indexPessoa = pessoas.buscarPessoa(cpf);
		if (indexPessoa == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int atualizarPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) {
		int result = pessoas.atualizarPessoa(pessoa);
		if (result == -1 ) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int atualizarPessoa(IRepositorioPessoa pessoas, String cpf, String nome,
			String senha) {
		int result = pessoas.atualizarPessoa(cpf, nome, senha);
		if (result == -1 ) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public Quarto getQuarto(IRepositorioQuarto quartos, int indexQuarto) {
		return quartos.getQuarto(indexQuarto);
	}
	
	public void addQuarto(IRepositorioQuarto quartos, Quarto quarto) 
			throws ArrayIndexOutOfBoundsException,
			QuartoJaExisteException{
		try {
			quartos.buscarQuarto(quarto);
			throw new QuartoJaExisteException();
		}
		catch(QuartoNaoEncontradoException e) {
			quartos.adicionarQuarto(quarto);
		}
		
	}
	public void addQuarto(IRepositorioQuarto quartos, int numeroQuarto, int tipoQuarto) 
			throws ArrayIndexOutOfBoundsException,
				QuartoJaExisteException{
		try {
			quartos.buscarQuarto(numeroQuarto, tipoQuarto);
			throw new QuartoJaExisteException();
		}
		catch (QuartoNaoEncontradoException e) {
			quartos.adicionarQuarto(numeroQuarto, tipoQuarto);
		}
	}


	public int deletarQuarto(IRepositorioQuarto quartos, Quarto quarto) throws QuartoNaoEncontradoException{
		int result = quartos.deletarQuarto(quarto);
		if (result == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int deletarQuarto(IRepositorioQuarto quartos, int numeroQuarto, int tipoQuarto) throws QuartoNaoEncontradoException{
		int result = quartos.deletarQuarto(numeroQuarto, tipoQuarto);
		if (result == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int consultarQuarto(IRepositorioQuarto quartos, Quarto quarto) throws QuartoNaoEncontradoException{
		int indexPessoa = quartos.buscarQuarto(quarto);
		if (indexPessoa == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int consultarQuarto(IRepositorioQuarto quartos, int numeroQuarto, 
			int tipoQuarto) throws QuartoNaoEncontradoException{
		int indexPessoa = quartos.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexPessoa == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int atualizarQuarto(IRepositorioQuarto quartos, Quarto quarto) throws QuartoNaoEncontradoException{
		int result = quartos.atualizarQuarto(quarto);
		if (result == -1 ) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int atualizarQuarto(IRepositorioQuarto quartos, int numeroQuarto, 
			int tipoQuarto, float consumo, boolean ocupado, int capacidade,
			float precoQuarto) throws QuartoNaoEncontradoException{
		
		int result = quartos.atualizarQuarto(numeroQuarto, tipoQuarto, 
				consumo, ocupado, capacidade, precoQuarto);
		
		if (result == -1 ) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
		
	}	
}
