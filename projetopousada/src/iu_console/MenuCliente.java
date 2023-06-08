package iu_console;

import java.util.Scanner;

import exceptionpousada.QuartoNaoEncontradoException;
import negocios.FachadaPousada;


public class MenuCliente extends Menu{
	
	private int cliente;
	private int indexQuarto;
	private int tipoDeQuarto;

	public MenuCliente(int indexCliente) {
		super();
		this.cliente = indexCliente;
	}
	public int menuCliente(FachadaPousada pousada, Scanner scan){
		String option[] = {"Check-in", "Sevirco de quarto", "Ver consumo", 
				"Ver historico de agendamento", "Dados do Cliente","Pagar consumo", "Checkout","voltar"};		
		int escolha = printOption(option, option.length, scan);
        
        switch(escolha){
            case 1:
				if ( pousada.isCheckin(cliente) == -1) {
                    this.menuCheckin(pousada, scan);
                    return -1;
            	}
				else{
                System.out.println("Check-in feito anteriormente");
				}
                
                return -1;
            case 2:
            	if (pousada.isCheckin(cliente)== 1) {
            		this.menuServisoDeQuarto(pousada, scan);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                
                return -1;
            case 3:
				if (pousada.isCheckin(cliente)== 1) {
            		verConsumo(pousada);
            		return -1;
            	}
                System.out.println("Por favor, fazer check-in");
                return -1;
            case 4:
        
            	historicoAgendamento(pousada);
            	
                return -1;
            case 5:
				System.out.println(dadosDoCliente(pousada));	
                return -1;
            case 6:
				if (pousada.isCheckin(cliente)== 1) {
					this.pagarConsumo(pousada, this.indexQuarto, scan);
					return -1;
				}
				System.out.println("Por favor, fazer check-in");
					return -1;
			case 7:
				while(this.Checkout(pousada)== -1){
					return -1;
				}
				return 0;
			default:
            	
				return 0;
        }
    }

	public int menuCheckin(FachadaPousada pousada, Scanner scan){
		
		String option[] = {"Quarto Normal ate 3 pessoas - 250,00",
				"Quarto Prime ate 7 pessoas - 400,00", "Voltar"};
    	// tratar a exception de nenhum quarto desse tipo vazio;
		
		int escolha = printOption(option, option.length, scan);
        
        switch(escolha){
			case 1: 
				int indexQuartoN;
				try {
					indexQuartoN = pousada.quartoVazio(1);
					this.tipoDeQuarto = 1;
					this.diarias(pousada, indexQuartoN, scan); 
				}
				catch(QuartoNaoEncontradoException e) {
					System.out.println("Nenhum Quarto normal disponivel, por favor falar com o gerente ");
					this.menuCheckin(pousada, scan);
				}
				catch(Exception e) {
					System.out.println(e.getMessage() + " " + e.getClass());
				}
				return -1;

			case 2: 
				int indexQuartoP;
				try {
					indexQuartoP = pousada.quartoVazio(2);
					this.tipoDeQuarto = 2;
					this.diarias(pousada, indexQuartoP, scan);
				}
				catch(QuartoNaoEncontradoException e) {
					System.out.println("Nenhum Quarto Prime disponivel, por favor falar com o gerente ");
					this.menuCheckin(pousada, scan);
				}
				catch(Exception e) {
					System.out.println(e.getMessage() + " " + e.getClass());
				}
				return -1;
				
			default:	
				return 0;

		}
	}
	public void diarias(FachadaPousada pousada,int indexQuarto, Scanner scan){
		
		System.out.println("quantas diarias deseja reservar?");
		int d,r=0;
		while(r != 1 ){
			try{
				do {
					d = scan.nextInt();
					if (d < 1 || d >15) {
						System.out.println("o maximo de diarias possivel sao 15 por pessoa!");
						System.out.println("Por favor, digite a quantidadede de diarias desejadas: ");
					}
				
				
				}while( d < 1 || d >15);
				this.indexQuarto = indexQuarto;
				pousada.reservarQuarto(indexQuarto, d,this.tipoDeQuarto);
				pousada.setCheckin(this.cliente, true);
				pousada.setHistorico(cliente);
				System.out.println("Reserva Realizada");
				r = 1;
			}
			
			catch(java.util.InputMismatchException e) {
        		System.out.println("opticao invalida");
        		if(scan.hasNextLine()) {
        			scan.nextLine();
        		}
        	}

			catch(Exception e) {
				System.out.println(e.getMessage() + "  " + e.getClass());
			}
		}

	}

	public int menuServisoDeQuarto(FachadaPousada pousada, Scanner scan){
		int r=0;
		if (this.tipoDeQuarto == 1){
			int quantidade;
			System.out.println("Qual opcao de quarto gostaria ?");
			String option[] = {"Agua - 2,00",
				"Refrigarante - 4,00", "Voltar"};
		
			int escolha = printOption(option, option.length, scan);
			
			switch(escolha){
				case 1:
					while(r !=1){
						try {
							System.out.println("Qual a quantidade?");
							quantidade = scan.nextInt();
							if(quantidade>=0) {
								pousada.sevircoDeQuarto(1,this.indexQuarto , quantidade);
							}
							r=1;
						}
						catch(java.util.InputMismatchException e) {
							System.out.println("opticao invalida");
							if(scan.hasNextLine()) {
								scan.nextLine();
							}
						}
						catch(Exception e) {
							System.out.println(e.getMessage() + " " + e.getClass());
						}
					}
					return -1;

				case 2:
					
					while(r != 1){
						try{
							System.out.println("Qual a quantidade?");
							quantidade = scan.nextInt();
							if(quantidade>=0) {
							pousada.sevircoDeQuarto(2,this.indexQuarto , quantidade);
							}
							r = 1;
						}
						catch(java.util.InputMismatchException e) {
							System.out.println("opticao invalida");
							if(scan.hasNextLine()) {
								scan.nextLine();
							}
						}
						catch(Exception e) {
							System.out.println(e.getMessage() + " " + e.getClass());
						}
					}
					return -1;
				default:
				
					return 0;
			}
		}
		
			
		else{
			int quantidade;
			System.out.println("Qual opcao de quarto gostaria ?");
			String option[] = {" Vinho - 70,00",
				"champagne - 120,00", "Voltar"};
		
			int escolha = printOption(option, option.length, scan);

			switch(escolha){
				case 1:
					while(r != 1){	
						try{
							System.out.println("Qual a quantidade?");
							quantidade = scan.nextInt();
							if(quantidade>=0) {
								pousada.sevircoDeQuarto(3, this.indexQuarto, quantidade);
							}
							r=1;
						}
						catch(java.util.InputMismatchException e) {
							System.out.println("opticao invalida");
							if(scan.hasNextLine()) {
								scan.nextLine();
							}
						}
						catch(Exception e) {
							System.out.println(e.getMessage() + " " + e.getClass());
						}
					}
				return -1;

				case 2:
					while(r != 1){	
						try{
							System.out.println("Qual a quantidade?");
							quantidade = scan.nextInt();
							if(quantidade>=0) {
								pousada.sevircoDeQuarto(4, this.indexQuarto , quantidade);
							}
							r=1;
						}
						catch(java.util.InputMismatchException e) {
							System.out.println("opticao invalida");
							if(scan.hasNextLine()) {
								scan.nextLine();
							}
						}	
						catch(Exception e) {
							System.out.println(e.getMessage() + " " + e.getClass());
						}
					}
					
				return -1;
			
				default:


				return 0;
			
			}
		}
	}

	public void verConsumo(FachadaPousada pousada) {
		System.out.println("seu consumo atual: R$" + pousada.consumo(this.indexQuarto));
	}

	public void historicoAgendamento(FachadaPousada pousada){
		System.out.println("você fez "+ pousada.getHistorico(cliente) + " agendamentos nessa pousada");
	}

	public int pagarConsumo(FachadaPousada pousada, int indexQuarto, Scanner scan) {
		System.out.println("valor da conta e "+ pousada.consumo(this.indexQuarto));
		System.out.println("Qual forma de pagamento?");
		String option[] = {" Dinheiro","Cartao", "pix","Voltar"};

		int escolha = printOption(option, option.length, scan);
			
		switch(escolha){
			case 1:
				System.out.println("pagamento efetuado. Obrigado, volte sempre!");
				pousada.pagarConta(this.indexQuarto);
			return -1;
				
			case 2:
				System.out.println("insira seu cartao");
				System.out.println("coloque sua senha");
				System.out.println("pagamento efetuado. Obrigado, volte sempre!");
				pousada.pagarConta(this.indexQuarto);
			return -1;

			case 3:
				System.out.println("A chave pix: 55555");
				System.out.println("pagamento efetuado. Obrigado, volte sempre!");
				pousada.pagarConta(this.indexQuarto);
			return -1;
			default:

			return 0;
		}

	}
	public String dadosDoCliente (FachadaPousada pousada){
		
		return pousada.dadosDoCliente(this.cliente);
	}

	public int Checkout(FachadaPousada pousada){
		if (pousada.consumo(indexQuarto) == 0){
			pousada.setCheckin(this.cliente, false);
			return 0;
		}
		else {
			System.out.println("você ainda tem conta aberta na pousada, por favor voltar a 'pagar conta'");
			return -1;
		}
	}
















}