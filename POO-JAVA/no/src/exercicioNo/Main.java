package exercicioNo;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<Integer> listaSimples = new ListaEncadeadaSimples<>();
        ListaEncadeada<String> listaCircular = new ListaEncadeadaCircular<>();

        // Adiciona itens à lista simples
        listaSimples.adicionar(10);
        listaSimples.adicionar(20);
        listaSimples.adicionar(30);


        listaSimples.imprimirLista();


        No<Integer> noRemovido = listaSimples.remover(20);
        if (noRemovido != null) {
            System.out.println("Item removido da lista simples: " + noRemovido.getValor());
        }

        listaSimples.imprimirLista();


        listaCircular.adicionar("A");
        listaCircular.adicionar("B");
        listaCircular.adicionar("C");


        listaCircular.imprimirLista();


        No<String> noRemovidoCircular = listaCircular.remover("B");
        if (noRemovido != null) {
            System.out.println("Item removido da lista circular: " + noRemovidoCircular.getValor());
        }

        listaCircular.imprimirLista();
    }
}
