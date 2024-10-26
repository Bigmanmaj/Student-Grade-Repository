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

  @Test
  void getLastNameTest() {
    Student student = new Student();
    student.setLastName("Jackson");
    assertEquals(student.getLastName(), "Jackson");
  }

  @Test
  void getUserNameTest() {
    Student student = new Student();
    student.setUserName("JAC1678");
    assertEquals(student.getUserName(), "JAC1678");
  }

  @Test
  void getEmailTest() {
    Student student = new Student();
    student.setEmail("JAC1678@AwesomeUniversity.uk");
    assertEquals(student.getEmail(), "JAC1678@AwesomeUniversity.uk");
  }
}
