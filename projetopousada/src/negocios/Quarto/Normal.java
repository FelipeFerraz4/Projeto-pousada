package negocios.Quarto;

public class Normal extends Quarto {
	
	
	public Normal(int numero) {
		super(numero);
		super.setCapacidade(4);
		super.setTipoQuarto(1);
		super.setPrecoQuarto(250);
	}

	public void agua(int quantAgua) {
		setConta(getConta() + quantAgua*2);
	}
	public void refrigerante(int quantRefri) {
		setConta(getConta() + quantRefri*4);
	}
	public void diaria(int dias) {
		setConta(getConta() + dias*super.getPrecoQuarto());
	}
	
	
}
