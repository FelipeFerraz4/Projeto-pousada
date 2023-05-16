package iuconsole;

import dados.RepositorioQuarto;
import negocios.Normal;
import negocios.Prime;

public class TesteQuarto {
	public static void main(String[] args) {
		
		// teste da classe Normal
		
		Normal normal1 = new Normal(1);
		
		System.out.println(normal1.getNumeroQuato());
		System.out.println(normal1.getTipoQuarto());
		System.out.println(normal1.getPreco());
		System.out.println(normal1.getConta());
		System.out.println(normal1.isOcupado());
		System.out.println(normal1.getCapacidade());
		
		normal1.agua(2);
		System.out.println(normal1.getConta());
		
		normal1.refrigerante(3);
		System.out.println(normal1.getConta());
		
		normal1.diaria(4);
		System.out.println(normal1.getConta());
		
		System.out.println(normal1.toString());
		
		System.out.println("\n");
		
		// teste da classe Prime
		
		Prime prime1 = new Prime(1);
		
		System.out.println(prime1.getNumeroQuato());
		System.out.println(prime1.getTipoQuarto());
		System.out.println(prime1.getPreco());
		System.out.println(prime1.getConta());
		System.out.println(prime1.isOcupado());
		System.out.println(prime1.getCapacidade());
		
		prime1.vinho(2);
		System.out.println(prime1.getConta());
		
		prime1.champagne(1);
		System.out.println(prime1.getConta());
		
		prime1.diaria(4);
		System.out.println(prime1.getConta());
		
		System.out.println(prime1.toString());
		
		System.out.println("\n");
		
		// teste da classe RepositorioQuarto



		
		RepositorioQuarto quartos = new RepositorioQuarto();
		
		quartos.criarQuarto(100, 1);
		System.out.println(quartos.getQuartos().get(0));
		
		quartos.adicionarQuarto(prime1);
		System.out.println(quartos.getQuartos().get(1));
		
		quartos.adicionarQuarto(normal1);
		int indexQuarto = quartos.buscarQuarto(normal1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuartos().get(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		int res = quartos.deletarQuarto(1);
		if (res==1) {
			System.out.println("Quarto deletado");
		}
		else {
			System.out.println("Problema na delecao do Quarto");
		}
			
		indexQuarto = quartos.buscarQuarto(prime1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuartos().get(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		indexQuarto = quartos.buscarQuarto(100, 1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuartos().get(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		res = quartos.deletarQuarto(100, 1);
		if (res==1) {
			System.out.println("Quarto deletado");
		}
		else {
			System.out.println("Problema na delecao do Quarto");
		}
			
		indexQuarto = quartos.buscarQuarto(100, 1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuartos().get(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		System.out.println(quartos.getQuartos().get(0));
		Normal quarto = (Normal) quartos.getQuartos().get(0);
		quarto.setOcupado();
		quartos.atualizarQuarto(quarto);
		System.out.println(quartos.getQuartos().get(0));
		
		indexQuarto = quartos.quartoVazio(1);
		System.out.println(quartos.getQuartos().get(indexQuarto));

		
	}
}
