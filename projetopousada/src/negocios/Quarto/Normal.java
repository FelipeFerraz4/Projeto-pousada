package negocios.Quarto;

public class Normal extends Quarto {
	
	private float preco = 250;
	
	public Normal(int numero) {
		super(numero);
		setCapacidade(4);
		setTipoQuarto(1);
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}

	public void agua(int quantAgua) {
		setConta(getConta() + quantAgua*2);
	}
	public void refrigerante(int quantRefri) {
		setConta(getConta() + quantRefri*4);
	}
	public void diaria(int dias) {
		setConta(getConta() + dias*getPreco());
	}
	
	
}
