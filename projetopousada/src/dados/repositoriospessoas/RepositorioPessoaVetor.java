package dados.repositoriospessoas;

import exceptionpousada.PessoaNaoEncontradoException;
import negocios.Pessoa.Cliente;
import negocios.Pessoa.Gerente;
import negocios.Pessoa.Pessoa;

public class RepositorioPessoaVetor implements IRepositorioPessoa {
   
	private int tam = 100;
   	private Pessoa[] pessoas = new Pessoa[tam];
   	private int quantidadeElemento = 0;
    
	
	public Pessoa getPessoa (int indexPessoa){
        return this.pessoas[indexPessoa];
    }
    
    public void criarPessoa(String nome, String cpf, String senha, int tipoPessoa) 
    		throws ArrayIndexOutOfBoundsException{
		Pessoa pessoa;
		if (tipoPessoa==1) {
			pessoa = new Cliente(nome, cpf, senha);
		}
		else{
			pessoa = new Gerente(nome, cpf, senha);
		}
		if (quantidadeElemento < tam) {
            pessoas[quantidadeElemento] = pessoa;
            quantidadeElemento++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	public void addPessoa(Pessoa pessoa) 
			throws ArrayIndexOutOfBoundsException{
		if (quantidadeElemento < tam) {
            pessoas[quantidadeElemento] = pessoa;
            quantidadeElemento++;
		}
		else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public int buscarPessoa(String cpf) throws PessoaNaoEncontradoException{
		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].getCPF().equals(cpf)) {
				return i;
			}
		}
		throw new PessoaNaoEncontradoException();
	}
	public int buscarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException{
		for (int i = 0; i < pessoas.length; i++) {
			if (pessoas[i].equals(pessoa)) {
				return i;
			}
		}
		throw new PessoaNaoEncontradoException();
	}

	public void deletarPessoa(String cpf) throws PessoaNaoEncontradoException{
		int indeceQuarto = this.buscarPessoa(cpf);
		if (indeceQuarto < tam-1) {
			for(int i = indeceQuarto; i < quantidadeElemento-1; i++) {
				pessoas[i] = pessoas[i+1];
			}
		}
		else {
			pessoas[tam-1] = null;
		}
		quantidadeElemento--;
	}
	public void deletarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException{
		int indeceQuarto = this.buscarPessoa(pessoa);
		if (indeceQuarto < tam-1) {
			for(int i = indeceQuarto; i < quantidadeElemento-1; i++) {
				pessoas[i] = pessoas[i+1];
			}
		}
		else {
			pessoas[tam-1] = null;
		}
		quantidadeElemento--;
	}
	
	public void atualizarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException{
		int indicePessoa = this.buscarPessoa(pessoa);
		pessoas[indicePessoa].setNome(pessoa.getNome());
		pessoas[indicePessoa].setSenha(pessoa.getSenha());
	}
	public void atualizarPessoa(String cpf,String nome, String senha)
			throws PessoaNaoEncontradoException{
		int indicePessoa = this.buscarPessoa(cpf);
		pessoas[indicePessoa].setNome(nome);
		pessoas[indicePessoa].setSenha(senha);
	}

}

    

