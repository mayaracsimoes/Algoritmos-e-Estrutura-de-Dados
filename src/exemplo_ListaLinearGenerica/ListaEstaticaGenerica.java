package exemplo_ListaLinearGenerica;

public class ListaEstaticaGenerica<ClasseInformadaPeloProgramador> {
	/*
	 * tamanho = espaço ocupado com dados em um vetor. Exemplo: Vetor de 10 posições
	 * com apenas 5 ocupadas, o tamanho retorna o valor 5
	 */
	private Object[] info;
	private int tamanho;

	public ListaEstaticaGenerica() {
		info = new Object[10];
		tamanho = 0;
	}

	private void redimensionar() {

		// cria novo vetor para armazenar as informações, o novo vetor tem o tamanho do
		// vetor antigo + 10 posições
		Object[] novoInfo = new Object[info.length + 10];

		// para cada registro do vetor antigo, ele copia para o novo
		for (int i = 0; i < tamanho; i++) {
			novoInfo[i] = info[i];
		}

		// agora a variavel info recebe o novo vetor
		info = novoInfo;
	}

	public void inserir(ClasseInformadaPeloProgramador valor) {
		// antes de inserir ele verifica se tem espaço para armazenar, se não tiver ele
		// precisa redimensionar antes
		if (tamanho == info.length) {
			redimensionar();
		}

		// insere o valor no vetor
		info[tamanho] = valor;

		// incrementa a variavel
		tamanho++;

	}

	public void exibir() {
		// mostra todas as posições do vetor que possuem valor inserido
		for (int i = 0; i < tamanho; i++) {
			System.out.print(info[i]);
		}
	}

	public int buscar(ClasseInformadaPeloProgramador valor) {
		// percorre todas as posições do vetor que possuem valor para procurar o valor
		// passado por parametro
		for (int i = 0; i < tamanho; i++) {
			// se encontrou retorna a posição (indice)
			if (info[i].equals(valor)) { // == busca pelo endereço de memória, o equals compara os valores em si
				return i;
			}
		}
		// se o vetor tiver vazio retorna indice -1
		return -1;
	}

	public void retirar(ClasseInformadaPeloProgramador valor) {
		// busca a posicao onde será removido o valor
		int posicao = buscar(valor);
		if (posicao != -1) {
			if (posicao == tamanho -1)
				info[posicao] = null;
			else
				for (int i = posicao + 1; i < tamanho; i++) {
					info[i - 1] = info[i];
				}

			tamanho--;
		}
	}

	public void liberar() {
		// "limpa" o vetor, restaura a posição
		info = new Object[10];
		tamanho = 0;

	}

	public ClasseInformadaPeloProgramador obterElemento(int posicao) {
		// se a posição informada for menor q 0 ou maior do que há de valor preenchido,
		// retorna excessão
		if (posicao < 0 || posicao >= tamanho) {
			throw new IndexOutOfBoundsException();
		}
		return (ClasseInformadaPeloProgramador) info[posicao];
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < tamanho; i++) {
			sb.append(info[i]);
			if (i < tamanho - 1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
