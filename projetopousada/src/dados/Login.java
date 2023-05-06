package dados;

import java.util.Scanner;
import repositorio.RepositorioPessoa;

public class Login {
	
	public int entrar(RepositorioPessoa pessoas) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Digite o CPF: ");
		String cpf = scan.nextLine();
		int pessoa = pessoas.buscarPesoa(cpf); 
		if(pessoa ==-1) {
			System.out.println("CPF ainda nao cadastrado");
			return 0;
		}
		System.out.println("Digite a sua senha: ");
		int senha = scan.nextInt();
		//if (pessoas.get())
		
		return 0;
	}
	public void cadastrar() {
		
	}
	
}
