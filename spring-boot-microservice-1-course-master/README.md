# Microservice Course

### Endpoints

#### Save Course

```
POST /api/course HTTP/1.1
Host: localhost:3333
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
Content-Type: application/json

{
    "title": "test-course-1",
    "subtitle": "test-course-subtitle-1",
    "price": 9
}
```

#### Get Courses

````
GET /api/course HTTP/1.1
Host: localhost:3333
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````

#### Delete Course

````
DELETE /api/course/1 HTTP/1.1
Host: localhost:3333
Authorization: Basic cmFuZG9tU2VjdXJlS2V5VXNlcm5hbWUhOnJhbmRvbVNlY3VyZUtleVBhc3N3b3JkIQ==
````





























Spring Framework (35 Questions and Answers)
1.	What is the Spring Framework?
o	A comprehensive framework for enterprise Java development offering support for dependency injection, transaction management, web apps, and more.
2.	Explain Inversion of Control (IoC) and Dependency Injection (DI).
o	IoC is a principle where control of object creation is transferred to the container. DI is a pattern to inject dependencies into objects rather than having them construct themselves.
3.	What are the benefits of using Spring?
o	Loose coupling, easy testability, modular architecture, and support for various technologies like JPA, JMS, and Web.
4.	Differentiate between BeanFactory and ApplicationContext.
o	BeanFactory is the basic container; ApplicationContext extends it and adds more features like event propagation, internationalization, etc.
5.	What is the Spring IoC container?
o	The core of Spring that creates, configures, and manages beans.
6.	How does Spring manage bean scopes?
o	By using scope identifiers like singleton, prototype, request, session, etc.
7.	What are the different bean scopes in Spring?
o	Singleton, prototype, request, session, application, and websocket.
8.	How can you inject dependencies in Spring?
o	Using constructor injection, setter injection, or field injection via annotations or XML.
9.	What is the difference between constructor and setter injection?
o	Constructor injection ensures immutability and mandatory dependencies; setter injection allows optional dependencies.
10.	What is autowiring in Spring?
•	Spring's feature to automatically resolve bean dependencies.
11.	List the key modules of the Spring Framework.
•	Core, Beans, Context, AOP, Web MVC, ORM, Web Flow, Web WebSocket, and Security.
12.	What is Spring AOP?
•	Aspect-Oriented Programming to separate cross-cutting concerns like logging, security, etc.
13.	Explain the concept of Aspect, JoinPoint, Advice, and Pointcut.
•	Aspect: Module with cross-cutting logic. JoinPoint: Execution point. Advice: Action at JoinPoint. Pointcut: Predicate to match JoinPoints.
14.	What is the use of the @Aspect annotation?
•	To define a class as an Aspect in Spring AOP.
15.	How does Spring handle transactions?
•	Using the @Transactional annotation or XML configuration with PlatformTransactionManager.
16.	Difference between programmatic and declarative transaction management?
•	Programmatic is manual; declarative is configured using annotations or XML.
17.	Role of the @Transactional annotation?
•	To define the scope of a single database transaction.
18.	How does Spring MVC work?
•	Uses DispatcherServlet to handle requests and dispatch them to appropriate controllers.
19.	What is the DispatcherServlet?
•	Front controller in Spring MVC that handles all HTTP requests and responses.
20.	Explain the MVC architecture in Spring.
•	Model (data), View (UI), Controller (logic).
21.	Difference between @Component, @Controller, @Service, and @Repository?
•	@Component: Generic bean. @Controller: Web layer. @Service: Business logic. @Repository: Data access layer.
22.	How do you configure Spring beans using annotations?
•	Using annotations like @Component, @Autowired, @Qualifier, etc.
23.	Purpose of the @Qualifier annotation?
•	Used with @Autowired to avoid confusion when multiple beans of the same type exist.
24.	How can you define properties in Spring?
•	Using application.properties, application.yml or @Value annotation.
25.	Use of the @Value annotation?
•	Injects values from properties files into Spring beans.
26.	How do you handle exceptions in Spring MVC?
•	Using @ControllerAdvice and @ExceptionHandler.
27.	Role of the @ExceptionHandler annotation?
•	Handles specific exceptions thrown by controller methods.
28.	How can you validate user input in Spring MVC?
•	Using @Valid or @Validated annotations along with BindingResult.
29.	Purpose of the @InitBinder annotation?
•	Used to customize request parameter binding.
30.	How do you internationalize a Spring application?
•	By defining messageSource bean and using message.properties files.
31.	What is Spring Security?
•	A framework for securing Java applications (authentication, authorization).
32.	How does method-level security work in Spring?
•	Using annotations like @PreAuthorize, @PostAuthorize on methods.
33.	Role of the @PreAuthorize and @PostAuthorize annotations?
•	Pre-authorization before method call, post-authorization after method call.
34.	Integrating Spring with other frameworks like Hibernate?
•	By configuring a SessionFactory bean and using HibernateTransactionManager.
35.	Best practices for developing Spring applications?
•	Use proper dependency injection, follow layered architecture, use annotations over XML, enable logging and security, handle exceptions gracefully.


