package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Deque<T>,Iterable<T> {

    int size=0;
    int MAXSIZE=8;
    int RFACTOR=2;  //the multiplier used in resizing
    int UFACTOR=4;  //the divider used in resizing
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

//    public boolean isEmpty(){  //using the Deque interface's default method
//        return size == 0;
//    }

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
          T[] newArray;
          if(size-1>=MAXSIZE/UFACTOR){
              newArray = (T[]) new Object[MAXSIZE];
          }
          else{
              newArray = (T[]) new Object[MAXSIZE / UFACTOR];
          }
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
        else{
            T  temp=array[size-1];
            if(size-1>=MAXSIZE/UFACTOR){
                array[size]=null;
                tail--;
                size--;
            }
            else{
                T[] newArray = (T[]) new Object[MAXSIZE / UFACTOR];
                System.arraycopy(array, 0, newArray, 0, size - 1);
                array=newArray;
                size--;
                tail--;
            }
            return temp;
        }

    }

    public T get(int index){
      if(index>=size){
          return null;
      }
      else{
          return array[index];
      }
    }




    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator<T> implements Iterator<T> {
        int curr;
        public ArrayDequeIterator(){
            curr=head;
        }
        public boolean hasNext(){
            return curr<size;
        }
        public T next(){
            T temp= (T) array[curr];
            curr++;
            return temp;
        }
    }

    public boolean equals(Object o){
        if(o instanceof ArrayDeque) { //if they belong to the same class

            if(((ArrayDeque<T>) o).size()!= size){ //if not of same length, no equal
                return false;
            }
            else{
                for(int index=0;index<size;index++){
                    if(array[index] != ((ArrayDeque<T>) o).get(index)){
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
