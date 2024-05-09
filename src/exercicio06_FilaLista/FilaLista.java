package exercicio06_FilaLista;

import exercicio03_ListaEncadeada.ListaEncadeada;

public class FilaLista<T> implements Fila<T> {

	private ListaEncadeada<T> lista;

	public FilaLista() {
		this.lista = new ListaEncadeada<>();
	}

	@Override
	public void inserir(T valor) {
		lista.inserirNoFinal(valor);
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new FilaVaziaException("A fila está vazia.");
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public T retirar() {
		T valor = peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<>();
	}

	@Override
	public String toString() {
		return lista.toString();
	}
	
	
	public static void main(String[] args) {
        FilaLista<Integer> fila = new FilaLista<>();

        // Adicionando elementos à fila
        fila.inserir(10);
        fila.inserir(20);
        fila.inserir(30);

        // Imprimindo a fila
        System.out.println("Conteúdo da fila: " + fila);

        // Verificando se a fila está vazia
        System.out.println("A fila está vazia? " + fila.estaVazia());

        // Obtendo o primeiro elemento sem removê-lo
        System.out.println("Primeiro elemento da fila: " + fila.peek());

        // Removendo e imprimindo elementos da fila
        System.out.println("Removendo elemento da fila: " + fila.retirar());
        System.out.println("Conteúdo da fila após a remoção: " + fila);

        // Liberando a fila
        fila.liberar();

        // Verificando se a fila está vazia após liberá-la
        System.out.println("A fila está vazia após liberá-la? " + fila.estaVazia());
    }

}