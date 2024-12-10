package uk.ac.rhul.cs2800.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uk.ac.rhul.cs2800.model.Grade;
import uk.ac.rhul.cs2800.model.Module;
import uk.ac.rhul.cs2800.model.Student;
import uk.ac.rhul.cs2800.repository.GradeRepository;
import uk.ac.rhul.cs2800.repository.ModuleRepository;
import uk.ac.rhul.cs2800.repository.StudentRepository;

/**
 * A rest controller handling Grades.
 */
@RestController
public class GradeController {
  private final GradeRepository gradeRepository;
  private final ModuleRepository moduleRepository;
  private final StudentRepository studentRepository;

  /**
   * Constructor for GradeController class, called automatically by spring.
   *
   * @param gradeRepository gradeRepository object
   * @param moduleRepository moduleRepository object
   * @param studentRepository studentRepository object
   */
  public GradeController(GradeRepository gradeRepository, ModuleRepository moduleRepository,
      StudentRepository studentRepository) {
    this.gradeRepository = gradeRepository;
    this.moduleRepository = moduleRepository;
    this.studentRepository = studentRepository;
  }

  /**
   * addGrade POST handler.
   *
   * @param params should contain "student_id", "code", "score"
   * @return Successfully saved Grade object or exception
   */
  @PostMapping(value = "/grades/addGrade")
  public ResponseEntity<Grade> addGrade(@RequestBody Map<String, String> params) {
    // Find the student by using student_id
    // Find the module by using the module_code
    // Create a Grade object and set all values
    // Save the Grade object.
    // Return the saved Grade object.
    Student student =
        studentRepository.findById(Long.valueOf(params.get("student_id"))).orElseThrow();
    Module module = moduleRepository.findById(params.get("module_code")).orElseThrow();
    Grade grade = new Grade();
    grade.setModule(module);
    grade.setStudent(student);
    grade.setScore(Integer.valueOf(params.get("score")));
    grade = gradeRepository.save(grade);
    return ResponseEntity.ok(grade);
  }
}
