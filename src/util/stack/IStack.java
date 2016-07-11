package util.stack;

public interface IStack<T> {
    public T top();

    public void pop();

    public void push(T element);

    public int size();

    public boolean isEmpty();

    public String toString();
}
