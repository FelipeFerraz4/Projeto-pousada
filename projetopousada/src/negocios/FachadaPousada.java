package negocios;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import dados.repositoriosquartos.IRepositorioQuarto;
import dados.repositoriosquartos.RepositorioQuartoArrayList;
import negocios.Pessoa.Cliente;
import negocios.Pessoa.Gerente;

public class FachadaPousada {
	
	private NegocioGerente adm;
	private NegocioCliente user;
	
	public FachadaPousada() {
		this.adm = new NegocioGerente(new RepositorioPessoaArrayList(), new RepositorioQuartoArrayList());
		this.user = new NegocioCliente(new RepositorioPessoaArrayList(), new RepositorioQuartoArrayList());
		this.adm.cadastrarNovoGerente("admPousada", "00000","12345");
	}
	
	public void cadastrarNovoCliente(String nome, String cpf, String senha) {
		adm.cadastrarNovoCliente(nome, cpf, senha);
	}
	public int buscarPessoa(String cpf) {
		return adm.buscarPessoa(cpf);
	}
	public int verificarSenha(int indexPessoa, String senha) {
		return adm.verificarSenha(indexPessoa, senha);
	}
	public int verificarTipoPessoa(int indexPessoa) {
		return adm.verificarTipoPessoa(indexPessoa);
	}
}
