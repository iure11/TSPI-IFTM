package exercicioNo;

public class ListaEncadeadaSimples<T> implements ListaEncadeada<T> {
    private No<T> inicio;

    public ListaEncadeadaSimples() {
        this.inicio = null;
    }

    @Override
    public void adicionar(T valor) {
        No<T> novoNo = new No<>(valor);
        if (inicio == null) {
            inicio = novoNo;
        } else {
            No<T> atual = inicio;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(novoNo);
        }
    }

    @Override
    public No<T> remover(T valor) {
        No<T> noRemovido = null;
        if (inicio != null) {
            if (inicio.getValor().equals(valor)) {
                noRemovido = inicio;
                inicio = inicio.getProximo();
            } else {
                No<T> atual = inicio;
                while (atual.getProximo() != null && !atual.getProximo().getValor().equals(valor)) {
                    atual = atual.getProximo();
                }
                if (atual.getProximo() != null) {
                    noRemovido = atual.getProximo();
                    atual.setProximo(noRemovido.getProximo());
                }
            }
        }
        return noRemovido;
    }

    @Override
    public void imprimirLista() {
        No<T> atual = inicio;
        while (atual != null) {
            System.out.print(atual.getValor() + " ");
            atual = atual.getProximo();
        }
        System.out.println();
    }
}
