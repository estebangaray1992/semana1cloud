FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
COPY Wallet_TESTDB1 /Wallet_TESTDB1
ENTRYPOINT ["java","-jar","/app.jar"]