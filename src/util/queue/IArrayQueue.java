package util.queue;

public interface IArrayQueue<T> extends IQueue<T> {
    public boolean isFull();

    public void enqueue(T element) throws QueueOverflowException;
}
