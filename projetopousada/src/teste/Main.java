package teste;

import dados.Menu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
        int close = 0, i;
        do {
          String nome = "Sol Nascente";    
          menu.cabecarioPousada(nome);
          close = 1;
        }while(close != 1);
	}

}
