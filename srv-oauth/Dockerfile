FROM openjdk:11.0
VOLUME /tmp
ADD ./target/srv-oauth-1.0.0.jar tcambio-srv-oauth.jar
ENTRYPOINT [ "java", "-Doracle.jdbc.timezoneAsRegion=false", "-jar", "/tcambio-srv-oauth.jar" ]


#mvnw.cmd clean package -Dmaven.test.skip=true
#docker build -t apn-servicio-oauth:v1 .
#docker network create apn-net-springcloud
#docker run -P --name apn-servicio-oauth --network apn-net-springcloud apn-servicio-oauth:v1  --add-host="localhost:192.168.99.16"