Spring Boot (35 Questions and Answers)
1.	What is Spring Boot?
Spring Boot is a framework built on top of the Spring Framework that simplifies the setup, development, and deployment of Spring applications. It comes with pre-configured defaults, embedded servers like Tomcat, and eliminates the need for boilerplate configuration code.
2.	How does Spring Boot differ from traditional Spring Framework?
In traditional Spring, you have to configure everything manually, like web server setup, bean configuration, and dependency setup. Spring Boot provides auto-configuration, opinionated starter dependencies, and embedded web servers, making development much faster and easier.
3.	Main features of Spring Boot?
Key features include auto-configuration, starter dependencies, embedded servlet containers, production-ready monitoring through Actuator, and minimal Spring configuration.
4.	Role of Spring Boot Starters?
Starters are dependency descriptors that bundle commonly used libraries for specific functionality. For example, spring-boot-starter-web includes Tomcat, Spring MVC, and JSON libraries.
5.	How does Spring Boot auto-configuration work?
It checks the classpath and configuration files at runtime, then automatically configures beans based on detected dependencies using @EnableAutoConfiguration.
6.	Purpose of @SpringBootApplication annotation?
This annotation combines @Configuration, @EnableAutoConfiguration, and @ComponentScan into one, streamlining application setup.
7.	How do you create a Spring Boot application?
Use Spring Initializr to generate a project structure with selected dependencies. Annotate the main class with @SpringBootApplication and run the application using main() method.
8.	What embedded servers does Spring Boot support?
Spring Boot supports embedded servers like Tomcat (default), Jetty, and Undertow to run web applications without needing an external server.
9.	How to change the default port in Spring Boot?
Set a new port in application.properties using server.port=8081 or any custom port.
10.	What is the application.properties file used for?
This file allows you to externalize application configuration such as database settings, server port, logging, and more.
11.	How do you externalize configuration in Spring Boot?
Using application.properties or application.yml, environment variables, or command-line arguments to keep config separate from code.
12.	Difference between application.properties and application.yml?
Both serve configuration purposes. .properties is key-value based, while .yml allows hierarchical configurations in a more readable format.
13.	How to profile different environments?
Use @Profile to define beans for specific environments and create files like application-dev.properties for environment-specific settings.
14.	Use of @ConfigurationProperties annotation?
This annotation binds external configurations to a POJO class, promoting type safety and organized configuration.
15.	How to implement custom error pages?
Create custom error HTML files under /resources/public/error/ or use an @Controller that implements ErrorController for dynamic handling.
16.	What is Spring Boot Actuator?
It's a module that helps monitor and manage Spring Boot applications via built-in REST endpoints, offering insights into app health, metrics, and more.
17.	How to monitor Spring Boot apps?
Use Actuator endpoints like /actuator/health, /actuator/metrics, /actuator/info to get runtime data about the application.
18.	Metrics provided by Spring Boot Actuator?
Actuator provides system metrics such as JVM memory usage, garbage collection, thread counts, and application-specific metrics.
19.	How to enable security in Spring Boot?
Add the spring-boot-starter-security dependency. It applies a default security configuration including basic authentication.
20.	Default security configuration?
By default, it sets up HTTP Basic authentication with a generated password shown in the console at runtime and a user named user.
21.	How do you package a Spring Boot application?
Use mvn package or gradle build to create an executable JAR or WAR that includes embedded dependencies and servers.
22.	Difference between JAR and WAR in Spring Boot?
JAR contains everything to run the app with embedded server. WAR is used when deploying to an external servlet container like Tomcat.
23.	How to deploy Spring Boot to a server?
Run a JAR using java -jar app.jar or deploy the WAR to a servlet container. No external server is needed for JARs.
24.	What is Spring Boot CLI?
A command-line tool that allows you to run Spring Boot applications written in Groovy without the need to set up a full Java project.
25.	How to use Spring Initializr?
Go to start.spring.io, choose project metadata and dependencies, then generate and download the pre-configured project.
26.	How to implement logging?
Spring Boot uses Logback by default. You can configure logging via application.properties, logback.xml, or use other logging frameworks.
27.	Logging frameworks supported by Spring Boot?
Spring Boot supports Logback (default), Log4j2, and Java Util Logging (JUL). You can customize which one to use by including the correct dependency.
28.	How to handle exceptions globally?
Use @ControllerAdvice to define a global error handler and @ExceptionHandler to manage specific exceptions.
29.	Purpose of @ControllerAdvice annotation?
It allows you to handle exceptions across all controllers in one place and apply common exception handling logic globally.
30.	How to schedule tasks in Spring Boot?
Use the @Scheduled annotation on a method and enable scheduling using @EnableScheduling in a config class.
31.	How to integrate Spring Boot with databases?
Add dependencies like spring-boot-starter-data-jpa, configure the datasource in properties file, and define entities and repositories.
32.	Role of Spring Data JPA in Spring Boot?
It simplifies data access by abstracting boilerplate CRUD operations and generating queries based on method names.
33.	How to implement RESTful web services in Spring Boot?
Use @RestController to define the class and use mappings like @GetMapping, @PostMapping to expose HTTP endpoints.
34.	Use of @RestController annotation?
It combines @Controller and @ResponseBody so that methods return JSON or XML responses by default.
35.	How to test Spring Boot applications?
Use @SpringBootTest for integration testing, MockMvc for controller testing, and tools like JUnit and Mockito for unit testing.
















