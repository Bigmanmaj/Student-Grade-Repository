package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * represents student being registered on a given module.
 */
@Entity
public class Registration {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "module_code")
  private Module module;
  
  // @ManyToOne
  // @JoinColumn(name = "student_id")
  // private long studentId;

  /**
   * registers module for student.
   *
   * @param newModule module to be registered
   */
  public void setModule(Module newModule) {
    module = newModule;
    // moduleCode = module.getCode();
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
