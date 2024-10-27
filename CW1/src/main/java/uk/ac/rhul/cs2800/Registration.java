package uk.ac.rhul.cs2800;

/**
 * represents student being registered on a given module.
 */
public class Registration {
  private Module m;

  /**
   * registers one module to the student.
   * 
   * @param module to be registered
   */
  public Registration(Module module) {
    m = module;
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
