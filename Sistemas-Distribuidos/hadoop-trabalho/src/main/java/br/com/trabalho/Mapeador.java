package br.com.trabalho;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;
import java.util.StringTokenizer;

public class Mapeador extends org.apache.hadoop.mapreduce.Mapper<Object, Text, Text, IntWritable> {
    private final static IntWritable um = new IntWritable(1);
    private final Text palavra = new Text();

    @Override
    public void map(Object chave, Text valor, Context contexto) throws IOException, InterruptedException {
        StringTokenizer tk = new StringTokenizer(valor.toString());
        while (tk.hasMoreTokens()) {
            processarToken(tk.nextToken(), tk, contexto);
        }
    }

    private void processarToken(String token, StringTokenizer tk, Context contexto) throws IOException, InterruptedException {
        if (ehPalavraChave(token)) {
            palavra.set(tk.nextToken());
            contexto.write(palavra, um);
        }
    }

    private boolean ehPalavraChave(String token) {
        return token.equals("\"NumberOfPrompts\":") || token.equals("\"Type\":");
    }
}