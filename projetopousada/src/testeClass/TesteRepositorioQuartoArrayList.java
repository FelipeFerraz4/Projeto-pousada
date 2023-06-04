package testeClass;

import dados.repositoriosquartos.*;
import exceptionpousada.QuartoNaoEncontradoException;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class TesteRepositorioQuartoArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		IRepositorioQuarto quartos = new RepositorioQuartoArrayList();
		Normal quartoNormal1 = new Normal(1);
		Prime quartoPrime1 = new Prime(1);
		
		try {
			quartos.adicionarQuarto(100, 1);
			System.out.println(quartos.getQuarto(0));
			quartos.adicionarQuarto(100, 1);
			System.out.println(quartos.getQuarto(0));
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		quartos.adicionarQuarto(quartoPrime1);
		System.out.println(quartos.getQuarto(1));
		
		quartos.adicionarQuarto(quartoNormal1);
		int indexQuarto = -1;
		try {
			indexQuarto = quartos.buscarQuarto(quartoNormal1);
			System.out.println(quartos.getQuarto(indexQuarto).toString());
		} catch (QuartoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			System.out.println("Quarto informadao nao existe\n");
		}
		
		try {
			quartos.deletarQuarto(quartoNormal1);
		} catch (QuartoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			indexQuarto = quartos.buscarQuarto(quartoNormal1);
			if(indexQuarto != -1 ) {
				System.out.println(quartos.getQuarto(indexQuarto));
			}
			else {
				System.out.println("Quarto informadao nao existe\n");
			}
		} catch (QuartoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			System.out.println("Quarto nao encontrado\n");
		}
		
		try {
			indexQuarto = quartos.buscarQuarto(100, 1);
			System.out.println(quartos.getQuarto(indexQuarto));
		} catch (QuartoNaoEncontradoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			quartos.deletarQuarto(100, 1);
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Quarto informadao nao existe\n");
		}
			
		try {
			indexQuarto = quartos.buscarQuarto(100, 1);
			System.out.println(quartos.getQuarto(indexQuarto));
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Quarto informadao nao existe\n");
		}
		
		System.out.println(quartos.getQuarto(0));
		Normal quarto = (Normal) quartos.getQuarto(0);
		quarto.setConta(1000);
		try {
			quartos.atualizarQuarto(quarto);
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Quarto informadao nao existe\n");
		}
		System.out.println(quartos.getQuarto(0));
		
		try {
			indexQuarto = quartos.quartoVazio(2);
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Quarto informadao nao existe\n");
		}
		System.out.println(quartos.getQuarto(indexQuarto));
		
	}

}
