package biblioteca;

public class Revista extends Item {
    private int numeroEdicao;
    private String editora;

    public Revista(String titulo, String autor, boolean disponivel, int numeroEdicao, String editora) {
        super(titulo, autor, disponivel);
        this.numeroEdicao = numeroEdicao;
        this.editora = editora;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}
