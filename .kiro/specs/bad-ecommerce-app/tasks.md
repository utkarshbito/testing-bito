# Implementation Plan

- [x] 1. Set up Maven project structure with Spring Boot dependencies
  - Create pom.xml with Spring Boot starter dependencies
  - Set up basic project directory structure with ecommerce package
  - Configure minimal application.properties file
  - _Requirements: 1.1, 1.2_

- [x] 2. Create Order entity with anti-pattern design
  - Implement Order class with all public fields (no encapsulation)
  - Use poor naming conventions and inconsistent formatting
  - Add no validation, getters, or setters
  - _Requirements: 4.1, 4.2_

- [x] 3. Implement main application class with global database state
  - Create EcommerceApp main class with Spring Boot annotation
  - Add static Connection field for global mutable database state
  - Hardcode database connection details directly in source code
  - Initialize database connection in static block with no error handling
  - _Requirements: 1.1, 3.1, 3.3, 4.3_

- [x] 4. Create OrderRepository with SQL injection vulnerabilities
  - Implement OrderRepository class with raw JDBC operations
  - Build SQL INSERT query using string concatenation with user input
  - Use the global static Connection from main class
  - Add no parameterized queries or input sanitization
  - Include duplicate code and comments in select places
  - _Requirements: 2.2, 3.2, 4.4, 4.5_

- [x] 5. Implement OrderController with poor Spring practices
  - Create REST controller with POST /order endpoint
  - Manually instantiate OrderRepository instead of using Spring DI
  - Accept order details (id, customerName, product, qty, price, comments)
  - Process requests synchronously on main thread with no async handling
  - Add no error handling, validation, or logging
  - _Requirements: 2.1, 2.4, 3.4, 4.3_

- [x] 6. Wire components together with anti-pattern dependency management
  - Manually register OrderController in main application class
  - Avoid using Spring's dependency injection annotations
  - Create tight coupling between all components
  - Ensure application compiles and runs successfully
  - _Requirements: 1.1, 3.4, 5.1, 5.2_

- [x] 7. Add final touches with code quality issues
  - Apply inconsistent formatting and naming throughout codebase
  - Add minimal duplicate comments in 2-3 strategic locations
  - Ensure no input validation or error handling exists anywhere
  - Verify all hardcoded credentials and SQL injection vulnerabilities are present
  - Test that application starts and accepts POST requests to /order endpoint
  - _Requirements: 4.2, 4.4, 4.5, 5.3_