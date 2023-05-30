package negocios;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import dados.repositoriosquartos.IRepositorioQuarto;
import dados.repositoriosquartos.RepositorioQuartoArrayList;
import negocios.Pessoa.Cliente;
import negocios.Pessoa.Gerente;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class NegocioGerente {
	
	private IRepositorioQuarto quartos;
	private IRepositorioPessoa pessoas;
	private Gerente gerente;
	
	public NegocioGerente(IRepositorioPessoa repositorioPessoa, IRepositorioQuarto repositorioQuarto) {
		this.pessoas = repositorioPessoa;
		this.quartos = repositorioQuarto;
		gerente = new Gerente("admPousada", "00000","12345");
		pessoas.addPessoa(gerente);
		classesDefault();
	}
	
	public void classesDefault() {
		Cliente cliente1 = new Cliente("Paula", "1111", "12345");
		Cliente cliente2 = new Cliente("Alice", "2222", "12345");
		
		pessoas.addPessoa(cliente1);
		pessoas.addPessoa(cliente2);
		
		Normal quartoNormal1 = new Normal(1111);
		Normal quartoNormal2 = new Normal(2222);
		Prime quartoPrime1 = new Prime(1111);
		Prime quartoPrime2 = new Prime(2222);
		
		quartos.adicionarQuarto(quartoNormal1);
		quartos.adicionarQuarto(quartoNormal2);
		quartos.adicionarQuarto(quartoPrime1);
		quartos.adicionarQuarto(quartoPrime2);
	}
	
	
	
	
	public void cadastrarNovoCliente(String nome, String cpf, String senha) {
		Cliente cliente = new Cliente(nome, cpf, senha);
		//tratar a exception de addPessoa
		gerente.addPessoa(pessoas, cliente);
	}
	public void cadastrarNovoGerente(String nome, String cpf, String senha) {
		Gerente gerente = new Gerente(nome, cpf, senha);
		//tratar a exception de addPessoa
		gerente.addPessoa(pessoas, gerente);
	}
	public int buscarPessoa(String cpf) {
		return gerente.consultarPessoa(pessoas, cpf);
	}
	public int verificarSenha(int indexPessoa, String senha) {
		if (pessoas.getPessoa(indexPessoa).getSenha().equals(senha)) {
			return 1;
		}
		return -1;
	}
	public int verificarTipoPessoa(int indexPessoa) {
		if (pessoas.getPessoa(indexPessoa).getTipoPessoa() == 1) {
			return 1;
		}
		else {
			return 2;
		}
	}




		//A partir daqui acontece um duplicação de codigo com o NegocioCliente,
		//só foi feito em prol do codigo rodar;



		public int quartovazio(int tipoQuarto){
			return quartos.quartoVazio(tipoQuarto);
	
		}
		public void buscarCliente(int indexCliente){
			pessoas.getPessoa(indexCliente);
		}
		public void reservarQuarto(int indexQuarto, int diarias, int tipoDeQuarto){
			if(tipoDeQuarto == 1){
				Normal quarto = (Normal)quartos.getQuarto(indexQuarto);
				quarto.setOcupado(true);
				quarto.diaria(diarias);}
			else{
				Prime quarto = (Prime)quartos.getQuarto(indexQuarto);
				quarto.setOcupado(true);
				quarto.diaria(diarias);
			}
		}
		public int buscarQuarto(int indexQuarto){
			return quartos.getQuarto(indexQuarto).getTipoQuarto();
			
		}
	
		public void agua(int indexCliente, int quantidade){
			Normal quarto = (Normal)quartos.getQuarto(indexCliente);
			quarto.agua(quantidade);
		}
		public void refrigerante(int indexCliente, int quantidade){
			Normal quarto = (Normal)quartos.getQuarto(indexCliente);
			quarto.refrigerante(quantidade);
		}
		public void vinho(int indexCliente, int quantidade){
			Prime quarto = (Prime)quartos.getQuarto(indexCliente);
			quarto.vinho(quantidade);
		}
		public void champagne(int indexCliente, int quantidade){
			Prime quarto = (Prime)quartos.getQuarto(indexCliente);
			quarto.champagne(quantidade);
		}
		public float consumo(int indexQuarto){
			return quartos.getQuarto(indexQuarto).getConta();
			
		}
		public void pagarConta(int indexQuarto){
			quartos.getQuarto(indexQuarto).setConta(0);
		}
		public String dadosDoCliente(int indexPessoa){
			String cliente = pessoas.getPessoa(indexPessoa).toString();
			return cliente;
			
		}
		public int isCheckin (int indexCliente){
			Cliente cliente = (Cliente)pessoas.getPessoa(indexCliente);
			if (cliente.isCheckin() == false ){
				return -1;
			}
			else{ 
				return 1;
			}
		}
		public void setCheckin(int indexCliente, boolean checkin){
			Cliente cliente = (Cliente) pessoas.getPessoa(indexCliente);
			cliente.setCheckin(checkin);
		}
	
		public int getHistorico(int indexPessoa){
			Cliente cliente = (Cliente) pessoas.getPessoa(indexPessoa);
			return cliente.getHistorico();
		}
	
		public void setHistorico(int indexPessoa){
			Cliente cliente = (Cliente) pessoas.getPessoa(indexPessoa);
			int novoHistorico = cliente.getHistorico()+1;
			cliente.setHistorico(novoHistorico);
		}











}