Spring Data JPA (30 Questions and Answers)
Basics
1.	What is JPA?
JPA (Java Persistence API) is a specification provided by Java for object-relational mapping (ORM). It allows developers to map Java objects (entities) to database tables using annotations or XML, making database interactions more intuitive and less error-prone.
2.	How does Spring Data JPA simplify database interactions?
Spring Data JPA abstracts away boilerplate code by providing ready-made interfaces such as JpaRepository or CrudRepository. It auto-generates queries based on method names and allows easy creation of custom queries using annotations like @Query.
3.	What are the main components of JPA?
o	Entity: Java class mapped to a table
o	EntityManager: Interface to manage persistence operations
o	Persistence Unit: Configuration for persistence (persistence.xml)
o	Annotations: For mapping and behavior (@Entity, @Id, @OneToMany, etc.)
4.	What is an Entity in JPA?
An Entity is a lightweight, persistent domain object. It is typically a POJO (Plain Old Java Object) class annotated with @Entity, representing a table in the database.
5.	How do you define a primary key in JPA?
Use the @Id annotation on a field to mark it as the primary key. You can also use @GeneratedValue to auto-generate values (like auto-increment IDs).
6.	What is the purpose of the @Entity annotation?
@Entity tells JPA that the class is a database entity and should be mapped to a table. Without this annotation, JPA will ignore the class.
7.	How do you map relationships in JPA?
Using relationship annotations:
o	@OneToOne
o	@OneToMany
o	@ManyToOne
o	@ManyToMany
These annotations define how one entity relates to others and how foreign keys should be handled.
8.	What is the difference between @OneToOne, @OneToMany, @ManyToOne, and @ManyToMany?
o	@OneToOne: One entity instance is related to exactly one of another entity.
o	@OneToMany: One entity is related to many others.
o	@ManyToOne: Many instances of an entity are related to one of another.
o	@ManyToMany: Many-to-many relationship between two entities.
9.	How do you fetch data lazily and eagerly in JPA?
o	Lazy: Data is fetched only when accessed (FetchType.LAZY) – improves performance.
o	Eager: Related entities are loaded immediately (FetchType.EAGER) – simpler but can be inefficient.
10.	What is the N+1 select problem in JPA?
When a collection is lazily fetched in a loop, JPA issues one query for the parent entity and N queries for each child, causing performance issues. This is solved using JOIN FETCH or entity graphs.
________________________________________
Repositories and Queries
11.	What is the role of the CrudRepository interface?
CrudRepository provides CRUD operations like save(), findById(), findAll(), and delete(). It reduces boilerplate code for basic database access.
12.	How does JpaRepository differ from CrudRepository?
JpaRepository extends CrudRepository and adds extra JPA-specific features like pagination (findAll(Pageable p)), sorting, and batch operations.
13.	How do you define custom query methods in Spring Data JPA?
Simply declare methods using naming conventions like findByUsername, findByEmailAndStatus, etc., and Spring generates the query automatically.
14.	What is the purpose of the @Query annotation?
It allows you to define JPQL or native SQL queries inside repository methods. Useful when method names are not enough or complex queries are needed.
15.	How can you execute native SQL queries in Spring Data JPA?
Use @Query with nativeQuery = true, e.g.
java
CopyEdit
@Query(value = "SELECT * FROM users WHERE status = ?1", nativeQuery = true)
List<User> findUsersByStatus(String status);
16.	What is the use of the @NamedQuery annotation?
It defines static queries in entity classes with a name and JPQL string. These can be reused across the application.
17.	How do you paginate query results in Spring Data JPA?
Use the Pageable interface in repository methods:
java
CopyEdit
Page<User> findByStatus(String status, Pageable pageable);
18.	What is the role of the Pageable interface?
It encapsulates pagination and sorting information like page number, size, and sorting direction. Passed to repository methods to limit results.
19.	How can you sort query results in Spring Data JPA?
By passing a Sort object to repository methods or defining it in the Pageable parameter.
20.	What is the Specification interface used for?
It provides a way to write dynamic and type-safe queries using the Criteria API. It's part of Spring Data JPA's JpaSpecificationExecutor.
________________________________________
Advanced Topics
21.	How do you handle transactions in Spring Data JPA?
Use @Transactional on service methods or classes. Spring manages opening, committing, or rolling back transactions.
22.	What is the purpose of the @Transactional annotation?
It marks a method or class to run within a database transaction. Ensures data consistency during multiple operations.
23.	How can you audit entities in Spring Data JPA?
Use @CreatedDate, @LastModifiedDate, @CreatedBy, and @LastModifiedBy with @EntityListeners(AuditingEntityListener.class).
24.	What is optimistic locking in JPA?
A strategy to prevent conflicts by using a version number. Updates fail if the version has changed since read.
25.	How do you implement optimistic locking in JPA?
Add a @Version field to the entity. JPA will handle versioning automatically.
26.	What is pessimistic locking in JPA?
A locking strategy that locks the database row for reading or writing to avoid concurrent modification by others.
27.	How do you implement pessimistic locking in JPA?
Use @Lock(LockModeType.PESSIMISTIC_WRITE) on repository methods.
28.	How can you batch insert or update entities in JPA?
Use EntityManager for batch operations, disable auto-flush, and commit in chunks. Also, set hibernate.jdbc.batch_size.
29.	What are the best practices for using Spring Data JPA?
o	Use JpaRepository for ease
o	Avoid N+1 issues
o	Use DTOs for projections
o	Prefer native queries only when necessary
o	Manage transactions properly
o	Enable SQL logging in dev
30.	How do you handle exceptions in Spring Data JPA?
Catch exceptions like DataIntegrityViolationException, use @ControllerAdvice for global handling, and wrap low-level exceptions in custom ones for clarity.

