docker rm -f xyu
docker rmi lab2-backend
mvn clean install
docker rm -f actual_db
docker rmi lab2-actual_db
cd databases
mvn clean install
cd ..
docker rm -f archive_db
docker rmi lab2-archive_db
cd archive
mvn clean install
docker compose up