plugins {
  java
  application
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("io.smallrye.reactive:smallrye-reactive-messaging-provider:0.0.5")
  implementation("io.smallrye.reactive:smallrye-reactive-streams-operators:1.0.3")
  implementation("org.jboss.weld.se:weld-se-core:3.1.0.Final")
  implementation("org.slf4j:slf4j-api:1.7.26")
  implementation("ch.qos.logback:logback-classic:1.2.3")
}

tasks.withType(Wrapper::class.java) {
  gradleVersion = "5.3"
  distributionType = Wrapper.DistributionType.BIN
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

val mainClass = "com.github.daggerok.App"

application {
  mainClassName = mainClass
}

tasks {
  register("fatJar", Jar::class.java) {
    archiveClassifier.set("all")
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
      attributes("Main-Class" to mainClass)
    }
    from(configurations.runtimeClasspath.get()
        .onEach { println("add from dependencies: ${it.name}") }
        .map { if (it.isDirectory) it else zipTree(it) })
    val sourcesMain = sourceSets.main.get()
    sourcesMain.allSource.forEach { println("add from sources: ${it.name}") }
    from(sourcesMain.output)
  }
}

defaultTasks("fatJar", "installDist")
