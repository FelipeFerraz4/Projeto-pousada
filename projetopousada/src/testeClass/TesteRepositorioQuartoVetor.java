package testeClass;

import dados.repositoriospessoas.*;
import dados.repositoriosquartos.*;
import exceptionpousada.QuartoNaoEncontradoException;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class TesteRepositorioQuartoVetor {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		IRepositorioQuarto quartos = new RepositorioQuartoVetor();
		Normal quartoNormal1 = new Normal(1);
		Prime quartoPrime1 = new Prime(1);
		
		try {
			for(int i = 0; i <= 3; i++) {
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
		
		quartos.adicionarQuarto(quartoPrime1);
		System.out.println(quartos.getQuarto(1));
		
		quartos.adicionarQuarto(quartoNormal1);
		int indexQuarto = quartos.buscarQuarto(quartoNormal1);
		if(indexQuarto != -1 ) {
			System.out.println(quartos.getQuarto(indexQuarto).toString());
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
				System.out.println("Quarto informadao nao existe\n");
			}
		}
		catch(java.lang.ArrayIndexOutOfBoundsException e){
			System.out.println(e.getMessage() +" "+ e.getClass());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			quartos.deletarQuarto(quartoNormal1);
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			indexQuarto = quartos.buscarQuarto(quartoNormal1);
			System.out.println(quartos.getQuarto(indexQuarto));
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

		
		try {
			quartos.deletarQuarto(100, 1);
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Quarto nao encontrado\n");
		}

			
		try {
			indexQuarto = quartos.buscarQuarto(100, 1);
			System.out.println(quartos.getQuarto(indexQuarto));
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Quarto informadao nao existe\n");
		}

		
		
		try {
			System.out.println(quartos.getQuarto(0));
			Normal quarto = (Normal) quartos.getQuarto(0);
			quarto.setConta(1000);
			quartos.atualizarQuarto(quarto);
			System.out.println(quartos.getQuarto(0));
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro na atualizacao\n");
		}
		

		try {
			indexQuarto = quartos.quartoVazio(1);
			System.out.println(quartos.getQuarto(indexQuarto));
		} catch (QuartoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			System.out.println("erro na busca por um quarto vazio");
		}
		
	}
	
}
