package exercicio04_ListaDuplaEncadeada;

public class NoListaDupla<T> {
    T dado;
    NoListaDupla<T> proximo;
    NoListaDupla<T> anterior;
    
    public NoListaDupla(T dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public NoListaDupla<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoListaDupla<T> proximo) {
		this.proximo = proximo;
	}

	public NoListaDupla<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NoListaDupla<T> anterior) {
		this.anterior = anterior;
	}
}
