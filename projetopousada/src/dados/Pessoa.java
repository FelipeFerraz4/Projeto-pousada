package dados;

public abstract class Pessoa {
	
	private String CPF;
	private int Senha;
	private String Nome;
	private int tipoPessoa;
	
	public Pessoa(String n, String cpf, int senha){
		this.Nome = n;
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
	public int getSenha() {
		return Senha;
	}
	public void setSenha(int senha) {
		Senha = senha;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Pessoa) {
			Pessoa pessoa = (Pessoa) obj;
			if (this.CPF == pessoa.CPF) {
				return true;
			}
		}
		return false;
	}
/*	
	@Override
	public boolean equals(Object c) {
		if(this.CPF.equals(((Pessoa)c).CPF)) {
			return true;
		}else {
			return false;
		}
	}
*/	
	@Override
	public String toString() {
		String resultado = "Cliente " + this.getNome() + 
				"\nportador do CPF: " + CPF + "com a senha: " + Senha;
		return resultado;
	}
	
}
