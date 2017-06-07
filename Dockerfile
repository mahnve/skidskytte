FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/skidskytte.jar /skidskytte/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/skidskytte/app.jar"]
