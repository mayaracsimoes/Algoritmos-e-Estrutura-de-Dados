package exercicio03_ListaEncadeada;

public class ListaEncadeada<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;

	public ListaEncadeada() {
		this.primeiro = null;
		this.ultimo = null;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	public void inserir(T info) {
		NoLista<T> novoNo = new NoLista<>(info);
		novoNo.setInfo(info);
		novoNo.setProximo(primeiro);
		primeiro = novoNo;

		if (estaVazia()) {
			ultimo = novoNo;
		}
	}

	public boolean estaVazia() {
		return this.primeiro == null;
	}

	public NoLista<T> buscar(T info) {
		NoLista<T> atual = primeiro;
		while (atual != null) {
			if (atual.getInfo().equals(info)) {
				return atual;
			}
			atual = atual.getProximo();
		}
		return null;
	}

	public void retirar(T info) {
		NoLista<T> anterior = null;
		NoLista<T> atual = primeiro;

		while ((atual != null) && (!atual.getInfo().equals(info))) {
			anterior = atual;
			atual = atual.getProximo();
		}

		if (atual != null) {
			if (atual == primeiro)
				primeiro = primeiro.getProximo();
			else
				anterior.setProximo(atual.getProximo());
		}
		if (atual != null) {
			if (anterior == null)
				this.primeiro = atual.getProximo();
			else
				anterior.setProximo(atual.getProximo());
			if (atual == ultimo) {
				ultimo = anterior;
			}
		}
	}

	public int obterComprimento() {
		int comprimento = 0;
		NoLista<T> atual = primeiro;
		while (atual != null) {
			comprimento++;
			atual = atual.getProximo();
		}
		return comprimento;
	}

	public NoLista<T> obterNo(int posicao) {
		if (posicao < 0) {
			throw new IndexOutOfBoundsException("Posição inválida");
		}

		NoLista<T> atual = primeiro;
		while ((atual != null) && (posicao > 0)) {
			posicao--;
			atual = atual.getProximo();
		}

		if (atual == null) {
			throw new IndexOutOfBoundsException("Posição inválida");
		}

		return atual;
	}

	/* questao da prova */
	public void retirarTodos(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;

		while (p != null) {
			if (p.getInfo().equals(valor)) {
				if (p == primeiro)
					primeiro = primeiro.getProximo();
				else
					anterior.setProximo(p.getProximo());
			} else {
				anterior = p;
			}
			p = p.getProximo();
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		NoLista<T> atual = primeiro;
		while (atual != null) {
			builder.append(atual.getInfo());
			if (atual.getProximo() != null) {
				builder.append(", ");
			}
			atual = atual.getProximo();
		}
		return builder.toString();
	}

	public void inserirNoFinal(T valor) {
		NoLista<T> novoNo = new NoLista<>(valor);
		novoNo.setInfo(valor);
		novoNo.setProximo(null);
		if (estaVazia())
			primeiro = novoNo;
		else
			ultimo.setProximo(novoNo);
		ultimo = novoNo;
	}

}