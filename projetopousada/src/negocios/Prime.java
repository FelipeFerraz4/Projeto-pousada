package negocios;

public class Prime extends Quarto {
	
	private float preco = 400;
	
	public Prime(int numero) {
		super(numero);
		setCapacidade(7);
		setTipoQuarto(2);
	}
	
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
	public void vinho(int quantidade) {
		setConta(getConta() + quantidade*70);
	}
	public void champagne(int quantidade) {
		setConta(getConta() + quantidade*120);
	}
	public void diaria(int quantidade) {
		setConta(getConta() + quantidade*this.preco);
	}
}
