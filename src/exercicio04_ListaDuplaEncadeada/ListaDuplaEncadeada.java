package exercicio04_ListaDuplaEncadeada;

public class ListaDuplaEncadeada<T> {

	private NoListaDupla<T> primeiro;

	public ListaDuplaEncadeada() {
		this.primeiro = null;
	}

	public NoListaDupla<T> getPrimeiro() {
		return this.primeiro;
	}

	public void inserir(T dado) {
		NoListaDupla<T> novoNo = new NoListaDupla<T>(dado);
		novoNo.proximo = this.primeiro;
		if (this.primeiro != null) {
			this.primeiro.anterior = novoNo;
		}
		this.primeiro = novoNo;
	}

	public NoListaDupla<T> buscar(T valor) {
		NoListaDupla<T> atual = this.primeiro;
		while (atual != null) {
            if (atual.getDado().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
	}

	public void retirar(T valor) {
		NoListaDupla<T> alvo = buscar(valor);
		if (alvo != null) {
			if (alvo.anterior != null) {
				alvo.anterior.proximo = alvo.proximo;
			} else {
				this.primeiro = alvo.proximo;
			}
			if (alvo.proximo != null) {
				alvo.proximo.anterior = alvo.anterior;
			}
		}
	}

	public void exibirOrdemInversa() {
		NoListaDupla<T> atual = this.primeiro;
		NoListaDupla<T> ultimo = null;
		while (atual != null) {
			ultimo = atual;
			atual = atual.proximo;
		}
		while (ultimo != null) {
			System.out.println(ultimo.dado);
			ultimo = ultimo.anterior;
		}
	}

	public void liberar() {
		NoListaDupla<T> atual = this.primeiro;
		while (atual != null) {
			NoListaDupla<T> proximo = atual.proximo;
			atual.anterior = null;
			atual.proximo = null;
			atual = proximo;
		}
		this.primeiro = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		NoListaDupla<T> atual = this.primeiro;
		while (atual != null) {
			builder.append(atual.dado);
			if (atual.proximo != null) {
				builder.append(", ");
			}
			atual = atual.proximo;
		}
		return builder.toString();
	}
}
/*public void ordenarCrescente() {
        for (int i = 1; i < tamanho; i++) {
            int chave = info[i];
            int j = i - 1;
            while (j >= 0 && info[j] > chave) {
                info[j + 1] = info[j];
                j = j - 1;
            }
            info[j + 1] = chave;
        }
    }*/