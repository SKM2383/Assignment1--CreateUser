package util;

public class LinkedListNode<T>{
    private T data;
    private LinkedListNode<T> link;

    public LinkedListNode(T nodeData){
        this.data = nodeData;
        this.link = null;
    }

    public LinkedListNode(T nodeData, LinkedListNode nextNode){
        this.data = nodeData;
        this.link = nextNode;
    }

    public void setData(T newData){
        this.data = newData;
    }

    public T getData(){
        return this.data;
    }

    public void setLink(LinkedListNode newLink){
        this.link = newLink;
    }

    public LinkedListNode getLink(){
        return this.link;
    }
}
