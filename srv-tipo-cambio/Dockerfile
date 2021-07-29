FROM openjdk:11.0
VOLUME /tmp
ADD ./target/srv-tipo-cambio-1.0.jar tcambio-srv-tipo-cambio.jar
ENV TZ=America/Lima
ENTRYPOINT [ "java", "-Doracle.jdbc.timezoneAsRegion=false", "-jar", "/tcambio-srv-tipo-cambio.jar" ]