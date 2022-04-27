package br.com.redis;

import java.time.LocalDate;

import br.com.redis.services.RedisService;

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
    }
}
