# Transactions

## Description

BasicDataSource is a connection pooling implementation provided by the Apache Commons Database Connection Pooling (DBCP) library (org.apache.commons.dbcp2). It manages a pool of reusable database connections, improving application performance by avoiding the overhead of repeatedly opening/closing connections.


It includes the following key topics:

- Connection Pooling:
  - Maintains idle connections alive for reuse.
  - Limits the total number of connections to prevent database overload.

- Configuration Flexibility:
  - Supports settings like:
    - initialSize: Connections created when the pool starts.
    - maxTotal: Maximum active connections allowed.
    - maxIdle: Maximum idle connections retained.
    - minIdle: Minimum idle connections kept on standby.

- Health Checks:
  - Validates connections via validationQuery (e.g., SELECT 1).
  - Removes stale/broken connections automatically.

- Transaction Support:
  - Integrates with JDBC transactions (commit()/rollback()).

- Resource Management:
  - Automatically closes leaked connections after a timeout.


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
