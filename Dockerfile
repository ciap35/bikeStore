# Usa una imagen base de JDK
FROM openjdk:17-jdk-alpine

# Añade un directorio de trabajo
WORKDIR /app

# Copia el JAR generado de tu aplicación
COPY target/bikeStore-0.0.1-SNAPSHOT.jar /app/bikeStore-0.0.1-SNAPSHOT.jar

# Expone el puerto que usará la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/bikeStore-0.0.1-SNAPSHOT.jar"]
