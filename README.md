# microprofile-examples [![Build Status](https://travis-ci.org/daggerok/microprofile-examples.svg?branch=master)](https://travis-ci.org/daggerok/microprofile-examples)
MicroProfile examples

## OpenLiberty

### maven / docker

_build_

```bash
./mvnw -f openliberty-maven-docker/pom.xml clean package
docker build -t openliberty-maven-docker -f openliberty-maven-docker/Dockerfile openliberty-maven-docker
```

_run_

```bash
docker run --name app --rm -p 9080:9080 -p 9443:9443 openliberty-maven-docker
```

_test_

```bash
http :9080/app/
http :9080/app/v1/properties
```
