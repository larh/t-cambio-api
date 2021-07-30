FROM openjdk:11.0
VOLUME /tmp
EXPOSE 8083
ADD ./target/srv-zuul-server-1.0.0.jar tcambio-srv-zuul-server.jar
ENTRYPOINT [ "java", "-jar", "/tcambio-srv-zuul-server.jar" ]


#mvnw.cmd clean package -Dmaven.test.skip=true
#docker build -t apn-zuul-server:v1 .
#docker build -t apnaplicacion/apn-zuul-server:v1 .
#docker network create apn-net-springcloud
#docker run -p 8083:8083 --name apn-zuul-server --network apn-net-springcloud apn-zuul-server:v1

#docker build -t apnaplicacion/apn-zuul-server:v1 .
#docker push apnaplicacion/apn-zuul-server:v1
