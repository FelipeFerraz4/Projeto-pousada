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
	public void cadastrarNovoGerente(String nome, String cpf, String senha) {
		adm.cadastrarNovoGerente(nome, cpf, senha);
	}
	public void cadastrarQuartoNormal(int numeroQuarto) {
		adm.cadastrarQuartoNormal(numeroQuarto);
	}
	public void cadastrarQUartoPrime(int numeroQuarto) {
		adm.cadastrarQuartoPrime(numeroQuarto);
	}
	public int deletarPessoa(String cpf) {
		return adm.deletarPessoa(cpf);
	}
	public int deletarQuarto(int numeroQuarto, int tipoQuarto) {
		return adm.deletarQuarto(numeroQuarto, tipoQuarto);
	}
	public int buscarPessoa(String cpf) {
		return adm.buscarPessoa(cpf);
	}
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) {
		return adm.buscarQuarto(numeroQuarto, tipoQuarto);
	}
	public void modificarPessoaNome(int indexPessoa, String nome) {
		adm.modificarPessoaNome(indexPessoa, nome);
	}
	public void modificarPessoaSenha(int indexPessoa, String senha) {
		adm.modificarPessoaSenha(indexPessoa, senha);
	}
	public void modificarQuartoConsumo(int indexQuarto, float consumo) {
		adm.modificarQuartoConsumo(indexQuarto, consumo);
	}
	public void modificarQuartoCapacidade(int indexQuarto, int capacidade) {
		adm.modificarQuartoCapacidade(indexQuarto, capacidade);
	}
	public void modificarQuartoPrecoQuarto(int indexQuarto, float precoQuarto) {
		adm.modificarQuartoPrecoQuarto(indexQuarto, precoQuarto);
	}
	public void modificarQuartoOcupado(int indexQuarto) {
		adm.modificarQuartoOcupado(indexQuarto);
	}
	public int verificarSenha(int indexPessoa, String senha) {
		return adm.verificarSenha(indexPessoa, senha);
	}
	public int verificarTipoPessoa(int indexPessoa) {
		return adm.verificarTipoPessoa(indexPessoa);
	}
	public String toStringPessoa(int indexPessoa) {
		return adm.toStringPessoa(indexPessoa);
	}
	public String toStringQuarto(int indexQuarto) {
		return adm.toStringQuarto(indexQuarto);
	}
}
