package uk.ac.rhul.cs2800;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;

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

  @Test
  void getAverageTest1() {
    assertThrows(NoGradeAvailableException.class, () -> {
      Student student = new Student();
      student.computeAverage();
    });
  }

  @Test
  void getAverageTest2() {
    Student student = new Student();
    Grade g1 = new Grade();
    g1.setScore(10);
    student.addGrade(g1);
    try {
      assertEquals(10.0, student.computeAverage());
    } catch (NoGradeAvailableException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Test
  void getAverageTest3() {
    Student student = new Student();
    Grade g1 = new Grade();
    Grade g2 = new Grade();
    g1.setScore(10);
    g2.setScore(12);
    student.addGrade(g1);
    student.addGrade(g2);
    try {
      assertEquals(11.0, student.computeAverage());
    } catch (NoGradeAvailableException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
