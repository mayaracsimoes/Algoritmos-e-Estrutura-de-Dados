package exercicio10_ordenacao;

public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        if (getInfo() != null && getInfo().length > 1) {
            mergeSort(0, getInfo().length - 1);
        }
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(left, mid);
            mergeSort(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        T[] info = getInfo();
        int tamEsquerda = mid - left + 1;
        T[] esquerda = (T[]) new Comparable[tamEsquerda];

        for (int i = 0; i <= tamEsquerda - 1; i++) {
            esquerda[i] = info[left + i];
        }

        int tamDireita = right - left;
        T[] direita = (T[]) new Comparable[tamDireita];

        for (int i = 0; i <= tamDireita - 1; i++) {
            direita[i] = info[mid + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;

        int i;
        for (i = left; i <= right; i++) {
            if ((cEsq < tamEsquerda) && (cDir < tamDireita)) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) { // se esquerda[cesq] < direita [cdir]
                    info[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }

            while (cEsq < tamEsquerda) {
                info[i] = esquerda[cEsq];
                cEsq++;
                i++;
            }
            while (cDir < tamDireita) {
                info[i] = direita[cDir];
                cDir++;
                i++;
            }
        }
    }
}