Basic MySQL Questions
1.	What is MySQL?
MySQL is an open-source relational database management system (RDBMS) that uses SQL (Structured Query Language) for managing data in a structured way.
2.	What are the data types in MySQL?
o	Numeric: INT, FLOAT, DOUBLE
o	Date/Time: DATE, TIME, DATETIME
o	String: VARCHAR, CHAR, TEXT
3.	What is a primary key?
A column or combination of columns that uniquely identifies each row in a table. It cannot have NULL or duplicate values.
4.	What is a foreign key?
A foreign key links two tables by referring to the primary key in another table to maintain referential integrity.
5.	What is the difference between WHERE and HAVING?
o	WHERE is used to filter rows before grouping.
o	HAVING is used to filter groups after aggregation.
6.	What are JOINS in MySQL?
o	INNER JOIN: Returns only matching rows.
o	LEFT JOIN: All rows from the left table + matching rows from the right.
o	RIGHT JOIN: All rows from the right table + matching rows from the left.
o	FULL JOIN: All rows from both tables (not directly supported in MySQL; simulated with UNION).
7.	What is normalization?
Process of organizing data to reduce redundancy and improve data integrity.
Common forms:
o	1NF: Atomic values
o	2NF: No partial dependency
o	3NF: No transitive dependency
8.	What is denormalization?
Adding redundancy for better performance during read-heavy operations.
9.	Difference between DELETE, TRUNCATE, and DROP?
o	DELETE: Deletes selected rows (can use WHERE).
o	TRUNCATE: Removes all rows quickly, no WHERE clause.
o	DROP: Deletes the table structure entirely.
10.	What is an index?
A performance optimization structure that helps in faster search and retrieval operations.
________________________________________
🔧 Intermediate-Level Questions
11.	What are views?
A view is a virtual table based on the result of a SQL query. It does not store data physically.
12.	What is a stored procedure?
A group of SQL statements that can be saved and reused. Example:
CREATE PROCEDURE getCourses()
BEGIN
  SELECT * FROM courses;
