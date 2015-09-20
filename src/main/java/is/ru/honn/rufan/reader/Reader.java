package is.ru.honn.rufan.reader;

public interface Reader
{
    public Object read();
    public Object parse(String content);
    public void setURI(String URI);
    public void setReadHandler(ReadHandler readHandler);
}
