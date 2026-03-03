# University Management System

## 📌 Description
Backend REST API for managing students, courses, and lessons.

The system demonstrates:
- One-to-One relationship
- Many-to-Many relationship
- One-to-Many relationship
- JPA/Hibernate entity mapping
- Cascade operations
- REST controllers

---

## 🛠 Technologies
- Java 17
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

---

## 🗂 Entity Relationships

Student ↔ StudentProfile → One-to-One  
Student ↔ Course → Many-to-Many  
Course → Lesson → One-to-Many

---

## 🚀 How to Run

1. Clone repository:git clone https://github.com/zoxxonp/university-management-system.git


2. Open in IntelliJ IDEA

3. Run:

UniversityApplication.java


4. Server starts at:

http://localhost:8080


---

## 📡 API Endpoints

### Students
POST /students  
POST /students/{studentId}/courses/{courseId}  
GET /students/{id}

### Courses
POST /courses  
POST /courses/{courseId}/lessons  
GET /courses/{id}

---

## 🗄 Database
H2 in-memory database:

jdbc:h2:mem:universitydb


H2 Console:

http://localhost:8080/h2-console


---

## 🎯 Project Goal
Educational project to practice JPA relationships and REST API development.