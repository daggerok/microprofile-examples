# OpenLiberty MicroProfile

```bash
./mvnw -U -f openliberty-maven-zip/ clean package

docker build -t openliberty-maven-zip -f openliberty-maven-zip/Dockerfile openliberty-maven-zip
docker run -d --name app1 --rm -p 9080:9080 -p 9443:9443 openliberty-maven-zip

http :9080/app1/api/v1/

docker rm -f -v app1
```

* https://openliberty.io/guides/rest-intro.html

* https://openliberty.io/guides/cdi-intro.html
* https://github.com/OpenLiberty/guide-cdi-intro
        
* https://openliberty.io/guides/microprofile-rest-client.html
* https://github.com/openliberty/guide-microprofile-rest-client

* https://openliberty.io/guides/microprofile-config.html
* https://github.com/OpenLiberty/guide-microprofile-config

* https://openliberty.io/guides/microprofile-fallback.html
* https://github.com/OpenLiberty/guide-microprofile-fallback

* https://openliberty.io/guides/microprofile-jwt.html
* https://github.com/OpenLiberty/guide-microprofile-jwt

* https://openliberty.io/guides/microprofile-openapi.html
* https://github.com/OpenLiberty/guide-microprofile-openapi

* https://openliberty.io/guides/microprofile-metrics.html
* https://github.com/OpenLiberty/guide-microprofile-metrics

* https://openliberty.io/guides/microprofile-health.html
* https://github.com/OpenLiberty/guide-microprofile-health

* https://openliberty.io/guides/microprofile-opentracing.html
* https://github.com/OpenLiberty/guide-microprofile-opentracing

* https://openliberty.io/guides/?search=docker
* https://openliberty.io/guides/?search=kubernetes
