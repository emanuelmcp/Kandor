ARG BASE_IMAGE=amazoncorretto:17-alpine
FROM ${BASE_IMAGE}
RUN addgroup -S kandor && adduser -S kandor -G kandor
USER kandor:kandor
WORKDIR /home/kandor
RUN wget -O server.jar https://api.papermc.io/v2/projects/paper/versions/1.19.3/builds/368/downloads/paper-1.19.3-368.jar
ENTRYPOINT ["java","-jar","server.jar"]