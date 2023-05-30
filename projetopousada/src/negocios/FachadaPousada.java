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







	// mudança de user para adm feita a partir daqui



	public int quartoVazio(int tipoQuarto){
		return adm.quartovazio(tipoQuarto);
	}
	public int buscarQuarto(int indexQuarto){
		return adm.buscarQuarto(indexQuarto);
	}
	public void sevircoDeQuarto(int tipoDeServico , int indexQuarto, int quantidade){
		if(tipoDeServico == 1){
			adm.agua(indexQuarto, quantidade);
		}
		if (tipoDeServico == 2){
			adm.refrigerante(indexQuarto, quantidade);
		}
		if (tipoDeServico == 3){
			adm.vinho(indexQuarto, quantidade);
		}
		if(tipoDeServico == 4){
			adm.champagne(indexQuarto, quantidade);
		}
	}
	public void reservarQuarto(int indexQuarto, int diarias, int tipoDeQuarto){
		adm.reservarQuarto(indexQuarto, diarias, tipoDeQuarto);
	}
	public float consumo(int indexQuarto){
		return adm.consumo(indexQuarto);
	}
	public void pagarConta(int indexQuarto){
		adm.pagarConta(indexQuarto);
	}
	public String dadosDoCliente(int indexPessoa){
		return adm.dadosDoCliente(indexPessoa);
	}
	public int isCheckin (int indexCliente){
		return adm.isCheckin(indexCliente);

	}
	public void setCheckin(int indexCliente, boolean checkin){
		adm.setCheckin(indexCliente, checkin);
	}
	public int getHistorico(int indexPessoa){
		return adm.getHistorico(indexPessoa);
	}
	
	public void setHistorico(int indexPessoa){
		adm.setHistorico(indexPessoa);
	}
}
