package uk.ac.rhul.cs2800;

import java.util.ArrayList;
import java.util.List;
import uk.ac.rhul.cs2800.exception.NoGradeAvailableException;
import uk.ac.rhul.cs2800.exception.NoRegistrationException;

/**
 * Class representing student.
 */
public class Student {
  private long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  private List<Grade> grades = new ArrayList<Grade>();
  private List<Registration> registrations = new ArrayList<Registration>();
  
  /**
   * Sets the ID for this instance.
   *
   * @param newId The new ID to set.
   */
  public void setId(long newId) {
    id = newId;
  }

  /**
   * Retrieves the ID of this instance.
   *
   * @return The ID of this instance.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the first name for this instance.
   *
   * @param newFirstName The new first name to set.
   */
  public void setFirstName(String newFirstName) {
    firstName = newFirstName;
  }

  /**
   * Retrieves the first name of this instance.
   *
   * @return The first name of this instance.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets the last name for this instance.
   *
   * @param newLastName The new last name to set.
   */
  public void setLastName(String newLastName) {
    lastName = newLastName;
  }

  /**
   * Retrieves the last name of this instance.
   *
   * @return The last name of this instance.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets the username for this instance.
   *
   * @param newUserName The new username to set.
   */
  public void setUserName(String newUserName) {
    userName = newUserName;
  }

  /**
   * Retrieves the username of this instance.
   *
   * @return The username of this instance.
   */
  public String getUserName() {
    return userName;
  }

  /**
   * Sets the email for this instance.
   *
   * @param newEmail The new email to set.
   */

  public void setEmail(String newEmail) {
    email = newEmail;
  }

  /**
   * Retrieves the email of this instance.
   *
   * @return The email of this instance.
   */
  public String getEmail() {
    return email;
  }

  /**
   * adds the grade into the list of grades for the student.
   *
   * @param g grade to be added
   */
  public void addGrade(Grade g) {
    grades.add(g);
  }

  /**
   * Registers a module, m for the student.
   *
   * @param m Module to be registered to student
   */
  public void registerModule(Module m) {
    Registration registration = new Registration();
    registration.setModule(m);
    registrations.add(registration);
  }

  /**
   * Retrieves the grade for the given module.
   *
   * @param m Module for which grade to get
   * @throws NoRegistrationException thrown when no modules are registered for the student
   */
  public Grade getGrade(Module m) throws NoRegistrationException {
    int pointer = -1;
    int counter = 0;
    for (Grade g : grades) {
      if (g.getModule().equals(m)) {
        pointer = counter;
      }
      counter++;
    }
    if (pointer == -1) {
      throw new NoRegistrationException("No Registered Modules");
    } else {
      return grades.get(pointer);
    }
  }

  /**
   * computes the average grade of the student.
   *
   * @return the average of all grades for the student
   * @throws NoGradeAvailableException Exception thrown when student has no grades available,
   *         meaning no average can be calculated
   */
  public float computeAverage() throws NoGradeAvailableException {
    float average = 0;
    int counter = 0;
    if (grades.size() == 0) {
      throw new NoGradeAvailableException("Student has no Registered grades");
    }
    for (Grade g : grades) {
      average += g.getScore();
      counter++;
    }
    return average / (float) counter;
  }
}
