# Student Grade Repository

In-memory student, module, and grade model (CW1) with a Spring Boot REST API (CW2), written as CS2800 coursework at Royal Holloway.

## What it does

**CW1** is a plain Java model in `uk.ac.rhul.cs2800`, covered by JUnit 5 tests.

- A student has an id, first name, last name, username, and email. `Student` can register a module (`registerModule`), record a grade (`addGrade`), look up the grade for a module (`getGrade`), and average the recorded scores (`computeAverage`).
- A module has a code, a name, and an `mnc` flag (mandatory non-condonable).
- A grade is an integer score for one module.
- A registration links a student to a module.
- `getGrade` throws `NoRegistrationException` when the student has no grade for that module. `computeAverage` throws `NoGradeAvailableException` when the student has no grades.

**CW2** maps the same concepts onto JPA entities in `uk.ac.rhul.cs2800.model` and serves them over HTTP on port **2800**. The database is in-memory H2 (`jdbc:h2:mem:test`, PostgreSQL compatibility mode). On startup the application runs `CW2/src/main/resources/schema.sql`, which creates `student`, `module`, `grade`, and `registration`.

Spring Data REST exports `StudentRepository`, `ModuleRepository`, and `GradeRepository`. `GET /` returns HAL+JSON links to those collections. Registration is an entity and a table; only the three repositories above are top-level resources. Registering a module and computing an average stay on the Java model.

| Resource | Collection | Item | Identifier |
| --- | --- | --- | --- |
| Student | `/students` | `/students/{id}` | client-assigned numeric `id` |
| Module | `/modules` | `/modules/{code}` | `code` |
| Grade | `/grades` | `/grades/{id}` | generated numeric `id` |

Each collection supports the Spring Data REST operations for a `CrudRepository`: list (`GET`), create (`POST`), read one (`GET`), replace (`PUT`), partial update (`PATCH`), and delete (`DELETE`). `RestConfiguration` calls `exposeIdsFor` for `Student`, `Module`, and `Grade`. Student JSON includes `id`; a module's identifier is its `code`.

`GradeController` adds one custom create that looks up an existing student and module, saves a grade, and returns it:

`POST /grades/addGrade`

```json
{
  "student_id": "1",
  "module_code": "CS2800",
  "score": "81"
}
```

OpenAPI is at `/v3/api-docs`. Swagger UI is configured at `/swagger-ui.html` (that path redirects to `/swagger-ui/index.html`).

## Tech stack

- Java 17 (source and target in both `pom.xml` files; JDK 17 or newer)
- **CW1:** Maven, JUnit Jupiter 5.11.0
- **CW2:** Spring Boot 3.3.6
  - Spring Web, Spring Data JPA, Spring Data REST, Spring Security
  - H2
  - springdoc OpenAPI UI 2.0.2
  - Spring Boot DevTools (runtime, optional)

## Quality tooling

Both modules configure the same checks in Maven:

- **Checkstyle** (plugin 3.4.0) with `google_checks.xml`. `checkstyle:check` fails the build on warnings.
- **SpotBugs** (plugin 4.8.6.0) with threshold `High` (`spotbugs:check`).
- **JaCoCo** 0.8.12. The `verify` phase writes a report and requires at least 90% line coverage per package. CW2 excludes `Cw2Application` from that measurement.

The reporting section of each POM also wires Checkstyle, SpotBugs, JaCoCo, and Javadoc into the Maven site. `.gitlab-ci.yml` runs `compile`, `test`, `verify`, `checkstyle:check`, and `spotbugs:check` for both CW1 and CW2.

## Build, test, and run

Install JDK 17 or newer. CW1 uses Maven on your `PATH` (the GitLab CI jobs call `mvn`). CW2 includes the Maven Wrapper, which downloads Maven 3.9.9. Git stores `mvnw` as a normal file, so run it with `bash`.

### CW1

```bash
cd CW1
mvn test
mvn verify
mvn checkstyle:check
mvn spotbugs:check
```

### CW2

```bash
cd CW2
bash ./mvnw test
bash ./mvnw verify
bash ./mvnw checkstyle:check
bash ./mvnw spotbugs:check
bash ./mvnw spring-boot:run
```

The API listens on <http://localhost:2800>. Swagger UI: <http://localhost:2800/swagger-ui.html>.

```bash
curl -X POST http://localhost:2800/students \
  -H 'Content-Type: application/json' \
  -d '{"id":1,"firstName":"Ada","lastName":"Lovelace","username":"ada","email":"ada@example.com"}'

curl -X POST http://localhost:2800/modules \
  -H 'Content-Type: application/json' \
  -d '{"code":"CS2800","name":"Software Engineering","mnc":true}'

curl -X POST http://localhost:2800/grades/addGrade \
  -H 'Content-Type: application/json' \
  -d '{"student_id":"1","module_code":"CS2800","score":"81"}'
```

## Project structure

```text
CW1/                          Plain Java grade model and JUnit tests
  pom.xml
  src/main/java/uk/ac/rhul/cs2800/
  src/test/java/uk/ac/rhul/cs2800/
CW2/                          Spring Boot REST API
  pom.xml
  mvnw                        Maven Wrapper
  src/main/java/uk/ac/rhul/cs2800/
    config/                   Security and Spring Data REST settings
    controller/               POST /grades/addGrade
    model/                    JPA entities
    repository/               Student, Module, and Grade repositories
    exception/
  src/main/resources/
    application.properties    Port 2800 and the H2 datasource
    schema.sql
  src/test/java/uk/ac/rhul/cs2800/
.gitlab-ci.yml                Build, test, and quality-gate jobs
```

## Security note

CW2 is an in-memory coursework demo. `SecurityConfig` permits every CORS origin (`allowedOriginPatterns` is `*`, with all methods and headers) and disables CSRF. Requests are accepted without authentication.

This repository is university coursework for CS2800 at Royal Holloway.
