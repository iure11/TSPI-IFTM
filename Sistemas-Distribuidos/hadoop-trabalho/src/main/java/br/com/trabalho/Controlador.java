package br.com.trabalho;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.io.Text;

public class Controlador {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Uso: Controlador <entrada> <saida>");
            System.exit(2);
        }

        Configuration conf = new Configuration();
        Job job = configurarJob(conf);

        configurarPaths(job, args);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

    private static Job configurarJob(Configuration conf) throws IOException {
        Job job = Job.getInstance(conf, "conta palavras chave");
        job.setJarByClass(Controlador.class);
        job.setMapperClass(Mapeador.class);
        job.setReducerClass(Redutor.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
        return job;
    }

    private static void configurarPaths(Job job, String[] args) throws IOException {
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
    }
}
