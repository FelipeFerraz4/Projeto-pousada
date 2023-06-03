package iu_console;

import java.util.Scanner;

public class Menu {
	
	private String nomePousada;
	
	public Menu() {
		this.nomePousada = "Sol Nascente";
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
    
    public void cabecarioPousada(){
        this.linha(40);
        this.espaco(14);
        System.out.print(nomePousada);
        this.espaco(14);
        System.out.print("\n");
        this.linha(40);
    }
    
    public int printOption(String[] option, int numberOption, Scanner scan) {
    	this.cabecarioPousada();
    	int escolha = -1;
    	for(int i = 0; i < numberOption; i++) {
    		System.out.println((i+1) + " - " + option[i]);
    	}
    	do{
        	System.out.println("Digite a sua alternativa: ");
        	escolha = scan.nextInt();
        	if(escolha>numberOption || escolha<1) {
        		System.out.println("Alternativa invalida");
        	}
        }while(escolha>numberOption || escolha<1);
    	return escolha;
    	
    }
	
}
