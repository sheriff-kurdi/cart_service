FROM openjdk:17
COPY target/cart-service-0.0.1-SNAPSHOT.jar cart-service-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/cart-service-0.0.1-SNAPSHOT.jar"]
