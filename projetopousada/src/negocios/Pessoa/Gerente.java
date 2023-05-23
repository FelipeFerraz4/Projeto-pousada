package negocios.Pessoa;

import java.util.Scanner;

import dados.*;
import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import dados.repositoriosquartos.IRepositorioQuarto;
import negocios.Quarto.Quarto;

public class Gerente extends Pessoa  {

	public Gerente(String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(2);
	}
	
	//Lembrar adicionar a excetion do Repositorio Lotado 
	public int addPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) {
		int indexPessoa = pessoas.buscarPessoa(pessoa); 
		if (indexPessoa != -1) {
			//adicionar exception Pessoa já existe
			return -1;
		}
		else {
			pessoas.addPessoa(pessoa);
			return 1;
		}
		
		/*
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
		*/
	}
	//Lembrar adicionar a excetion do Repositorio Lotado
	public int addPessoa(IRepositorioPessoa pessoas, int tipoPessoa, String nome, 
			String cpf, String senha) {
		int indexPessoa = pessoas.buscarPessoa(cpf); 
		if (indexPessoa != -1) {
			//adicionar exception Pessoa já existe
			return -1;
		}
		else {
			pessoas.criarPessoa(nome, cpf, senha, tipoPessoa);
			return 1;
		}
	}
	
	public int removerPessoa(IRepositorioPessoa pessoas, Pessoa pessoa){
		int result = pessoas.deletarPessoa(pessoa);
		if (result == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
		
		/*
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
        */
	}
	public int removerPessoa(IRepositorioPessoa pessoas, String cpf) {
		int result = pessoas.deletarPessoa(cpf);
		if (result == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int consultarPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) {
		int indexPessoa = pessoas.buscarPessoa(pessoa);
		if (indexPessoa == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int consultarPessoa(IRepositorioPessoa pessoas, String cpf) {
		int indexPessoa = pessoas.buscarPessoa(cpf);
		if (indexPessoa == -1) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int atualizarPessoa(IRepositorioPessoa pessoas, Pessoa pessoa) {
		int result = pessoas.atualizarPessoa(pessoa);
		if (result == -1 ) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int atualizarPessoa(IRepositorioPessoa pessoas, String cpf, String nome,
			String senha) {
		int result = pessoas.atualizarPessoa(cpf, nome, senha);
		if (result == -1 ) {
			//adicionar exception Pessoa não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	
	public int addQuarto(IRepositorioQuarto quartos, Quarto quarto){
		int indexQuarto = quartos.buscarQuarto(quarto);
		if (indexQuarto != -1) {
			//adicionar exception Quarto já existe
			return -1;
		}
		else {
			int result = quartos.adicionarQuarto(quarto);
			if (result == -1) {
				//adicionar exception RepositorioQuartoLotado
				return -1;
			}
			return 1;
		}
		
		/*
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
		*/
	}
	public int addQuarto(IRepositorioQuarto quartos, int numeroQuarto, int tipoQuarto) {
		int indexQuarto = quartos.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto != -1) {
			//adicionar exception Quarto já existe
			return -1;
		}
		else {
			int result = quartos.adicionarQuarto(numeroQuarto, tipoQuarto);
			if (result == -1) {
				//adicionar exception RepositorioQuartoLotado
				return -1;
			}
			return 1;
		}
	}


	public int deletarQuarto(IRepositorioQuarto quartos, Quarto quarto){
		int result = quartos.deletarQuarto(quarto);
		if (result == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
		
		
		/*
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
        */
	}
	public int deletarQuarto(IRepositorioQuarto quartos, int numeroQuarto, int tipoQuarto) {
		int result = quartos.deletarQuarto(numeroQuarto, tipoQuarto);
		if (result == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int consultarQuarto(IRepositorioQuarto quartos, Quarto quarto) {
		int indexPessoa = quartos.buscarQuarto(quarto);
		if (indexPessoa == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int consultarQuarto(IRepositorioQuarto quartos, int numeroQuarto, 
			int tipoQuarto) {
		int indexPessoa = quartos.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexPessoa == -1) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return indexPessoa;
		}
	}
	public int atualizarQuarto(IRepositorioQuarto quartos, Quarto quarto) {
		int result = quartos.atualizarQuarto(quarto);
		if (result == -1 ) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
	}
	public int atualizarQuarto(IRepositorioQuarto quartos, int numeroQuarto, 
			int tipoQuarto, float consumo, boolean ocupado, int capacidade) {
		
		int result = quartos.atualizarQuarto(numeroQuarto, tipoQuarto, 
				consumo, ocupado, capacidade);
		
		if (result == -1 ) {
			//adicionar exception Quarto não existe
			return -1;
		}
		else {
			return 1;
		}
		
	}	
}
