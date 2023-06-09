package negocios.Quarto;

public abstract class Quarto {
	
	private int numeroQuato;
	private int tipoQuarto;
	private int capacidade;
	private boolean ocupado;
	private float conta;
	private float precoQuarto;

	public Quarto(int numero){
		this.numeroQuato = numero;
		this.ocupado = false;
		this.conta = 0;
	}
	
	public int getNumeroQuato() {
		return this.numeroQuato;
	}
	
	public int getTipoQuarto() {
		return tipoQuarto;
	}

	public void setTipoQuarto(int tipoQuarto) {
		this.tipoQuarto = tipoQuarto;
	}

	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	public boolean isOcupado() {
		return this.ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public float getConta() {
		return conta;
	}
	public void setConta(float valor) {
		this.conta = valor;
	}
	
	public float getPrecoQuarto() {
		return precoQuarto;
	}

	public void setPrecoQuarto(float precoQuarto) {
		this.precoQuarto = precoQuarto;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Quarto) {
			Quarto quarto = (Quarto) obj;
			if(this.tipoQuarto==quarto.getTipoQuarto()) {
				if(this.numeroQuato==quarto.getNumeroQuato()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		String tipo;
		if (this.tipoQuarto==1) {
			tipo = "N";
		}
		else {
			tipo = "P";
		}
		
		return "Numero do quarto: " + tipo + this.numeroQuato + "\n"
		+ "Ocupado: " + this.ocupado + "\n"
		+ "Conta: " + this.conta + "\n"
		+ "Capacidade: " + this.capacidade + "\n"
		+ "Preco da diaria do quarto: " + this.precoQuarto + "\n";
	}
	
}
