FROM openjdk:11
LABEL maintainer="nayansengupta99@gmail.com"
VOLUME /tmp
EXPOSE 8081
ADD target/zull-gateway-service-0.0.1-SNAPSHOT.jar zull-gateway-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","zull-gateway-service-0.0.1-SNAPSHOT.jar"]