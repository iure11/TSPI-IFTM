package biblioteca;

public class Livro extends Item {
    private int anoPublicacao;
    private int numeroPaginas;
    private String editora;

    public Livro(String titulo, String autor, boolean disponivel, int anoPublicacao, int numeroPaginas, String editora) {
        super(titulo, autor, disponivel);
        this.anoPublicacao = anoPublicacao;
        this.numeroPaginas = numeroPaginas;
        this.editora = editora;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }
}

