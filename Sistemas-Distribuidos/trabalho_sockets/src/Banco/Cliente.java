package Banco;

import java.io.*;
import java.net.*;




public class Cliente {

    public static void main(String[] args) {
        try (
                Socket socket = new Socket("localhost", 12345);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
        ) {
            while (true) {

                Transacao transacao = new Transacao();
                transacao.setValor(100.0);
                transacao.setData("2023-09-21");
                transacao.setHora("15:30");
                transacao.setRedeTransmissora("RedeA");
                transacao.setFormaPagamento("CartaoCredito");
                transacao.setNSU(0);
                transacao.setCodigoResposta("");


                out.writeObject(transacao);


                Transacao resposta = (Transacao) in.readObject();


                if ("00".equals(resposta.getCodigoResposta())) {
                    System.out.println("Transação aprovada!");
                } else {
                    System.out.println("Transação rejeitada. Código de resposta: " + resposta.getCodigoResposta() + " (NSU:" + resposta.getNSU() + ")" + " (data: " + resposta.getData() + ", hora: " + resposta.getHora() + ")");
                }


                Thread.sleep(5000);
            }
        } catch (IOException | ClassNotFoundException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
