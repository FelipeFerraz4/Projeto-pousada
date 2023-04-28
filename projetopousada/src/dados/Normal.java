package dados;

public class Normal extends Quarto {
	private float preco;
	private float conta;
	private void Agua(int quantAgua) {
		conta = conta + quantAgua*2;
		
	}
	private void refrigerante(int quantRefri) {
		conta= conta + quantRefri*4;
	}
	private void diaria(int dias) {
		conta =conta +  dias*200;
		
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	public float getConta() {
		return conta;
	}
	public void setConta(float conta) {
		this.conta = conta;
	}

}
