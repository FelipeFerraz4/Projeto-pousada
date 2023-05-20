package iuconsole;

import dados.RepositorioPessoaArrayList;
import dados.RepositorioQuartoArrayList;
import negocios.*;

public class TestePessoa {
	public static void main(String[] args) {
	
		RepositorioQuartoArrayList quartos = new RepositorioQuartoArrayList();
		RepositorioPessoaArrayList pessoas = new RepositorioPessoaArrayList();
		
	    // Cliente
		
		Normal quartoN = new Normal(100);
		Normal quarto3 = new Normal(102);
		Prime quarto4 = new Prime(102);
		quartos.adicionarQuarto(quarto3);
		quartos.adicionarQuarto(quarto4);
	   
	    Cliente cliente1 = new Cliente("Andre","1234","123");
	    cliente1.setQuarto(quartoN);
	    quartoN.setOcupado();
	    
	    System.out.println(cliente1.getCPF());
	    System.out.println(cliente1.getNome());
	    System.out.println(cliente1.getHistorico());
	    System.out.println(cliente1.getDiarias());
	    System.out.println(cliente1.getSenha());
	    System.out.println(cliente1.getQuarto().toString());
	    System.out.println(cliente1.toString());
	    
	    System.out.println("teste quartos");
	    cliente1.checkin(quartos);
	    
	    System.out.println("teste servico de quarto Normal");
	    cliente1.sevircoDeQuarto(quartos, 0);
	    
	    System.out.println("teste servico de quarto Prime");
	    cliente1.sevircoDeQuarto(quartos, 1);
	    
	    System.out.println("teste verConsumo");
	    cliente1.verConsumo(quartos, 0);
	    
	    System.out.println("teste historico de agendamento");
	    cliente1.historicoAgendamento();
	    
	    System.out.println("teste pagarConsumo");
	    cliente1.pagarConsumo(quartos, 0);
	    
	    System.out.println("teste diarias");
	    cliente1.diarias();

		
	    
	    System.out.println();
	    // Repositorio 
		
	    pessoas.addPessoa(cliente1);
	    System.out.println(pessoas.getPessoas().get(0).getCPF());
	    System.out.println(pessoas.getPessoas().get(0).getNome());
	    System.out.println(pessoas.getPessoas().get(0).getSenha());
	    System.out.println(pessoas.getPessoas().get(0).getQuarto());
	    
	    System.out.println();
	    
	    pessoas.criarPessoa("lucas", "120", "0000", 1);
	    Prime quartoP = new Prime(100);
	    pessoas.getPessoas().get(1).setQuarto(quartoP);
	    pessoas.getPessoas().get(1).getQuarto().setOcupado();
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
	    quartoN2.setOcupado();
	    pessoas.addPessoa(cliente2);
	    indexBusca = pessoas.buscarPessoa(cliente2);
	    System.out.println(indexBusca);
	    System.out.println(pessoas.getPessoas().get(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getNome());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoas().get(indexBusca).getQuarto());

	    
	    System.out.println();

		
		Cliente pessoa = (Cliente) pessoas.getPessoas().get(2);
		pessoas.atualizarPessoa(pessoa);//"felicia","0992"
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
	    
	    System.out.println();
	    
	    //Gerente
	    
	    Gerente gerente1 = new Gerente("Steve", "50", "10");
	    pessoas.addPessoa(gerente1);
	    Normal quarto = new Normal(50);
	    quartos.adicionarQuarto(quarto);
	    gerente1.setQuarto(quarto);
	    quarto.setOcupado();
	    
	    System.out.println(gerente1.getCPF());
	    System.out.println(gerente1.getNome());
	    System.out.println(gerente1.getSenha());
	    System.out.println(gerente1.getQuarto().toString());
	    System.out.println(gerente1.toString());
	    
	    System.out.println();
	    
	    //CPF de pessoas já adicionadas: 1234, 50, 021, 120
	    //Numero de quartos já cadastrados: N50, N101, P100, N100, N102, P102
	    System.out.println("teste Adicionar cliente");
	    gerente1.addPessoa(pessoas, 1);
	    System.out.println("teste Adicionar gerente");
	    gerente1.addPessoa(pessoas, 2);
	    System.out.println("teste Adicionar quarto normal");
	    gerente1.addQuarto(quartos, 1);
	    System.out.println("teste Adicionar quarto prime");
	    gerente1.addQuarto(quartos, 2);
	    
	    System.out.println("teste remover pesssoa");
	    //gerente1.deletarPessoa(pessoas);
	    System.out.println("teste remover quarto normal");
	    gerente1.removerQuarto(quartos, 1);
	    System.out.println("teste remover quarto Prime");
	    gerente1.removerQuarto(quartos, 2);
	    
    }
}