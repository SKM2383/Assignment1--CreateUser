package util.queue;

import util.LinkedListNode;

import java.io.Serializable;

public class LinkedListQueue<T> implements IQueue<T>, Serializable{
    private LinkedListNode head;
    private LinkedListNode tail;
    private int queueSize = 0;

    public LinkedListQueue(){
        head = null;
        tail = null;
    }

    @Override
    public void enqueue(T element) {
        // Create a new node
        LinkedListNode<T> newNode = new LinkedListNode<T>(element);

        // If the tail is null, that means the queue is empty and this is the first node being added
        if(tail == null) {
            // When the queue is empty, the head must also reference the new node
            head = newNode;
        }
        else{
            // Otherwise just link the current last node to the new node to set it at the end
            tail.setLink(newNode);
        }

        // Update the tail to point to the new node that was placed at the end of the queue
        tail = newNode;

        queueSize++;
    }

    @Override
    public T dequeue() {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is empty. Could not dequeue");
        }

        // Hold the data of the node that is about to be dereferenced
        T oldHeadData = (T) head.getData();

        // Have the head reference the next node in the queue or null is there aren't any
        head = head.getLink();

        // If the head was set to null, which means the only node was dequeued, then
        // the tail must also be set to null
        if(head == null){
            tail = null;
        }

        queueSize--;

        return oldHeadData;
    }

    @Override
    public boolean isEmpty() {
        return (head == null);
    }

    @Override
    public int size() {
        return queueSize;
    }

    private String getQueueRepresentation(LinkedListNode node){
        /**This private helper method recursively goes through this linked list
         * and extracts the String representation of its data. The recursion stops
         * when the current node link is null, meaning that node is the last element*/
        if(node.getLink() == null){
            return node.getData() + "\n";
        }
        else{
            /** By placing the concatenation in this order, the elements will be printed in the order
             * they were enqueued*/
            return (node.getData() + "\n") + getQueueRepresentation(node.getLink());
        }
    }

    @Override
    public String toString(){ return getQueueRepresentation(head); }
}
