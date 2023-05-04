package repositorio;

import java.util.ArrayList;

import dados.Cliente;
import dados.Pessoa;

public class RepositorioPessoa {

	ArrayList<Pessoa> pessoas = new ArrayList();
	
	public ArrayList getPessoas() {
		return this.pessoas;
	}



	
	public void criarPessoa(String nome, String cpf, int senha) {
		Pessoa pessoa;
		pessoa = new Cliente(nome,cpf,senha);
		pessoas.add(pessoa);
		
		
		
	}
	public int buscarPesoa(String cpf) {
		for (int i = 0; i < pessoas.size(); i++) {
			if (pessoas.get(i).getCPF()==cpf) {
				return i;
			}
		}
		return -1;
		
	}

	
	public int deletarPessoa(String nome, String cpf) {
		int indeceQuarto = this.buscarPesoa(cpf);
		if (indeceQuarto > -1) {
			pessoas.remove(indeceQuarto);
			return 1;
		}
		return -1;}

	public void atualizarPessoa() {
		
	}
}