END;
13.	What is a trigger?
A database object that automatically executes code in response to certain events on a table (like INSERT, UPDATE, DELETE).
14.	What is a transaction?
A sequence of SQL operations that are executed as a single unit of work. It ensures ACID properties.
15.	Explain ACID properties.
o	Atomicity: All or none of the operations succeed.
o	Consistency: Data remains valid before and after the transaction.
o	Isolation: Transactions do not affect each other.
o	Durability: Once committed, data is saved permanently.
16.	What is the difference between CHAR and VARCHAR?
o	CHAR(n): Fixed length. Always uses n bytes.
o	VARCHAR(n): Variable length. Uses space as needed.
17.	How can you improve MySQL query performance?
o	Use indexes.
o	Avoid SELECT *.
o	Use EXPLAIN to analyze queries.
o	Limit the number of joins.
o	Optimize table structure.
18.	What is the difference between MyISAM and InnoDB?
o	InnoDB: Supports transactions, foreign keys, row-level locking.
o	MyISAM: Faster for read-heavy tasks, no transaction support.
19.	How do you handle NULL values in SQL?
Use IS NULL or IS NOT NULL. You can also use IFNULL() or COALESCE() for replacement.
20.	What is the difference between UNION and UNION ALL?
o	UNION: Removes duplicate rows.
o	UNION ALL: Keeps duplicates.

