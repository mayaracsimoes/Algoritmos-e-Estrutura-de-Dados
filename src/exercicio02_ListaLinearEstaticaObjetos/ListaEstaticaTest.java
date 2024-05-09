/**
 * 
 */
package exercicio02_ListaLinearEstaticaObjetos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class ListaEstaticaTest {

	private ListaEstatica lista;

	@BeforeEach
	public void setup() {
		lista = new ListaEstatica();
	}

	@Test
	public void testInclusaoDeDados() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		System.out.println(lista.toString());
		assertEquals("5, 10, 15, 20", lista.toString());
	}

	@Test
	public void testObtencaoTamanho() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		assertEquals(4, lista.getTamanho());
	}

	@Test
	public void testBuscarElementoExistente() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		assertEquals(2, lista.buscar(15));
	}

	@Test
	public void testBuscarElementoInexistente() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		assertEquals(-1, lista.buscar(30));
	}

	@Test
	public void testRetirarElemento() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.retirar(10);
		assertEquals("5, 15, 20", lista.toString());
		assertEquals(3, lista.getTamanho());
	}

	@Test
	public void testRedimensionamento() {
		for (int i = 1; i <= 15; i++) {
			lista.inserir(i);
		}
		assertEquals("1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15", lista.toString());
		assertEquals(15, lista.getTamanho());
	}

	@Test
	public void testObterElemento() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		assertEquals(20, lista.obterElemento(3));
	}

	@Test
	public void testLancamentoDeExcecaoObterElemento() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		assertThrows(IndexOutOfBoundsException.class, () -> lista.obterElemento(5));
	}

	@Test
	public void testLiberarRemoveTodosElementos() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.liberar();
		assertTrue(lista.estaVazia());
	}
	
	@Test
	public void testInverterOrdemCrescente() {
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.inverter();
		assertEquals("20, 15, 10, 5", lista.toString());
	}
	
	@Test
	public void testInverterOrdemDecrescente() {
		lista.inserir(25);
		lista.inserir(20);
		lista.inserir(15);
		lista.inserir(10);
		lista.inserir(5);
		lista.inverter();
		assertEquals("5, 10, 15, 20, 25", lista.toString());
	}
}
