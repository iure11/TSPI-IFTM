package atividade2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<CartaoWeb> cartoes = new ArrayList<>();
        cartoes.add(new DiaDosNamorados("Iure"));
        cartoes.add(new Natal("Dayna"));
        cartoes.add(new Aniversario("Vera"));

        for (CartaoWeb cartao : cartoes) {
            cartao.showMessage();
            System.out.println();

            //8 linha da classe CartaoWeb
        }
    }
}
