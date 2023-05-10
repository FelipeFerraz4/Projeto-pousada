package dados;

import java.util.Scanner;
import repositorio.*;

public class Gerente extends Pessoa  {

	public Gerente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(2);
	}
	
	public void addPessoa(RepositorioPessoa pessoas, int tipoPessoa) {
		String nome,cpf;
		String tipoUsario;
		if (tipoPessoa==1) {
			tipoUsario = "cliente";
		}
		else {
			tipoUsario = "gerente";
		}
		String senha;
		int busca;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("Digite o CPF do novo "+tipoUsario +":");
	        cpf = scan.nextLine();
	        busca = pessoas.buscarPessoa(cpf);
	        if (busca!=-1) {
	        	System.out.println("operacao invalida, CPF cadastrado anteriormente");
	        }
		}while(busca!=-1);
		System.out.println("Qual nome do novo "+tipoUsario+":");
        nome = scan.nextLine();
		System.out.println("Qual a senha do novo "+tipoUsario+":");
		senha = scan.nextLine();
		pessoas.criarPessoa(nome, cpf, senha, tipoPessoa);
	}
	
	public void addQuarto(RepositorioQuarto quartos, int tipoQuarto){
		int numQuarto;
		Scanner scan = new Scanner(System.in);
		int busca;
		do {
			System.out.println("qual o numero do quarto?");
			numQuarto= scan.nextInt();
			busca = quartos.buscarQuarto(numQuarto, tipoQuarto);
			if (busca!=-1) {
	        	System.out.println("operacao invalida, numero do quarto cadastrado anteriormente");
	        }
		}while(busca!=-1);
		quartos.criarQuarto(numQuarto, tipoQuarto);
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
