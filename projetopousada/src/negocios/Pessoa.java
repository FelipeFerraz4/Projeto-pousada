package negocios;

public abstract class Pessoa {
	
	private String CPF;
	private String Senha;
	private String Nome;
	private int tipoPessoa;
	private Quarto quarto;
	
	public Pessoa(String nome, String cpf, String senha){
		this.Nome = nome;
		this.CPF = cpf;
		this.Senha = senha;
	}
	
	
	public int getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(int tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public Quarto getQuarto() {
		return quarto;
	}
	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa pessoa = (Pessoa) obj;
			if (this.CPF.equals(pessoa.getCPF())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String resultado = "Cliente " + this.getNome() + 
				"\nportador do CPF: " + CPF + " com a senha: " 
				+ Senha;
		return resultado;
	}
	
}
