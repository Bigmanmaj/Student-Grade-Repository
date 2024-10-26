package uk.ac.rhul.cs2800;

/**
 * Represents a grade with an Integer score.
 */
public class Grade {
  private Integer score;
  Module module;

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
}
