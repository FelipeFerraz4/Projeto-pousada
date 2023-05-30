package negocios.Pessoa;

import java.util.Scanner;
import dados.repositoriospessoas.IRepositorioPessoa;
import dados.repositoriosquartos.IRepositorioQuarto;
import negocios.*;

public class Cliente extends Pessoa {
	
	private int diarias;
	private int historico;
	private boolean checkin;

	
	public Cliente (String nome, String cpf, String senha) {
		super(nome, cpf, senha);
		this.setTipoPessoa(1);
		this.checkin = false;
		this.historico = 0;
	}
	public int getDiarias() {
		return diarias;
	}
	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	public boolean isCheckin() {
		return checkin;
	}
	public void setCheckin(boolean checkin) {
		this.checkin = checkin;
	}
	public int getHistorico() {
		return historico;
	}
	public void setHistorico(int novoHistorico) {
		this.historico = novoHistorico;
	}
}
