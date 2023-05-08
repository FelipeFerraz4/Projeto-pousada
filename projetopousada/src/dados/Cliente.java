package dados;

import java.util.Scanner;
import dados.*;

public class Cliente extends Pessoa {
	
	//private float Consumo;
//	public String Historico;
	private float ValorQuarto;
	private int diarias = 0;
	private int capacidade;
	private int Historico;
//	private Quarto quarto;
	
	public Cliente (String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
	}
	/*public Cliente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
	}*/
	
	
	/*public float getConsumo(int valorQuarto,int produto,int quantidade) {
		Consumo = valorQuarto + produto*quantidade; 
		return Consumo;
	}

	public void setConsumo(float consumo) {
		Consumo = ValorQuarto + consumo;
	}*/

	public int getHistorico() {
		return Historico;
	}
	public void setHistorico(int historico) {
		Historico = Historico + historico;
	}


	public void checkin() {
		int opção;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual opção de quarto gostaria?");
		System.out.println("1 - Quarto Normal(2-4)");
		System.out.println("2 - Quarto Prime(5-7)");
		System.out.println("3 - Voltar");
		
		do{
        	System.out.println("Escolha sua opção: ");
        	opção = scan.nextInt();
        	if(opção>3 || opção<1) {
        		System.out.println("Opção Invalida:");
        	}
        }while(opção>3 || opção<1);
		
		if (opção == 1) {
			tamanhoDoQuarto();
			diarias();
			this.checkin();
		}
		if (opção == 2) {
			tamanhoDoQuarto();
			diarias();
			
			this.checkin();
		}
		if(opção == 3) {
			
		}
		
		
	}
	
	public void sevircodequarto() {
		int opção,quantidade;
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
			Normal n1 = new Normal(1);
			System.out.println("Qual a quantidade?");
			quantidade = scan.nextInt();
			n1.agua(quantidade);
		}
		if (opção==2){
			Normal n1 = new Normal(1);
			System.out.println("Qual a quantidade?");
			quantidade = scan.nextInt();
			n1.refrigerante(quantidade);
		}
		else{
		}
		
		System.out.println("seriço de quarto acionado");
	}

	public void verconsumo() {
		float consumo;
		Normal n1 = new Normal(1);
		consumo = n1.getConta();
		System.out.println("seu consumo atual é:R$" + consumo );
	}
	
	

 	public void historicodeagendamento(int i) { 
		System.out.println("você já fez "+ Historico + "reservas na nossa pousada");
		System.out.println("Reservas anteriores:");
	}

	
	public void pagarconsumo() {
		int opção;
		Scanner scan = new Scanner(System.in);
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
			sleep(1000);
			System.out.println("coloque sua senha");
			sleep(1000);
			System.out.println("pagamento aprovado");
		}
	
	}
	public void Checkout (){
		historicodeagendamento(1);
	}
	
	public void tamanhoDoQuarto() {
		int n;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual a capacidade do quarto você deseja?");
		System.out.println("1 - 2 pessoa");
		System.out.println("2 - 3 pessoas");
		System.out.println("3 - 4 pessoas");
		do {
			System.out.println("digite sua escolha:");
			n = scan.nextInt();
		if (n < 1 || n >3) {
			System.out.println("opção inavalida");
		}
		
		} while(n < 1 || n >3);
		
		this.capacidade = n+1;
	}
	
	public void diarias() {
		int d;
		Scanner scan = new Scanner(System.in);
		System.out.println("quantas diarias deseja reservar?");
		do {
			System.out.println(":");
			d = scan.nextInt();
		if (d < 1 || d >15) {
			System.out.println("o maximo de diarias possivel são 15 por pessoa!");
		}
		} while(d < 1 || d >15);
		scan.close();
		this.diarias = d;
	}
	
	private void sleep(int i) {
	}

}
