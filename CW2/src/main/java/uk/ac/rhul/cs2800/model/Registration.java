package uk.ac.rhul.cs2800.model;

/**
 * represents student being registered on a given module.
 */
public class Registration {
  private Module module;

  /**
   * registers module for student.
   *
   * @param newModule module to be registered
   */
  public void setModule(Module newModule) {
    module = newModule;
  }

  /**
   * returns registered module.
   *
   * @return the registered module
   */
  public Module getModule() {
    return module;
  }
}
