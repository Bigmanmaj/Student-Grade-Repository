package uk.ac.rhul.cs2800.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Represents a grade with an Integer score.
 */
@Entity
public class Grade {

  @Id
  @GeneratedValue
  Long id;

  @Column(name = "score")
  private Integer score;

  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @ManyToOne
  @JoinColumn(name = "module_code")
  private Module module;

  /**
   * Sets the score for this grade.
   *
   * @param newScore The new score to set.
   */
  public void setScore(Integer newScore) {
    score = newScore;
  }

  /**
   * Retrieves the score of this grade.
   *
   * @return The score of this grade.
   */
  public Integer getScore() {
    return score;
  }

  /**
   * set module to parameter given.
   *
   * @param setModule corresponding module
   */
  public void setModule(Module setModule) {
    module = setModule;
  }

  /**
   * retrieves corresponding module.
   *
   * @return corresponding module
   */
  public Module getModule() {
    return module;
  }

  public void setStudent(Student newStudent) {
    student = newStudent;
  }

  public Student getStudent() {
    return student;
  }
}
