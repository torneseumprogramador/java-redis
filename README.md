# redis
- https://redis.io/

# install
- https://redis.io/download/

- configurar o seu .bash_profile ou .bashrc
```shell
code ~/.bash_profile

alias "redis_start= ~/redis/src/redis-server"
alias "redis= ~/redis/src/redis-cli"

source ~/.bash_profile
```

# documentação
- https://redis.io/docs/

# acessar client
- https://redis.io/docs/manual/cli/
```shell
redis
// 127.0.0.1:6379>
```

# adicionar no cache via client
```shell
FLUSHALL # limpa todo cache
```


# criando projeto
mvn archetype:generate -DgroupId=br.com.redis -DartifactId=redis -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4 -DinteractiveMode=false

# doc mvn
https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
### gerar com manifest
https://www.sohamkamani.com/java/cli-app-with-maven/

# como rodar
```shell
./buld.sh
./start.sh
```

# dependencias
```xml
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>4.2.2</version>
</dependency>
```

# criando instancia
```java
Jedis jedis = new Jedis("http://localhost:6379");
```

# utilizando redis para gravar e ler strings
```java
jedis.set("chave", "um valor");
String cachedResponse = jedis.get("chave");
```

# Push/Pop
```java
jedis.lpush("fila", "item1");
jedis.lpush("fila", "item2");

String pop1 = jedis.rpop("fila");
String pop2 = jedis.rpop("fila");
```

# Sets(Array)
```java
jedis.sadd("membros", "danilo");
jedis.sadd("membros", "lana");
jedis.sadd("membros", "sheila");

Set<String> membros = jedis.smembers("membros");
boolean isMember = jedis.sismember("membros", "sheila");
```

# Hashes
```java
jedis.hset("usuario", "nome", "Danilo");
jedis.hset("usuario", "cpf", "339839389383");
jedis.hset("usuario", "telefone", "(11)99999-9999");
        
String nome = jedis.hget("usuario", "nome");
        
Map<String, String> fields = jedis.hgetAll("usuario");
String cpf = fields.get("cpf");
```        

# mais infos
- https://www.baeldung.com/jedis-java-redis-client-library