package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class StudentTest {
  @Test
  void getIdTest() {
    Student student = new Student();
    student.setId(1678);
    assertEquals(student.getId(), 1678);
  }

  @Test
  void getFirstNameTest() {
    Student student = new Student();
    student.setFirstName("Benjamin");
    assertEquals(student.getFirstName(), "Benjamin");
  }
}
