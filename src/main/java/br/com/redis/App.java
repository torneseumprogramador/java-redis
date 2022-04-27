package br.com.redis;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import br.com.redis.services.RedisService;
import redis.clients.jedis.Jedis;

public class App 
{
    public static void main( String[] args )
    {
        var key = "UMA_CHAVE";

        var redisService = new RedisService();

        redisService.write(key, "Gardando no cache " + LocalDate.now());

        var valor = redisService.read(key);
        System.out.println("Lendo valor do Cache: " + valor);


        // ====== pub sub ===
        var channel = "canal_push";

        // Message reader - habilitar para ler
        redisService.subscribe(channel);

        // // Message sender - habilitar para enviar
        // redisService.publish(channel, "mandando uma mensagem para o pub/sub");

        // var jedis = new Jedis("http://localhost:6379");


        // ==== PUSH/POP ====
        // jedis.lpush("fila", "item1");
        // jedis.lpush("fila", "item2");

        // String pop1 = jedis.rpop("fila");
        // String pop2 = jedis.rpop("fila");



        // ==== Sets(Array) ====
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
