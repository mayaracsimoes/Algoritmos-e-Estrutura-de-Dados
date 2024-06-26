package exercicio10_ordenacao;

public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {
    @Override
    public void ordenar() {
        quickSort(0, getInfo().length - 1);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int indicePivo = particionar(inicio, fim);
            quickSort(inicio, indicePivo - 1);
            quickSort(indicePivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        int a = inicio;
        int b = fim + 1;
        T[] info = getInfo();
        T pivo = info[inicio];
        while (true) {
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) <= 0); // info[a]< pivo

            do {
                b++;
            } while (b >= inicio && info[b].compareTo(pivo) > 0); // pivo > info[b]
            if (a >= b) {
                break;
            }
            trocar(a, b);
        }
        trocar(b, inicio);
        return b;
    }
}
