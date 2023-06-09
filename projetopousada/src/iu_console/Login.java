package iu_console;

import java.util.Scanner;

import exceptionpousada.PessoaJaExisteException;
import exceptionpousada.PessoaNaoEncontradoException;
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
		int indexPessoa;
		try {
			indexPessoa = pousada.buscarPessoa(cpf);
			int verifyPassword = pousada.verificarSenha(indexPessoa, senha);
			if (verifyPassword == -1) {
				return -1;
			}
			return indexPessoa;
		}
		catch(PessoaNaoEncontradoException e) {
			return -1;
		}
		catch(Exception e) {
			System.out.println(e.getMessage() + " " + e.getClass());
		}
		return -1;

	}
	
	public void cadastrar(FachadaPousada pousada, Scanner scan) {
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
		try {
			pousada.cadastrarNovoCliente(nome, cpf, senha);
			System.out.println("Cadastro do cliente feito");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Espaco para cadastro lotado");
		}
		catch(PessoaJaExisteException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e ) {
			System.out.println(e.getMessage() + " " + e.getClass());
		}
	}

	public int reservarQuarto(FachadaPousada pousada){
		return 0;
	}
	
}
