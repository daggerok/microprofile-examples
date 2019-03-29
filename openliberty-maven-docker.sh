#!/usr/bin/env bash
 ./mvnw -f openliberty-maven-docker/pom.xml clean package
docker build -t openliberty-maven-docker -f openliberty-maven-docker/Dockerfile openliberty-maven-docker
docker run --name app --rm -p 9080:9080 -p 9443:9443 openliberty-maven-docker
