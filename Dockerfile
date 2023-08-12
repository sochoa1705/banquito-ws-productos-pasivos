FROM eclipse-temurin:17-jdk-focal

COPY target/ws-productos-pasivos-0.0.1-SNAPSHOT.jar ws-productos-pasivos-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/ws-productos-pasivos-0.0.1-SNAPSHOT.jar"]