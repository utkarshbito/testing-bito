# Design Document

## Overview

This design outlines a deliberately flawed Java Spring Boot ecommerce application that demonstrates multiple anti-patterns, security vulnerabilities, and poor coding practices. The application will serve as a training ground for automated code review agents to detect and flag common issues found in real-world codebases.

## Architecture

The application follows a poor architectural pattern with tight coupling, global state, and manual dependency management:

```
┌─────────────────┐
│   EcommerceApp  │ ← Main Spring Boot Application
│   (Static DB)   │
└─────────────────┘
         │
         ▼
┌─────────────────┐
│ OrderController │ ← REST Controller (manually instantiated)
│  (No DI used)   │
└─────────────────┘
         │
         ▼
┌─────────────────┐
│ OrderRepository │ ← Data Access (raw JDBC, SQL injection)
│ (Global state)  │
└─────────────────┘
         │
         ▼
┌─────────────────┐
│   Order Entity  │ ← Plain class with public fields
│ (No validation) │
└─────────────────┘
```

## Components and Interfaces

### 1. Main Application Class (EcommerceApp)
- **Anti-pattern**: Stores static database Connection
- **Issues**: Global mutable state, hardcoded DB credentials
- **Location**: `src/main/java/ecommerce/EcommerceApp.java`

### 2. Order Entity (Order)
- **Anti-pattern**: Public fields, no encapsulation
- **Issues**: No validation, no getters/setters, poor naming
- **Location**: `src/main/java/ecommerce/Order.java`

### 3. Order Controller (OrderController)
- **Anti-pattern**: Manual instantiation instead of Spring DI
- **Issues**: No error handling, blocking operations, poor naming
- **Location**: `src/main/java/ecommerce/OrderController.java`

### 4. Order Repository (OrderRepository)
- **Anti-pattern**: Raw JDBC with string concatenation
- **Issues**: SQL injection vulnerability, no connection pooling
- **Location**: `src/main/java/ecommerce/OrderRepository.java`

## Data Models

### Order Entity Structure
```java
public class Order {
    public int id;           // Poor: public field
    public String customerName;  // Poor: no validation
    public String product;   // Poor: inconsistent naming
    public int qty;         // Poor: abbreviated name
    public double price;    // Poor: no validation
    public String comments; // Poor: no sanitization
}
```

### Database Schema
```sql
CREATE TABLE orders (
    id INT PRIMARY KEY,
    customer_name VARCHAR(255),
    product VARCHAR(255),
    qty INT,
    price DECIMAL(10,2),
    comments TEXT
);
```

## Error Handling

**Deliberate Anti-pattern**: No error handling implemented
- No try-catch blocks
- No input validation
- No HTTP status code management
- No logging of errors
- Database exceptions propagate to client

## Testing Strategy

**Deliberate Anti-pattern**: No testing strategy
- No unit tests
- No integration tests
- No validation tests
- No security tests

## Security Vulnerabilities

### 1. SQL Injection
- Raw JDBC with string concatenation
- No parameterized queries
- Direct user input in SQL statements

### 2. Hardcoded Credentials
- Database URL, username, password in source code
- No environment variable usage
- No configuration externalization

### 3. No Input Validation
- No sanitization of user input
- No data type validation
- No business rule validation

## Code Quality Issues

### 1. Poor Naming Conventions
- Inconsistent variable naming (camelCase vs snake_case)
- Abbreviated names (qty instead of quantity)
- Non-descriptive method names

### 2. Formatting Issues
- Inconsistent indentation
- Mixed spacing styles
- Inconsistent bracket placement

### 3. Duplicate Code
- Repeated database connection logic
- Duplicate comments
- Redundant variable declarations

### 4. Global State
- Static database connection
- Shared mutable state across requests
- Thread safety issues

## Implementation Details

### Project Structure
```
ecommerce/
├── src/main/java/ecommerce/
│   ├── EcommerceApp.java      (Main + DB connection)
│   ├── Order.java             (Entity with public fields)
│   ├── OrderController.java   (REST endpoint)
│   └── OrderRepository.java   (Raw JDBC)
├── src/main/resources/
│   └── application.properties (Minimal config)
└── pom.xml                    (Maven dependencies)
```

### Key Anti-patterns to Implement
1. **Static database connection** in main class
2. **Manual controller instantiation** instead of Spring DI
3. **String concatenation** for SQL queries
4. **Public entity fields** without validation
5. **Hardcoded credentials** in source code
6. **No error handling** anywhere
7. **Blocking synchronous** operations
8. **Duplicate code** and comments
9. **Poor naming** and formatting
10. **No logging** or monitoring