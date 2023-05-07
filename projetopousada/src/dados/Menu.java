package dados;

import java.util.Scanner;
import dados.*;
import repositorio.*;


public class Menu {
	
	//RepositorioQuarto quartos = new RepositorioQuarto();
	private RepositorioPessoa pessoas;
	private Gerente adm;
	private Login login;
	
	public Menu() {
		this.pessoas = new RepositorioPessoa();
		this.adm = new Gerente("Andre", "0000", "12345");
		this.login = new Login();
		this.pessoas.addPessoa(adm);
	}
	
	public void linha(int quantidade){
        int i;
        for(i = 0; i < quantidade; i++){
            System.out.print("-");
        }
        System.out.print("\n");
    }
    public void espaco(int quantidade){
        int i;
        for(i = 0; i < quantidade; i++){
            System.out.print(" ");
        }
    }
    public void cabecarioPousada(String nome){
        this.linha(40);
        this.espaco(14);
        System.out.print(nome);
        this.espaco(14);
        System.out.print("\n");
        this.linha(40);
    }
    public void menuInicial(){
    	String nome = "Sol Nascente";
    	this.cabecarioPousada(nome);
    	
    	int escolha;
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("1 - Fazer login");
        System.out.println("2 - Cadastrar usuario");
        System.out.println("3 - Sair do programa");
        
        do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>3 || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>3 || escolha<1);
        
        
        if(escolha == 1){
        	
        	int option = login.entrar(pessoas);
        	
            if (option==1){
            	System.out.println("Bem vindo Cliente");
            	this.menuCliente();
            }
            else if (option == 2){
            	System.out.println("Bem vindo Gerente");
            	this.menuGerente();
            }
            else {
            	this.menuInicial();
            }
        }
        else if(escolha == 2){
        	int opition = login.cadastrar(pessoas);
        	
        	if (opition == 1) {
        		System.out.println("Cadastro do cliente feito");
        	}
            this.menuInicial();
        }
        else{
            System.out.println("Programa finalizado");
        }
    }
    
    public void menuGerente(){
        String nome = "Sol Nascente";
    	this.cabecarioPousada(nome);
    	
    	int escolha;
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("1 - Adicionar um gerente");
        System.out.println("2 - Adicionar um quarto");
        System.out.println("3 - Consultar estado do gerente");
        System.out.println("4 - Consultar estado do quarto");
        System.out.println("5 - Atualizar dados do gerente");
        System.out.println("6 - Atualizar dados do quarto");
        System.out.println("7 - remover um gerente");
        System.out.println("8 - remover um quarto");
        System.out.println("9 - Ver dados do gerente");
        System.out.println("10 - Fechar guia gerente");
        
        do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>10 || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>10 || escolha<1);
        
        switch(escolha){
            case 1:
                System.out.println("Gerente adicionada");
                this.menuGerente();
                break;
            case 2:
                System.out.println("Quarto adicionado");
                this.menuGerente();
                break;
            case 3:
                System.out.println("Gerente consultada");
                this.menuGerente();
                break;
            case 4:
                System.out.println("Quarto consultado");
                this.menuGerente();
                break;
            case 5:
                System.out.println("Gerente atualizada");
                this.menuGerente();
                break;
            case 6:
                System.out.println("Quarto atualizado");
                this.menuGerente();
                break;
            case 7:
                System.out.println("Gerente removida");
                this.menuGerente();
                break;
            case 8:
                System.out.println("Quarto removido");
                this.menuGerente();
                break;
            case 9:
                System.out.println("Quarto removido");
                this.menuGerente();
                break;
            default:
                System.out.println("Fechado guia gerente");
                this.menuInicial();
                break;
        }
    }
    public void menuCliente(){
        String nome = "Sol Nascente";
    	this.cabecarioPousada(nome);
    	
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
                System.out.println("Check-in feito");
                this.menuCliente();
                break;
            case 2:
                System.out.println("Sevirco de quarto feito");
                this.menuCliente();
                break;
            case 3:
                System.out.println("Consumo mostrado");
                this.menuCliente();
                break;
            case 4:
                System.out.println("historico mostrado");
                this.menuCliente();
                break;
            case 5:
                System.out.println("Consumo pago");
                this.menuCliente();
                break;
            case 6:
                System.out.println("Dados do cliente mostrados");
                this.menuCliente();
                break;
            default:
                System.out.println("Checkout feito com sucesso");
                this.menuInicial();
                break;
        }
    }
}
