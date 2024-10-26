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
}
