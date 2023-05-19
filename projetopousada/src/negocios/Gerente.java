package negocios;

import java.util.Scanner;

import dados.*;

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
	
	public void addQuarto(RepositorioQuartoArrayList quartos, int tipoQuarto){
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
		quartos.adicionarQuarto(numQuarto, tipoQuarto);
	}	

	public void removerPessoa(RepositorioPessoa pessoas, int indexGerente){
		String cpf;
		int busca, valido = -1;
		Scanner scan = new Scanner(System.in);
        do {
        	System.out.println("Digite o CPF da Pessoa:");
            cpf = scan.nextLine();
            busca = pessoas.buscarPessoa(cpf);
            if(busca == -1) {
            	valido = -1;
            	System.out.println("operacao invalida, CPF nao cadastrado");
            }
            else if(busca == indexGerente) {
            	valido = -1;
            	System.out.println("CPF nao pode ser excluido");
            }
            else {
            	valido = 1;
            }
            	
        }while(valido == -1);
        System.out.println(pessoas.getPessoas().get(busca).toString());
        System.out.println("Confirma remocao (0 - nao, 1 - sim): ");
        int escolha = scan.nextInt();
        if (escolha == 1) {
        	pessoas.deletarPessoa(cpf);
        	System.out.println("remocao conluida");
        }
        else {
        	System.out.println("remocao cancelada");
        }
	}

	public void removerQuarto(RepositorioQuartoArrayList quartos, int tipoQuarto){
		int numQuarto, busca;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("qual o numero do quarto?:");
			numQuarto= scan.nextInt();
			busca = quartos.buscarQuarto(numQuarto, tipoQuarto);
			if(busca == -1) {
            	System.out.println("operacao invalida, Quarto nao cadastrado");
            }
		}while(busca==-1);
		System.out.println(quartos.getQuarto(busca).toString());
		System.out.println("Confirma remocao (0 - nao, 1 - sim): ");
        int escolha = scan.nextInt();
        if (escolha == 1) {
        	quartos.deletarQuarto(numQuarto, tipoQuarto);
        	System.out.println("remocao conluida");
        }
        else {
        	System.out.println("remocao cancelada");
        }
	}
}
