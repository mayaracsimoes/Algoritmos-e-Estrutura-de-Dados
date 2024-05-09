package exemplo_ListaLinearGenerica;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		ListaEstaticaGenerica<String> nomes = new ListaEstaticaGenerica<>();
		nomes.inserir("May");
		nomes.inserir("Maria");
		nomes.inserir("Brenda");
		
		//int posicao = nomes.buscar("Brenda");
		//System.out.println(posicao);
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome a procurar:");
		String nomeProcurar = teclado.nextLine();
		int posicao = nomes.buscar(nomeProcurar);
		System.out.println(posicao);
	}
	

}
