FROM eclipse-temurin
COPY . /app
WORKDIR /app/src/main/java
RUN javac Main.java
CMD ["java","Main"]