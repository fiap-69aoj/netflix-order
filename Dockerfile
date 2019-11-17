FROM openjdk:8-jdk-alpine

LABEL source="https://github.com/fiap-69aoj/netflix-order" \
      maintainer="flavioso16@gmail.com"

ADD ./target/order-0.0.1-SNAPSHOT.jar order.jar
ADD ./docker-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8083

env CONFIG_SERVER_URL="http://netflix-configuration-server:9093"

ENTRYPOINT ["/docker-entrypoint.sh"]