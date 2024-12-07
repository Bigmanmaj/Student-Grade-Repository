package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Represents a module with a code name and mnc (mandatory non-condonable) status.
 */
@Entity
public class Module {
  @Id
  @Column(name = "code")
  private String code;
  @Column(name = "name")
  private String name;
  @Column(name = "mnc")
  private Boolean mnc;

  /**
   * Sets the code for this instance.
   *
   * @param newCode The new code to set.
   */
  public void setCode(String newCode) {
    code = newCode;
  }

  /**
   * Retrieves the code of this instance.
   *
   * @return The code of this instance.
   */
  public String getCode() {
    return code;
  }

  /**
   * Sets the name for this instance.
   *
   * @param newName The new name to set.
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * Retrieves the name of this instance.
   *
   * @return The name of this instance.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the MNC status for this instance.
   *
   * @param newMnc The new MNC (mandatory non-condonable) status to set.
   */
  public void setMnc(Boolean newMnc) {
    mnc = newMnc;
  }

  /**
   * Retrieves the MNC status of this instance.
   *
   * @return The MNC (mandatory non-condonable) status of this instance.
   */
  public Boolean getMnc() {
    return mnc;
  }
}
