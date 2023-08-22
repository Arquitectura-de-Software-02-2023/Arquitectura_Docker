# Establece la imagen base (OpenJDK 20)
FROM openjdk:20

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /App

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/proyectopedido-0.0.1.jar app.jar

ENV DATABASE_URL=jdbc:postgresql://localhost:5432/Ejemplo_arqui

# Expone el puerto en el que escucha tu aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación cuando se inicie el contenedor
CMD ["java", "-jar", "app.jar"]
