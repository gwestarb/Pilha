package encadeada;


/**
 *
 * @author gwestarb
 */
public class ListaEncadeada<T> extends NoLista<T> {

    private NoLista<T> primeiro;

    public ListaEncadeada() {
        primeiro = null;
    }

    public NoLista<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T info) {
        NoLista<T> novo = new NoLista<>();
        novo.setInfo(info);
        novo.setProximo(primeiro);
        this.primeiro = novo;
    }

    public void exibir() {
        NoLista p = primeiro;
        while (p != null) {
            System.out.println(p.getInfo());
            p = p.getProximo();
        }
    }

    public boolean estaVazia() {
        return primeiro == null;
    }

    public NoLista<T> busca(T info) {
        NoLista<T> p = primeiro;
        while (p != null) {
            if (p.getInfo().equals(info)) {
                return p;
            }
            p = p.getProximo();
        }
        return null;
    }

    public void retirar(T info) {
        NoLista<T> anterior = null;
        NoLista<T> p = primeiro;

        while ((p != null) && (!p.getInfo().equals(info))) {
            anterior = p;
            p = p.getProximo();
        }

        if (p != null) {
            if (anterior == null) {
                this.primeiro = p.getProximo();
            } else {
                anterior.setProximo(p.getProximo());
            }
        }
    }

    public int obterComprimento() {
        NoLista<T> p = primeiro;
        int qtdeNos = 0;
        while (p != null) {
            qtdeNos++;
            p = p.getProximo();
        }
        return qtdeNos;
    }

    public NoLista<T> obterNo(int idx) {
        if (idx < 0) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> p = getPrimeiro();
        for (int i = 0; (p != null) && (i < idx); i++) {
            p = p.getProximo();

        }
        if (p == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return p;
        }
    }

    public String toString() {
        String conteudo = "";
        NoLista p = primeiro;
        while (p != null) {
            if (!p.equals(primeiro)) {
                conteudo += ",";
            }
            conteudo += p.getInfo();
            p = p.getProximo();
        }
        return conteudo;
    }
}
