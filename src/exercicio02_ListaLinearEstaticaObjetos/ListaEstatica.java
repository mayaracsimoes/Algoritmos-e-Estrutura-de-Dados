package exercicio02_ListaLinearEstaticaObjetos;

public class ListaEstatica<T> {
	/*
	 * tamanho = espaço ocupado com dados em um vetor. Exemplo: Vetor de 10 posições
	 * com apenas 5 ocupadas, o tamanho retorna o valor 5
	 */
	private Object[] info;
	private int tamanho;

	public ListaEstatica() {
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

	public void inserir(T valor) {
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

	public int buscar(T valor) {
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

	public void retirar(T valor) {
		// busca a posicao onde será removido o valor
		int posicao = buscar(valor);
		if (posicao != -1) {
			if (posicao == tamanho - 1)
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

	@SuppressWarnings("unchecked")
	public T obterElemento(int posicao) {
		// se a posição informada for menor q 0 ou maior do que há de valor preenchido,
		// retorna excessão
		if (posicao < 0 || posicao >= tamanho) {
			throw new IndexOutOfBoundsException();
		}
		return ((T) info[posicao]);
	}

	public boolean estaVazia() {
		return tamanho == 0;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void inverter() {
		// o tamanho/2 é pq nao tem necessidade de ir ate o final da lista, indo ate a
		// metade eu ja faço a mudança de todos os valores da lista

		// exemplo lista com tamanho 4, eu vou percorrer até o tamanho 2
		for (int i = 0; i < tamanho / 2; i++) {
			// Troca os elementos nas posições i e tamanho - 1 - i
			Object temp = info[i]; // valor do indice 0
			info[i] = info[tamanho - 1 - i]; // indice 0 vai receber o valor do indice 3
			info[tamanho - 1 - i] = temp; // indice 3 recebe o valor do indice 0
		}

	}

	public void retirarElementos(int inicio, int fim) {
	    if ((inicio >= 0) && (fim >= 0) && (inicio <= fim) && (fim < tamanho)) {
	        int elementosRemovidos = fim - inicio + 1;

	        // Move os elementos restantes para preencher os espaços dos elementos removidos
	        for (int i = inicio; i + elementosRemovidos < tamanho; i++) {
	            info[i] = info[i + elementosRemovidos];
	        }

	        // Define como nulo os espaços que foram deslocados
	        for (int i = tamanho - elementosRemovidos; i < tamanho; i++) {
	            info[i] = null;
	        }

	        // Atualiza o tamanho da lista
	        tamanho -= elementosRemovidos;
	    }
	}
	
	/* resposta do prof 
	 * 
	 * public void retirarElementos(int inicio, int fim){

        int destino = inicio;
        for(int i=fim+1; i<=getTamanho(); i++){
            info[destino] = info[i];
            destino++;
        }

        for(int i=0; i<=(fim-inicio); i++){
            info[tamanho-i] = null;
        }

        tamanho = tamanho - (fim-inicio+1);
    }
	 */


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

	public static void main(String[] args) {
		ListaEstatica<Integer> lista = new ListaEstatica<>();
		lista.inserir(10);
		lista.inserir(20);
		lista.inserir(30);
		lista.inserir(40);
		lista.inserir(50);
		lista.inserir(60);
		lista.retirarElementos(1, 4);

		System.out.println(lista);
		System.out.println(lista.tamanho);
	}

}
