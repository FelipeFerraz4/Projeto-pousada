package dados.repositoriospessoas;
import exceptionpousada.PessoaNaoEncontradoException;
import negocios.*;
import negocios.Pessoa.Pessoa;

public interface IRepositorioPessoa {
	
	public Pessoa getPessoa(int indexPessoa);
	
    public void addPessoa(Pessoa pessoa)throws ArrayIndexOutOfBoundsException;
    public int buscarPessoa(Pessoa pessoa) throws PessoaNaoEncontradoException;
    public void deletarPessoa(Pessoa pessoa)throws PessoaNaoEncontradoException;
    public void atualizarPessoa(Pessoa pessoa)throws PessoaNaoEncontradoException;

    
    public void criarPessoa(String nome, String cpf, String senha, int tipoPessoa)throws ArrayIndexOutOfBoundsException;
    public int buscarPessoa(String cpf)throws PessoaNaoEncontradoException;
    public void deletarPessoa(String cpf)throws PessoaNaoEncontradoException;
    public void atualizarPessoa(String cpf,String nome, String senha)throws PessoaNaoEncontradoException;
   

}
