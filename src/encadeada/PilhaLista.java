package encadeada;


/**
 *
 * @author gwestarb
 */
public class PilhaLista<T> implements Pilha<T> {

    private ListaEncadeada<T> lista = new ListaEncadeada<T>();

    @Override
    public void push(T valor) {
        lista.inserir(valor);
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new PilhaVaziaException();
        }
        return lista.getPrimeiro().getInfo();
    }

    @Override //pior caso - constante
    public T pop() {
        T valor = this.peek();
        lista.retirar(valor);
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return lista.estaVazia();
    }

    @Override
    public void liberar() {
        while (!estaVazia()) {
            pop();
        }
    }

    public String toString() {
        return lista.toString();
    }

}
