package teste;

import dados.*;
import repositorio.RepositorioPessoa;

public class TestePessoa {
	public static void main(String[] args) {
	
	    // Cliente
		
		Normal quartoN = new Normal(100);
	   
	    Cliente cliente1 = new Cliente("Andre","1234","123");
	    cliente1.setQuarto(quartoN);
	    
	    System.out.println(cliente1.getCPF());
	    System.out.println(cliente1.getNome());
	    System.out.println(cliente1.getSenha());
	    System.out.println(cliente1.getQuarto().toString());
	    
	    System.out.println();
	    // Repositorio 

	    
	    RepositorioPessoa pessoas = new RepositorioPessoa();
	    
	    pessoas.addPessoa(cliente1);
	    System.out.println(pessoas.getPessoas().get(0).getCPF());
	    System.out.println(pessoas.getPessoas().get(0).getNome());
	    System.out.println(pessoas.getPessoas().get(0).getSenha());
	    System.out.println(pessoas.getPessoas().get(0).getQuarto());
	    
	    System.out.println();
	    
	    pessoas.criarPessoa("lucas", "120", "0000", 1);
	    Prime quartoP = new Prime(100);
	    pessoas.getPessoas().get(1).setQuarto(quartoP);
	    System.out.println(pessoas.getPessoas().get(1).getCPF());
	    System.out.println(pessoas.getPessoas().get(1).getNome());
	    System.out.println(pessoas.getPessoas().get(1).getSenha());
	    System.out.println(pessoas.getPessoas().get(1).getQuarto());
	    
	    System.out.println();
	    
	    int indexBusca = pessoas.buscarPessoa("1234");
	    System.out.println(pessoas.getPessoas().get(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getNome());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getQuarto());
	    
	    System.out.println();
	    
	    Cliente cliente2 = new Cliente("felipe", "021", "021");
	    Normal quartoN2 = new Normal(101);
	    cliente2.setQuarto(quartoN2);
	    pessoas.addPessoa(cliente2);
	    indexBusca = pessoas.buscarPessoa(cliente2);
	    System.out.println(indexBusca);
	    System.out.println(pessoas.getPessoas().get(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getNome());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getQuarto());

	    
	    System.out.println();

		
		Cliente pessoa = (Cliente) pessoas.getPessoas().get(1);
		pessoas.atualizarPessoa(pessoa);
	    indexBusca = pessoas.buscarPessoa(pessoa);
	    System.out.println(pessoas.getPessoas().get(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getNome());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getQuarto());
	    
	    if (pessoas.deletarPessoa("120")==1) {
	    	System.out.println("pessoa deletada");
	    }
	    else {
	    	System.out.println("pessoa nao deletada");
	    }
	    
	    System.out.println();
	    
	    if (pessoas.deletarPessoa(cliente2)==1) {
	    	System.out.println("pessoa deletada");
	    }
	    else {
	    	System.out.println("pessoa nao deletada");
	    }
	    
	    
	    
    }
}