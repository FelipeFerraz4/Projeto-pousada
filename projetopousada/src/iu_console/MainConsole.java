
package iu_console;

import java.util.Scanner;

import negocios.FachadaPousada;

public class MainConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FachadaPousada pousada = new FachadaPousada();
		Scanner scan = new Scanner(System.in);
		MenuInicial menu = new MenuInicial();
        	int option;
        	do {
        		option = menu.menuInicial(pousada, scan); 
        	}while(option == -1);
        scan.close();
	}
}
