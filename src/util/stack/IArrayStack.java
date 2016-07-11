package util.stack;

public interface IArrayStack<T> extends IStack<T> {
    public boolean isFull();

    public void push(T element);
}
