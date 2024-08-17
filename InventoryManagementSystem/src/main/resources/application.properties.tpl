# Application name
spring.application.name=InventoryManagementSystem

# Database properties for PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/ims
spring.datasource.username=postgres
spring.datasource.password=test
spring.datasource.driver-class-name=org.postgresql.Driver
# JPA (Java Persistence API) properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update

# Thymeleaf configuration
spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

# Liquibase configuration
spring.liquibase.change-log=classpath:db.changelog/db.changelog-master.xml