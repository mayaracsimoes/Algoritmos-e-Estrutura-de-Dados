package exercicio07_ArvoreBinaria;

class NoArvoreBinaria<T> {
    private T info;
    private NoArvoreBinaria<T> esquerda;
    private NoArvoreBinaria<T> direita;

    // usado para criar uma folha
    public NoArvoreBinaria(T info) {
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esquerda, NoArvoreBinaria<T> direita) {
        this.info = info;
        this.esquerda = esquerda;
        this.direita = direita;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public T getInfo() {
        return info;
    }

    public NoArvoreBinaria<T> getEsquerda() {
        return esquerda;
    }

    public NoArvoreBinaria<T> getDireita() {
        return direita;
    }

    public void setEsquerda(NoArvoreBinaria<T> esquerda) {
        this.esquerda = esquerda;
    }

    public void setDireita(NoArvoreBinaria<T> direita) {
        this.direita = direita;
    }
}