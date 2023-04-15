package atividade4;

public class Linha implements Relacao {
    private int x1, y1, x2, y2;

    public Linha(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public boolean eMaior(Object a, Object b) {
        Linha linhaA = (Linha) a;
        Linha linhaB = (Linha) b;
        return linhaA.getTamanho() > linhaB.getTamanho();
    }

    @Override
    public boolean eMenor(Object a, Object b) {
        Linha linhaA = (Linha) a;
        Linha linhaB = (Linha) b;
        return linhaA.getTamanho() < linhaB.getTamanho();
    }

    @Override
    public boolean eIgual(Object a, Object b) {
        Linha linhaA = (Linha) a;
        Linha linhaB = (Linha) b;
        return linhaA.getTamanho() == linhaB.getTamanho();
    }

    public double getTamanho() {
        return Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
    }
}
