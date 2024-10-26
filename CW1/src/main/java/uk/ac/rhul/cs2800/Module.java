package uk.ac.rhul.cs2800;

public class Module {
  private String code;
  private String name;
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

  public void setName(String newName) {
    name = newName;
  }

  public String getName() {
    return name;
  }

  public void setMnc(Boolean newMnc) {
    mnc = newMnc;
  }

  public Boolean getMnc() {
    return mnc;
  }
}
