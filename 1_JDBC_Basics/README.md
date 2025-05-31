# JDBC 

## Description

JDBC is a Java API that enables applications to interact with relational databases using SQL queries. It provides a standard interface for connecting to databases, executing statements, and processing results. JDBC acts as a bridge between Java applications and databases, supporting operations like inserts, updates, deletes, and queries. To use JDBC, you need a database-specific driver (e.g., MySQL, PostgreSQL) and basic configurations like connection URLs, credentials, and connection pooling for better performance.


It includes the following key topics:

- DriverManager: Legacy class to manage JDBC drivers and create database connections.
- Connection: Represents a physical link to the database, enabling transaction control and statement creation.
- Statement: Executes static SQL queries (vulnerable to SQL injection).
- PreparedStatement: Precompiled parameterized SQL queries (secure and efficient).
- ResultSet: Holds tabular data returned from a query, navigable via a cursor.
- DataSource: Preferred alternative to DriverManager, supporting connection pooling and JNDI.


## Quick Start

### Prerequisites

- Java 17+ (recommended for Spring Boot 3+)
- Maven (optional, since `mvnw` is included)
- IDE: IntelliJ, Eclipse, or VS Code

### Run the Application

1. Execute the application:
- mvn clean package

- In Linux/macOS
  - cp target/mi-app.war /ruta/al/tomcat/webapps/

- In Windows
  - copy target\mi-app.war C:\ruta\al\tomcat\webapps\

- with plugin tomcat
  - mvn tomcat7:deploy  
  - mvn tomcat7:redeploy

- Init tomcat
  - In Linux/macOS
    - /ruta/al/tomcat/bin/startup.sh

  - In Windows
    - C:\ruta\al\tomcat\bin\startup.bat


2. Access the application:
   - Default URL: `http://localhost:8080/`

3. Dependencies used:
   - mysql-connector-java
   - commons-dbcp2
