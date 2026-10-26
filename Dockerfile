FROM maven:3.9.11-eclipse-temurin-21 AS build
WORKDIR /src
COPY pom.xml .
COPY libraries libraries
COPY services services
ARG SERVICE=school-service
RUN mvn -B -ntp -pl services/${SERVICE} -am package -DskipTests && cp services/${SERVICE}/target/${SERVICE}-0.1.0-SNAPSHOT.jar /application.jar
FROM eclipse-temurin:21-jre-jammy
RUN groupadd --system school && useradd --system --gid school school
WORKDIR /app
COPY --from=build --chown=school:school /application.jar /app/application.jar
USER school
EXPOSE 8080
ENV PORT=8080
ENTRYPOINT ["java","-XX:MaxRAMPercentage=70","-jar","/app/application.jar"]
