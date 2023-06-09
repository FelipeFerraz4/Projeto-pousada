package exceptionpousada;

public class PessoaJaExisteException extends Exception{
 
	private static final long serialVersionUID = 1L;

	public PessoaJaExisteException() {
		super("Pessoa cadastrada anteriomente");
	}
	
}
