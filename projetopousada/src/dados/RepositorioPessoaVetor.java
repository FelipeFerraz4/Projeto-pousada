package dados;

import negocios.*;

public class RepositorioPessoaVetor implements IRepositorioPessoa {
   
	int tam = 100;
   	private Pessoa[] pessoas = new Pessoa[tam];
    
	
	public Pessoa getpessoas (int indexPessoa){
        return this.pessoas[indexPessoa];
    }
    
    public void criarPessoa(String nome, String cpf, String senha, int tipoPessoa) {
		Pessoa pessoa;
		if (tipoPessoa==1) {
			pessoa = new Cliente(nome, cpf, senha);
		}
		else{
			pessoa = new Gerente(nome, cpf, senha);
		}
        int i= pessoas.length + 1;
            pessoas[i] = pessoa;
	}
	public void addPessoa(Pessoa pessoa) {
		int i = pessoas.length + 1;
            pessoas[i] = pessoa;
	}
	
	public int buscarPessoa(String cpf) {
		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].getCPF().equals(cpf)) {
				return i;
			}
		}
		return -1;
	}
	public int buscarPessoa(Pessoa pessoa) {
		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].equals(pessoa)) {
				return i;
			}
		}
		return -1;
	}

	public int deletarPessoa(String cpf) {
		int indeceQuarto = this.buscarPessoa(cpf);
		if (indeceQuarto > -1) {
			pessoas[indeceQuarto] = null;
			return 1;
		}
		return -1;
	}
	public int deletarPessoa(Pessoa pessoa) {
		for (int i = 0; i <pessoas.length;i++)
        if (pessoas[i].equals(pessoa)) {
            pessoas[i] = null;
			return 1;
		}
		return -1;
	}
	
	public int atualizarPessoa(Pessoa pessoa) {
		int indicePessoa = this.buscarPessoa(pessoa);
		if (indicePessoa != -1) {
			pessoas[indicePessoa].setNome(pessoa.getNome());
			pessoas[indicePessoa].setSenha(pessoa.getSenha());
			return 1;
		}
		return -1;
		
	}
	public int atualizarPessoa(String cpf,String nome, String senha){
		int indicePessoa = this.buscarPessoa(cpf);
		if (indicePessoa != 1) {
			pessoas[indicePessoa].setNome(nome);
			pessoas[indicePessoa].setSenha(senha);
			return 1;
		}
		return -1;

	}

}

    

