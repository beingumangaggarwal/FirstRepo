FROM openjdk:8-jre-alpine
ENV HTTP_PROXY "http://10.135.0.29:8080"
ENV HTTPS_PROXY "http://10.135.0.29:8080"
ENV NO_PROXY "http://10.135.0.29:8080"
ENV http_proxy "http://10.135.0.29:8080"
ENV https_proxy "http://10.135.0.29:8080"
ENV no_proxy "http://10.135.0.29:8080" 
COPY ./target/docker-spring.jar /usr/src/docker-spring/
WORKDIR /usr/src/docker-spring-boot
EXPOSE 8990
CMD ["java", "-jar", "docker-spring.jar"]