Advanced SQL and Real-World Scenarios
21.	What is a composite primary key?
A primary key made up of more than one column. Example: a combination of student_id and course_id in a registration table.
22.	What is a subquery?
A query inside another query.
Example:
SELECT name FROM students 
WHERE id IN (SELECT student_id FROM scores WHERE score > 80);
23.	What is a correlated subquery?
A subquery that uses values from the outer query. It runs once for each row of the outer query.
24.	How do you get the second highest salary?
SELECT MAX(salary) 
FROM employees 
WHERE salary < (SELECT MAX(salary) FROM employees);
25.	How do you find duplicate rows in a table?
SELECT name, COUNT(*) 
FROM students 
GROUP BY name 
HAVING COUNT(*) > 1;
26.	What are aggregate functions?
Functions that operate on a set of values and return a single value. Examples:
•	SUM(), AVG(), COUNT(), MIN(), MAX()
27.	What is the difference between GROUP BY and ORDER BY?
•	GROUP BY: Groups rows with the same values. Often used with aggregate functions.
•	ORDER BY: Sorts rows in ascending or descending order.
28.	How can you update data in one table based on another?
UPDATE employees e 
JOIN departments d ON e.dept_id = d.id 
SET e.salary = e.salary * 1.10 
WHERE d.name = 'Engineering';
29.	What is the LIMIT clause used for?
Limits the number of rows returned.
SELECT * FROM courses LIMIT 5;
30.	How do you select a range of data (like top 3 to 7 rows)?
SELECT * FROM courses LIMIT 3, 5;
________________________________________
🔐 Security and Maintenance
31.	How do you prevent SQL Injection in MySQL?
•	Use prepared statements.
•	Validate and sanitize input.
•	Use ORM frameworks like Spring Data JPA.
32.	What is a prepared statement?
A precompiled SQL statement with placeholders (?) for parameters. Improves performance and security.
33.	How do you back up a MySQL database?
Use mysqldump:
mysqldump -u root -p dbname > backup.sql
34.	How do you restore a MySQL database from a backup?
mysql -u root -p dbname < backup.sql
35.	How do you check current database size?
SELECT table_schema AS "Database", 
       ROUND(SUM(data_length + index_length)/1024/1024, 2) AS "Size (MB)" 
FROM information_schema.tables 
GROUP BY table_schema;
36.	What is a stored function in MySQL?
Similar to stored procedures but returns a single value.
Example:
CREATE FUNCTION totalPrice(qty INT, price DECIMAL(10,2))
RETURNS DECIMAL(10,2)
RETURN qty * price;
37.	What are constraints in MySQL?
Rules enforced on table columns.
Types:
•	NOT NULL, UNIQUE, PRIMARY KEY, FOREIGN KEY, CHECK, DEFAULT
38.	How do you rename a table or column?
•	Rename table:
RENAME TABLE old_name TO new_name;
•	Rename column:
ALTER TABLE table_name RENAME COLUMN old_col TO new_col;
39.	How to add a new column to an existing table?
ALTER TABLE students ADD email VARCHAR(100);
40.	What is the INFORMATION_SCHEMA in MySQL?
A virtual database that provides metadata about the database structure — like tables, columns, and users.



