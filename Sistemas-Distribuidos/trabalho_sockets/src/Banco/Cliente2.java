package Banco;

import java.io.*;
import java.net.*;

public class Cliente2 {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 12345);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            while (true) {
                Transacao transacao = new Transacao();
                transacao.setValor(50.0);
                transacao.setData("2023-09-21");
                transacao.setHora("16:00");
                transacao.setRedeTransmissora("RedeB");
                transacao.setFormaPagamento("1111");
                transacao.setNSU(0);
                transacao.setCodigoResposta("");


                out.writeObject(transacao);


                Transacao resposta = (Transacao) in.readObject();


                if ("00".equals(resposta.getCodigoResposta())) {
                    System.out.println("Transação aprovada!");
                    System.out.println("NSU: " + resposta.getNSU() + " (data: " + resposta.getData() + ", hora: " + resposta.getHora() + ")");
                } else {
                    System.out.println("Transação rejeitada. Código de resposta: " + resposta.getCodigoResposta() + " (NSU:" + resposta.getNSU() + ")");
                }


                Thread.sleep(5000);
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
