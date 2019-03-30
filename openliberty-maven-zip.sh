#!/usr/bin/env bash
for c in $(docker ps -aq) ; do docker rm -f -v $c ; done
for i in $(docker images -qf dangling=true) ; do docker rmi -f $i ; done
docker rmi -f openliberty-maven-zip
 ./mvnw -f openliberty-maven-zip/pom.xml clean package
docker build -t openliberty-maven-zip -f openliberty-maven-zip/Dockerfile openliberty-maven-zip
docker run --rm -p 9080:9080 openliberty-maven-zip
