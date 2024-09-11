# back
# устанавливаем самую лёгкую версию JVM
FROM amazoncorretto:17

LABEL maintainer="2262288@gmail.com"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=./target/lab2-0.0.8-SNAPSHOT.jar

ADD ${JAR_FILE} backend.jar
ADD ./meow.sh ./meow.sh

# команда запуска джарника
ENTRYPOINT ["java", "-jar", "backend.jar"]
