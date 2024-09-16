docker rm -f xyu
docker rmi lab2-backend
mvn clean install
docker compose up