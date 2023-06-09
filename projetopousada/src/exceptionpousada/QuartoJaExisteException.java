package exceptionpousada;

public class QuartoJaExisteException extends Exception {

	private static final long serialVersionUID = 1L;

	public QuartoJaExisteException() {
		super("Quarto cadastrado anteriormente");
	}
	
}
