package br.com.redis.services;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.params.SetParams;

public class RedisService {
    private Jedis jedis;

    public RedisService(){
        jedis = new Jedis("http://localhost:6379");
    }

    public void write(String key, String value) {
        var params = new SetParams();
        params.ex(10);
        jedis.set(key, value, params);
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