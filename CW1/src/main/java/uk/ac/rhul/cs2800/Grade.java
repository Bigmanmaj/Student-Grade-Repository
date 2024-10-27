package uk.ac.rhul.cs2800;

/**
 * Represents a grade with an Integer score.
 */
public class Grade {
  private Integer score;
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
}
