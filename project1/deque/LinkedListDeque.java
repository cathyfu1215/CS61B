package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T> {
    private int size;
    private Node sentinel;

    public class Node{
        public T item;
        public Node next;
        public Node prev;

        public Node(T i, Node n,Node p) {
            this.item = i;
            this.next = n;
            this.prev = p;
        }
    }

    public LinkedListDeque(){
        size=size;
        sentinel=new Node(null,null,null);
    }


    //methods

    public void addFirst(T item){
        if(size==0){
            Node newNode=new Node(item,null,sentinel);
            sentinel.next=newNode;
            sentinel.prev=newNode;
            size++;
        }
        else{
            Node oldHead=sentinel.next;
            Node newNode=new Node(item,oldHead,sentinel);
            oldHead.prev=newNode;
            sentinel.next=newNode;
            size++;
        }
    }
    public void addLast(T item){
        if(size==0){
            Node newNode=new Node(item,null,sentinel);
            sentinel.next=newNode;
            sentinel.prev=newNode;
            size++;
        }
        else{
            Node oldButt=sentinel.prev;
            Node newNode=new Node(item,sentinel,oldButt);
            oldButt.next=newNode;
            sentinel.prev=newNode;
            size++;
        }


    }
    public boolean isEmpty(){return size==0;}

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p=sentinel;
        int count=0;
        while(p.next != null && count<size){
            System.out.println(p.next.item);
            p=p.next;
            count++;
        }
        System.out.println('\n'); //an empty line?
    }

    public T removeFirst(){
        Node first=sentinel.next;
        if(size>=1 && first != null){
            Node second=first.next;
            sentinel.next=second;
            if(second !=null){
                second.prev=sentinel;
            }
            size--;
            return first.item;
        }
        else{
            System.out.println("empty linked list, cannot remove first");
            return null;
        }
    }

    public T removeLast(){
        Node last=sentinel.prev;
        if(size>=1 && last !=null){
            Node secondLast=last.prev;
            if(secondLast != null){
                secondLast.next=sentinel;
                sentinel.prev=secondLast;

            }
            else{
                sentinel.prev=null;
                sentinel.next=null;
            }
            size--;
            return last.item;
        }
        else{
            System.out.println("empty linked list, cannot remove last");
            return null;
        }
    }

    public T get(int index){
        if(index>=size){
            System.out.println("out of range");
            return null;
        }
        else{
            int count=0;
            Node node=sentinel.next;
            while(count<index){
                node=node.next;
                count++;
            }
            return node.item;
        }
    }

    public T getRecursive(int index){
        return null;

    }

    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        T curr;
        public boolean hasNext(){
            return false;
        }
        public T next(){
            return null;
        }
    }



    public boolean equals(Object o){
        return false;
    }


}
