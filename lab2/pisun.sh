docker rm -f xyu
docker rmi lab2-backend
mvn clean install
docker rm -f databases
docker rmi lab2-db
cd databases
mvn clean install
cd ..
docker compose up