package negocios;

import java.util.Scanner;

import dados.RepositorioPessoa;

public class Login {
	
	public int entrar(RepositorioPessoa pessoas) {

		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o seu CPF: ");
		String cpf = scan.nextLine();
		
		int pessoa = pessoas.buscarPessoa(cpf); 
		
		if(pessoa ==-1) {
			System.out.println("Operacao invalida, CPF ainda nao cadastrado");
			return -1;
		}
		
		System.out.println("Digite a sua senha: ");
		String senha = scan.nextLine();
		
		if (pessoas.getPessoas().get(pessoa).getSenha().equals(senha)) {
			return pessoa;
		}
		System.out.println("Operacao invalida, CPF ou senha incorreto");
		return -1;
	}
	
	public int cadastrar(RepositorioPessoa pessoas) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o seu CPF: ");
		String cpf = scan.nextLine();
		
		if(pessoas.buscarPessoa(cpf)!=-1) {
			System.out.println("Operacao invalida, CPF ja cadastrado");
			return 0;
		}
		
		System.out.println("Digite o seu Nome: ");
		String nome = scan.nextLine();
		System.out.println("Digite uma senha: ");
		String senha = scan.nextLine();
		
		pessoas.criarPessoa(nome, cpf, senha, 1);
		
		return 1;
	}
	
}
