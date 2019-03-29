FROM open-liberty:microProfile2-java8-ibm as server-setup
COPY ./target/app.zip /config/
USER root
RUN apt update -yqq \
 && apt install -yqq --no-install-recommends unzip \
 && unzip /config/app.zip\
 && mv /wlp/usr/servers/appServer/* /config/ \
 && rm -rf /config/wlp \
 && rm -rf /config/app.zip

FROM open-liberty:microProfile2-java8-ibm
LABEL maintainer="Maksim Kostromin" github="https://github.com/daggerok"
COPY --from=server-setup /config/ /config/
EXPOSE 9080 9443
