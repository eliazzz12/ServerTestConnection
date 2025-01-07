FROM eclipse-temurin
COPY . /app
WORKDIR /app/src/main/java
EXPOSE 10100
RUN javac Main.java
CMD ["java","Main","-Djava.net.preferIPv4Stack=true"]