package exercicio05_PilhaVetor;

public class PilhaVetor<T> implements Pilha<T> {
	private int tamanho;
	private int limite;
	private Object[] info;

	public PilhaVetor(int limite) {
		this.info = new Object[limite];
		this.tamanho = 0;
		this.limite = limite;
	}

	@Override
	public void push(T info) throws PilhaCheiaException {
		if (tamanho == limite) {
			throw new PilhaCheiaException("A pilha está cheia");
		}
		this.info[tamanho] = info;
		tamanho++;
	}

	@Override
	public T pop() throws PilhaVaziaException {

		if (estaVazia()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}

		T valor = peek(); // obtem o topo da pilha e guarda

		info[tamanho - 1] = null; // limpa a posição
		tamanho--; // decrementa o tamanho no caso tirando o numero

		return valor; // retorna o novo topo da pilha
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() throws PilhaCheiaException {
		if (estaVazia()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}

		return (T) info[tamanho - 1];
	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	@Override
	public void liberar() {
		// info = new Object[limite]; essa aqui ta certo mas da mais trabalho para o
		// coletor de lixo
		// tamanho = 0;

		try {
			while (true) {
				pop(); // o pop chama o estavazia; numa pilha de 3 elementos, chamaria o metodo
						// estavazia 4 vezes pq a ultima vez cai na exceção
			}
		} catch (PilhaVaziaException e) {

		}
	}

	public String toString() {
		String resultado = "";
		for (int i = tamanho - 1; i >= 0; i--) { // começa no topo
			resultado = info[i].toString();
			if (i > 0) { // so incrementa se n for o ultimo elemento q no caso é o indice 0
				resultado = resultado + " , ";
			}
		}
		return resultado;

	}

	public void concatenar(PilhaVetor<T> p) throws PilhaCheiaException {

		if (tamanho + p.tamanho > limite) {
			throw new PilhaCheiaException("A pilha está cheia");
		}

		PilhaVetor<T> pilhaP = new PilhaVetor<>(limite - tamanho);

		while (!p.estaVazia()) {
			pilhaP.push(p.pop());
		}

		while (!pilhaP.estaVazia()) {
			this.push(pilhaP.pop());
		}
	}
}
