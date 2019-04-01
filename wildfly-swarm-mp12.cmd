@echo off
call mvnw -f wildfly-swarm-mp12\pom.xml
java -jar wildfly-swarm-mp12\target\wildfly-swarm-mp12-swarm.jar  
