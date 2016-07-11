package util.list;

public interface IIndexedList<T> extends IList<T> {
    public void add(int index, T elementToAdd);

    public T set(int index, T replacementElement);

    public T get(int index);

    public int indexOf(T element);

    public T remove(int index);
}
