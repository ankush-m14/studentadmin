Student Management System with JWT Authentication
This is a Spring Boot project for managing students and subjects with JWT (JSON Web Token) authentication. The project demonstrates basic CRUD operations and secure REST API access using JWT.

Prerequisites
Java JDK 21
Maven or Gradle
IntelliJ IDEA or any other IDE

Project Setup
1. Clone the Repository
   Clone the project repository to your local machine


2. Open the Project in IntelliJ IDEA
   Open IntelliJ IDEA.
   Select File -> Open and choose the project directory you just cloned.
   IntelliJ IDEA will import the Maven/Gradle project and download the necessary dependencies.
3. Configure the Database
   The project uses an H2 in-memory database for simplicity. You can configure other databases by updating the application.properties file.

application.properties

properties
Copy code
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
4. Add JWT Secret Key
   Update the JwtUtil class with your secret key. For development, it’s stored in plain text.

JwtUtil.java

java
Copy code
private String secretKey = "your_secret_key"; // Replace with your actual secret key
5. Build the Project
   Using Maven:

Open the terminal in IntelliJ IDEA and run:

bash
Copy code
mvn clean install
Using Gradle:

Open the terminal in IntelliJ IDEA and run:

bash
Copy code
./gradlew build
6. Run the Application
   You can run the application from IntelliJ IDEA by following these steps:

Locate the StudentAppApplication.java file in the src/main/java/com/example/studentapp directory.
Right-click the file and select Run 'StudentAppApplication'.
Alternatively, you can run the application from the terminal


7. Test the Application
   Generate a JWT Token

Send a POST request to /auth/login with the following parameters:

username: the username
password: the password
Example cURL Request:

bash
Copy code
curl -X POST "http://localhost:8080/auth/login" -d "username=user&password=password"
Use the JWT Token

Include the JWT token in the Authorization header for accessing protected endpoints.

Example cURL Request:

bash
Copy code
curl -H "Authorization: Bearer <your_jwt_token>" "http://localhost:8080/students"

8. Project Structure
   src/main/java/com/example/studentapp
   StudentAppApplication.java: Main application entry point.
   config/SecurityConfig.java: Security configuration for JWT.
   controller/StudentController.java: REST controller for students.
   entity/Student.java: Student entity.
   entity/Subject.java: Subject entity.
   filter/JwtAuthenticationFilter.java: JWT authentication filter.
   repository/StudentRepository.java: Repository for Student entity.
   repository/SubjectRepository.java: Repository for Subject entity.
   service/StudentService.java: Service interface for students.
   service/StudentServiceImpl.java: Service implementation for students.
   service/UserDetailsServiceImpl.java: User details service implementation.
   util/JwtUtil.java: Utility class for JWT operations.


9. Additional Information
    For production, ensure that you use a strong secret key and properly configure the JWT expiration and validation settings.
    Secure the application with HTTPS and consider additional security measures as necessary.