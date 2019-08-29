# yet another simple smallrye-next
(:

```bash
./mvnw clean ; ./mvnw ; java -jar ./target/*-all.jar

http :8080 message=hello
http :8080 message=world
http :8080 message=yeah
```

links:

* [Emitting data into process flow](https://smallrye.io/smallrye-reactive-messaging/#_stream)
