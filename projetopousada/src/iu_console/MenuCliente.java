package iu_console;

import java.util.Scanner;

import negocios.FachadaPousada;
import negocios.Pessoa.Cliente;
import negocios.Quarto.Quarto;

public class MenuCliente extends Menu{
	
	private int cliente;
	
	public MenuCliente(int indexCliente) {
		super();
		this.cliente = indexCliente;
	}
	
	public int menuCliente(FachadaPousada pousada){
		String option[] = {"Chenck-in", "Sevirco de quarto", "Ver consumo", 
				"Ver historico de agendamento", "Pagar consumo", 
				"Perfil", "Checkout", "Fechar guia cliente" };
    	
		int escolha = printOption(option, option.length);
        
        switch(escolha){
            case 1:
            	/*
            	if (cliente.isCheckin()==false) {
            		int option;
                    do {
                    	option = cliente.checkin(quartos);
                    }while(option == -1);
                    return -1;
            	}
                System.out.println("Check-in feito anteriormente");
                */
                return -1;
            case 2:
            	/*
            	if (cliente.isCheckin()==true) {
            		Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
            		int indexQuarto = quartos.buscarQuarto(quarto);
            		cliente.sevircoDeQuarto(quartos, indexQuarto);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                */
                return -1;
            case 3:
            	/*
            	if (cliente.isCheckin()==true) {
            		Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
            		int indexQuarto = quartos.buscarQuarto(quarto);
            		cliente.verConsumo(quartos, indexQuarto);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                */
                return -1;
            case 4:
            	/*
            	cliente.historicoAgendamento();
            	*/
                return -1;
            case 5:
            	/*
            	if (cliente.isCheckin()==true) {
            		Quarto quarto = pessoas.getPessoas().get(indexCliente).getQuarto();
            		int indexQuarto = quartos.buscarQuarto(quarto);
            		cliente.pagarConsumo(quartos, indexQuarto);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                */
                return -1;
            case 6:
            	/*
            	System.out.println(pessoas.getPessoas().get(indexCliente).toString());
            	if (pessoas.getPessoas().get(indexCliente).getQuarto()!=null) {
            		System.out.println(pessoas.getPessoas().get(indexCliente).getQuarto().toString());
            	}
            	*/
            	return -1;
            case 7:
            	/*
            	if(cliente.getQuarto()!=null) {
            		if (cliente.getQuarto().getConta() == 0) {
                		cliente.getQuarto().setOcupado();
                		cliente.setQuarto(null);
                		cliente.setDiarias(0);
                		cliente.setCheckin(false);
                		System.out.println("Obrigado pela preferencia e volte sempre");
                		return 0;
                	}
            		System.out.println("Por favor, finalize sua conta antes de sair");
            		return -1;
            	}
            	//possivel de ser retirado, basta testa sem
            	cliente.setDiarias(0);
        		cliente.setCheckin(false);
        		System.out.println("Obrigado e volte sempre");
        		*/
                return -1;
            default:
            	System.out.println("Guia cliente fechada");
            	return 0;
        }
    }
}
