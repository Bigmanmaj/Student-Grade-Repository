package uk.ac.rhul.cs2800.exception;

/**
 * Exception thrown when a registration record is not available or not found.
 */
public class NoRegistrationException extends Exception {
  private static final long serialVersionUID = 6170059689585944581L;

  /**
   * Constructs a new NoRegistrationException with the specified detail message.
   *
   * @param s The detail message explaining the reason for the exception.
   */
  public NoRegistrationException(String s) {
    super(s);
  }
}
