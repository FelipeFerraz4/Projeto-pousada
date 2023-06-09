package negocios.Quarto;

public class Prime extends Quarto {
	
	public Prime(int numero) {
		super(numero);
		super.setCapacidade(7);
		super.setTipoQuarto(2);
		super.setPrecoQuarto(400);
	}
	
	public void vinho(int quantidade) {
		setConta(getConta() + quantidade*70);
	}
	public void champagne(int quantidade) {
		setConta(getConta() + quantidade*120);
	}
	public void diaria(int quantidade) {
		setConta(getConta() + quantidade*super.getPrecoQuarto());
	}
}
