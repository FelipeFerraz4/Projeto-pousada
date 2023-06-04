package exceptionpousada;

public class PessoaNaoEncontradoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PessoaNaoEncontradoException() {
		super("Pessoa nao encontrada");
	}
	
}
