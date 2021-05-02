FROM openjdk:8
EXPOSE 9090
ADD /spring-boot-actuator-0.0.1.jar spring-boot-actuator-0.0.1.jar
ENTRYPOINT ["java","-jar","spring-boot-actuator-0.0.1.jar"]
