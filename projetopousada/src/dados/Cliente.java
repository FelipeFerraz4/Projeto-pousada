package dados;

import java.util.Scanner;
import dados.*;
import repositorio.RepositorioQuarto;

public class Cliente extends Pessoa {
	
	//private float Consumo;
//	public String Historico;
	private int diarias;
	//private int capacidade;
	private int Historico=0;
	private Normal quartoNormal;
	private Prime quartoPrime;
	//private Quarto quarto;

	
	public Cliente (String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
	}
	

	public int getHistorico() {
		return Historico;
	}
	public void setHistorico(int historico) {
		Historico = Historico + historico;
	}


	public int checkin(RepositorioQuarto quartos) {
		int opção;
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual opcao de quarto gostaria ?");
		System.out.println("1 - Quarto Normal(2-4)");
		System.out.println("2 - Quarto Prime(5-7)");
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
			diarias();
			//falta algo para definir esse numero do quarto
			int indexQuarto = quartos.quartoVazio(1);
			if (indexQuarto == -1){
				System.out.println("pousada esta lotada, favor falar com o gerente");
				return -1;
			}
			else{
				setQuarto(quartos.getQuartos().get(indexQuarto));
				setHistorico(1);
				return 0;
			}
		}
		if (opção == 2) {
			diarias();
			int indexQuarto = quartos.quartoVazio(2);
			if (indexQuarto == -1){
				System.out.println("pousada esta lotada, favor falar com o gerente");
				return -1;
				
			}
			else{
				setQuarto(quartos.getQuartos().get(indexQuarto));
				setHistorico(1);
				return 0;
			}
				
		}
		return 0;	
	}
	
	public void sevircodequarto(RepositorioQuarto quartos,int indexQuarto) {
		if (quartos.getQuartos().get(indexQuarto).getTipoQuarto()==1){
			int opção,quantidade;
			Normal quartoNormal = (Normal) quartos.getQuartos().get(indexQuarto);
			Scanner scan = new Scanner(System.in);
			System.out.println("Qual opção de quarto gostaria?");
			System.out.println("1 - Água - 2,00");
			System.out.println("2 - Refrigarante - 4,00");
			System.out.println("3 - Voltar");
			
			do{
				System.out.println("Escolha sua opção: ");
				opção = scan.nextInt();
				if(opção>3 || opção<1) {
					System.out.println("Opção Invalida:");
				}
			}while(opção>3 || opção<1);
			
			if (opção==1){
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				quartoNormal.agua(quantidade);
				
			}
			if (opção==2){
				
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				quartoNormal.refrigerante(quantidade);
				
			}
			else{
			}
		}
		else{
			int opção,quantidade;
			Prime quartoPrime = (Prime) quartos.getQuartos().get(indexQuarto);
			Scanner scan = new Scanner(System.in);
			System.out.println("Qual opção de quarto gostaria?");
			System.out.println("1 - Vinho - 70,00");
			System.out.println("2 - champagne - 120,00");
			System.out.println("3 - Voltar");
			
			do{
				System.out.println("Escolha sua opção: ");
				opção = scan.nextInt();
				if(opção>3 || opção<1) {
					System.out.println("Opção Invalida:");
				}
			}while(opção>3 || opção<1);
			
			if (opção==1){
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				quartoPrime.vinho(quantidade);
			}
			if (opção==2){
				
				System.out.println("Qual a quantidade?");
				quantidade = scan.nextInt();
				quartoPrime.champagne(quantidade);
			}
			else{
			}
		}
	}
	
	//Não está funcionando
	public void verconsumo(RepositorioQuarto quartos, int indexQuarto) {
		System.out.println("seu consumo atual é:R$" + quartos.getQuartos().get(indexQuarto).getConta());
	}
	
	

 	public void historicodeagendamento() { 
		System.out.println("você já fez "+ getHistorico() + " reservas na nossa pousada");
		
	}

	
	public void pagarconsumo(RepositorioQuarto quartos, int index) {
		int opção;
		Scanner scan = new Scanner(System.in);
		System.out.println("valor da conta é "+quartos.getQuartos().get(index).getConta());
		System.out.println("passou");
		System.out.println("Qual forma de pagamento?");
		System.out.println("1 - Dinheiro");
		System.out.println("2 - Cartão");
		System.out.println("3 - Pix");
	
		do{
        	System.out.println(": ");
        	opção = scan.nextInt();
        	if(opção>3 || opção<1) {
        		System.out.println("Opção Invalida:");
        	}
        }while(opção>3 || opção<1);
		
		
		if (opção == 1) {
			System.out.println("pagamento efetuado. Obrigado, volte sempre!!");
		}
		if (opção == 2) {
			System.out.println("insira seu cartão");
			System.out.println("coloque sua senha");
			System.out.println("pagamento aprovado");
		}
		else{
			System.out.println("A chave pix é: 55555");
		}
	
	}
	public void Checkout (){
		//this..setConta(0);
		//this..setOcupado();

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
