package iu_console;

import java.util.Scanner;
import iu_console.*;
import negocios.FachadaPousada;

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
        		
        		int indexPessoa = login.entrar(super.getPousada());

                if (indexPessoa != -1) {
                	int tipoPessoa = super.getPousada().verificarTipoPessoa(indexPessoa);
                	if (tipoPessoa==1){
                    	System.out.println("Bem vindo Cliente");
                    	MenuCliente tela = new MenuCliente(indexPessoa);
                    	int result;
                    	do {
                    		result = tela.menuCliente(super.getPousada());
                    	}while(result == -1);
                    	return -1;
                    }
                    else if (tipoPessoa == 2){
                    	System.out.println("Bem vindo Gerente");
                    	MenuGerente tela = new MenuGerente(indexPessoa);
                    	int result;
                    	do {
                    		result = tela.menuGerente();
                    	}while(result == -1);
                    	return -1;
                    }
                }
                else {
                	System.out.println("Conta nao encontrada");
                	return -1;
                }
        	case 2:
        		int opition = login.cadastrar(super.getPousada());
            	if (opition == 1) {
            		System.out.println("Cadastro do cliente feito");
            	}
                return -1;
        	default:
        		System.out.println("Programa finalizado");
        		return 1;
        }
    }
	
}
