package dados;

import java.util.Scanner;

public class Menu {
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
    	//boolean escolhaCorreta = false;
    	
    	Scanner scan = new Scanner(System.in);
        System.out.println("1 - Fazer login");
        System.out.println("2 - Cadastrar usuário");
        System.out.println("3 - Sair do programa");
        
        do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>3 || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>3 || escolha<1);
        
        if(escolha == 1){
            System.out.println("Login feito");
            this.menuCliente();
            this.menuInicial();
        }
        else if(escolha == 2){
            System.out.println("Cadastrar usuario feito");
            this.menuInicial();
        }
        else{
            System.out.println("Programa finalizado");
        }
    }
    
    public void menuGerente(){
        
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
        System.out.println("6 - Checkout");
        
        do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>6 || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>6 || escolha<1);
        
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
            default:
                System.out.println("Checkout feito com sucesso");
                break;
        }
    }
}
