FROM clojure:openjdk-11-lein-slim-buster AS BUILD
RUN apt-get update; apt-get install nodejs npm -y;
COPY . /code
WORKDIR /code
RUN lein uberjar

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=BUILD /code/target/uberjar/skidskytte.jar ./app.jar
CMD ["java", "-jar", "app.jar"]
EXPOSE 3000

