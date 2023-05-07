package dados;

import java.util.Scanner;

public class Cliente extends Pessoa {
	
	public Cliente (String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
	}

	
	
/*	
//	private float Consumo;
	public String Historico;
//	public float ValorQuarto;
	private int diarias = 0;
//	private int capacidade;
//	private int Historico;;
//	private Quarto quarto;
	
	public Cliente(String nome, String cpf, int senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
	}
	
	
	public float getConsumo(int valorQuarto,int produto,int quantidade) {
		Consumo = valorQuarto + produto*quantidade; 
		return Consumo;
	}

	public void setConsumo(float consumo) {
		Consumo = ValorQuarto + consumo;
	}

	public String getHistorico() {
		return Historico;
	}

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public void setHistorico(String historico) {
		Historico = historico;
	}
	
	
	public void checkin() {
		int opção;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Qual opção de quarto gostaria?");
		System.out.println("1 - Quarto Normal");
		System.out.println("2 - Quarto Prime");
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
		System.out.println("seriço de quarto acionado");
	}

	public void verconsumo() {
		System.out.println("seu consumo atual é:R$" + Consumo );
	}
	
	

 	public void historicodeagendamento() {
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
		// TODO Auto-generated method stub
		
	}
*/
}
