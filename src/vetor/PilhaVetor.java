package vetor;


/**
 *
 * @author gwestarb
 */
public class PilhaVetor<T> implements Pilha<T> {

    private T[] info;
    private int limite;
    private int tamanho;

    public PilhaVetor(int limite) {
        info = (T[]) new Object[limite];
        this.limite = limite;
        tamanho = 0;
    }

    @Override
    public void push(T valor) {
        if (limite == tamanho) {
            throw new PilhaCheiaException();
        }
        info[tamanho] = valor;
        tamanho++;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new PilhaVaziaException();
        }
        return info[tamanho - 1];
    }

    @Override
    public T pop() {
        T valor = this.peek();
        info[tamanho - 1] = null;
        tamanho--;
        return valor;
    }

    @Override
    public boolean estaVazia() {
        return tamanho == 0;
    }

    @Override
    public void liberar() {
        // 1a. implementação - constante
        //info = (T[]) new Object[limite];
        // tamanho = 0;

        // 2a. implementação - linear
        //for (int i = 0; i < tamanho; i++) {
        //  info[i] = null;
        //}
        // tamanho = 0;
        
        //3a. implementação - linear
        while (!estaVazia()) {
            pop();
        }
        
        //4a. implementação - linear
        //try {
        //    while (true) {
        //        pop();
        //    }
        //} catch (PilhaVaziaException e) {
        //}
    }

    public String toString() {
        String resultado = "";
        for (int i = tamanho - 1; i >= 0; i--) {
            resultado += info[i];
            if (i > 0) {
                resultado = resultado + ",";
            }
        }
        return resultado;
    }

    public void concatenar(PilhaVetor<T> p) {
        for (int i = 0; i < p.tamanho; i++) {
            push(p.info[i]);
        }
        //PilhaVetor<T> aux = new PilhaVetor<T>(p.limite);
        //
        //while (!p.estaVazia()) {
        //    aux.push(p.peek());
        //    p.pop();
        //}
        //while (!aux.estaVazia()) {
        //    this.push(aux.peek());
        //aux.pop();
    }
}

