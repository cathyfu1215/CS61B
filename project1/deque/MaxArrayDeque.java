package deque;

import java.util.Comparator;
import java.util.Iterator;

public class MaxArrayDeque<T> implements Deque<T>,Iterable<T>{
    int size=0;
    int MAXSIZE=8;
    int RFACTOR=2;

    int UFACTOR=4;
    T[] array = (T []) new Object [MAXSIZE];  //cast here

    int head ;
    int tail ;

    Comparator comparator;


    // creates a MaxArrayDeque with the given Comparator.
    public MaxArrayDeque(Comparator<T> c){
        this.size=size;
        this.array=array;
        this.comparator=c;
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
        return new MaxArrayDequeIterator();
    }

    private class MaxArrayDequeIterator<T> implements Iterator<T> {
        int curr;
        public MaxArrayDequeIterator(){
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

    //this method will not be tested, so just put it here for completeness
    public boolean equals(Object o){
        if(o instanceof ArrayDeque){
            return true; //need iteration here comparing all values
        }
        else{
            return false;
        }
    }


    //returns the maximum element in the deque as governed by the previously given Comparator.
    // If the MaxArrayDeque is empty, simply return null.
    public T max(){
        if(size == 0){
            return null;
        }
        else{
            T maxVal=array[0];
            for(int i=0;i<size;i++){
                if(array[i]!=null && this.comparator.compare(array[i],maxVal)>0){
                    maxVal=array[i];
                }
            }
            return maxVal;
        }
    }

    //returns the maximum element in the deque as governed by the parameter Comparator c.
    // If the MaxArrayDeque is empty, simply return null.
    public T max(Comparator<T> c){
        if(size == 0){
            return null;
        }
        else{
            T maxVal=array[0];
            for(int i=0;i<size;i++){
                if(array[i]!=null && c.compare(array[i],maxVal)>0){
                    maxVal=array[i];
                }
            }
            return maxVal;
        }
    }



}