COURSE MICROSERVICE WORKFLOW
1. Workflow Explanation of Course Microservice
High-level flow:
1.	Client sends HTTP requests to Course microservice endpoints exposed by CourseController.
2.	For example, when adding a course:
o	Client sends a POST request with course details and a thumbnail image (multipart/form-data) to /api/course/add.
3.	CourseController receives the request and calls the CourseService.saveCourse(...) method.
4.	CourseServiceImpl calls ImageUploadService.upload() to upload the image to Cloudinary (a cloud image hosting service).
5.	The uploaded image URL from Cloudinary is returned and saved into the Course entity.
6.	The Course entity with all details, including the image URL, is saved to the database via CourseRepository.
7.	For fetching courses or deleting a course, CourseController calls respective service methods which interact with the database.
8.	AOP logging aspect logs entry, exit, and exceptions of service layer methods for better traceability.
________________________________________
2. Possible Viva Questions with Answers
Q1: Explain the architecture and flow of the Course microservice.
Answer:
•	The Course microservice follows a typical layered architecture with Controller, Service, and Repository layers.
•	Client sends REST API calls to CourseController.
•	CourseController validates input and delegates business logic to CourseService.
•	CourseServiceImpl handles course creation, fetching, and deletion.
•	For image handling, it delegates to ImageUploadService which uses the Cloudinary SDK to upload the image and get a URL.
•	The course details including the image URL are stored in the database via CourseRepository which extends JpaRepository.
•	The microservice also uses AOP for logging all service method calls for better monitoring and debugging.
•	Security is managed via Spring Security with basic in-memory authentication configured in SecurityConfig.
•	The microservice exposes endpoints like /api/course/add (POST), /api/course (GET), and /api/course/{id} (DELETE).
________________________________________
Q2: How is the thumbnail image handled in the Course microservice?
Answer:
•	The thumbnail image is uploaded by the client as a multipart file.
•	The controller accepts the image as a MultipartFile.
•	This file is sent to the ImageUploadService.upload() method.
•	Inside ImageUploadService, the Cloudinary SDK uploads the image to the Cloudinary cloud.
•	Cloudinary returns a secure URL for the uploaded image.
•	This URL is saved as a string field thumbnailUrl in the Course entity.
•	This design decouples image storage from the microservice and leverages a dedicated cloud storage solution.
________________________________________
Q3: What is the role of the CourseRepository interface?
Answer:
•	CourseRepository extends Spring Data JPA’s JpaRepository, providing CRUD methods.
•	It abstracts database operations on the Course entity.
•	We do not need to write boilerplate SQL or queries.
•	It allows operations like findAll(), save(), and deleteById() to interact with the underlying database.
•	This promotes clean separation of concerns and simplifies persistence logic.
________________________________________
Q4: How do you handle errors during image upload?
Answer:
•	The saveCourse method in CourseServiceImpl throws IOException if the upload fails.
•	In the CourseController, this exception is caught.
•	On failure, the controller responds with HTTP 500 Internal Server Error and a meaningful message like "Failed to upload thumbnail".
•	This ensures that errors are gracefully handled and clients get proper feedback.
________________________________________
Q5: What is the purpose of the AOP logging aspect in your microservice?
Answer:
•	The LoggingAspect uses Spring AOP to log method entry, exit, arguments, and exceptions for service layer methods.
•	This helps track method calls without polluting business logic with logging code.
•	It improves observability, making it easier to debug and monitor the microservice in production.
•	The logs include method signatures, input parameters, return values, and exceptions if any occur.
•	It’s a cross-cutting concern implemented cleanly via aspects.
________________________________________
Q6: Explain your security setup.
Answer:
•	The microservice uses Spring Security with an in-memory user configured via SecurityConfig.
•	Credentials (username and password) are injected from application properties.
•	Passwords are stored encoded using BCryptPasswordEncoder.
•	The security configuration disables CSRF for ease of testing.
•	It ensures that only authorized users can access secured endpoints (like adding or deleting courses).
•	This is a simple approach suitable for demonstration or internal use.
________________________________________
Q7: How did you write unit tests for your service and controller?
Answer:
•	Used JUnit 5 and Mockito for unit tests.
•	Service tests mock dependencies like CourseRepository and ImageUploadService.
•	MockMultipartFile is used to simulate image upload in tests.
•	Verified that service methods return expected data and handle operations correctly.
•	Controller tests use MockMvc to simulate HTTP requests and verify responses.
•	Mocked service layer in controller tests to isolate controller behavior.
•	Tests cover typical scenarios: adding courses, fetching all courses, deleting a course.
•	This ensures correctness and regression safety.
________________________________________
Q8: How does the saveCourse method work?
Answer:
•	It receives course details plus a thumbnail file.
•	Calls ImageUploadService.upload(thumbnail) to upload the image to Cloudinary.
•	Receives image URL from Cloudinary.
•	Creates a new Course object and sets all fields including image URL.
•	Sets the current timestamp for creation time.
•	Saves the course object to the database using CourseRepository.save().
•	Returns the saved course object, which includes the generated ID.
________________________________________
Q9: Why use Cloudinary instead of storing images locally?
Answer:
•	Cloudinary is a cloud-based image management service.
•	Benefits:
o	Handles storage, CDN, image transformations, and delivery optimized for web.
o	Scales automatically with traffic.
o	Offloads storage from your microservice infrastructure.
o	Simplifies backend logic by avoiding manual file storage.
•	Local storage may cause problems with scaling, backups, and deployment consistency.
________________________________________
Q10: What are the annotations used in your Course entity and why?
Answer:
•	@Entity to mark the class as a JPA entity mapped to a database table.
•	@Table(name = "course") to specify the exact table name.
•	@Id and @GeneratedValue to define primary key with auto-increment.
•	@Column to specify column properties like length, nullable, and name.
•	@Data (Lombok) to generate getters, setters, and other boilerplate code automatically.
•	These help in ORM mapping and simplify entity definition.

