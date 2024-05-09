package exercicio06_FilaVetor;

public class FilaVaziaException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilaVaziaException(String mensagem) {
        super(mensagem);
    }
}