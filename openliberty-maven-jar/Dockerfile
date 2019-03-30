#FROM openjdk:8u201-jdk-alpine3.9
FROM openjdk:8u201-jre-alpine3.9
LABEL maintainer="Maksim Kostromin" github="https://github.com/daggerok"
ENV APP=app2
CMD /bin/ash
ENTRYPOINT java -jar /tmp/${APP}.jar
EXPOSE 9080 9443
COPY ./target/${APP}.jar /tmp/${APP}.jar
