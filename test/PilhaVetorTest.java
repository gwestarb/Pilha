
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ltedesco
 */
public class PilhaVetorTest {

    @Test // caso 1
    public void testPilhaVazia() {
        PilhaVetor pilha = new PilhaVetor(10);

        assertEquals(true, pilha.estaVazia());
    }

    @Test // caso 2
    public void testPilhaNaoVazia() {
        PilhaVetor pilha = new PilhaVetor(5);
        pilha.push(10);

        assertEquals(false, pilha.estaVazia());
    }

    @Test // caso 3
    public void testPilhaEmpilhadarDesempilar() {
        PilhaVetor pilha = new PilhaVetor(10);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.pop());
        assertEquals(20, pilha.pop());
        assertEquals(10, pilha.pop());
        assertEquals(true, pilha.estaVazia());
    }

    @Test  // caso 4
    public void testPilhaCheiaException() {
        PilhaVetor pilha = new PilhaVetor(3);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        try {
            pilha.push(40);
        } catch (PilhaCheiaException e) {
        }
    }

    @Test // caso 5
    public void testPilhaVaziaException() {
        PilhaVetor pilha = new PilhaVetor(10);

        try {
            pilha.pop();
        } catch (PilhaVaziaException e) {
        }
    }

    @Test // caso 6
    public void testPeek() {
        PilhaVetor pilha = new PilhaVetor(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);

        assertEquals(30, pilha.peek());
        assertEquals(30, pilha.pop());
    }

    @Test // caso 7
    public void testLiberar() {
        PilhaVetor pilha = new PilhaVetor(5);
        pilha.push(10);
        pilha.push(20);
        pilha.push(30);
        pilha.liberar();

        assertEquals(true, pilha.estaVazia());
    }

    @Test // caso 8
    public void testConcatenar() {
        PilhaVetor pilha1 = new PilhaVetor(10);
        pilha1.push(10);
        pilha1.push(20);
        pilha1.push(30);
        
        PilhaVetor pilha2 = new PilhaVetor(2);
        pilha2.push(40);
        pilha2.push(50);

        pilha1.concatenar(pilha2);
        assertEquals("50,40,30,20,10", pilha1.toString());

    }

}
