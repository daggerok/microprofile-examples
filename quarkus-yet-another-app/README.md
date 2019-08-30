# quarkus-yet-another-app
Yet another quarkus app!

## Table of contents

<!--ts-->
   * [getting started](#getting-started)
      * [prepare workplace](#prepare-workplace)
      * [generate new project](#generate-new-project)
      * [run tests](#run-tests)
      * [build runner jar](#build-runner-jar)
      * [run locally](#run-locally)
      * [run locally](#run-locally)
   * [development](#development)
<!--te-->

## getting started

### prepare workplace

```bash
mkdir -p /tmp/yet-another-quarkus-app
cd /tmp/yet-another-quarkus-app
```

### generate new project

```bash
mvn io.quarkus:quarkus-maven-plugin:0.21.1:create \
    -DprojectGroupId=com.github.daggerok \
    -DprojectArtifactId=yet-another-quarkus-app \
    -DprojectVersion=1.0.0-SNAPSHOT \
    -DclassName="daggerok.Resource" \
    -Dpath=/api/hello
```

### run tests

```bash
mvn clean test
```

### build runner jar

```bash
mvn package
```

### run locally

```bash
java -jar target/*-runner.jar
```

## development

```bash
mvn quarkus:dev
```

## development

```bash
mvn quarkus:dev
```

## links

* [Quarkus Getting Started](https://quarkus.io/guides/getting-started-testing)
* [Quarkus Getting Started Testing](https://quarkus.io/guides/getting-started-testing)
* [Read InputStream into String](https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java)
