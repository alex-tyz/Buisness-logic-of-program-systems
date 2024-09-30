docker rm -f xyu
docker rmi lab4-backend
mvn clean install
docker rm -f actual_db
docker rmi lab4-actual_db
cd databases
mvn clean install
cd ..
docker rm -f archive_db
docker rmi lab4-archive_db
cd archive
mvn clean install
docker compose up