FROM open-liberty:19.0.0.9-microProfile3-java11 as server-setup
ENV APP=app1
COPY ./target/${APP}.zip /config/
USER root
RUN apt update -yqq \
 && apt install -yqq --no-install-recommends unzip \
 && unzip /config/${APP}.zip \
 && mv /wlp/usr/servers/${APP}Server/* /config/ \
 && rm -rf /config/wlp \
 && rm -rf /config/${APP}.zip

FROM open-liberty:19.0.0.9-microProfile3-java11
LABEL maintainer="Maksim Kostromin" github="https://github.com/daggerok/"
ARG APP_ARG=app1
ENV APP=${APP_ARG}
EXPOSE 9080 9443
COPY --from=server-setup /config/ /config/
