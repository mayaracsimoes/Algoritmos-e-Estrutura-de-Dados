package exercicio05_PilhaVetor;

public class PilhaVaziaException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PilhaVaziaException(String mensagem) {
        super(mensagem);
    }
}