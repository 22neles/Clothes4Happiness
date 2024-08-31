# Use a imagem base do OpenJDK
FROM openjdk:21-jdk

# Adicione o jar ao container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Execute o jar
ENTRYPOINT ["java","-jar","/app.jar"]