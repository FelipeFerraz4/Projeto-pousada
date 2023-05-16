package dados;

import java.util.ArrayList;

import negocios.*;

public class RepositorioPessoa {

	private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
	
	//melhora fazendo getPessoa receber um index e returna a pessoa 
	public ArrayList<Pessoa> getPessoas() {
		return this.pessoas;
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
	
	public int buscarPessoa(String cpf) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getCPF().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}
	public int buscarPessoa(Pessoa pessoa) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).equals(pessoa)) {
				return i;
			}
		}
		return -1;
	}

	public int deletarPessoa(String cpf) {
		int indeceQuarto = this.buscarPessoa(cpf);
		if (indeceQuarto > -1) {
			pessoas.remove(indeceQuarto);
			return 1;
		}
		return -1;
	}
	public int deletarPessoa(Pessoa pessoa) {
		if (pessoas.remove(pessoa)) {
			return 1;
		}
		return -1;
	}

	public void atualizarPessoa(Pessoa pessoa) {
		int indicePessoa = this.buscarPessoa(pessoa);
		pessoas.get(indicePessoa).setNome(pessoa.getNome());
		pessoas.get(indicePessoa).setSenha(pessoa.getSenha());
		
	}
	public void atualizarPessoa(Pessoa pessoa,String Nome, String Senha){
		int indicePessoa = this.buscarPessoa(pessoa);
		pessoas.get(indicePessoa).setNome(Nome);
		pessoas.get(indicePessoa).setSenha(Senha);

	}

}
