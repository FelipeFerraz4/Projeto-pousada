package iu_console;

import java.util.Scanner;

import negocios.FachadaPousada;
import negocios.Pessoa.Gerente;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class MenuGerente extends Menu{
	
	private int indexGerente;
	
	public MenuGerente(int indexGerente) {
		super();
		this.indexGerente = indexGerente;
	}
	
	public int UI_adicionarPessoa(FachadaPousada pousada, int tipoPessoa) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o CPF da pessoa: ");
		String cpf = scan.nextLine();
		System.out.println("Digite o Nome da pessoa: ");
		String nome = scan.nextLine();
		System.out.println("Digite a senha da pessoa: ");
		String senha = scan.nextLine();
		// Tratar exception cadastro já existe
		int indexPessoa = pousada.buscarPessoa(cpf);
		if (indexPessoa != -1) {
			return -1;
		}
		if (tipoPessoa == 1) {
			
			pousada.cadastrarNovoCliente(nome, cpf, senha);
		}
		else {
			pousada.cadastrarNovoGerente(nome, cpf, senha);
		}
		return 1;
	}
	public int UI_adicionarQuarto(FachadaPousada pousada, int tipoQuarto) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o numero do quarto: ");
		int numeroQuarto = scan.nextInt();
		int indexQuarto = pousada.buscarQuarto(numeroQuarto, tipoQuarto);
		if (indexQuarto != -1) {
			return -1;
		}
		if (tipoQuarto == 1) {
			pousada.cadastrarQuartoNormal(numeroQuarto);
		}
		else {
			pousada.cadastrarQUartoPrime(numeroQuarto);
		}
		return 1;
	}
	
	public int menuGerente(FachadaPousada pousada){
		
		String option[] = {"Adicionar um Quarto ou uma Pessoa",
				"Consultar dados de um Quarto ou de uma Pessoa",
				"Modificar dados de um Quarto ou de uma Pessoa",
				"Remover um Quarto ou uma Pessoa",
				"Ver dados do gerente",
				"Fechar guia gerente"
		};
		
		int escolha = printOption(option, option.length);
        
        switch(escolha){
            case 1:
            	
            	String[] options = {"Adicionar cliente", 
            			"Adicionar gerente", "Adicionar quarto normal",
            			"Adicionar quarto prime", "Voltar"};
            	
            	int option1 = this.printOption(options, options.length);
            	
            	if (option1 != -1) {
            		switch(option1) {
            		case 1:
            			int result = this.UI_adicionarPessoa(pousada, 1);
            			if (result != -1) {
            				System.out.println("Adicao concluida");
            			}
            			else {
            				System.out.println("CPF cadastrada anteriomente");
            			}
            			break;
            		case 2:
            			result = this.UI_adicionarPessoa(pousada, 2);
            			if (result != -1) {
            				System.out.println("Adicao concluida");
            			}
            			else {
            				System.out.println("CPF cadastrada anteriomente");
            			}
            			break;
            		case 3:
            			result = this.UI_adicionarQuarto(pousada, 1);
            			if (result != -1) {
            				System.out.println("Adicao concluida");
            			}
            			else {
            				System.out.println("Numero do quarto cadastrada anteriomente");
            			}
            			break;
            		case 4:
            			result = this.UI_adicionarQuarto(pousada, 2);
            			if (result != -1) {
            				System.out.println("Adicao concluida");
            			}
            			else {
            				System.out.println("Numero do quarto cadastrada anteriomente");
            			}
            			break;
            		default:
            			break;
            		}
            	}
                return -1;
            case 2:
            	
            	String[] options2 = {"Consultar uma pessoa", 
            			"Consultar um quarto normal", 
            			"Consultar quarto prime", "Voltar"};
            	
            	int option2 = this.printOption(options2, options2.length);
            	/*
            	if (option != -1) {
            		switch(option) {
            		case 1:
            			System.out.println("Digite o cpf: ");
            			if(scan.hasNextLine()) {
            				scan.nextLine();
            			}
            			String cpf = scan.nextLine();
            			int busca = pessoas.buscarPessoa(cpf);
            			if (busca!=-1) {
            				System.out.println(pessoas.getPessoas().get(busca).toString());
            				if(pessoas.getPessoas().get(busca).getQuarto()!=null) {
            					System.out.println(pessoas.getPessoas().get(busca).getQuarto().toString());
            				}
            				System.out.println("Consulta concluida");
            			}
            			else {
            				System.out.println("Operacao invalida, CPF ainda nao cadastrado");
            			}
            			break;
            		case 2:
            			System.out.println("Digite o numero do quarto: ");
            			int numeroQuarto = scan.nextInt();
            			busca = quartos.buscarQuarto(numeroQuarto, 1);
            			if (busca!=-1) {
            				System.out.println(quartos.getQuarto(busca).toString());
            				System.out.println("Consulta concluida");
            			}
            			else {
            				System.out.println("Operacao invalida, quarto ainda nao cadastrado");
            			}
            			break;
            		case 3:
            			System.out.println("Digite o numero do quarto: ");
            			numeroQuarto = scan.nextInt();
            			busca = quartos.buscarQuarto(numeroQuarto, 2);
            			if (busca!=-1) {
            				System.out.println(quartos.getQuarto(busca).toString());
            				System.out.println("Consulta concluida");
            			}
            			else {
            				System.out.println("Operacao invalida, quarto ainda nao cadastrado");
            			}
            			break;
            		default:
            			break;
            		}
            	}
            	else {
            		System.out.println("Não foi possível consultar");
            	}
            	*/
                return -1;
            case 3:
            	
            	String[] options3 = {"Modificar dados de uma pessoa", 
            		"Modificar dados de um quarto normal", 
            		"Modificar dados de um quarto prime"};
            	
            	int option3 = this.printOption(options3, options3.length);
            	/*
            	if (option != -1) {
            		switch(option) {
            		case 1:
            			System.out.println("Digite o CPF da pessoa: ");
            			if(scan.hasNextLine()) {
            				scan.nextLine();
            			}
            			String cpf = scan.nextLine();
            			int indexPessoa = pessoas.buscarPessoa(cpf);
            			if(indexPessoa != -1) {
            				System.out.println(pessoas.getPessoas().get(indexPessoa).toString());
            				String[] options4 = {"senha", "nome"};
            				option = this.optionGerente("Modificar",options4, options4.length);
            				if(option==1) {
            					System.out.println("Digite a nova senha: ");
            					String senha = scan.nextLine();
            					pessoas.getPessoas().get(indexPessoa).setSenha(senha);
            					System.out.println("Modificacao concluida");
            				}
            				if(option == 2) {
            					System.out.println("Digite o novo nome: ");
            					String nomeUsuario = scan.nextLine();
            					pessoas.getPessoas().get(indexPessoa).setNome(nomeUsuario);
            					System.out.println("Modificacao concluida");
            				}
            			}
            			else {
            				System.out.println("Pessoa nao encontrada");
            			}
            			break;
            		case 2:
            			System.out.println("Digite o numero de quarto Normal");
            			int numeroQuarto = scan.nextInt();
            			int indexQuarto = quartos.buscarQuarto(numeroQuarto, 1);
            			if (indexQuarto!=-1) {
            				System.out.println(quartos.getQuarto(indexQuarto).toString());
            				Normal quarto = (Normal) quartos.getQuarto(indexQuarto);
            				System.out.println(quarto.getPreco());
            				String[] options4 = {"consumo", "capacidade", "preco do quarto"};
            				option = this.optionGerente("Modificar",options4, options4.length);
            				if (option==1) {
            					System.out.println("Digite o novo valor do consumo: ");
            					float consumo = scan.nextFloat();
            					quartos.getQuarto(indexQuarto).setConta(consumo);
            					System.out.println("Modificacao concluida");
            				}
            				if (option==2) {
            					System.out.println("Digite o novo valor da capacidade: ");
            					int capacidade = scan.nextInt();
            					quartos.getQuarto(indexQuarto).setCapacidade(capacidade);
            					System.out.println("Modificacao concluida");
            				}
            				if (option==3) {
            					System.out.println("Digite o novo valor do preco do quarto: ");
            					float precoQuarto = scan.nextFloat();
            					Normal quartoNormal = (Normal) quartos.getQuarto(indexQuarto);
            					quartoNormal.setPreco(precoQuarto);
            					System.out.println("Modificacao concluida");
            				}
            			}
            			else {
            				System.out.println("Quarto nao encontrado");
            			}
            			break;
            		case 3:
            			System.out.println("Digite o numero de quarto Prime");
            			numeroQuarto = scan.nextInt();
            			indexQuarto = quartos.buscarQuarto(numeroQuarto, 2);
            			if (indexQuarto!=-1) {
            				System.out.println(quartos.getQuarto(indexQuarto).toString());
            				Prime quarto = (Prime) quartos.getQuarto(indexQuarto);
            				System.out.println(quarto.getPreco());
            				String[] options4 = {"consumo", "capacidade", "preco do quarto"};
            				option = this.optionGerente("Modificar",options4, options4.length);
            				if (option==1) {
            					System.out.println("Digite o novo valor do consumo: ");
            					float consumo = scan.nextFloat();
            					quartos.getQuarto(indexQuarto).setConta(consumo);
            					System.out.println("Modificacao concluida");
            				}
            				if (option==2) {
            					System.out.println("Digite o novo valor da capacidade: ");
            					int capacidade = scan.nextInt();
            					quartos.getQuarto(indexQuarto).setCapacidade(capacidade);
            					System.out.println("Modificacao concluida");
            				}
            				if (option==3) {
            					System.out.println("Digite o novo valor do preco do quarto: ");
            					float precoQuarto = scan.nextFloat();
            					Prime quartoPrime = (Prime) quartos.getQuarto(indexQuarto);
            					quartoPrime.setPreco(precoQuarto);
            					System.out.println("Modificacao concluida");
            				}
            			}
            			else {
            				System.out.println("Quarto nao encontrado");
            			}
            			break;
            		default:
            			break;
            		}
            	}
            	else {
            		System.out.println("Não foi possível modificar os dados");
            	}
            	*/
                return -1;
            case 4:
            	
            	String[] options4 = {"Remover uma pessoa", 
            		"Remover um quarto normal", "Remover um quarto prime"};
            	
            	int option4 = this.printOption(options4, options4.length);
            	/*
            	if (option==1) {
            		gerente.removerPessoa(pessoas, indexGerente);
            	}
            	if (option==2) {
            		gerente.removerQuarto(quartos, 1);
            	}
            	if (option==3) {
            		gerente.removerQuarto(quartos, 2);
            	}
            	*/
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
