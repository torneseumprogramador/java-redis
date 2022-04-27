package br.com.redis.services;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisService {
    private Jedis jedis;

    public RedisService(){
        jedis = new Jedis("http://localhost:6379");
    }

    public void write(String key, String value) {
        jedis.set(key, value);
    }

    public String read(String key) {
       return jedis.get(key);
    }

    public void publish(String channel, String message) {
        jedis.publish(channel, message);
    }

    public void subscribe(String key) {
        jedis.subscribe(new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                System.out.println("Canal: " + channel);
                System.out.println("Mensagem: " + message);
            }
        }, key);
    }
}