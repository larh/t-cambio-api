#export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-11.0.9.11-2.el7_9.x86_64

###########################   BACKEND     ######################################
#------------------------------  GENERAR COMPILADOS ----------------------------
################################################################################
cd /opt/tcambio/bcp-repo/apis
cd D:/PY_EXAMEN/apis

cd srv-tarifario
mvn clean install package -Dmaven.test.skip=true
cd ..

cd srv-tipo-cambio
mvn clean install package -Dmaven.test.skip=true
cd ..


################################################################################
#------------------------  SUBIR AL DOCKER REGISTRY ----------------------------
################################################################################
cd srv-tarifario
docker build -t tcambio/tcambio-srv-tarifario:v1.0.0 .
#docker push tcambio/tcambio-srv-tarifario:v1.0.0
cd ..
cd srv-tipo-cambio
docker build -t tcambio/tcambio-srv-tipo-cambio:v1.0.0 .
#docker push tcambio/tcambio-srv-tipo-cambio:v1.0.0
cd ..

################################################################################
#------------------------  DEPLOYMENT ----------------------------
################################################################################

docker stop $(docker ps -aq)
docker rm $(docker ps -aq)
docker rmi -f $(docker images "tcambio*" -q)

docker network create tcambio-net-springcloud

docker run -t -d -p 8080:8080 --name tcambio-srv-tarifario --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-tarifario:v1.0.0
docker run -t -d -p 8081:8081 --name tcambio-srv-tipo-cambio --add-host="localhost:192.168.99.67" --network tcambio-net-springcloud -v /mnt/logs:/logs -e TZ=America/Lima tcambio/tcambio-srv-tipo-cambio:v1.0.0







