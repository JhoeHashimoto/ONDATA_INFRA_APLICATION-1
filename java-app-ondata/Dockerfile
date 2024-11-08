FROM openjdk:17-alpine


WORKDIR /app


RUN adduser -D appuser


COPY ./target/my-app.jar /app/my-app.jar


USER appuser


EXPOSE 8080


ENTRYPOINT ["java", "-jar", "/app/my-app.jar"]
