package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Deque<T>,Iterable<T> {
    private int size;
    private Node sentinel;



    public LinkedListDeque(){
        this.size=size;
        this.sentinel=new Node(null,null,null);
    }

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
//    public boolean isEmpty(){return size==0;} //using the interface's default method

    public int size(){
        return size;
    }

    public void printDeque(){
        Node p=sentinel;
        int count=0;
        while(p.next != null && count<size){
            System.out.print(p.next.item+" ");
            p=p.next;
            count++;
        }
        System.out.println('\n'); //an empty line
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
        if(index<size) {
            return getRecursiveNode(index).item;
        }
        else{
            System.out.println("out of range!");
            return null;
        }
    }

    private Node getRecursiveNode(int index){
        if(index == 0){
            return sentinel.next;
        }
        else{
            return getRecursiveNode(index - 1).next;
        }
    }

    @Override
    public Iterator<T> iterator(){
        return new LinkedListDequeIterator();
    }

    private class LinkedListDequeIterator implements Iterator<T> {
        Node curr= sentinel.next;
        public boolean hasNext(){
            return curr !=null;
        }
        public T next(){
            Node temp=curr;
            curr=curr.next;
            return temp.item;
        }
    }



    public boolean equals(Object o){
        if(o instanceof LinkedListDeque) { //if they belong to the same class

            if(((LinkedListDeque<T>) o).size()!= size){ //if not of same length, no equal
                return false;
            }
            else{
                for(int index=0;index<size;index++){
                    if(get(index) != ((LinkedListDeque<T>) o).get(index)){
                        return false;
                    }
                }
                return true;
            }

        }
        else{// not belong to same class
            return false;
        }
    }


}
