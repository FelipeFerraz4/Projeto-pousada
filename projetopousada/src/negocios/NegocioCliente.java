package negocios;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import dados.repositoriosquartos.IRepositorioQuarto;
import dados.repositoriosquartos.RepositorioQuartoArrayList;
import negocios.Pessoa.*;

public class NegocioCliente {
	
	private IRepositorioPessoa pessoas;
	private IRepositorioQuarto quartos;
	
	public NegocioCliente() {
		this.pessoas = new RepositorioPessoaArrayList();
		this.quartos = new RepositorioQuartoArrayList();
	}
	
	public void cadastrarNovoCliente(Gerente adm, String nome, String cpf, String senha) {
		Cliente cliente = new Cliente(nome, cpf, senha);
		//tratar a exception de addPessoa
		adm.addPessoa(pessoas, cliente);
	}
	
}
