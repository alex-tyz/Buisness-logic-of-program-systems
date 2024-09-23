# back
# устанавливаем самую лёгкую версию JVM
FROM amazoncorretto:17

LABEL maintainer="2262288@gmail.com"

VOLUME /tmp

EXPOSE 5431

ARG JAR_FILE=./target/databases-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} databases.jar


# команда запуска джарника
ENTRYPOINT ["java", "-jar", "databases.jar"]
