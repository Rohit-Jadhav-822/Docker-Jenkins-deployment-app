FROM openjdk:8
EXPOSE 9090
ADD target/spring-boot-actuator-0.0.1-SNAPSHOT.jar spring-boot-actuator-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-actuator-0.0.1-SNAPSHOT.jar"]
