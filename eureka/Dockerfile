FROM openjdk:11
LABEL maintainer="nayansengupta99@gmail.com"
VOLUME /tmp
EXPOSE 8761
ADD target/eureka-0.0.1-SNAPSHOT.jar eureka-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","eureka-0.0.1-SNAPSHOT.jar"]