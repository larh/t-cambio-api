#export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.9.11-2.el7_9.x86_64

###########################   BACKEND     ######################################
#------------------------------  GENERAR COMPILADOS ----------------------------
################################################################################
cd /opt/tcambio/bcp-repo/apis
cd D:/PY_EXAMEN/apis

cd srv-eureka
mvn clean install package -Dmaven.test.skip=true
cd ..

cd srv-tarifario
mvn clean install package -Dmaven.test.skip=true
cd ..

cd srv-tipo-cambio
mvn clean install package -Dmaven.test.skip=true
cd ..

cd srv-oauth
mvn clean install package -Dmaven.test.skip=true
cd ..

cd srv-zuul-server
mvn clean install package -Dmaven.test.skip=true
cd ..

################################################################################
#------------------------  SUBIR AL DOCKER REGISTRY ----------------------------
################################################################################
cd srv-eureka
docker build -t tcambio/tcambio-srv-eureka:v1.0.0 .
#docker push tcambio/tcambio-srv-eureka:v1.0.0
cd ..

cd srv-tarifario
docker build -t tcambio/tcambio-srv-tarifario:v1.0.0 .
#docker push tcambio/tcambio-srv-tarifario:v1.0.0
cd ..

cd srv-tipo-cambio
docker build -t tcambio/tcambio-srv-tipo-cambio:v1.0.0 .
#docker push tcambio/tcambio-srv-tipo-cambio:v1.0.0
cd ..

cd srv-oauth
docker build -t tcambio/tcambio-srv-oauth:v1.0.0 .
#docker push tcambio/tcambio-srv-oauth:v1.0.0
cd ..

cd srv-zuul-server
docker build -t tcambio/tcambio-srv-zuul-server:v1.0.0 .
#docker push tcambio/tcambio-srv-zuul-server:v1.0.0
cd ..

################################################################################
#------------------------  DEPLOYMENT ----------------------------
################################################################################

docker stop $(docker ps -aq)
docker rm $(docker ps -aq)
docker rmi -f $(docker images "tcambio*" -q)

docker network create tcambio-net-springcloud

docker run -t -d -p 8761:8761 --name tcambio-srv-eureka --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-eureka:v1.0.0

docker run -t -d -p 8081:8081 --name tcambio-srv-tipo-cambio --add-host="localhost:192.168.99.67" --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-tipo-cambio:v1.0.0
docker run -t -d -p 8085:8085 --name tcambio-srv-tarifario --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-tarifario:v1.0.0
docker run -t -d -p 9001:9001 --name tcambio-srv-oauth --add-host="localhost:192.168.99.67" --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-oauth:v1.0.0

docker run -t -d -p 8090:8090 --name tcambio-srv-zuul-server --add-host="localhost:192.168.99.67" --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-zuul-server:v1.0.0








