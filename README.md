# HibernateStudent

A Maven-based Hibernate application that demonstrates how to map a Java `Student` entity to a MySQL database table and perform database operations using Hibernate ORM.

## 📌 Project Overview

This project is a simple **Hibernate Student Management application** developed using:

* Java
* Maven
* Hibernate ORM
* MySQL
* Jakarta Persistence API
* Eclipse IDE

The application demonstrates how to create a `Student` entity, map it to a MySQL table, insert student information into the database, retrieve the record, and update the existing student details using Hibernate.

## 🚀 Features

* Create a `Student` entity
* Map the Java entity to a MySQL table
* Configure Hibernate using `hibernate.cfg.xml`
* Connect Hibernate with MySQL
* Insert student records
* Retrieve student records
* Update student records
* Use Hibernate transactions
* Display generated SQL queries in the console
* Maven dependency management

## 🛠️ Technologies Used

| Technology              | Purpose                         |
| ----------------------- | ------------------------------- |
| Java                    | Application development         |
| Maven                   | Build and dependency management |
| Hibernate ORM           | Object-Relational Mapping       |
| MySQL                   | Database                        |
| Jakarta Persistence API | Entity mapping                  |
| Eclipse                 | Development environment         |

## 📂 Project Structure

```text
HibernateStudent
│
├── src
│   └── main
│       ├── java
│       │   └── com.student
│       │       ├── Student.java
│       │       ├── HibernateUtil.java
│       │       ├── StudentApp.java
│       │       └── StudentUpdate.java
│       │
│       └── resources
│           └── hibernate.cfg.xml
│
├── pom.xml
└── README.md
```

## 🗄️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE studentdb;
```

Select the database:

```sql
USE studentdb;
```

Create the `student` table:

```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);
```

Verify the table:

```sql
DESC student;
```

## 👨‍🎓 Student Entity

The `Student` class contains the following fields:

```text
ID
Name
Email
Course
```

The entity is mapped using Jakarta Persistence annotations:

```java
@Entity
@Table(name = "student")
public class Student {
    
    @Id
    private int id;

    private String name;
    private String email;
    private String course;
}
```

## ⚙️ Hibernate Configuration

Hibernate is configured using:

```text
src/main/resources/hibernate.cfg.xml
```

The configuration contains:

* MySQL JDBC driver
* Database URL
* MySQL username
* MySQL password
* Hibernate dialect
* SQL logging configuration
* Student entity mapping

Example:

```xml
<property name="hibernate.connection.driver_class">
    com.mysql.cj.jdbc.Driver
</property>

<property name="hibernate.connection.url">
    jdbc:mysql://localhost:3306/studentdb
</property>

<property name="hibernate.connection.username">
    root
</property>

<property name="hibernate.connection.password">
    YOUR_MYSQL_PASSWORD
</property>

<property name="hibernate.dialect">
    org.hibernate.dialect.MySQLDialect
</property>

<property name="hibernate.show_sql">
    true
</property>

<mapping class="com.student.Student"/>
```

> Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password.

## 📦 Maven Dependencies

The project uses Maven to manage Hibernate, MySQL, Jakarta Persistence, and logging dependencies.

Important dependencies include:

```xml
<dependency>
    <groupId>org.hibernate.orm</groupId>
    <artifactId>hibernate-core</artifactId>
</dependency>

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
</dependency>

<dependency>
    <groupId>jakarta.persistence</groupId>
    <artifactId>jakarta.persistence-api</artifactId>
</dependency>
```

## ▶️ How to Run in Eclipse

### 1. Clone the Repository

```bash
git clone https://github.com/personal-2007/HibernateStudent.git
```

### 2. Import into Eclipse

Open Eclipse and select:

```text
File
→ Import
→ Maven
→ Existing Maven Projects
```

Select the cloned project.

### 3. Configure MySQL

Make sure MySQL Server is running.

Create the database:

```sql
CREATE DATABASE studentdb;
```

Create the `student` table:

```sql
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    course VARCHAR(100)
);
```

### 4. Configure Database Password

Open:

```text
src/main/resources/hibernate.cfg.xml
```

Update:

```xml
<property name="hibernate.connection.password">
    YOUR_MYSQL_PASSWORD
</property>
```

### 5. Update Maven Project

In Eclipse:

```text
Right Click Project
→ Maven
→ Update Project
→ OK
```

### 6. Run the Application

Right-click:

```text
StudentApp.java
```

Select:

```text
Run As
→ Java Application
```

## ➕ Insert Student

The application creates a `Student` object:

```java
Student student = new Student(
    101,
    "Selva",
    "selva@gmail.com",
    "B.Tech IT"
);
```

The object is inserted using Hibernate:

```java
session.persist(student);
transaction.commit();
```

Expected console output:

```text
Student inserted successfully!
```

## 🔄 Update Student

The existing student can be retrieved using its ID:

```java
Student student = session.get(Student.class, 101);
```

Then the course can be updated:

```java
student.setCourse("B.Tech Computer Science");

session.merge(student);

transaction.commit();
```

Expected output:

```text
Student updated successfully!
```

## 🔍 Verify Data in MySQL

Run:

```sql
SELECT * FROM student;
```

Example result:

```text
+-----+-------+------------------+-------------------------+
| id  | name  | email            | course                  |
+-----+-------+------------------+-------------------------+
| 101 | Selva | selva@gmail.com  | B.Tech Computer Science |
+-----+-------+------------------+-------------------------+
```

## 🔄 Hibernate Workflow

```text
Student Java Object
        ↓
Hibernate Entity
        ↓
SessionFactory
        ↓
Session
        ↓
Transaction
        ↓
Hibernate ORM
        ↓
MySQL Database
        ↓
student Table
```

## 📚 Main Hibernate Operations

| Hibernate Method     | Purpose                   |
| -------------------- | ------------------------- |
| `openSession()`      | Opens a Hibernate session |
| `beginTransaction()` | Starts a transaction      |
| `persist()`          | Inserts a new entity      |
| `get()`              | Retrieves an entity       |
| `merge()`            | Updates an entity         |
| `commit()`           | Commits database changes  |
| `rollback()`         | Rolls back a transaction  |
| `close()`            | Closes the session        |

## 🎯 Learning Objectives

This project helps understand:

1. Hibernate ORM fundamentals
2. Entity-to-table mapping
3. Jakarta Persistence annotations
4. Maven project configuration
5. Hibernate Session and SessionFactory
6. Database transactions
7. CRUD operations
8. MySQL connectivity
9. Object-relational mapping
10. Updating persistent entities

## 📝 Conclusion

The **HibernateStudent** project demonstrates a basic Java application using Hibernate ORM with MySQL. It shows how a Java `Student` object can be mapped to a relational database table and how Hibernate can be used to insert, retrieve, and update database records without writing the complete SQL logic manually.

## 👨‍💻 Author

**Selva S**

GitHub:
https://github.com/personal-2007

---

⭐ If you find this project useful, consider giving the repository a star.
