package exercicio06_FilaLista;

public class FilaVaziaException extends RuntimeException  {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FilaVaziaException(String mensagem) {
        super(mensagem);
    }
}