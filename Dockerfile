FROM maven:3.8.3-openjdk-17

WORKDIR /app
COPY . /app
EXPOSE 8080

CMD [ "mvn","spring-boot:run" ]

#WORKDIR /app
#COPY ./target/*.jar /app/demo.jar
#RUN sh -c 'touch demo.jar'
#ENTRYPOINT ["java","-jar","demo.jar"]