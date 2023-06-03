package iu_console;

import java.util.Scanner;
import negocios.FachadaPousada;

public class MenuInicial extends Menu {
	
	private Login login;
	
	public MenuInicial() {
		super();
		this.login = new Login();
	}
	
	public int menuInicial(FachadaPousada pousada, Scanner scan){
    	String option[] = {"Fazer login", "Cadastrar usuario", 
    			"Finalizar programa"};
    	
    	int escolha = printOption(option, option.length, scan);
        switch(escolha) {
        	case 1:
        		
        		int indexPessoa = login.entrar(pousada, scan);

                if (indexPessoa != -1) {
                	int tipoPessoa = pousada.verificarTipoPessoa(indexPessoa);
                	if (tipoPessoa==1){
                    	System.out.println("Bem vindo Cliente");
                    	MenuCliente tela = new MenuCliente(indexPessoa);
                    	int result;
                    	do {
                    		result = tela.menuCliente(pousada, scan);
                    	}while(result == -1);
                    	return -1;
                    }
                    else if (tipoPessoa == 2){
                    	System.out.println("Bem vindo Gerente");
                    	MenuGerente tela = new MenuGerente(indexPessoa);
                    	int result;
                    	do {
                    		result = tela.menuGerente(pousada, scan);
                    	}while(result == -1);
                    	return -1;
                    }
                }
                else {
                	System.out.println("Conta nao encontrada");
                	return -1;
                }
        	case 2:
        		int opition = login.cadastrar(pousada, scan);
            	if (opition == 1) {
            		System.out.println("Cadastro do cliente feito");
            	}
            	else {
            		System.out.println("operacao invalida, cliente cadastrado anteriomente");
            	}
                return -1;
        	default:
        		System.out.println("Programa finalizado");
        		return 1;
        }
    }
	
}
