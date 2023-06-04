package negocios.Pessoa;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriosquartos.IRepositorioQuarto;
import exceptionpousada.PessoaJaExisteException;
import exceptionpousada.PessoaNaoEncontradoException;
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
	public void addPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) 
		throws PessoaJaExisteException, ArrayIndexOutOfBoundsException{
		
		try {
			pessoas.buscarPessoa(pessoa);
			throw new PessoaJaExisteException();
		}
		catch(PessoaNaoEncontradoException e) {
			pessoas.addPessoa(pessoa);
		}
		
	}
	//Lembrar adicionar a excetion do Repositorio Lotado
	public void addPessoa(IRepositorioPessoa pessoas, int tipoPessoa, String nome, 
			String cpf, String senha) throws PessoaJaExisteException, ArrayIndexOutOfBoundsException{
		try {
			pessoas.buscarPessoa(cpf);
			throw new PessoaJaExisteException();
		}
		catch(PessoaNaoEncontradoException e) {
			pessoas.criarPessoa(nome, cpf, senha, tipoPessoa);;
		}
	}
	
	public void removerPessoa(IRepositorioPessoa pessoas, Pessoa pessoa)
			throws PessoaNaoEncontradoException{
		pessoas.deletarPessoa(pessoa);
		
	}
	public void removerPessoa(IRepositorioPessoa pessoas, String cpf) 
			throws PessoaNaoEncontradoException{
		pessoas.deletarPessoa(cpf);
	}
	public int consultarPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) 
			throws PessoaNaoEncontradoException{
		int indexPessoa = pessoas.buscarPessoa(pessoa);
		return indexPessoa;
	}
	public int consultarPessoa(IRepositorioPessoa pessoas, String cpf) 
			throws PessoaNaoEncontradoException{
		int indexPessoa = pessoas.buscarPessoa(cpf);
		return indexPessoa;
	}
	public void atualizarPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) 
			throws PessoaNaoEncontradoException{
		pessoas.atualizarPessoa(pessoa);
	}
	public void atualizarPessoa(IRepositorioPessoa pessoas, String cpf, String nome,
			String senha) throws PessoaNaoEncontradoException{
		pessoas.atualizarPessoa(cpf, nome, senha);
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
	public void deletarQuarto(IRepositorioQuarto quartos, Quarto quarto) 
			throws QuartoNaoEncontradoException{
		quartos.deletarQuarto(quarto);
	}
	public void deletarQuarto(IRepositorioQuarto quartos, int numeroQuarto, int tipoQuarto) 
			throws QuartoNaoEncontradoException{
		quartos.deletarQuarto(numeroQuarto, tipoQuarto);
	}
	public int consultarQuarto(IRepositorioQuarto quartos, Quarto quarto) 
			throws QuartoNaoEncontradoException{
		int indexPessoa = quartos.buscarQuarto(quarto);
		return indexPessoa;
	}
	public int consultarQuarto(IRepositorioQuarto quartos, int numeroQuarto, 
			int tipoQuarto) throws QuartoNaoEncontradoException{
		int indexPessoa = quartos.buscarQuarto(numeroQuarto, tipoQuarto);
		return indexPessoa;
	}
	public void atualizarQuarto(IRepositorioQuarto quartos, Quarto quarto) throws QuartoNaoEncontradoException{
		quartos.atualizarQuarto(quarto);
	}
	public void atualizarQuarto(IRepositorioQuarto quartos, int numeroQuarto, 
			int tipoQuarto, float consumo, boolean ocupado, int capacidade,
			float precoQuarto) throws QuartoNaoEncontradoException{
		
		quartos.atualizarQuarto(numeroQuarto, tipoQuarto, consumo, ocupado, 
				capacidade, precoQuarto);

	}	
}
