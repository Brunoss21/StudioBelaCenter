FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY pom.xml .

COPY src ./src

COPY mvnw .
COPY .mvn .mvn

RUN chmod +x mvnw

RUN ./mvnw clean package

CMD ["java", "-jar", "target/studiobela-0.0.1-SNAPSHOT.war"]
