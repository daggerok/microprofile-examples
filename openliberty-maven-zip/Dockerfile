FROM open-liberty:microProfile2-java8-ibm as server-setup
ENV APP=app1
COPY ./target/${APP}.zip /config/
USER root
RUN apt update -yqq \
 && apt install -yqq --no-install-recommends unzip \
 && unzip /config/${APP}.zip \
 && mv /wlp/usr/servers/${APP}Server/* /config/ \
 && rm -rf /config/wlp \
 && rm -rf /config/${APP}.zip

FROM open-liberty:microProfile2-java8-ibm
LABEL maintainer="Maksim Kostromin" github="https://github.com/daggerok"
COPY --from=server-setup /config/ /config/
EXPOSE 9080 9443
