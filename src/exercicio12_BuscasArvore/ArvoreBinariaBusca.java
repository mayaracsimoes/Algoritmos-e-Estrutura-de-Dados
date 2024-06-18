package exercicio12_BuscasArvore;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    NoArvoreBinaria<T> raiz = super.getRaiz();

    public void inserir(T valor) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);
        if (raiz == null) {
            raiz = novo;
        } else {
            NoArvoreBinaria<T> p = raiz;
            NoArvoreBinaria<T> pai = p;
            while (true) {

                if (valor.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }
        }
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscarRecursivo(info, raiz);
    }

    private NoArvoreBinaria<T> buscarRecursivo(T info, NoArvoreBinaria<T> no) {
        if (no == null) {
            return null;
        }

        if (info.equals(no.getInfo())) {
            return no;
        } else if (info.compareTo(no.getInfo()) < 0) {
            return buscarRecursivo(info, no.getEsquerda());
        } else {
            return buscarRecursivo(info, no.getDireita());
        }
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // localiza o no a ser removido
        while ((p != null) && (!p.getInfo().equals(info))) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) { // se info < p.info
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) { // achou dado a ser removido?
            if ((p.getEsquerda() == null) && (p.getDireita() == null)) {
                // 1.o caso - Nó folha
                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda)
                        pai.setEsquerda(null);
                    else
                        pai.setDireita(null);
                }

            } else {
                if (p.getDireita() == null) {
                    // nó com apenas um filho a esquerda 2.o caso
                    if (p == getRaiz()) {
                        setRaiz(p.getEsquerda());
                    } else {
                        if (filhoEsquerda)
                            pai.setEsquerda(p.getEsquerda());
                        else
                            pai.setDireita(p.getEsquerda());
                    }
                } else {
                    if (p.getEsquerda() == null) {
                        // nó com apenas um flho a direita 2.o caso
                        if (p == getRaiz())
                            setRaiz(p.getDireita());
                        else {
                            if (filhoEsquerda)
                                pai.setEsquerda(p.getDireita());
                            else
                                pai.setDireita(p.getDireita());
                        }

                    } else {
                        // nó com filho a esquerda e a direita 3.o caso
                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);
                        if (p == getRaiz())
                            setRaiz(sucessor);
                        else {
                            if (filhoEsquerda)
                                pai.setEsquerda(sucessor);
                            else
                                pai.setDireita(sucessor);
                        }
                        sucessor.setEsquerda(p.getEsquerda());
                    }
                }
            }
        }
    }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if (sucessor != p.getDireita()) {
            paiSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }

}