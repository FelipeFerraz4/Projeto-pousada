package dados;

public abstract class Quarto {
	
	private int numeroQuato;
	private int tipoQuarto;
	private int capacidade;
	private boolean ocupado = false;
	private float conta = 0;
	
	public Quarto(int numero){
		this.numeroQuato = numero;
		this.ocupado = true;
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
	public void setOcupado() {
		if (this.ocupado == false) {
			this.ocupado = true;
		}
		else {
			this.ocupado = false;
			this.conta = 0;
		}
	}
	public float getConta() {
		return conta;
	}
	public void setConta(float valor) {
		this.conta = valor;
	}
	
	public boolean equals(Quarto quarto) {
		if(this.tipoQuarto==quarto.getTipoQuarto()) {
			if(this.numeroQuato==quarto.getNumeroQuato()) {
				return true;
			}
			return false;
		}
		return false;
	}
}
