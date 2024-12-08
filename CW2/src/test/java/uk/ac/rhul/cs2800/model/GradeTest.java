package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GradeTest {
  @Test
  void getScoreTest() {
    // Test 6
    Grade grade = new Grade();
    grade.setScore(5);
  }

  @Test
  void getStudentTest() {
    // Test 19
    Grade grade = new Grade();
    Student student = new Student();
    student.setId(1);
    grade.setStudent(student);
    assertEquals(grade.getStudent(), student);
  }
}
