package exceptionpousada;

public class DeletarGerentePrincipalException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public DeletarGerentePrincipalException() {
		super("Nao pode deletar o gerente inicial");
	}
	
}
