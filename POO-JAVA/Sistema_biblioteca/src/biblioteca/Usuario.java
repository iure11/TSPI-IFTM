package biblioteca;

import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String email;
    private String endereco;
    private ArrayList<Item> itensEmprestados;
    private ArrayList<Item> itensDevolvidos;

    public Usuario(String nome, String email, String endereco) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.itensEmprestados = new ArrayList<>();
        this.itensDevolvidos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Item> getItensEmprestados() {
        return itensEmprestados;
    }

    public ArrayList<Item> getItensDevolvidos() {
        return itensDevolvidos;
    }

    public void emprestarItem(Item item) {
        if (item.isDisponivel()) {
            itensEmprestados.add(item);
            item.setDisponivel(false);
            System.out.println("Item emprestado com sucesso!");
        } else {
            System.out.println("Item indisponível para empréstimo!");
        }
    }

    public void devolverItem(Item item) {
        if (itensEmprestados.contains(item)) {
            itensEmprestados.remove(item);
            item.setDisponivel(true);
            itensDevolvidos.add(item);
            System.out.println("O item '" + item.getTitulo() + "' foi devolvido com sucesso.");
        } else {
            System.out.println("Você não tem este item emprestado.");
        }
    }
    public void mostrarItensEmprestados() {

        for (Item item : this.getItensEmprestados()) {
            System.out.println("- " + item.getTitulo());
        }
        System.out.println();
    }
    public void mostrarItensDevolvidos() {

        for (Item item : this.getItensDevolvidos()) {
            System.out.println("- " + item.getTitulo());
        }
        System.out.println();
    }

}
