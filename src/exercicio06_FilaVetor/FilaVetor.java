package exercicio06_FilaVetor;

public class FilaVetor<T> implements Fila<T> {
	private int tamanho;
	private int limite;
	private int inicio;
	private Object[] info;

	public FilaVetor(int limite) {
		this.tamanho = 0;
		this.limite = limite;
		this.inicio = 0;
		this.info = new Object[limite];
	}

	@Override
	public void inserir(T valor) {
		if (tamanho == limite) {
			throw new FilaCheiaException("A fila está cheia");
		}
		int posicaoInserir;
		posicaoInserir = (inicio + tamanho) % limite;
		this.info[posicaoInserir] = valor;
		tamanho++;

	}

	@Override
	public boolean estaVazia() {
		return tamanho == 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (estaVazia()) {
			throw new FilaVaziaException("A fila está vazia");
		}
		/* retorna o primeiro dado da fila */
		return (T) info[inicio];
	}

	@Override
	public T retirar() {
		T valorRetirado = peek();
		info[inicio] = null;

		inicio = (inicio + 1) % limite;
		tamanho--;
		return valorRetirado;
	}

	@Override
	public void liberar() {
		info = new Object[limite];
		tamanho = 0;
	}

	public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2) {
		FilaVetor<T> f3 = new FilaVetor<>(this.limite + f2.limite);
		int indice = this.inicio;
		for (int i = 0; i < this.tamanho; i++) {
			f3.inserir((T) this.info[i]);
			indice = (inicio + 1) % this.limite;
		}

		indice = f2.inicio;
		for (int i = 0; i < f2.tamanho; i++) {
			f3.inserir((T) f2.info[i]);
			indice = (inicio + 1) % this.limite;
		}
		return f3;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		int count = 0;
		int index = inicio;
		while (count < tamanho) {
			sb.append(info[index]);
			if (count < tamanho - 1) {
				sb.append(", ");
			}
			index = (index + 1) % limite;
			count++;
		}

		sb.append("]");
		return sb.toString();
	}

	public int getLimite() {
		return limite;
	}

	public void encolher() {
		if (tamanho < limite) {
			Object[] novaLista = new Object[tamanho];
			for (int i = 0; i < tamanho; i++) {
				novaLista[i] = info[(inicio + i) % limite];
			}
			info = novaLista;
			limite = tamanho;
			inicio = 0;
		}
	}

	public static void main(String[] args) {

		FilaVetor<String> fila = new FilaVetor(10);

		// Adicionando elementos à fila
		fila.inserir("Ab");
		fila.retirar();
		fila.inserir("A");
		fila.inserir("B");
		fila.inserir("C");
		fila.inserir("D");

		// Imprimindo a fila
		System.out.println("Conteúdo da fila: " + fila);

		// Verificando se a fila está vazia
		System.out.println("A fila está vazia? " + fila.estaVazia());

		System.out.println("Inicio da fila: " + fila.inicio);

		System.out.println("Limite da fila: " + fila.limite);

		System.out.println("Tamanho da fila: " + fila.tamanho);

		fila.encolher();
		System.out.println("---------------------------------------------");
		// Imprimindo a fila
		System.out.println("Conteúdo da fila: " + fila);

		// Verificando se a fila está vazia
		System.out.println("A fila está vazia? " + fila.estaVazia());

		System.out.println("Inicio da fila: " + fila.inicio);

		System.out.println("Limite da fila: " + fila.limite);

		System.out.println("Tamanho da fila: " + fila.tamanho);
	}

}
