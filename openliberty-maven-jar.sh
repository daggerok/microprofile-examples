#!/usr/bin/env bash
#for c in $(docker ps -aq) ; do docker rm -f -v $c ; done
#for i in $(docker images -qf dangling=true) ; do docker rmi -f $i ; done
#docker rmi -f openliberty-maven-jar
# ./mvnw -f openliberty-maven-jar/pom.xml clean package
#docker build -t openliberty-maven-jar -f openliberty-maven-jar/Dockerfile openliberty-maven-jar
#docker run --rm -p 9080:9080 openliberty-maven-jar
./mvnw -f openliberty-maven-jar/pom.xml clean package
java -jar openliberty-maven-jar/target/*.jar
