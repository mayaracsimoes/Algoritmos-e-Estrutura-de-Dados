package exercicio07_ArvoreBinaria;

public class ArvoreBinaria<T> {
	private NoArvoreBinaria<T> raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public NoArvoreBinaria<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(NoArvoreBinaria<T> raiz) {
		this.raiz = raiz;
	}

	public boolean estaVazia() {
		return this.raiz == null;
	}

	public boolean pertence(T info) {
		return pertence(this.raiz, info);
	}

	// verifica se a raiz é null, se for, nem procura pelo valor passado.
	// depois segue a sequencia: procura na raiz, depois na esquerda e depois na
	// direita da arvore
	private boolean pertence(NoArvoreBinaria<T> no, T info) {
		if (no == null) {
			return false;
		}
		if (no.getInfo().equals(info)) {
			return true;
		}
		return pertence(no.getEsquerda(), info) || pertence(no.getDireita(), info);
	}

	public String toString() {
		return arvorePre(this.raiz);
	}

	private String arvorePre(NoArvoreBinaria<T> no) {
		if (no == null) {
			return "<>";
		}
		return no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
	}

	public int contarNos() {
		return contarNos(this.raiz);
	}

	private int contarNos(NoArvoreBinaria<T> no) {
		if (no == null) {
			return 0;
		}
		return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
	}

	public static boolean isDegenerada(NoArvoreBinaria raiz) {
		if (raiz == null) {
			return true;
		}

		if (raiz.getEsquerda() != null && raiz.getDireita() != null) {
			return false;
		}

		return isDegenerada(raiz.getEsquerda()) && isDegenerada(raiz.getDireita());
	}

	// public int contarNosInternos(NoArvoreBinaria<T> sa)
	// Este método deverá contar a quantidade de nós internos que existem numa
	// árvore cuja raiz seja sa.

	public int contarNosInternos(NoArvoreBinaria<T> sa) {

		if (sa.getInfo() != null|| sa.getEsquerda() != null || sa.getDireita() != null) {
			return 1 + contarNosInternos(sa.getEsquerda()) + contarNosInternos(sa.getDireita());
		}
		return 0;
	}

	public static void main(String[] args) {
NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<Integer>(9,null,null);
NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<Integer>(10);
NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<Integer>(10,no2,null);
ArvoreBinaria<Integer> arvore =new ArvoreBinaria<>();
no1.setEsquerda(no2);
arvore.setRaiz(no1);

System.out.println("qtd de nos: "+ arvore.contarNos());
	}
}