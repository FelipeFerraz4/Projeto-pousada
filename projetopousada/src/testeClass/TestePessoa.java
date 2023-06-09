/*package testeClass;

import dados.repositoriospessoas.*;
import dados.repositoriosquartos.*;
import negocios.*;
import negocios.Pessoa.Cliente;
import negocios.Pessoa.Gerente;
import negocios.Quarto.Normal;
import negocios.Quarto.Prime;

public class TestePessoa {
	public static void main(String[] args) {
	
		IRepositorioQuarto quartos = new RepositorioQuartoArrayList();
		IRepositorioPessoa pessoas = new RepositorioPessoaArrayList();
		
	    // Cliente
		
		Normal quartoN = new Normal(100);
		Normal quarto3 = new Normal(102);
		Prime quarto4 = new Prime(102);
		quartos.adicionarQuarto(quarto3);
		quartos.adicionarQuarto(quarto4);
	   
	    Cliente cliente1 = new Cliente("Andre","1234","123");
	    cliente1.setQuarto(quartoN);
	    quartoN.setOcupado(true);
	    
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
	    System.out.println(pessoas.getPessoa(0).getCPF());
	    System.out.println(pessoas.getPessoa(0).getNome());
	    System.out.println(pessoas.getPessoa(0).getSenha());
	    System.out.println(pessoas.getPessoa(0).getQuarto());
	    
	    System.out.println();
	    
	    pessoas.criarPessoa("lucas", "120", "0000", 1);
	    Prime quartoP = new Prime(100);
	    pessoas.getPessoa(1).setQuarto(quartoP);
	    pessoas.getPessoa(1).getQuarto().setOcupado(true);
	    System.out.println(pessoas.getPessoa(1).getCPF());
	    System.out.println(pessoas.getPessoa(1).getNome());
	    System.out.println(pessoas.getPessoa(1).getSenha());
	    System.out.println(pessoas.getPessoa(1).getQuarto());
	    
	    System.out.println();
	    
	    int indexBusca = pessoas.buscarPessoa("1234");
	    System.out.println(pessoas.getPessoa(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoa(indexBusca).getNome());
	    System.out.println(pessoas.getPessoa(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoa(indexBusca).getQuarto());
	    
	    System.out.println();
	    
	    Cliente cliente2 = new Cliente("felipe", "021", "021");
	    Normal quartoN2 = new Normal(101);
	    cliente2.setQuarto(quartoN2);
	    quartoN2.setOcupado(true);
	    pessoas.addPessoa(cliente2);
	    indexBusca = pessoas.buscarPessoa(cliente2);
	    System.out.println(indexBusca);
	    System.out.println(pessoas.getPessoa(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoa(indexBusca).getNome());
	    System.out.println(pessoas.getPessoa(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoa(indexBusca).getQuarto());

	    
	    System.out.println();

		
		Cliente pessoa = (Cliente) pessoas.getPessoa(2);
		pessoas.atualizarPessoa(pessoa);//"felicia","0992"
	    indexBusca = pessoas.buscarPessoa(pessoa);
	    System.out.println(pessoas.getPessoa(indexBusca).getCPF());
	    System.out.println(pessoas.getPessoa(indexBusca).getNome());
	    System.out.println(pessoas.getPessoa(indexBusca).getSenha());
	    System.out.println(pessoas.getPessoa(indexBusca).getQuarto());
	    
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
	    quarto.setOcupado(true);
	    
	    System.out.println(gerente1.getCPF());
	    System.out.println(gerente1.getNome());
	    System.out.println(gerente1.getSenha());
	    System.out.println(gerente1.getQuarto().toString());
	    System.out.println(gerente1.toString());
	    
	    System.out.println();
	    
	    //CPF de pessoas já adicionadas: 1234, 50, 021, 120
	    //Numero de quartos já cadastrados: N50, N101, P100, N100, N102, P102
	    System.out.println("teste Adicionar cliente");
	    gerente1.addPessoa(pessoas, 1, "1", "1","1");
	    System.out.println("teste Adicionar gerente");
	    gerente1.addPessoa(pessoas, 2, "steve", "342", "7621");
	    System.out.println("teste Adicionar quarto normal");
	    gerente1.addQuarto(quartos, 1, 1);
	    System.out.println("teste Adicionar quarto prime");
	    gerente1.addQuarto(quartos, 1, 2);
	    
	    System.out.println("teste remover pesssoa");
	    //gerente1.deletarPessoa(pessoas);
	    System.out.println("teste remover quarto normal");
	    gerente1.deletarQuarto(quartos, 1, 1);
	    System.out.println("teste remover quarto Prime");
	    gerente1.deletarQuarto(quartos, 1, 2);
	    
    }
}*/