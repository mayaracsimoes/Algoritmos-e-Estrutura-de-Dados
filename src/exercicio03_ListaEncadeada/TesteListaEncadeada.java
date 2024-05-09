package exercicio03_ListaEncadeada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import exercicio05_PilhaLista.ListaEncadeada;
import exercicio05_PilhaLista.NoLista;

class TesteListaEncadeada {

	    @Test
	    public void testListaVazia() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        assertTrue(lista.estaVazia());
	    }

	    @Test
	    public void testListaNaoVazia() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        assertFalse(lista.estaVazia());
	    }

	    @Test
	    public void testInclusaoDeNumero() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        NoLista<Integer> primeiro = lista.getPrimeiro();
	        assertNotNull(primeiro);
	        assertEquals(5, (int) primeiro.getInfo());
	        assertNull(primeiro.getProximo());
	    }

	    @Test
	    public void testInclusaoDeTresNumeros() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        assertEquals(3, lista.obterComprimento());

	        NoLista<Integer> primeiro = lista.getPrimeiro();
	        assertNotNull(primeiro);
	        assertEquals(15, (int) primeiro.getInfo());

	        NoLista<Integer> segundo = primeiro.getProximo();
	        assertNotNull(segundo);
	        assertEquals(10, (int) segundo.getInfo());

	        NoLista<Integer> terceiro = segundo.getProximo();
	        assertNotNull(terceiro);
	        assertEquals(5, (int) terceiro.getInfo());
	        assertNull(terceiro.getProximo());
	    }

	    @Test
	    public void testBuscaNaPrimeiraPosicao() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        NoLista<Integer> encontrado = lista.buscar(20);
	        assertNotNull(encontrado);
	        assertEquals(20, (int) encontrado.getInfo());
	    }

	    @Test
	    public void testBuscaNoMeioDaLista() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        NoLista<Integer> encontrado = lista.buscar(15);
	        assertNotNull(encontrado);
	        assertEquals(15, (int) encontrado.getInfo());
	    }

	    @Test
	    public void testBuscaDadoInexistente() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        NoLista<Integer> encontrado = lista.buscar(50);
	        assertNull(encontrado);
	    }

	    @Test
	    public void testExclusaoDePrimeiroElemento() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        lista.retirar(20);
	        assertEquals(3, lista.obterComprimento());
	        assertNull(lista.buscar(20));
	    }

	    @Test
	    public void testExclusaoDeElementoDoMeioDaLista() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        lista.retirar(15);
	        assertEquals(3, lista.obterComprimento());
	        assertNull(lista.buscar(15));
	    }

	    @Test
	    public void testObterNoPosicaoZero() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        NoLista<Integer> no = lista.obterNo(0);
	        assertEquals(20, (int) no.getInfo());
	    }

	    @Test
	    public void testObterNoUltimaPosicao() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        NoLista<Integer> no = lista.obterNo(3);
	        assertEquals(5, (int) no.getInfo());
	    }

	    @Test
	    public void testObterNoPosicaoInvalida() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        
	        assertThrows(IndexOutOfBoundsException.class, () -> {
	            lista.obterNo(10);
	        });
	    }

	    @Test
	    public void testObterComprimentoListaVazia() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        assertEquals(0, lista.obterComprimento());
	    }

	    @Test
	    public void testObterComprimentoListaNaoVazia() {
	        ListaEncadeada<Integer> lista = new ListaEncadeada<>();
	        lista.inserir(5);
	        lista.inserir(10);
	        lista.inserir(15);
	        lista.inserir(20);
	        assertEquals(4, lista.obterComprimento());
	    }
	}