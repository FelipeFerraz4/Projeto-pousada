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
	
	public NegocioGerente() {
		this.pessoas = new RepositorioPessoaArrayList();
		this.quartos = new RepositorioQuartoArrayList();
		classesDefault();
	}
	
	public void classesDefault() {
		Gerente adm = new Gerente("Andre", "0000", "12345");
		Normal quarto = new Normal(10001);
		adm.setQuarto(quarto);
		quarto.setOcupado(true);
		pessoas.addPessoa(adm);
		quartos.adicionarQuarto(quarto);
		
		Cliente cliente1 = new Cliente("Felipe", "1111", "12345");
		Cliente cliente2 = new Cliente("Alice", "2222", "12345");
		
		pessoas.addPessoa(adm);
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
	
	
	

}
