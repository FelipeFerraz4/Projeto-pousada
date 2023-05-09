package dados;

import java.util.Scanner;
import dados.*;
import repositorio.*;


public class Menu {
	
	private RepositorioQuarto quartos;
	private RepositorioPessoa pessoas;
	private Gerente adm;
	private Login login;
	
	public Menu() {
		this.login = new Login();
		this.quartos = new RepositorioQuarto();
		this.pessoas = new RepositorioPessoa();
		this.adm = new Gerente("Andre", "0000", "12345");
		Normal quarto = new Normal(0);
		adm.setQuarto(quarto);
		this.pessoas.addPessoa(adm);
		this.quartos.adicionarQuarto(quarto);
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
    public int menuInicial(){
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
        
        switch(escolha) {
        	case 1:
        		int indexPessoa = login.entrar(pessoas);
            	
                if (indexPessoa!=-1) {
                	int tipoPessoa = pessoas.getPessoas().get(indexPessoa).getTipoPessoa();
                	if (tipoPessoa==1){
                    	System.out.println("Bem vindo Cliente");
                    	int option;
                    	do {
                    		option = this.menuCliente(indexPessoa);
                    	}while(option == -1);
                    }
                    else if (tipoPessoa == 2){
                    	System.out.println("Bem vindo Gerente");
                    	int option;
                    	do {
                    		option = this.menuGerente(indexPessoa);
                    	}while(option == -1);
                    }
                }
                return -1;
        	case 2:
        		int opition = login.cadastrar(pessoas);
            	
            	if (opition == 1) {
            		System.out.println("Cadastro do cliente feito");
            	}
                return -1;
        	default:
        		System.out.println("Programa finalizado");
        		return 0;
        }
    }
    
    public int menuGerente(int indexGerente){
        String nome = "Sol Nascente";
    	this.cabecarioPousada(nome);
    	
    	int escolha;
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("1  - Adicionar um gerente");
        System.out.println("2  - Adicionar um quarto");
        System.out.println("3  - Consultar estado do gerente");
        System.out.println("4  - Consultar estado do quarto");
        System.out.println("5  - Atualizar dados do gerente");
        System.out.println("6  - Atualizar dados do quarto");
        System.out.println("7  - remover um gerente");
        System.out.println("8  - remover um quarto");
        System.out.println("9  - Ver dados do gerente");
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
                return -1;
            case 2:
                System.out.println("Quarto adicionado");
                return -1;
            case 3:
                System.out.println("Gerente consultada");
                return -1;
            case 4:
                System.out.println("Quarto consultado");
                return -1;
            case 5:
                System.out.println("Gerente atualizada");
                return -1;
            case 6:
                System.out.println("Quarto atualizado");
                return -1;
            case 7:
                System.out.println("Gerente removida");
                return -1;
            case 8:
                System.out.println("Quarto removido");
                return -1;
            case 9:
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
                //System.out.println("Check-in feito");
                Cliente c2 = (Cliente)pessoas.getPessoas().get(indexCliente);
                int option;
                do {
                	option = c2.checkin(quartos);
                }while(option == -1);
                return -1;
            case 2:
                System.out.println("Sevirco de quarto feito");
                return -1;
            case 3:
                System.out.println("Consumo mostrado");
                return -1;
            case 4:
                System.out.println("historico mostrado");
                return -1;
            case 5:
                //System.out.println("Consumo pago");
                Cliente c1 = new Cliente("andre", "123", "123");
                Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
                int indexQuarto = quartos.buscarQuarto(quarto);
                if (indexQuarto == -1){
                    System.out.println("você não possui um quarto, por favor voltar ao check-in");
                    return -1;
                }
                Normal n1 = new Normal(1);
                c1.setQuarto(n1);
                c1.pagarconsumo(quartos,indexQuarto);
                return -1;
            case 6:
            	System.out.println(pessoas.getPessoas().get(indexCliente).toString());
            	if (pessoas.getPessoas().get(indexCliente).getQuarto()!=null) {
            		System.out.println(pessoas.getPessoas().get(indexCliente).getQuarto().toString());
            	}
            	return -1;
            default:
                System.out.println("Checkout feito com sucesso");
                return 0;
        }
    }
}
