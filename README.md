# Student Management System with Cache

A Spring Boot REST API project that performs CRUD operations on student records and implements Spring Cache to improve application performance by reducing unnecessary database queries.

## Features

- Create Student
- Get All Students
- Get Student By ID
- Update Student Details
- Delete Student
- Spring Cache Integration
- RESTful APIs
- Layered Architecture

## Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Spring Cache
- PostgreSQL/MySQL
- Maven
- Postman

## Cache Management

This project uses Spring Cache annotations:

- `@Cacheable` – Caches frequently accessed student data
- `@CachePut` – Updates cache after modifying student details
- `@CacheEvict` – Removes stale cache entries after delete operations

The caching mechanism helps reduce database hits and improves API response time.

## API Endpoints

| Method | Endpoint | Description |
|----------|----------|-------------|
| POST | /api/save | Create Student |
| GET | /api/students | Get All Students |
| GET | /api/student/{id} | Get Student By ID |
| PUT | /api/stud/{id} | Update Student |
| DELETE | /api/student/{id} | Delete Student |

## Project Structure

Controller Layer -> Service Layer -> Repository Layer -> Database
