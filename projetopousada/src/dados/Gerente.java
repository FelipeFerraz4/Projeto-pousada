package dados;

import java.util.Scanner;
import repositorio.*;

public class Gerente extends Pessoa  {

	public Gerente(String n, String cpf, int senha) {
		super(n, cpf, senha);
	}
	
	Gerente G2 = new Gerente("felipe","12345678910", 1234);
	
	public void addpessoa() {
		String n,cpf;
		int senha;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual nome do cliente:");
        n = scan.nextLine();
        System.out.println("qual CPF do cliente:");
        cpf = scan.nextLine();
		System.out.println("Qual a senha do cliente");
		senha = scan.nextInt();
		RepositorioPessoa cliente = new RepositorioPessoa();
		cliente.criarPessoa(n, cpf, senha);
		System.out.println(cliente.toString());
		
	}
	public void addQuarto(){
		int numQuarto, TipoQuarto;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual o numero do quarto?:");
		numQuarto= scan.nextInt();
		System.out.println("qual o tipo do quarto (1/0):");
		TipoQuarto= scan.nextInt();
		RepositorioQuarto Q1 = new RepositorioQuarto();
		Q1.criarQuarto(numQuarto, TipoQuarto);
	}

	public void removerPessoa(){
		String n,cpf;
		int senha;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual nome do cliente:");
        n = scan.nextLine();
        System.out.println("qual CPF do cliente:");
        cpf = scan.nextLine();
		System.out.println("Qual a senha do cliente");
		senha = scan.nextInt();
		RepositorioPessoa cliente = new RepositorioPessoa();
		cliente.deletarPessoa(n, cpf);
		System.out.println(cliente.toString());

	}

	public void removerQuarto(){
		int numQuarto, TipoQuarto;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual o numero do quarto?:");
		numQuarto= scan.nextInt();
		System.out.println("qual o tipo do quarto (1/0):");
		TipoQuarto= scan.nextInt();
		RepositorioQuarto Q1 = new RepositorioQuarto();
		Q1.deletarQuarto(numQuarto, TipoQuarto);


	}
	

}
