package biblioteca;

public class Main {
    public static void main(String[] args) {
        // criando itens
        Livro livro1 = new Livro("O Hobbit", "J.R.R. Tolkien", true, 1937, 310, "Allen & Unwin");
        Livro livro2 = new Livro("Dom Casmurro", "Machado de Assis", true, 1899, 256, "Garnier");
        Livro livro3 = new Livro("1984", "George Orwell", true, 1949, 336, "Secker & Warburg");

        Revista revista1 = new Revista("Superinteressante", "Editora Abril", true, 100, "Abril");
        Revista revista2 = new Revista("Veja", "Editora Abril", true, 200, "Abril");
        Revista revista3 = new Revista("IstoÉ", "Editora Três", true, 300, "Três");

        DVD dvd1 = new DVD("O Poderoso Chefão", "Francis Ford Coppola", true, "Drama", 175);
        DVD dvd2 = new DVD("De Volta para o Futuro", "Robert Zemeckis", true, "Ficção científica", 116);
        DVD dvd3 = new DVD("Clube da Luta", "David Fincher", true, "Drama", 139);

        // criando usuários
        Usuario usuario1 = new Usuario("João", "joao@gmail.com", "Rua A, 123");
        Usuario usuario2 = new Usuario("Maria", "maria@gmail.com", "Rua B, 456");
        Usuario usuario3 = new Usuario("Pedro", "pedro@gmail.com", "Rua C, 789");

        // realizando empréstimos e devoluções
        usuario1.emprestarItem(livro1);
        usuario1.emprestarItem(revista1);
        usuario1.emprestarItem(dvd1);
        usuario1.devolverItem(livro1);
        usuario1.devolverItem(revista1);

        usuario2.emprestarItem(livro2);
        usuario2.emprestarItem(revista2);
        usuario2.emprestarItem(dvd2);
        usuario2.devolverItem(livro2);
        usuario2.devolverItem(dvd2);

        usuario3.emprestarItem(livro3);
        usuario3.emprestarItem(revista3);
        usuario3.emprestarItem(dvd3);
        usuario3.devolverItem(revista3);
        usuario3.devolverItem(dvd3);

        // exibindo os itens emprestados por cada usuário
        System.out.println("Itens emprestados por " + usuario1.getNome() + ":");
        usuario1.mostrarItensEmprestados ();

        System.out.println("Itens emprestados por " + usuario2.getNome() + ":");
        usuario2.mostrarItensEmprestados();

        System.out.println("Itens emprestados por " + usuario3.getNome() + ":");
        usuario3.mostrarItensEmprestados();

        // exemplo de item devolvido
        System.out.println("Item devolvido por " + usuario1.getNome() + ":");
        usuario3.mostrarItensDevolvidos();

    }
}
