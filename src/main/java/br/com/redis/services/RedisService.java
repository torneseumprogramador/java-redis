package br.com.redis.services;

import redis.clients.jedis.Jedis;

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
}