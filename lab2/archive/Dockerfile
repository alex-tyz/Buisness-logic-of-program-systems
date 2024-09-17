# back
# устанавливаем самую лёгкую версию JVM
FROM amazoncorretto:17

LABEL maintainer="2262288@gmail.com"

VOLUME /tmp

EXPOSE 8081

ARG JAR_FILE=./target/archive-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} archive.jar


# команда запуска джарника
ENTRYPOINT ["java", "-jar", "archive.jar"]
