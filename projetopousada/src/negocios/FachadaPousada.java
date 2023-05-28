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
	public int quartoVazio(int tipoQuarto){
		return user.quartovazio(tipoQuarto);
	}
	public int buscarQuarto(int indexQuarto){
		return user.buscarQuarto(indexQuarto);
	}
	public void sevircoDeQuarto(int tipoDeServico , int indexQuarto, int quantidade){
		if(tipoDeServico == 1){
			user.agua(indexQuarto, quantidade);
		}
		if (tipoDeServico == 2){
			user.refrigerante(indexQuarto, quantidade);
		}
		if (tipoDeServico == 3){
			user.vinho(indexQuarto, quantidade);
		}
		if(tipoDeServico == 4){
			user.champagne(indexQuarto, quantidade);
		}
	}
	public void reservarQuarto(int indexQuarto, int diarias){
		user.reservarQuarto(indexQuarto, diarias);
	}
	public float consumo(int indexQuarto){
		return user.consumo(indexQuarto);
	}
	public void pagarConta(int indexQuarto){
		user.pagarConta(indexQuarto);
	}
	public String dadosDoCliente(int indexPessoa){
		return user.dadosDoCliente(indexPessoa);
	}
	public int isCheckin (int indexCliente){
		return user.isCheckin(indexCliente);

	}
	public void setCheckin(int indexCliente, boolean checkin){
		user.setCheckin(indexCliente, checkin);
	}
	public int getHistorico(int indexPessoa){
		return user.getHistorico(indexPessoa);
	}
	
	public void setHistorico(int indexPessoa){
		user.setHistorico(indexPessoa);
	}
}
