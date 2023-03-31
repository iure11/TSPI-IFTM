package atividade8;
public class Main {
    public static void main(String[] args) {
        Computador notebook = new Notebook();
        Computador desktop = new Desktop();
        Computador servidor = new Servidor();

        notebook.iniciar();
        desktop.iniciar();
        servidor.iniciar();
    }
}