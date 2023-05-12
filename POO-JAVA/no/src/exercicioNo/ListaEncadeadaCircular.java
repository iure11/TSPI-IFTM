package exercicioNo;

public class ListaEncadeadaCircular<T> implements ListaEncadeada<T> {
    private No<T> inicio;

    public ListaEncadeadaCircular() {
        this.inicio = null;
    }

    @Override
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);
        if (inicio == null) {
            inicio = novoNo;
            inicio.setProximo(inicio);
        } else {
            No<T> atual = inicio;
            while (atual.getProximo() != inicio) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
            novoNo.setProximo(inicio);
        }
    }

    @Override
    public No<T> remover(T valor) {
        No<T> noRemovido = null;
        if (inicio != null) {
            if (inicio.getValor().equals(valor)) {
                noRemovido = inicio;
                No<T> atual = inicio;
                while (atual.getProximo() != inicio) {
                    atual = atual.getProximo();
                }
                atual.setProximo(inicio.getProximo());
                inicio = inicio.getProximo();
            } else {
                No<T> atual = inicio;
                while (atual.getProximo() != inicio && !atual.getProximo().getValor().equals(valor)) {
                    atual = atual.getProximo();
                }
                if (atual.getProximo() != inicio) {
                    noRemovido = atual.getProximo();
                    atual.setProximo(noRemovido.getProximo());
                }
            }
        }
        return noRemovido;
    }

    @Override
    public void imprimirLista() {
        if (inicio == null) {
            System.out.println("Lista vazia");
            return;
        }
        No<T> atual = inicio;
        do {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        } while (atual != inicio);
        System.out.println();
    }
}
