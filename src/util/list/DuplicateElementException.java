package util.list;

public class DuplicateElementException extends RuntimeException{
    public DuplicateElementException(){ super(); }

    public DuplicateElementException(String msg){ super(msg); }
}
