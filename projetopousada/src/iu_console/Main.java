package iu_console;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MenuInicial menu = new MenuInicial();
        	int option;
        	do {
        		option = menu.menuInicial();
        	}while(option == -1);
	}
}
