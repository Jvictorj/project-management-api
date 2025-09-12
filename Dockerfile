FROM eclipse-temurin:17
LABEL maintainer="supernova.dev"
WORKDIR /app
COPY target/GestaoDeProjetos-0.0.1-SNAPSHOT.jar /app/gestao-projeto.jar
ENTRYPOINT ["java", "-jar", "/app/gestao-projeto.jar"]
