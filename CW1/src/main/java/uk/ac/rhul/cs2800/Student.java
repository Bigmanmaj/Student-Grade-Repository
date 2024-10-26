package uk.ac.rhul.cs2800;

public class Student {
  private long id;
  private String firstName;
  private String lastName;
  private String userName;
  private String email;
  
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

}
