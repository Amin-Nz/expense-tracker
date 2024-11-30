# Expense Tracker API Tutorial

Welcome to the Expense Tracker API! This tutorial will guide you through the setup and usage of the API for managing expenses.

## Table of Contents

1. [Introduction](#introduction)
2. [Prerequisites](#prerequisites)
3. [Getting Started](#getting-started)
4. [API Endpoints](#api-endpoints)
5. [Example Requests](#example-requests)
6. [Conclusion](#conclusion)

## Introduction

The Expense Tracker API is a simple RESTful API that allows users to manage their expenses. You can add, retrieve, update, and delete expenses using standard HTTP methods.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 17 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse) or a text editor
- Postman or any other API testing tool (optional)

## Getting Started

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/yourusername/expense-tracker.git
   cd expense-tracker

2. **Build the Project**:
Use Maven to build the project and download dependencies:

 mvn clean install

3. **Run the Application**:
Start the Spring Boot application:

 mvn spring-boot:run

The application will run on http://localhost:8080.

**API Endpoints**

1. **Get All Expenses**
Endpoint: GET /api/expenses
Description: Retrieves a list of all expenses.

2. **Get Expense by ID**

Endpoint: GET /api/expenses/{id}
Description: Retrieves a specific expense by its ID.

3. **Add a New Expense**

Endpoint: POST /api/expenses
Description: Adds a new expense.
Request Body:
    
    
    {   
        "description": "Lunch",
        "amount": 15.0,
        "category": "Food"
    }
    
4. **Update an Existing Expense**

Endpoint: PUT /api/expenses/{id}
Description: Updates an existing expense.
Request Body:

    {
        "description": "Updated Lunch",
        "amount": 20.0,
        "category": "Food"
    }

5. **Delete an Expense**
Endpoint: DELETE /api/expenses/{id}
Description: Deletes an expense by its ID.

**Example Requests**

**Get All Expenses**: 

    
     curl -X GET http://localhost:8080/api/expenses
    
**Add a New Expense**:

     
    curl -X POST http://localhost:8080/api/expenses \
    -H "Content-Type: application/json" \
    -d '{
        "description": "Lunch",
        "amount": 15.0,
        "category": "Food"
    }'
    
**Update an Existing Expense**:
    
    curl -X PUT http://localhost:8080/api/expenses/1 \
    -H "Content-Type: application/json" \
    -d '{
        "description": "Updated Lunch",
        "amount": 20.0,
        "category": "Food"
    }'
    
**Delete an Expense**:
    
    curl -X DELETE http://localhost:8080/api/expenses/1
    
**Conclusion**:
Congratulations! You have successfully set up and used the Expense Tracker API to manage your expenses. For further development, consider exploring additional features or integrating it with a frontend application.
