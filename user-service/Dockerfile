FROM openjdk:17

COPY target/user_docker_app.jar  /user/app/

WORKDIR /user/app/

ENTRYPOINT ["java", "-jar", "user_docker_app.jar"]