FROM openjdk:8
COPY ./target/classes/pawelroman7/ftech_workshop/ /tmp
WORKDIR /tmp
RUN docker build https://github.com/ghusta/docker-postgres-world-db.git -t world-db
ENTRYPOINT["java", "FtechWorkshopApplication"]