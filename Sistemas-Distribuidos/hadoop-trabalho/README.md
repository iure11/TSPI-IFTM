<h2>Instruções para Execução do Job Hadoop MapReduce</h2>
<p>Este guia fornece instruções passo a passo para configurar e executar um job Hadoop MapReduce. Assegure-se de que você tem o Hadoop instalado e configurado, e que possui o arquivo de dados necessário disponível localmente.</p>

<b>Pré-requisitos</b>
<ul>
    <li>Hadoop instalado e configurado.</li>
    <li>Arquivo de dados (exemplo: <code>20230727_200102_file_sharings.json</code>) disponível no sistema de arquivos local.</li>
</ul>

<b>Passos para Execução</b>
<br>
<b>1. Criação do Diretório no HDFS</b>
<p>Crie um diretório no HDFS para armazenar os arquivos de entrada:</p>
<pre><code>hadoop fs -mkdir bases</code></pre>

<b>2. Carregando Dados para o HDFS</b>
<p>Carregue o arquivo de dados do sistema de arquivos local para o HDFS:</p>
<pre><code>hadoop fs -put DevGPT/snapshot_20230727/20230727_200102_file_sharings.json bases</code></pre>

<b>3. Listando Arquivos no HDFS</b>
<p>Verifique se o arquivo foi carregado corretamente:</p>
<pre><code>hadoop fs -ls bases</code></pre>

<b>4. Executando o Job do MapReduce</b>
<p>Execute o job MapReduce:</p>
<pre><code>hadoop jar ./aula/target/aula-1.0-SNAPSHOT.jar br.com.trabalho.Controlador bases saida</code></pre>

<b>5. Listando o Output do Job</b>
<p>Após a execução do job, verifique os resultados:</p>
<pre><code>hadoop fs -ls saida</code></pre>

<b>6. Repetição do Job do MapReduce</b>
<p>Para executar o job novamente, lembre-se de remover ou especificar um novo diretório de saída:</p>
<pre><code>hadoop jar ./aula/target/aula-1.0-SNAPSHOT.jar br.com.trabalho.Controlador bases nova_saida</code></pre>

<b>Notas Adicionais</b>
<ul>
    <li>Certifique-se de que o caminho para o arquivo de dados e o jar compilado estejam corretos.</li>
    <li>Verifique se o Hadoop está corretamente configurado e em execução antes de iniciar o processo.</li>
</ul>
