FROM openjdk:8-jdk-alpine

LABEL source="https://github.com/fiap-69aoj/netflix-order" \
      maintainer="flavioso16@gmail.com"

ADD ./target/order-0.0.1-SNAPSHOT.jar order.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "/order.jar"]