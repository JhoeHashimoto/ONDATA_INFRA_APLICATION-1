FROM node:16-alpine


RUN adduser -D appuser


WORKDIR /app


COPY ./react-native-app /app


USER appuser

EXPOSE 8081


CMD ["sh", "-c", "npm install && npm start"]
