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
		+ "Capacidade: " + this.capacidade;
	}
	
}
