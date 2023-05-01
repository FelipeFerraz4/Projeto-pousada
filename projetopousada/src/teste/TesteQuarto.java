package teste;

import dados.Normal;
import dados.Prime;
import repositorio.RepositorioQuarto;

public class TesteQuarto {
	public static void main(String[] args) {
		
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
		
		quartos.deletarQuarto(1);
		indexQuarto = quartos.buscarQuarto(prime1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuartos().get(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
	}
}