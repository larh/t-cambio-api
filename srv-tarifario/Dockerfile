FROM openjdk:11.0
VOLUME /tmp
ADD ./target/srv-tarifario-1.0.jar tcambio-srv-tarifario.jar
ENV TZ=America/Lima
ENTRYPOINT [ "java", "-jar", "/tcambio-srv-tarifario.jar" ]