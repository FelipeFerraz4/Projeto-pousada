package iu_console;

import java.util.Scanner;

import dados.*;
import dados.repositoriospessoas.RepositorioPessoaArrayList;
import negocios.*;
import negocios.Pessoa.Cliente;
import negocios.Pessoa.Gerente;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;
import negocios.Quarto.Quarto;


public class Menu2 {
	
	private RepositorioQuartoArrayList quartos;
	private RepositorioPessoaArrayList pessoas;
	private Login login;
	
	public Menu2() {
		this.login = new Login();
		this.quartos = new RepositorioQuartoArrayList();
		this.pessoas = new RepositorioPessoaArrayList();	
		classesDefault();
	}
	
    

    public int menuGerente(int indexGerente){
        String nome = "Sol Nascente";
    	this.cabecarioPousada(nome);
    	
    	Gerente gerente = (Gerente) pessoas.getPessoas().get(indexGerente);
    	int escolha;
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("1  - Adicionar um Quarto ou uma Pessoa");
        System.out.println("2  - Consultar dados de um Quarto ou de uma Pessoa");
        System.out.println("3  - Modificar dados de um Quarto ou de uma Pessoa");
        System.out.println("4  - Remover um Quarto ou uma Pessoa");
        System.out.println("5  - Ver dados do gerente");
        System.out.println("6 - Fechar guia gerente");
        
        do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>6 || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>6 || escolha<1);
        
        switch(escolha){
            case 1:
            	String[] options = {"cliente", "gerente", "quarto normal", "quarto prime"};
            	
            	int option = this.optionGerente("Adicionar",options, options.length);
            	
            	if (option != -1) {
            		switch(option) {
            		case 1:
            			gerente.addPessoa(pessoas, 1);
            			System.out.println("Adicao concluida");
            			break;
            		case 2:
            			gerente.addPessoa(pessoas, 2);
            			System.out.println("Adicao concluida");
            			break;
            		case 3:
            			gerente.addQuarto(quartos, 1);
            			System.out.println("Adicao concluida");
            			break;
            		case 4:
            			gerente.addQuarto(quartos, 2);
            			System.out.println("Adicao concluida");
            			break;
            		default:
            			break;
            		}
            	}
            	else {
            		System.out.println("Não foi possível adiconar");
            	}
            	
                return -1;
            case 2:
            	String[] options2 = {"pessoa", "quarto normal", "quarto prime"};
            	
            	option = this.optionGerente("Consultar",options2, options2.length);
            	
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
            	
                return -1;
            case 3:
            	
            	String[] options3 = {"pessoa", "quarto normal", "quarto prime"};
            	
            	option = this.optionGerente("Modificar",options3, options3.length);
            	
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
                return -1;
            case 4:
            	String[] options5 = {"pessoa", "quarto normal", "quarto prime"};
            	
            	option = this.optionGerente("Remover",options5, options5.length);
            	if (option==1) {
            		gerente.removerPessoa(pessoas, indexGerente);
            	}
            	if (option==2) {
            		gerente.removerQuarto(quartos, 1);
            	}
            	if (option==3) {
            		gerente.removerQuarto(quartos, 2);
            	}
                return -1;
            case 5:
            	System.out.println(pessoas.getPessoas().get(indexGerente).toString());
            	if (pessoas.getPessoas().get(indexGerente).getQuarto()!=null) {
            		System.out.println(pessoas.getPessoas().get(indexGerente).getQuarto().toString());
            	}
                return -1;
            default:
                System.out.println("Fechado guia gerente");
                return 0;
        }
    }
    public int menuCliente(int indexCliente){
        String nome = "Sol Nascente";
    	this.cabecarioPousada(nome);
    	
    	Cliente cliente = (Cliente)pessoas.getPessoas().get(indexCliente);
    	int escolha;
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("1 - Check-in");
        System.out.println("2 - Sevirco de quarto");
        System.out.println("3 - Ver consumo");
        System.out.println("4 - Ver historico de agendamento");
        System.out.println("5 - Pagar consumo");
        System.out.println("6 - Ver dados do cliente");
        System.out.println("7 - Checkout");
        
        do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>7 || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>7 || escolha<1);
        
        
        switch(escolha){
            case 1:
            	if (cliente.isCheckin()==false) {
            		int option;
                    do {
                    	option = cliente.checkin(quartos);
                    }while(option == -1);
                    return -1;
            	}
                System.out.println("Check-in feito anteriormente");
                return -1;
            case 2:
            	if (cliente.isCheckin()==true) {
            		Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
            		int indexQuarto = quartos.buscarQuarto(quarto);
            		cliente.sevircoDeQuarto(quartos, indexQuarto);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                return -1;
            case 3:
            	if (cliente.isCheckin()==true) {
            		Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
            		int indexQuarto = quartos.buscarQuarto(quarto);
            		cliente.verConsumo(quartos, indexQuarto);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                return -1;
            case 4:
            	cliente.historicoAgendamento();
                return -1;
            case 5:
            	if (cliente.isCheckin()==true) {
            		Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
            		int indexQuarto = quartos.buscarQuarto(quarto);
            		cliente.pagarConsumo(quartos, indexQuarto);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                return -1;
            case 6:
            	System.out.println(pessoas.getPessoas().get(indexCliente).toString());
            	if (pessoas.getPessoas().get(indexCliente).getQuarto()!=null) {
            		System.out.println(pessoas.getPessoas().get(indexCliente).getQuarto().toString());
            	}
            	return -1;
            default:
            	if(cliente.getQuarto()!=null) {
            		if (cliente.getQuarto().getConta() == 0) {
                		cliente.getQuarto().setOcupado();
                		cliente.setQuarto(null);
                		cliente.setDiarias(0);
                		cliente.setCheckin(false);
                		System.out.println("Obrigado pela preferencia e volte sempre");
                		return 0;
                	}
            		System.out.println("Por favor, finalize sua conta antes de sair");
            		return -1;
            	}
            	//possivel de ser retirado, basta testa sem
            	cliente.setDiarias(0);
        		cliente.setCheckin(false);
        		System.out.println("Obrigado e volte sempre");
                return 0;
        }
    }
}
