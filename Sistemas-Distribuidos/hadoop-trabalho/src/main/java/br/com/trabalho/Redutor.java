package br.com.trabalho;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import java.io.IOException;

public class Redutor extends org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable resultado = new IntWritable();

    @Override
    public void reduce(Text chave, Iterable<IntWritable> valores, Context contexto) throws IOException, InterruptedException {
        int soma = 0;
        for (IntWritable val : valores) {
            soma += val.get();
        }
        resultado.set(soma);
        contexto.write(chave, resultado);
    }
}