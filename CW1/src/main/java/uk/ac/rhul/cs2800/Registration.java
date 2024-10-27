package uk.ac.rhul.cs2800;

/**
 * represents student being registered on a given module.
 */
public class Registration {
  private Module m;

  /**
   * registers module for student.
   * 
   * @param newModule module to be registered
   */
  public void setModule(Module newModule) {
    m = newModule;
  }

  /**
   * returns registered module.
   * 
   * @return the registered module
   */
  public Module getModule() {
    return m;
  }
}
