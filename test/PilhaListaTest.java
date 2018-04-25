
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ltedesco
 */
public class PilhaListaTest {

    public PilhaLista pilha = new PilhaLista();

    @Test // caso 1
    public void testPilhaVazia() {
        assertEquals(true, pilha.estaVazia());
    }

    @Test // caso 2
    public void testPilhaNaoVazia() {
        pilha.push(10);

        assertEquals(false, pilha.estaVazia());
    }

    @Test // caso 3
    public void testPilhaEmpilhadarDesempilar() {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
        assertEquals(true, pilha.estaVazia());
    }

    @Test  // caso 4
    public void testPeek() {
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop());

    }

    @Test // caso 5
    public void testLiberar() {
        pilha.liberar();
        assertEquals(true, pilha.estaVazia());
    }

}
