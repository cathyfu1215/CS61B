package deque;

import java.util.Iterator;

public interface Deque<T> {
    int size=0;
    public void addFirst(T item);
    public void addLast(T item);

    public default boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    };

    public int size();

    public void printDeque();

    public T removeFirst();

    public T removeLast();

    public T get(int index);

    public default Iterator<T> iterator() {
        return null;
    }

    public boolean equals(Object o);
}
