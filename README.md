# Personal Expense Tracker API

## Description
This project is a RESTful API for a Personal Expense Tracker application built with Spring Boot and Java 17. It provides endpoints to create, read, update, and delete expense records.

## Technologies Used
- Java 17
- Spring Boot 3.1.5
- Maven
- Spring Data JPA
- H2 Database (for development)
- Lombok

## Project Structure

expense-tracker/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/
│ │ │ └── example/
│ │ │ └── expensetracker/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── repository/
│ │ │ ├── service/
│ │ │ └── ExpenseTrackerApplication.java
│ │ └── resources/
│ │ └── application.properties
│ └── test/
│ └── java/
├── pom.xml
└── README.md


## Build Tool: Maven
This project uses Maven as its build tool. Maven is used for:
1. Dependency Management: All project dependencies are defined in the `pom.xml` file.
2. Project Building: Maven compiles the source code, runs tests, and packages the application.
3. Project Information: Maven provides a standard way to manage project information.

The `pom.xml` file in the root directory defines the project structure, dependencies, and build configurations.

## How to Build and Run

### Prerequisites
- Java 17 JDK installed
- Maven installed

### Building the Application
1. Clone the repository:

git clone <repository-url>

cd expense-tracker


2. Build the project using Maven:

mvn clean install

This command will compile the code, run tests, and package the application into a JAR file.

### Running the Application
After building, you can run the application using:

java -jar target/expense-tracker-0.0.1-SNAPSHOT.jar

Or use Maven:

mvn spring-boot:run


The application will start, and you can access the API at `http://localhost:8080`.

## API Endpoints
- POST `/api/expenses`: Create a new expense
- GET `/api/expenses`: Get all expenses
- GET `/api/expenses/{id}`: Get an expense by ID
- PUT `/api/expenses/{id}`: Update an expense
- DELETE `/api/expenses/{id}`: Delete an expense

## Database
The application uses an H2 in-memory database for development. You can access the H2 console at `http://localhost:8080/h2-console` with the following details:
- JDBC URL: `jdbc:h2:mem:expensedb`
- Username: `sa`
- Password: (leave blank)

## Testing
You can run the tests using:

mvn test



## Additional Notes
- This is a basic setup and may need additional features like security, validation, and more comprehensive error handling for a production environment.
- The H2 database is for development purposes. For production, consider using a persistent database like PostgreSQL or MySQL.