FROM eclipse-temurin:17

LABEL author=frc90

ENV DATABASE_URL jdbc:mysql://mysql:3306/car-rental
ENV DATABASE_USERNAME user
ENV DATABASE_PASSWORD password
#ENV DATABASE_PLATFORM org.hibernate.dialect.MySQL57Dialect
#ENV DATABASE_DRIVER com.mysql.cj.jdbc.Driver

COPY target/car-rental-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]