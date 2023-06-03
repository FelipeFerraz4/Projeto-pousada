
package iu_console;

import negocios.FachadaPousada;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FachadaPousada pousada = new FachadaPousada();
		MenuInicial menu = new MenuInicial();
        	int option;
        	do {
        		option = menu.menuInicial(pousada);
        	}while(option == -1);
	}
}
