# Smallrye MicrpProfile

## maven exec plugin

```bash
mvn -f ./smallrye-jar/pom.xml clean package exec:java -Dexec.mainClass=com.github.daggerok.App
```

### maven fatJar

```bash
./mvnw -f ./smallrye-jar/pom.xml clean package
java -jar ./smallrye-jar/target/app4-*.jar
```

## gradle

### application gradle plugin

```bash
./gradlew -b ./smallrye-jar/build.gradle.kts installDist
bash ./smallrye-jar/build/install/app4/bin/app4
```

### fatJar gradle task

```bash
./gradlew -b ./smallrye-jar/build.gradle.kts fatJar
java -jar ./smallrye-jar/build/libs/*-all.jar
```

links:

* [MicroProfile starter](https://start.microprofile.io/index.xhtml)
* [SmallRye Reactive Messaging](https://smallrye.io/smallrye-reactive-messaging/#_quickstart)
* [Logback reference](https://logback.qos.ch/manual/configuration.html)
* [Lightbend MicroProfile Reactive Messaging](https://github.com/lightbend/microprofile-reactive-messaging)
* [Gradle fatJar task](https://gist.github.com/daggerok/4f5f63448f24d991c273165615baa39a)
