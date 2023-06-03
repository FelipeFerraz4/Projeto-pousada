package iu_console;

import java.util.Scanner;

import negocios.FachadaPousada;


public class MenuGerente extends Menu{
	
	private int indexGerente;
	
	public MenuGerente(int indexGerente) {
		super();
		this.indexGerente = indexGerente;
	}
	
	public int UI_adicionarPessoa(FachadaPousada pousada, int tipoPessoa, Scanner scan) {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		System.out.println("Digite o CPF da pessoa: ");
		String cpf = scan.nextLine();
		System.out.println("Digite o Nome da pessoa: ");
		String nome = scan.nextLine();
		System.out.println("Digite a senha da pessoa: ");
		String senha = scan.nextLine();
		// Tratar exception cadastro já existe
		int indexPessoa = pousada.buscarPessoa(cpf);
		if (indexPessoa != -1) {
			System.out.println("CPF cadastrado anteriomente");
			return -1;
		}
		if (tipoPessoa == 1) {
			
			pousada.cadastrarNovoCliente(nome, cpf, senha);
		}
		else {
			pousada.cadastrarNovoGerente(nome, cpf, senha);
		}
		System.out.println("Adicao concluida");
		return 1;
	}
	public int UI_adicionarQuarto(FachadaPousada pousada, int tipoQuarto, Scanner scan) {
		System.out.println("Digite o numero do quarto: ");
		int numeroQuarto = scan.nextInt();
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		int indexQuarto = pousada.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto != -1) {
			System.out.println("Numero do quarto cadastrado anteriomente");
			return -1;
		}
		if (tipoQuarto == 1) {
			pousada.cadastrarQuartoNormal(numeroQuarto);
		}
		else {
			pousada.cadastrarQUartoPrime(numeroQuarto);
		}
		System.out.println("Adicao concluida");
		return 1;
	}
	
	public void UI_ConsultarPessoa(FachadaPousada pousada, Scanner scan) {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		System.out.println("Digite o cpf: ");
		String cpf = scan.nextLine();
		int indexPessoa = pousada.buscarPessoa(cpf);
		if (indexPessoa!=-1) {
			System.out.println(pousada.toStringPessoa(indexPessoa));
			System.out.println("Consulta concluida");
		}
		else {
			System.out.println("Operacao invalida, CPF ainda nao cadastrado");
		}
	}
	public void UI_ConsultarQuarto(FachadaPousada pousada, int tipoQuarto, Scanner scan) {
		System.out.println("Digite o numero do quarto: ");
		int numeroQuarto = scan.nextInt();
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		int indexQuarto = pousada.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto!=-1) {
			System.out.println(pousada.toStringQuarto(indexQuarto));
			System.out.println("Consulta concluida");
		}
		else {
			System.out.println("Operacao invalida, quarto ainda nao cadastrado");
		}
	}
	public void UI_ModificarPessoa(FachadaPousada pousada, Scanner scan) {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		System.out.println("Digite o CPF da pessoa: ");
		String cpf = scan.nextLine();
		int indexPessoa = pousada.buscarPessoa(cpf);
		if(indexPessoa != -1) {
			System.out.println(pousada.toStringPessoa(indexPessoa));
			String[] options = {"Modificar senha", "Modificar nome", "Voltar"};
			int option = this.printOption(options, options.length, scan);
			if(scan.hasNextLine()) {
				scan.nextLine();
			}
			if(option==1) {
				System.out.println("Digite a nova senha: ");
				String senha = scan.nextLine();
				pousada.modificarPessoaSenha(indexPessoa, senha);
			}
			if(option == 2) {
				System.out.println("Digite o novo nome: ");
				String nomeUsuario = scan.nextLine();
				pousada.modificarPessoaNome(indexPessoa, nomeUsuario);
			}
			if(option != 3) {
				System.out.println("Modificacao concluida");
			}
		}
		else {
			System.out.println("Pessoa nao encontrada");
		}
	}
	public void UI_ModificarQuarto(FachadaPousada pousada, int tipoQuarto, Scanner scan) {
		System.out.println("Digite o numero de quarto Normal");
		int numeroQuarto = scan.nextInt();
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		int indexQuarto = pousada.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto!=-1) {
			System.out.println(pousada.toStringQuarto(indexQuarto));
			String[] options = {"Modificar consumo", "Modificar capacidade",
					"Modificar preco do quarto","Modificar ocupacao", "Voltar"};
			int option = this.printOption(options, options.length, scan);
			if (option==1) {
				System.out.println("Digite o novo valor do consumo: ");
				float consumo = scan.nextFloat();
				pousada.modificarQuartoConsumo(indexQuarto, consumo);
			}
			if (option==2) {
				System.out.println("Digite o novo valor da capacidade: ");
				int capacidade = scan.nextInt();
				pousada.modificarQuartoCapacidade(indexQuarto, capacidade);
			}
			if (option==3) {
				System.out.println("Digite o novo valor do preco do quarto: ");
				float precoQuarto = scan.nextFloat();
				pousada.modificarQuartoPrecoQuarto(indexQuarto, precoQuarto);
			}
			if (option == 4) {
				pousada.modificarQuartoOcupado(indexQuarto);
			}
			if (option != 5) {
				System.out.println("Modificacao concluida");
			}
		}
		else {
			System.out.println("Quarto nao encontrado");
		}
	}
	public void UI_DeletarPessoa(FachadaPousada pousada, Scanner scan) {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		System.out.println("Digite o cpf: ");
		String cpf = scan.nextLine();
		int indexPessoa = pousada.buscarPessoa(cpf);
		if (indexPessoa!=-1) {
			System.out.println(pousada.toStringPessoa(indexPessoa));
			System.out.println("Confirmar remocao [S/N]");
			String confirmation = scan.nextLine();
			if (confirmation.equals("S") || confirmation.equals("s")) {
				pousada.deletarPessoa(cpf);
				System.out.println("Remocao concluida");
			}
			else {
				System.out.println("Remocao cancelada");
			}
		}
		else {
			System.out.println("Operacao invalida, CPF ainda nao cadastrado");
		}
	}
	public void UI_DeletarQuarto(FachadaPousada pousada, int tipoQuarto, Scanner scan) {
		System.out.println("Digite o numero do quarto: ");
		int numeroQuarto = scan.nextInt();
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		int indexQuarto = pousada.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto!=-1) {
			System.out.println(pousada.toStringQuarto(indexQuarto));
			System.out.println("Confirmar remocao [S/N]");
			String confirmation = scan.nextLine();
			if (confirmation.equals("S") || confirmation.equals("s")) {
				pousada.deletarQuarto(numeroQuarto, tipoQuarto);
				System.out.println("Remocao concluida");
			}
			else {
				System.out.println("Remocao cancelada");
			}
		}
		else {
			System.out.println("Operacao invalida, quarto ainda nao cadastrado");
		}
	}
	
	public int menuGerente(FachadaPousada pousada, Scanner scan){
		
		String option[] = {"Adicionar um Quarto ou uma Pessoa",
				"Consultar dados de um Quarto ou de uma Pessoa",
				"Modificar dados de um Quarto ou de uma Pessoa",
				"Remover um Quarto ou uma Pessoa",
				"Ver dados do gerente",
				"Fechar guia gerente"
		};
		
		int escolha = printOption(option, option.length, scan);
        
        switch(escolha){
            case 1:
            	
            	String[] options = {"Adicionar cliente", 
            			"Adicionar gerente", "Adicionar quarto normal",
            			"Adicionar quarto prime", "Voltar"};
            	
            	int option1 = this.printOption(options, options.length, scan);
            	
        		switch(option1) {
        		case 1:
        			this.UI_adicionarPessoa(pousada, 1, scan);
        			break;
        		case 2:
        			this.UI_adicionarPessoa(pousada, 2, scan);
        			break;
        		case 3:
        			this.UI_adicionarQuarto(pousada, 1, scan);
        			break;
        		case 4:
        			this.UI_adicionarQuarto(pousada, 2, scan);
        			break;
        		default:
        			break;
        		}
                return -1;
            case 2:
            	
            	String[] options2 = {"Consultar uma pessoa", 
            			"Consultar um quarto normal", 
            			"Consultar um quarto prime", "Voltar"};
            	
            	int option2 = this.printOption(options2, options2.length, scan);
            	
        		switch(option2) {
        		case 1:
        			this.UI_ConsultarPessoa(pousada, scan);
        			break;
        		case 2:
        			this.UI_ConsultarQuarto(pousada, 1, scan);
        			break;
        		case 3:
        			this.UI_ConsultarQuarto(pousada, 2, scan);
        			break;
        		default:
        			break;
        		}
                return -1;
            case 3:
            	
            	String[] options3 = {"Modificar dados de uma pessoa", 
            		"Modificar dados de um quarto normal", 
            		"Modificar dados de um quarto prime",
            		"Voltar"};
            	
            	int option3 = this.printOption(options3, options3.length, scan);
        	
        		switch(option3) {
        		case 1:
        			this.UI_ModificarPessoa(pousada, scan);
        			break;
        		case 2:
        			this.UI_ModificarQuarto(pousada, 1, scan);
        			break;
        		case 3:
        			this.UI_ModificarQuarto(pousada, 2, scan);
        			break;
        		default:
        			break;
        		}
        		return -1;
            case 4:
            	
            	String[] options4 = {"Remover uma pessoa", 
            		"Remover um quarto normal", "Remover um quarto prime",
            		"Voltar"};
            	
            	int option4 = this.printOption(options4, options4.length, scan);
            	
            	if (option4==1) {
            		this.UI_DeletarPessoa(pousada, scan);
            	}
            	else if (option4==2) {
            		this.UI_DeletarQuarto(pousada, 1, scan);
            	}
            	else if (option4==3) {
            		this.UI_DeletarQuarto(pousada, 2, scan);
            	}
            
                return -1;
            case 5:
            	System.out.println(pousada.toStringPessoa(indexGerente));
                return -1;
            default:
                System.out.println("Guia gerente fechada");
                return 0;
        }
    }
}
