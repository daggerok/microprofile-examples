# OpenLiberty MicroProfile 3.1

```bash
mvn -f openliberty-mp3-maven-zip/ clean package docker:build docker:start

http :/app1/api/v1/
http :/app1/api/v1/os
http :/app1/api/v1/wlp
http :/app1/api/v1/name

mnv -f openliberty-mp3-maven-zip/ clean package docker:stop docker:remove
```
