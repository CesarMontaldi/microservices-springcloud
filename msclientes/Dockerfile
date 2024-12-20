# build
FROM maven:3.8.8-amazoncorretto-21-al2023 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests


# run
FROM amazoncorretto:21.0.5
WORKDIR /app

COPY --from=build ./app/target/*.jar ./app.jar

ENV EUREKA_SERVER=''
ENV EUREKA_USERNAME=''
ENV EUREKA_PASSWORD=''


ENV TZ='America/Sao_Paulo'

ENTRYPOINT java -jar app.jar