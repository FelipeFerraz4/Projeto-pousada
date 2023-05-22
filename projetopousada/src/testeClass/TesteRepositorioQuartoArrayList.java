package testeClass;

import dados.*;
import dados.repositoriosquartos.IRepositorioQuarto;
import negocios.*;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class TesteRepositorioQuartoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		IRepositorioQuarto quartos = new RepositorioQuartoArrayList();
		Normal quartoNormal1 = new Normal(1);
		Prime quartoPrime1 = new Prime(1);
		
		quartos.adicionarQuarto(100, 1);
		System.out.println(quartos.getQuarto(0));
		
		quartos.adicionarQuarto(quartoPrime1);
		System.out.println(quartos.getQuarto(1));
		
		quartos.adicionarQuarto(quartoNormal1);
		int indexQuarto = quartos.buscarQuarto(quartoNormal1);
		if(indexQuarto != -1 ) {
			System.out.println(quartos.getQuarto(indexQuarto).toString());
		}
		else {
			System.out.println("Quarto informadao nao existe");
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
		Prime quarto = (Prime) quartos.getQuarto(0);
		quarto.setConta(1000);
		quartos.atualizarQuarto(quarto);
		System.out.println(quartos.getQuarto(0));
		
		indexQuarto = quartos.quartoVazio(2);
		System.out.println(quartos.getQuarto(indexQuarto));
		
	}

}
