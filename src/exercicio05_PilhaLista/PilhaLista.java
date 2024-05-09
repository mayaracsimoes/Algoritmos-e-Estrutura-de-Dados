package exercicio05_PilhaLista;

import exercicio05_PilhaVetor.PilhaCheiaException;

public class PilhaLista<T> implements Pilha<T> {
	private ListaEncadeada<T> lista = new ListaEncadeada<>();

	@Override
	public void push(T info) throws PilhaCheiaException {
		lista.inserir(info);
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			throw new PilhaVaziaException("A pilha está vazia");
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public T pop() throws PilhaVaziaException {
		T valor = peek();
		lista.retirar(valor);
		return valor;
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista = new ListaEncadeada<>();

	}

	@Override
	public String toString() {
		return lista.toString();
	}
}
