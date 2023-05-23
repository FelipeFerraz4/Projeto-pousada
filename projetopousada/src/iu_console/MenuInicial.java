package iu_console;

import java.util.Scanner;
import iu_console.*;

public class MenuInicial extends Menu {
	
	private Login login;
	
	public MenuInicial() {
		super();
		this.login = new Login();
	}
	
	public int menuInicial(){
    	String option[] = {"Fazer login", "Cadastrar usuario", 
    			"Finalizar programa"};
    	
    	int escolha = printOption(option, option.length);
        switch(escolha) {
        	case 1:
        		/*
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
                */
                return -1;
        	case 2:
        		int opition = login.cadastrar(this.getPousada());
            	
            	if (opition == 1) {
            		System.out.println("Cadastro do cliente feito");
            	}
                return -1;
        	default:
        		System.out.println("Programa finalizado");
        		return 0;
        }
    }
	
}
