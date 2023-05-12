package exercicioNo;

public interface ListaEncadeada<T> {
    void adicionar(T valor);
    No<T> remover(T valor);
    void imprimirLista();
}

