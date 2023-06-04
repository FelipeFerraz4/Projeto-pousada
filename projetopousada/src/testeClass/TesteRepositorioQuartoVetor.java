package testeClass;

import dados.repositoriospessoas.*;
import dados.repositoriosquartos.*;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class TesteRepositorioQuartoVetor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		IRepositorioQuarto quartos = new RepositorioQuartoVetor();
		Normal quartoNormal1 = new Normal(1);
		Prime quartoPrime1 = new Prime(1);
		
		try {
			for(int i = 0; i <= 53; i++) {
				quartos.adicionarQuarto(100, 1);
				System.out.println(quartos.getQuarto(0));
			}
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		try {
			quartos.adicionarQuarto(quartoPrime1);
			System.out.println(quartos.getQuarto(1));
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		int indexQuarto;
		try {
			quartos.adicionarQuarto(quartoNormal1);
			indexQuarto = quartos.buscarQuarto(quartoNormal1);
			if(indexQuarto != -1 ) {
				System.out.println(quartos.getQuarto(indexQuarto).toString());
			}
			else {
				System.out.println("Quarto informadao nao existe");
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		int result = quartos.deletarQuarto(quartoNormal1);
		if (result==1) {
			System.out.println("Quarto deletado");
		}
		else {
			System.out.println("Problema na delecao do Quarto");
		}
			
		indexQuarto = quartos.buscarQuarto(quartoNormal1);
		if(indexQuarto != -1 ) {
			System.out.println(quartos.getQuarto(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		indexQuarto = quartos.buscarQuarto(100, 1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuarto(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		result = quartos.deletarQuarto(100, 1);
		if (result==1) {
			System.out.println("Quarto deletado");
		}
		else {
			System.out.println("Problema na delecao do Quarto");
		}
			
		indexQuarto = quartos.buscarQuarto(100, 1);
		if(indexQuarto > -1 ) {
			System.out.println(quartos.getQuarto(indexQuarto));
		}
		else {
			System.out.println("Quarto informadao nao existe");
		}
		
		System.out.println(quartos.getQuarto(0));
		Normal quarto = (Normal) quartos.getQuarto(0);
		quarto.setConta(1000);
		quartos.atualizarQuarto(quarto);
		System.out.println(quartos.getQuarto(0));
		
		indexQuarto = quartos.quartoVazio(1);
		System.out.println(quartos.getQuarto(indexQuarto));
		
	}
	
}
