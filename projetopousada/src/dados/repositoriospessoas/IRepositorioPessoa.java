package dados.repositoriospessoas;
import negocios.*;
import negocios.Pessoa.Pessoa;

public interface IRepositorioPessoa {
    public void addPessoa(Pessoa pessoa);
    public int buscarPessoa(Pessoa pessoa);
    public int deletarPessoa(Pessoa pessoa);
    public int atualizarPessoa(Pessoa pessoa);

    
    public void criarPessoa(String nome, String cpf, String senha, int tipoPessoa);
    public int buscarPessoa(String cpf);
    public int deletarPessoa(String cpf);
    public int atualizarPessoa(String cpf,String nome, String senha);
   

}
