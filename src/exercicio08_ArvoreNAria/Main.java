package exercicio08_ArvoreNAria;

public class Main {
    public static void main(String[] args) {
        // Caso 1: Validar representação textual da árvore
        /*
         *          1
        2           3           4
    5   6   7       8       9       10
        11 */
        NoArvore<Integer> no11 = new NoArvore<>(11);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        no6.inserirFilho(no11);
        no2.inserirFilho(no7);
        no2.inserirFilho(no6);
        no2.inserirFilho(no5);
    
        
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        no3.inserirFilho(no8);

        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        no4.inserirFilho(no10);
        no4.inserirFilho(no9);

        NoArvore<Integer> no1 = new NoArvore<>(1);
        no1.inserirFilho(no4);
        no1.inserirFilho(no3);
        no1.inserirFilho(no2);

        Arvore<Integer> arvore1 = new Arvore<>();
        arvore1.setRaiz(no1);
       
    

        System.out.println("Caso 1:");
        System.out.println("Representação textual da árvore:");
        System.out.println(arvore1.toString());
        System.out.println();

        // Caso 2: Validar método pertence()
        Arvore<Integer> arvore2 = arvore1; // Árvore igual à criada no caso 1
        System.out.println("Caso 2:");
        System.out.println("Método pertence() - Pesquisando por nó com valor igual a 7:");
        System.out.println("Resultado: " + arvore2.pertence(7)); // Deve retornar true
        System.out.println();

        // Caso 3: Validar método pertence() para dado que não consta na árvore
        Arvore<Integer> arvore3 = arvore1; // Árvore igual à criada no caso 1
        System.out.println("Caso 3:");
        System.out.println("Método pertence() - Pesquisando por nó com valor igual a 55:");
        System.out.println("Resultado: " + arvore3.pertence(55)); // Deve retornar false
        System.out.println();

        // Caso 4: Validar método contarNos()
        Arvore<Integer> arvore4 = arvore1; // Árvore igual à criada no caso 1
        System.out.println("Caso 4:");
        System.out.println("Método contarNos():");
        System.out.println("Quantidade de nós na árvore: " + arvore4.contarNos()); // Deve resultar em 10
    }
}
