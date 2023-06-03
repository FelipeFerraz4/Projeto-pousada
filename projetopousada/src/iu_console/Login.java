package iu_console;

import java.util.Scanner;
import negocios.FachadaPousada;

public class Login {
	
	public int entrar(FachadaPousada pousada, Scanner scan) {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		System.out.println("Digite o seu CPF: ");
		String cpf = scan.nextLine();
		System.out.println("Digite a sua senha: ");
		String senha = scan.nextLine();
		//Tratar a exception de senha não existe e de senha errada
		int indexPessoa = pousada.buscarPessoa(cpf);
		if (indexPessoa == -1) {
			return -1;
		}
		int verifyPassword = pousada.verificarSenha(indexPessoa, senha);
		if (verifyPassword == -1) {
			return -1;
		}
		return indexPessoa;
	}
	
	public int cadastrar(FachadaPousada pousada, Scanner scan) {
		if(scan.hasNextLine()) {
			scan.nextLine();
		}
		System.out.println("Digite o seu CPF: ");
		String cpf = scan.nextLine();
		System.out.println("Digite o seu Nome: ");
		String nome = scan.nextLine();
		System.out.println("Digite uma senha: ");
		String senha = scan.nextLine();
		// Tratar exception cadastro já existe
		int indexPessoa = pousada.buscarPessoa(cpf);
		if (indexPessoa != -1) {
			return -1;
		}
		pousada.cadastrarNovoCliente(nome, cpf, senha);
		return 1;
	}

	public int reservarQuarto(FachadaPousada pousada){
		return 0;
	}
	
}
