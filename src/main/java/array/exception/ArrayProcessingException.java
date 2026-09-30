package array.exception;

public class ArrayProcessingException extends Exception {

  private static final long serialVersionUID = 1L;

  public ArrayProcessingException() {
    super();
  }

  public ArrayProcessingException(String message) {
    super(message);
  }

  public ArrayProcessingException(String message, Throwable cause) {
    super(message, cause);
  }

  public ArrayProcessingException(Throwable cause) {
    super(cause);
  }
}
