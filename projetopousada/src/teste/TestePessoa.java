package teste;

import dados.*;
import repositorio.RepositorioPessoa;

public class TestePessoa {
	public static void main(String[] args) {

    // Teste Cliente
		
	Normal quartoN = new Normal(100);
   
    Cliente cliente1 = new Cliente("Andre","1234",123, quartoN);
    
    System.out.println(cliente1.getCPF());
    System.out.println(cliente1.getQuarto().toString());
    
    
    
    }
}