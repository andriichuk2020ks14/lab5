FROM openjdk:11
FROM maven:3.8.6
ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve
ADD src /tmp/build/src
RUN cd /tmp/build && cd / && rm -rf /tmp/build
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app"]