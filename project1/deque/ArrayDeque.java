package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T> {

    int size=0;
    int MAXSIZE=8;
    int RFACTOR=2;
    T[] array = (T []) new Object [MAXSIZE];  //cast here

    int head ;
    int tail ;



    public ArrayDeque(){
        this.size=size;
        this.array=array;
        head = 0;
        tail = 0;

    }

    public void addFirst(T item){
        T[] doubleArray;
        if(size > MAXSIZE-1){
            doubleArray = (T[]) new Object[MAXSIZE * RFACTOR];
            doubleArray[0]=item;
            MAXSIZE=MAXSIZE*RFACTOR;

        }
        else{
            doubleArray = (T[]) new Object[MAXSIZE];
            doubleArray[0]=item;

        }
        System.arraycopy(array,0,doubleArray,1,size);
        array=doubleArray;
        head=0;
        tail++;
        size++;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast( T item ){
        if(size > MAXSIZE-1){
           T [] doubleArray = (T []) new Object [MAXSIZE*RFACTOR];
           MAXSIZE=MAXSIZE*RFACTOR;
           System.arraycopy(array,0,doubleArray,0,size);
           array=doubleArray;


        }
        array[size]=item;
        tail++;
        size++;
    }

    public void printDeque(){
        if(size == 0){
            System.out.println("empty array!");
        }
        else{
            for(T i:array){
                if(i != null) {
                    System.out.print(i.toString() + " ");
                }
            }
            System.out.println('\n');
        }
    }

    public T removeFirst(){
      if(size<1){
          return null;
      }
      else {
          T temp = array[0];
          T[] newArray = (T[]) new Object[MAXSIZE];
          System.arraycopy(array, 1, newArray, 0, size - 1);
          array = newArray;
          size--;
          tail--;
          return temp;
      }
    }

    public T removeLast(){
        if(size <1){
            return null;
        }
        T  temp=array[size-1];
        array[size]=null;
        tail--;
        size--;
        return temp;
    }

    public T get(int index){
      if(index>=size){
          return null;
      }
      else{
          return array[index];
      }
    }

    public T getRecursive(int index){  //how to get recursive here??? It doesn't make sense.

        if(index>=size){
            return null;
        }
        else{
            return array[index];
        }


    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<T> {

        int curr;
        public ArrayDequeIterator(){
            curr=head;
        }
        public boolean hasNext(){
            return curr<size;
        }
        public T next(){
            T temp=array[curr];
            curr++;
            return temp;
        }
    }

    public boolean equals(Object o){
        return false;  //implement and test this later
    }
}
