package uk.ac.rhul.cs2800.repository;

import org.springframework.data.repository.CrudRepository;
import uk.ac.rhul.cs2800.model.Student;

/**
 * A repository which manages Students.
 */
public interface StudentRepository extends CrudRepository<Student, Long> {

}
