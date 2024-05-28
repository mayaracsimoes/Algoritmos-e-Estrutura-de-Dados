package exercicio10_ordenacao;

public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        int i;
        int j;
        T[] meuInfo = getInfo();
        int n = meuInfo.length; // n = size(info)

        for (i = n - 1; i >= 1; i--) {
            for (j = 0; j <= 1; j++) {
                if (meuInfo[j].compareTo(meuInfo[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }

}
