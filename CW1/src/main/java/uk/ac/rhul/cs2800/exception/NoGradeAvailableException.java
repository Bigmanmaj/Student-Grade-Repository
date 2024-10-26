package uk.ac.rhul.cs2800.exception;

/**
 * Exception thrown when the student has no grades
 */
public class NoGradeAvailableException extends Exception{
  private static final long serialVersionUID = 7240984316972856421L;

  /**
   * Constructs a new NoGradeAvailableException with the specified detail message.
   *
   * @param s The detail message explaining the reason for the exception.
   */
  public NoGradeAvailableException(String s) {
    super(s);
  }
}
