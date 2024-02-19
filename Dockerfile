FROM openjdk:21-jdk as buildstage
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline
COPY src src
RUN ./mvnw package -Dmaven.test.skip=true
# Rename the JAR file to blog-backend.jar
RUN mv target/*.jar blog-backend.jar

FROM openjdk:21-jdk
# Copy the renamed JAR file to the final image
COPY --from=buildstage /app/blog-backend.jar blog-backend.jar
ENTRYPOINT ["java","-jar","/blog-backend.jar"]
