package util.queue;

public interface IQueue<T> {
    public void enqueue(T element);

    public T dequeue() throws QueueUnderflowException;

    public boolean isEmpty();

    public int size();

    public String toString();
}
