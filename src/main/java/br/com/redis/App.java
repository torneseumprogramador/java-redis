package br.com.redis;

import java.util.ArrayList;

import com.google.gson.Gson;

import br.com.redis.models.Aluno;
import br.com.redis.services.RedisService;

public class App 
{
    public static void main( String[] args )
    {
        var key = "UMA_CHAVE";

        var redisService = new RedisService();

        // ====== Objeto transformado em string para gravação no cache =====
        var alunos = new ArrayList<Aluno>();

        var aluno = new Aluno();
        aluno.setNome("Danilo");
        aluno.setMatricula("001");

        var notas = new ArrayList<Double>();
        notas.add(7.0);
        notas.add(6.0);
        notas.add(8.0);
        aluno.setNotas(notas);

        alunos.add(aluno);

        String alunoParsed = new Gson().toJson(alunos);
        
        // === gravando no cache o objeto parseado
        redisService.write(key, alunoParsed, 30);
        // ====== Objeto transformado em string para gravação no cache =====

        var valor = redisService.read(key);
        System.out.println("Lendo valor do Cache: " + valor);

        Aluno[] alunosParseados = new Gson().fromJson(valor, Aluno[].class);

        System.out.println(alunosParseados);

        // // ====== pub sub ===
        // var channel = "canal_push";

        // // Message reader - habilitar para ler
        // // redisService.subscribe(channel);

        // // // Message sender - habilitar para enviar
        // redisService.publish(channel, "mandando uma mensagem para o pub/sub");

        // redisService.close();





        // var jedis = new Jedis("http://localhost:6379");


        // // ==== PUSH/POP ====
        // jedis.lpush("fila", "item1");
        // jedis.lpush("fila", "item2");

        // String pop1 = jedis.rpop("fila");
        // String pop2 = jedis.rpop("fila");



        // // ==== Sets(Array) ====
        // jedis.sadd("membros", "danilo");
        // jedis.sadd("membros", "lana");
        // jedis.sadd("membros", "sheila");

        // Set<String> membros = jedis.smembers("membros");
        // boolean isMember = jedis.sismember("membros", "sheila");



        // ==== Hashes ====
        // jedis.hset("usuario", "nome", "Danilo");
        // jedis.hset("usuario", "cpf", "339839389383");
        // jedis.hset("usuario", "telefone", "(11)99999-9999");
                
        // String nome = jedis.hget("usuario", "nome");
                
        // Map<String, String> fields = jedis.hgetAll("usuario");
        // String cpf = fields.get("cpf");


        // jedis.close();
    }
}
