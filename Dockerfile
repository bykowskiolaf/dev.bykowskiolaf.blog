FROM openjdk:21-jdk as buildstage
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package -Dmaven.test.skip=true
RUN mv target/*.jar springboot-flash-cards-docker.jar

FROM openjdk:21-jdk
COPY --from=buildstage target/*.jar blog-server.jar
ENTRYPOINT ["java","-jar","/blog-server.jar"]