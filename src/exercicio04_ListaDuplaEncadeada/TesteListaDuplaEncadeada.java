package exercicio04_ListaDuplaEncadeada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TesteListaDuplaEncadeada {

	@Test
	public void testInserir() {
		ListaDuplaEncadeada<Integer> lista = new ListaDuplaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		StringBuilder expectedForward = new StringBuilder();
		expectedForward.append("20, 15, 10, 5");
		assertEquals(expectedForward.toString(), lista.toString());

		StringBuilder expectedBackward = new StringBuilder();
		expectedBackward.append("5, 10, 15, 20");

		NoListaDupla<Integer> ultimo = lista.getPrimeiro();
		while (ultimo.proximo != null) {
			ultimo = ultimo.proximo;
		}

		StringBuilder actualBackward = new StringBuilder();
		actualBackward.append(ultimo.dado);
		while (ultimo.anterior != null) {
			ultimo = ultimo.anterior;
			actualBackward.append(", ").append(ultimo.dado);
		}

		assertEquals(expectedBackward.toString(), actualBackward.toString());
	}

	@Test
	public void testBuscar() {
		ListaDuplaEncadeada<Integer> lista = new ListaDuplaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		assertEquals(20, (int) lista.buscar(20).dado);
		assertEquals(10, (int) lista.buscar(10).dado);
		assertNull(lista.buscar(25));
	}

	@Test
	public void testRetirarInicio() {
		ListaDuplaEncadeada<Integer> lista = new ListaDuplaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.retirar(20);

		StringBuilder expectedForward = new StringBuilder();
		expectedForward.append("15, 10, 5");
		assertEquals(expectedForward.toString(), lista.toString());

		StringBuilder expectedBackward = new StringBuilder();
		expectedBackward.append("5, 10, 15");

		NoListaDupla<Integer> ultimo = lista.getPrimeiro();
		while (ultimo.proximo != null) {
			ultimo = ultimo.proximo;
		}

		StringBuilder actualBackward = new StringBuilder();
		actualBackward.append(ultimo.dado);
		while (ultimo.anterior != null) {
			ultimo = ultimo.anterior;
			actualBackward.append(", ").append(ultimo.dado);
		}

		assertEquals(expectedBackward.toString(), actualBackward.toString());
	}

	@Test
	public void testRetirarMeio() {
		ListaDuplaEncadeada<Integer> lista = new ListaDuplaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.retirar(10);

		StringBuilder expectedForward = new StringBuilder();
		expectedForward.append("20, 15, 5");
		assertEquals(expectedForward.toString(), lista.toString());

		StringBuilder expectedBackward = new StringBuilder();
		expectedBackward.append("5, 15, 20");

		NoListaDupla<Integer> ultimo = lista.getPrimeiro();
		while (ultimo.proximo != null) {
			ultimo = ultimo.proximo;
		}

		StringBuilder actualBackward = new StringBuilder();
		actualBackward.append(ultimo.dado);
		while (ultimo.anterior != null) {
			ultimo = ultimo.anterior;
			actualBackward.append(", ").append(ultimo.dado);
		}

		assertEquals(expectedBackward.toString(), actualBackward.toString());
	}

	@Test
	public void testRetirarFim() {
		ListaDuplaEncadeada<Integer> lista = new ListaDuplaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.retirar(5);

		StringBuilder expectedForward = new StringBuilder();
		expectedForward.append("20, 15, 10");
		assertEquals(expectedForward.toString(), lista.toString());

		StringBuilder expectedBackward = new StringBuilder();
		expectedBackward.append("10, 15, 20");

		NoListaDupla<Integer> ultimo = lista.getPrimeiro();
		while (ultimo.proximo != null) {
			ultimo = ultimo.proximo;
		}

		StringBuilder actualBackward = new StringBuilder();
		actualBackward.append(ultimo.dado);
		while (ultimo.anterior != null) {
			ultimo = ultimo.anterior;
			actualBackward.append(", ").append(ultimo.dado);
		}

		assertEquals(expectedBackward.toString(), actualBackward.toString());
	}

	@Test
	public void testLiberar() {
		ListaDuplaEncadeada<Integer> lista = new ListaDuplaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);

		lista.liberar();

		NoListaDupla<Integer> no = lista.getPrimeiro();
		while (no != null) {
			assertNull(no.anterior);
			assertNull(no.proximo);
			no = no.proximo;
		}
	}
}
