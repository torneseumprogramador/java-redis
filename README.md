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

# trabalhando com listas
```java
jedis.lpush("queue#tasks", "firstTask");
jedis.lpush("queue#tasks", "secondTask");

String task = jedis.rpop("queue#tasks");
```