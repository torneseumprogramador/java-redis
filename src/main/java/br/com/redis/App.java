package br.com.redis;

import java.time.LocalDate;

import br.com.redis.services.RedisService;

public class App 
{
    public static void main( String[] args )
    {
        var redisService = new RedisService();
        redisService.write("UMA_CHAVE", "Gardando no cache " + LocalDate.now());

        var valor = redisService.read("UMA_CHAVE");
        System.out.println("Lendo valor do Cache: " + valor);
    }
}
