package negocios;

import java.util.Scanner;

import dados.RepositorioQuarto;
import negocios.*;

public class Cliente extends Pessoa {
	
	private int diarias;
	private int historico;
	private boolean checkin;

	
	public Cliente (String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
		this.checkin = false;
		this.historico = 0;
	}
	

	public int getDiarias() {
		return diarias;
	}


	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}


	public boolean isCheckin() {
		return checkin;
	}


	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}


	public int getHistorico() {
		return historico;
	}
	public void setHistorico(int novoHistorico) {
		this.historico = novoHistorico;
	}


	public int checkin(RepositorioQuarto quartos) {
		int opção;
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual opcao de quarto gostaria ?");
		System.out.println("1 - Quarto Normal ate 3 pessoas - 250,00");
		System.out.println("2 - Quarto Prime ate 7 pessoas - 400,00");
		System.out.println("3 - Voltar");
		
		do{
        	System.out.println("Escolha sua opcao: ");
        	opção = scan.nextInt();
        	if(opção>3 || opção<1) {
        		System.out.println("Opcao Invalida:");
        	}
        }while(opção>3 || opção<1);
		
		if (opção == 1) {
			
			//tamanhoDoQuarto();
			//falta algo para definir esse numero do quarto
			int indexQuarto = quartos.quartoVazio(1);
			if (indexQuarto == -1){
				System.out.println("pousada esta lotada, por favor falar com o gerente");
				return -1;
			}
			else{
				diarias();
				setQuarto(quartos.getQuartos().get(indexQuarto));
				Normal quarto = (Normal) quartos.getQuartos().get(indexQuarto);
				quarto.setOcupado();
				quarto.diaria(this.diarias);
				setHistorico(1+this.getHistorico());
				this.checkin = true;
				System.out.println("Check-in finalizado");
				return 0;
			}
		}
		if (opção == 2) {
			int indexQuarto = quartos.quartoVazio(2);
			if (indexQuarto == -1){
				System.out.println("pousada esta lotada, favor falar com o gerente");
				return -1;
				
			}
			else{
				diarias();
				setQuarto(quartos.getQuartos().get(indexQuarto));
				Prime quarto = (Prime) quartos.getQuartos().get(indexQuarto);
				quarto.setOcupado();
				quarto.diaria(this.diarias);
				//quartos.getQuartos().get(indexQuarto).setOcupado();
				setHistorico(1+this.getHistorico());
				this.checkin = true;
				System.out.println("Check-in finalizado");
				return 0;
			}
				
		}
		return 0;	
	}
	
	public void sevircoDeQuarto(RepositorioQuarto quartos,int indexQuarto) {
		if (quartos.getQuartos().get(indexQuarto).getTipoQuarto()==1){
			int opcao,quantidade;
			Normal quartoNormal = (Normal) quartos.getQuartos().get(indexQuarto);
			Scanner scan = new Scanner(System.in);
			System.out.println("Qual opcao de quarto gostaria ?");
			System.out.println("1 - Agua - 2,00");
			System.out.println("2 - Refrigarante - 4,00");
			System.out.println("3 - Voltar");
			
			do{
				System.out.println("Escolha sua opcao: ");
				opcao = scan.nextInt();
				if(opcao > 3 || opcao<1) {
					System.out.println("Opcao Invalida:");
				}
			}while(opcao>3 || opcao<1);
			
			if (opcao==1){
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				if(quantidade>=0) {
					quartoNormal.agua(quantidade);
				}
				else {
					System.out.println("Quantida invalida");
				}
					
				
			}
			if (opcao==2){
				
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				if(quantidade>=0) {
					quartoNormal.refrigerante(quantidade);
				}
				else {
					System.out.println("Quantida invalida");
				}
				
			}
			else{
			}
		}
		else{
			int opcao,quantidade;
			Prime quartoPrime = (Prime) quartos.getQuartos().get(indexQuarto);
			Scanner scan = new Scanner(System.in);
			System.out.println("Qual opcao de quarto gostaria ?");
			System.out.println("1 - Vinho - 70,00");
			System.out.println("2 - champagne - 120,00");
			System.out.println("3 - Voltar");
			
			do{
				System.out.println("Escolha sua opcao: ");
				opcao = scan.nextInt();
				if(opcao>3 || opcao<1) {
					System.out.println("Opcao Invalida:");
				}
			}while(opcao>3 || opcao<1);
			
			if (opcao==1){
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				if(quantidade>=0) {
					quartoPrime.vinho(quantidade);
				}
				else {
					System.out.println("Quantida invalida");
				}
			}
			if (opcao==2){
				
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				if(quantidade>=0) {
					quartoPrime.champagne(quantidade);
				}
				else {
					System.out.println("Quantida invalida");
				}
			}
			else{
			}
		}
	}
	
	public void verConsumo(RepositorioQuarto quartos, int indexQuarto) {
		System.out.println("seu consumo atual: R$" + quartos.getQuartos().get(indexQuarto).getConta());
	}
	
	

 	public void historicoAgendamento() { 
		System.out.println("voce ja fez "+ this.historico + " reservas na nossa pousada");
		
	}

	
	public void pagarConsumo(RepositorioQuarto quartos, int indexQuarto) {
		int opção;
		Scanner scan = new Scanner(System.in);
		System.out.println("valor da conta e "+quartos.getQuartos().get(indexQuarto).getConta());
		System.out.println("passou");
		System.out.println("Qual forma de pagamento?");
		System.out.println("1 - Dinheiro");
		System.out.println("2 - Cartao");
		System.out.println("3 - Pix");
		System.out.println("4 - Voltar");
	
		do{
        	opção = scan.nextInt();
        	if(opção>4 || opção<1) {
        		System.out.println("Opcao Invalida:");
        		System.out.println("Digite a opcao novamente: ");
        	}
        }while(opção>4 || opção<1);
		
		
		if (opção == 1) {
			System.out.println("pagamento efetuado. Obrigado, volte sempre!");
			quartos.getQuartos().get(indexQuarto).setConta(0);
		}
		else if (opção == 2) {
			System.out.println("insira seu cartao");
			System.out.println("coloque sua senha");
			System.out.println("pagamento efetuado. Obrigado, volte sempre!");
			quartos.getQuartos().get(indexQuarto).setConta(0);
		}
		else if (opção == 3){
			System.out.println("A chave pix: 55555");
			System.out.println("pagamento efetuado. Obrigado, volte sempre!");
			quartos.getQuartos().get(indexQuarto).setConta(0);
		}
	
	}
	
	public void diarias() {
		int d;
		Scanner scan = new Scanner(System.in);
		System.out.println("quantas diarias deseja reservar?");
		do {
			d = scan.nextInt();
			if (d < 1 || d >15) {
				System.out.println("o maximo de diarias possivel sao 15 por pessoa!");
				System.out.println("Por favor, digite a quantidadede de diarias desejadas: ");
			}
		} while(d < 1 || d >15);
		
		this.diarias = d;
	}

}
