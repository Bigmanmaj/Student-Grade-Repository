package uk.ac.rhul.cs2800.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

public class StudentTest {
  @Test
  void getIdTest() {
    // Test 1
    Student student = new Student();
    student.setId(1678);
    assertEquals(student.getId(), 1678);
  }
  @Test
  void getFirstNameTest() {
    // Test 2
    Student student = new Student();
    student.setFirstName("Benjamin");
    assertEquals(student.getFirstName(), "Benjamin");
  }

  @Test
  void getLastNameTest() {
    // Test 3
    Student student = new Student();
    student.setLastName("Jackson");
    assertEquals(student.getLastName(), "Jackson");
  }

  @Test
  void getUserNameTest() {
    // Test 4
    Student student = new Student();
    student.setUserName("JAC1678");
    assertEquals(student.getUserName(), "JAC1678");
  }

  @Test
  void getEmailTest() {
    // Test 5
    Student student = new Student();
    student.setEmail("JAC1678@AwesomeUniversity.uk");
    assertEquals(student.getEmail(), "JAC1678@AwesomeUniversity.uk");
  }

  @Test
  void getAverageTest1() {
    // Test 7
    assertThrows(NoGradeAvailableException.class, () -> {
      Student student = new Student();
      student.computeAverage();
    });
  }

  @Test
  void getAverageTest2() {
    // Test 8
    Student student = new Student();
    Grade g1 = new Grade();
    g1.setScore(10);
    student.addGrade(g1);
    try {
      assertEquals(10.0, student.computeAverage());
    } catch (NoGradeAvailableException e) {
      // TODO Auto-generated catch block
    }
  }

  @Test
  void getAverageTest3() {
    // Test 8
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
    }
  }

  @Test
  void getGradeTest1() {
    // Test 9
    assertThrows(NoRegistrationException.class, () -> {
      Student student = new Student();
      student.getGrade(new Module());
    });
  }

  @Test
  void getGradeTest2() {
    // Test 10
    Student student = new Student();
    Grade g1 = new Grade();
    Module m = new Module();
    g1.setModule(m);
    student.addGrade(g1);
    student.registerModule(m);
    try {
      assertEquals(student.getGrade(m), g1);
    } catch (NoRegistrationException e) {
      // TODO Auto-generated catch block
    }
  }

  @Test
  void getGradeTest3() {
    // Test 14
    Student student = new Student();
    Grade g1 = new Grade();
    Module m = new Module();
    Module m1 = new Module();
    m1.setCode("CS1500");
    g1.setModule(m);
    student.addGrade(g1);
    student.registerModule(m);
    try {
      assertNotEquals(student.getGrade(m1), g1);
    } catch (NoRegistrationException e) {
      // TODO Auto-generated catch block
    }
  }
}
