package dados;

import java.util.Scanner;
import repositorio.*;

public class Gerente extends Pessoa  {

	public Gerente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(2);
	}
	
//	Gerente G2 = new Gerente("felipe","12345678910", 1234);
	
	public void addGerente(RepositorioPessoa pessoas) {
		String n,cpf;
		String senha;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual nome do novo Gerente:");
        n = scan.nextLine();
        System.out.println("qual CPF do novo Gerente:");
        cpf = scan.nextLine();
		System.out.println("Qual a senha do novo Gerente");
		senha = scan.nextLine();
		pessoas.criarPessoa(n, cpf, senha, 2);
		System.out.println(pessoas.toString());
	}
	
	public void addQuarto(RepositorioQuarto quartos){
		int numQuarto, TipoQuarto;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual o numero do quarto?:");
		numQuarto= scan.nextInt();
		System.out.println("qual o tipo do quarto (1/0):");
		TipoQuarto= scan.nextInt();
		quartos.criarQuarto(numQuarto, TipoQuarto);
	}

	public void verDadosdoGerente (RepositorioPessoa pessoas){
		pessoas.toString();
	}

	public void atualizarGerente (RepositorioPessoa pessoas,String cpf){
		int indece = pessoas.buscarPessoa(cpf);
		pessoas.atualizarPessoa(pessoas.getPessoas().get(indece),
		pessoas.getPessoas().get(indece).getNome(),pessoas.getPessoas().get(indece).getSenha());
	}
	public void atualiazarQuarto (RepositorioQuarto quarto){
		quarto.atualizarQuarto(getQuarto());
	}
	

	public void removerGerente(RepositorioPessoa pessoas){
		String n,cpf;
		int senha;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual nome do Gerente:");
        n = scan.nextLine();
        System.out.println("qual CPF do Gerente:");
        cpf = scan.nextLine();
		System.out.println("Qual a senha do Gerente");
		senha = scan.nextInt();
		pessoas.deletarPessoa(cpf);
		System.out.println(pessoas.toString());

	}

	public void removerQuarto(RepositorioQuarto quartos){
		int numQuarto, TipoQuarto;
		Scanner scan = new Scanner(System.in);
		System.out.println("qual o numero do quarto?:");
		numQuarto= scan.nextInt();
		System.out.println("qual o tipo do quarto (1/0):");
		TipoQuarto= scan.nextInt();
		quartos.deletarQuarto(numQuarto, TipoQuarto);
	}
}
