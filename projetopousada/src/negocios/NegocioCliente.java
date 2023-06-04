package negocios;

import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import dados.repositoriosquartos.IRepositorioQuarto;
import dados.repositoriosquartos.RepositorioQuartoArrayList;
import exceptionpousada.QuartoNaoEncontradoException;
import negocios.Pessoa.*;
import negocios.Quarto.*;

public class NegocioCliente {
	
	private IRepositorioQuarto quartos;
	private IRepositorioPessoa pessoas;
	
	public NegocioCliente(IRepositorioPessoa repositorioPessoa, IRepositorioQuarto repositorioQuarto) {
		this.pessoas = repositorioPessoa;
		this.quartos = repositorioQuarto;
	}
	public int quartovazio(int tipoQuarto) throws QuartoNaoEncontradoException{
		return quartos.quartoVazio(tipoQuarto);

	}
	public void buscarCliente(int indexCliente){
		pessoas.getPessoa(indexCliente);
	}
	// usa quarto 
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
	// usa quarto
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
		//String cliente = pessoas.getPessoa(indexPessoa).toString();
		//return cliente;
		if (pessoas.getPessoa(indexPessoa).getQuarto() != null) {
			System.out.println("ola");
			String dadosQuarto = pessoas.getPessoa(indexPessoa).getQuarto().toString();
			return pessoas.getPessoa(indexPessoa).toString() + dadosQuarto;
		}
		return pessoas.getPessoa(indexPessoa).toString();
	}
	public int isCheckin (int indexCliente){
		Cliente cliente = (Cliente) pessoas.getPessoa(indexCliente);
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
