FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8761
ADD ./target/srv-eureka-1.0.0.jar tcambio-srv-eureka-server.jar
ENTRYPOINT [ "java", "-jar", "/tcambio-srv-eureka-server.jar" ]