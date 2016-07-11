package util.list;

import java.io.Serializable;

public class ArrayUnsortedList<T> implements IList<T>, Serializable{
    protected T[] list;
    protected int elementAmount = 0;
    protected int iteratorPosition = 0;
    protected boolean hasNext = false; //Used by the hasNext function for iteration
    protected int elementLocationIndex;
    protected boolean elementFound;

    public ArrayUnsortedList(){
        list = (T[]) new Object[10];
    }

    public ArrayUnsortedList(int initialSize){
        list = (T[]) new Object[initialSize];
    }

    protected void expandList(){
        if(elementAmount == list.length) {
            T[] resizedArray = (T[]) new Object[list.length * 2];
            for (int index = 0; index < elementAmount; index++) {
                resizedArray[index] = list[index];
            }
            list = resizedArray;
        }
    }

    protected void search(T elementToFind){
        elementLocationIndex = 0;
        elementFound = false;

        for(int index = 0; index < elementAmount; index++){
            if(list[index].equals(elementToFind)){
                elementLocationIndex = index;
                elementFound = true;
                return;
            }
        }
    }

    @Override
    public int size() { return elementAmount; }

    @Override
    public void add(T newElement) {
        search(newElement);
        if(elementFound)
            throw new DuplicateElementException("Element is already in the list");

        if(elementAmount == list.length)
            expandList();

        list[elementAmount] = newElement;
        elementAmount++;
    }

    @Override
    public boolean remove(T elementToRemove) {
        search(elementToRemove);

        if(elementFound){
            /** In order to fill the hole after removing an element, just
             * put set the last element to null after placing it in the
             * hole that was created*/
            list[elementLocationIndex] = list[elementAmount - 1];
            list[elementAmount - 1] = null;
            elementAmount--;
        }

        return elementFound;
    }

    @Override
    public boolean contains(T elementToFind) {
        search(elementToFind);

        return elementFound;
    }

    @Override
    public boolean isEmpty() { return (elementAmount == 0); }

    @Override
    public T get(T elementToGet) {
        search(elementToGet);

        return elementFound ? list[elementLocationIndex] : null;
    }

    @Override
    public void reset() {
        iteratorPosition = 0;
        hasNext = true;
    }

    @Override
    public T getNext() {
        T nextElement = list[iteratorPosition];

        /** If the currentIteratorIndex has reached the index of
         * the last element being held, reset the iteratorPosition
         * to 0, then return null, this null return value
         * allows any applications looping through this list
         * to know when they reached the end */
        if(iteratorPosition == (elementAmount - 1)){
            hasNext = false;
        }
        else{
            iteratorPosition++;
        }

        return nextElement;
    }

    public boolean hasNext(){ return hasNext; }

    @Override
    public String toString(){
        String representation = "";

        for(int index = 0; index < elementAmount; index++){
            representation += (list[index] + "\n");
        }

        return representation;
    }
}
