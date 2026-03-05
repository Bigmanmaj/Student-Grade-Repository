# Student Grade Repository (REST API)

Backend REST API for managing **students**, **modules**, and **grades** - built as university coursework (CS2800).

This repository contains two coursework deliverables:
- **CW1**: Java/Maven project with quality tooling (tests + reporting)
- **CW2**: Spring Boot REST API (the main backend service)

---

## CW2 — Spring Boot REST API

### Tech Stack
- Java 17 :contentReference
- Spring Boot (Spring Web, Spring Data JPA, Spring Data REST)
- H2 in-memory database
- OpenAPI/Swagger UI (springdoc)
- Checkstyle, SpotBugs, JaCoCo

### What it does
- Exposes CRUD endpoints for core domain objects via **Spring Data REST** repositories (Students, Modules, Grades). :contentReference
- Provides a custom endpoint to create a Grade by referencing an existing Student + Module.
- Uses an in-memory H2 database with schema managed in `schema.sql`.
- Configures CORS permissively and disables CSRF for API-style interaction.
- Exposes entity IDs in REST responses for Student/Module/Grade.

## Getting Started (CW2)

### Prerequisites
- Java 17+
- Maven (or use the Maven Wrapper included in `CW2/`)

### Run locally
```bash
cd CW2
./mvnw spring-boot:run