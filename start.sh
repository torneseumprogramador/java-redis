#!/bin/bash
export CLASSPATH=target/redis-1.0-SNAPSHOT.jar
export className=App
echo "## Running $className..."
shift
mvn exec:java -Dexec.mainClass="br.com.redis.$className"