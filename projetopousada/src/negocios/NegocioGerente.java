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
	public void cadastrarQuartoNormal(int numeroQuarto) {
		Normal quarto = new Normal(numeroQuarto);
		//tratar a exception de addQuarto
		gerente.addQuarto(quartos, quarto);
	}
	public void cadastrarQuartoPrime(int numeroQuarto) {
		Prime quarto = new Prime(numeroQuarto);
		//tratar a exception de addQuarto
		gerente.addQuarto(quartos, quarto);
	}
	
	public int buscarPessoa(String cpf) {
		return gerente.consultarPessoa(pessoas, cpf);
	}
	public int buscarQuarto(int numeroQuarto, int tipoQuarto) {
		return gerente.consultarQuarto(quartos, numeroQuarto, tipoQuarto);
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
	
	public String toStringPessoa(int indexPessoa) {
		String toStringPessoa = gerente.getPessoa(pessoas, indexPessoa).toString();
		if (gerente.getPessoa(pessoas, indexPessoa).getQuarto()!=null) {
    		return toStringPessoa + 
    				gerente.getPessoa(pessoas, indexPessoa).getQuarto().toString();
    	}
		return toStringPessoa;
	}

}
