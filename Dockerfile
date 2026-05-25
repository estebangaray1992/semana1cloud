# 1. Usar una imagen de Java para compilar
FROM eclipse-temurin:21-jdk AS buildstage

# 2. Instalar Maven dentro del contenedor
RUN apt-get update && apt-get install -y maven

WORKDIR /app

# 3. Copiar archivos necesarios
COPY pom.xml .
COPY src ./src
# IMPORTANTE: Asegúrate que el nombre de tu carpeta de Wallet sea exactamente este
COPY Wallet_TESTDB1 ./wallet 

# 4. Configurar la Wallet para que Maven no falle al compilar
ENV TNS_ADMIN=/app/wallet

# 5. Empaquetar la aplicación saltando tests
RUN mvn clean package -DskipTests

# 6. Crear la imagen final ligera
FROM eclipse-temurin:21-jdk
WORKDIR /app

# 7. Copiar el archivo .jar generado (REVISA EL NOMBRE DE TU JAR EN POM.XML)
COPY --from=buildstage /app/target/*.jar app.jar
COPY Wallet_TESTDB1 ./wallet

ENV TNS_ADMIN=/app/wallet
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]