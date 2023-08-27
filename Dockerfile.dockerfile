FROM openjdk:11
WORKDIR /pet-app
VOLUME /pet-app/tmp
COPY ./pom.xml .
COPY ./src ./src
RUN mvn clean package
CMD ["java", "-jar", "./target/starter-0.0.1-SNAPSHOT.jar"]