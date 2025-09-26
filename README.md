# Deliberately Bad Ecommerce Application

This is a **deliberately flawed** Java Spring Boot application created for code review training. It contains numerous anti-patterns, security vulnerabilities, and poor coding practices.

## How to Run

```bash
mvn spring-boot:run
```

## Test the API

```bash
curl -X POST http://localhost:8080/order \
  -H "Content-Type: application/json" \
  -d '{
    "id": 1,
    "customerName": "John Doe",
    "product": "Laptop",
    "qty": 2,
    "price": 999.99,
    "comments": "Express delivery"
  }'
```

## Intentional Issues

This application contains the following deliberate flaws for training purposes:

- **SQL Injection**: Raw JDBC with string concatenation
- **Hardcoded Credentials**: Database credentials in source code
- **Global Mutable State**: Static database connection
- **No Input Validation**: No sanitization or validation
- **Poor Architecture**: Manual dependency instantiation
- **Code Quality Issues**: Inconsistent naming, duplicate code
- **No Error Handling**: Exceptions are swallowed
- **Security Vulnerabilities**: Multiple attack vectors

**DO NOT USE IN PRODUCTION!**