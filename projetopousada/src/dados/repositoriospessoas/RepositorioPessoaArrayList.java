package dados.repositoriospessoas;

import java.util.ArrayList;

import exceptionpousada.PessoaNaoEncontradoException;
import negocios.Pessoa.Cliente;
import negocios.Pessoa.Gerente;
import negocios.Pessoa.Pessoa;

public class RepositorioPessoaArrayList implements IRepositorioPessoa {

	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	//melhora fazendo getPessoa receber um index e returna a pessoa 
	public ArrayList<Pessoa> getPessoas() {
		return this.pessoas;
	}
	public Pessoa getPessoa(int indexPessoa) {
		return this.pessoas.get(indexPessoa);
	}
	
	public void criarPessoa(String nome, String cpf, String senha, int tipoPessoa) {
		Pessoa pessoa;
		if (tipoPessoa==1) {
			pessoa = new Cliente(nome, cpf, senha);
		}
		else{
			pessoa = new Gerente(nome, cpf, senha);
		}
		pessoas.add(pessoa);
	}
	public void addPessoa(Pessoa pessoa) {
		pessoas.add(pessoa);
	}
	
	public int buscarPessoa(String cpf) throws PessoaNaoEncontradoException{
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getCPF().equals(cpf)) {
				return i;
			}
		}
		throw new PessoaNaoEncontradoException();
	}
	public int buscarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException{
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).equals(pessoa)) {
				return i;
			}
		}
		throw new PessoaNaoEncontradoException();
	}

	public void deletarPessoa(String cpf) throws PessoaNaoEncontradoException{
		int indeceQuarto = this.buscarPessoa(cpf);
		pessoas.remove(indeceQuarto);
	}
	public void deletarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException{
		int indeceQuarto = this.buscarPessoa(pessoa);
		pessoas.remove(indeceQuarto);
	}

	public void atualizarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException{
		int indicePessoa = this.buscarPessoa(pessoa);
		pessoas.get(indicePessoa).setNome(pessoa.getNome());
		pessoas.get(indicePessoa).setSenha(pessoa.getSenha());
		
	}
	public void atualizarPessoa(String cpf,String nome, String senha)
			throws PessoaNaoEncontradoException{
		int indicePessoa = this.buscarPessoa(cpf);
		pessoas.get(indicePessoa).setNome(nome);
		pessoas.get(indicePessoa).setSenha(senha);
	}

}
