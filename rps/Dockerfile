# Etapa de build
FROM maven:3.9.11-eclipse-temurin-21 AS build

WORKDIR /app

# Copia os arquivos necessários para resolver as dependências
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .

RUN chmod +x mvnw

# Baixa as dependências (aproveita o cache do Docker)
RUN ./mvnw dependency:go-offline

# Copia o código-fonte
COPY src src

# Compila a aplicação
RUN ./mvnw clean package -DskipTests

# Etapa de execução
FROM amazoncorretto:21

WORKDIR /app

# Copia o JAR gerado pelo Maven
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]