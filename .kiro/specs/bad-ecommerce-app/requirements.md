# Requirements Document

## Introduction

This project creates a deliberately flawed Java Spring Boot ecommerce web application designed for code review training. The application will contain numerous anti-patterns, security vulnerabilities, and poor coding practices to help train automated code review agents to detect and flag common issues in real-world codebases.

## Requirements

### Requirement 1

**User Story:** As a code review training system, I want a Spring Boot application with intentional flaws, so that automated agents can practice detecting anti-patterns and security issues.

#### Acceptance Criteria

1. WHEN the application starts THEN the system SHALL create a Spring Boot web server that compiles and runs successfully
2. WHEN the application is examined THEN the system SHALL contain multiple categories of deliberate code quality issues
3. WHEN the codebase is analyzed THEN the system SHALL demonstrate poor practices across security, architecture, and code quality dimensions

### Requirement 2

**User Story:** As a training scenario, I want a single REST API endpoint for order processing, so that the code review agent can analyze API design and implementation flaws.

#### Acceptance Criteria

1. WHEN a POST request is made to /order THEN the system SHALL accept order details including id, customerName, product, qty, price, and comments
2. WHEN order data is processed THEN the system SHALL store the information using raw JDBC with string concatenation
3. WHEN SQL queries are built THEN the system SHALL be vulnerable to SQL injection attacks
4. WHEN the endpoint is called THEN the system SHALL process requests synchronously on the main thread

### Requirement 3

**User Story:** As a security vulnerability demonstration, I want database operations with hardcoded credentials and SQL injection vulnerabilities, so that security scanning tools can detect these issues.

#### Acceptance Criteria

1. WHEN database connections are established THEN the system SHALL use hardcoded connection details in source code
2. WHEN SQL queries are constructed THEN the system SHALL use string concatenation without parameterized queries
3. WHEN database operations execute THEN the system SHALL maintain global mutable state with static Connection objects
4. WHEN data access occurs THEN the system SHALL bypass Spring's dependency injection for manual instantiation

### Requirement 4

**User Story:** As a code quality demonstration, I want poor coding practices throughout the application, so that static analysis tools can identify style and structural issues.

#### Acceptance Criteria

1. WHEN entities are defined THEN the system SHALL expose public fields without getters/setters or validation
2. WHEN code is formatted THEN the system SHALL use inconsistent naming conventions and formatting
3. WHEN errors occur THEN the system SHALL provide no error handling, validation, or logging
4. WHEN code is duplicated THEN the system SHALL contain redundant implementations and comments
5. WHEN comments are present THEN the system SHALL include minimal, duplicated, or pointless comments in select locations

### Requirement 5

**User Story:** As a maintainable codebase counter-example, I want architectural anti-patterns, so that code review agents can learn to identify structural problems.

#### Acceptance Criteria

1. WHEN Spring components are used THEN the system SHALL avoid proper dependency injection patterns
2. WHEN controllers and repositories are created THEN the system SHALL manually instantiate dependencies
3. WHEN the application structure is examined THEN the system SHALL demonstrate tight coupling and poor separation of concerns
4. WHEN the project is named THEN the system SHALL use "ecommerce" as the package and main class name (not "bad-example")