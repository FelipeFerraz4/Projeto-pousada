package dados;

import java.util.Scanner;
import repositorio.RepositorioPessoa;

public class Login {
	
	public int entrar(RepositorioPessoa pessoas) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o seu CPF: ");
		String cpf = scan.nextLine();
		int pessoa = pessoas.buscarPesoa(cpf); 
		if(pessoa ==-1) {
			System.out.println("Operacao invalida, CPF ainda nao cadastrado");
			return 0;
		}
		System.out.println("Digite a sua senha: ");
		int senha = scan.nextInt();
		//if (pessoas.get())
		
		return 1;
	}
	
	public int cadastrar(RepositorioPessoa pessoas) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o seu CPF: ");
		String cpf = scan.nextLine();
		if(pessoas.buscarPesoa(cpf)!=-1) {
			System.out.println("Operacao invalida, CPF já cadastrado");
			return 0;
		}
		System.out.println("Digite o seu Nome: ");
		String nome = scan.nextLine();
		System.out.println("Digite uma senha: ");
		int senha = scan.nextInt();
		
		pessoas.criarPessoa(nome, cpf, senha);
		pessoas.getPessoas().get(0).toString();
		
		return 1;
	}
	
}
