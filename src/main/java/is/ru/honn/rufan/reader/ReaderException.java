package is.ru.honn.rufan.reader;

/**
 * Custom exception
 */
public class ReaderException extends Exception
{
  public ReaderException()
  {
    super();
  }

  public ReaderException(String message)
  {
    super(message);
  }

  public ReaderException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
