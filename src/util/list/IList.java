package util.list;

public interface IList<T> {
    public int size();

    public void add(T newElement);

    public boolean remove(T elementToRemove);

    public boolean contains(T elementToFind);

    public boolean isEmpty();

    public T get(T elementToGet);

    public String toString();

    public void reset();

    public T getNext();
}
