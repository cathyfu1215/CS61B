package hashmap;

import java.util.*;

/**
 *  A hash table-backed Map implementation. Provides amortized constant time
 *  access to elements via get(), remove(), and put() in the best case.
 *
 *  Assumes null keys will never be inserted, and does not resize down upon remove().
 *  @author Phoenix
 */
public class MyHashMap<K, V> implements Map61B<K, V> {


    /**
     * Protected helper class to store key/value pairs
     * The protected qualifier allows subclass access
     */
    protected class Node {
        K key;
        V value;

        Node(K k, V v) {
            key = k;
            value = v;
        }
    }

    /* Instance Variables */
    private Collection<Node>[] buckets;

    private int size=0;


    /** define a hashset to hold all keys? */
    HashSet mySet=new HashSet();



    /** default initialSize and maxLoad for constructors*/
    int defaultInitialSize=16;
    int tableActualSize=defaultInitialSize;
    double defaultMaxLoad=0.75;
    double givenMaxLoad=0;


    /** Constructors */
    public MyHashMap() {
        createTable(defaultInitialSize);
        //later during resizing, if the givenMaxLoad == 0, use defaultMaxLoad
    }

    public MyHashMap(int initialSize) {
        createTable(initialSize);
        tableActualSize=initialSize;
        //later during resizing, if the givenMaxLoad == 0, use defaultMaxLoad
    }

    /**
     * MyHashMap constructor that creates a backing array of initialSize.
     * The load factor (# items / # buckets) should always be <= loadFactor
     *
     * @param initialSize initial size of backing array
     * @param maxLoad maximum load factor
     */
    public MyHashMap(int initialSize, double maxLoad) {
        createTable(initialSize);
        givenMaxLoad=maxLoad;
        tableActualSize=initialSize;
        //later during resizing, if the givenMaxLoad == 0 , use defaultMaxLoad
    }






    /**
     * Returns a new node to be placed in a hash table bucket
     */
    private Node createNode(K key, V value) {
        return new Node(key,value);
    }

    /**
     * Returns a data structure to be a hash table bucket
     *
     * The only requirements of a hash table bucket are that we can:
     *  1. Insert items (`add` method)
     *  2. Remove items (`remove` method)
     *  3. Iterate through items (`iterator` method)
     *
     * Each of these methods is supported by java.util.Collection,
     * Most data structures in Java inherit from Collection, so we
     * can use almost any data structure as our buckets.
     *
     * Override this method to use different data structures as
     * the underlying bucket type
     *
     * BE SURE TO CALL THIS FACTORY METHOD INSTEAD OF CREATING YOUR
     * OWN BUCKET DATA STRUCTURES WITH THE NEW OPERATOR!
     */
    protected Collection<Node> createBucket() {
        //this will be overridden, so just use any structure
        return new ArrayList<>();
    }

    /**
     * Returns a table to back our hash table. As per the comment
     * above, this table can be an array of Collection objects
     *
     * BE SURE TO CALL THIS FACTORY METHOD WHEN CREATING A TABLE SO
     * THAT ALL BUCKET TYPES ARE OF JAVA.UTIL.COLLECTION
     *
     * @param tableSize the size of the table to create
     */
    private Collection<Node>[] createTable(int tableSize) {
        //in Java, you cannot create an array of parameterized type.
        //refer to lab 8 guideline

      buckets=new Collection[tableSize];

      for(int i=0;i<tableSize;i++){
          buckets[i]=createBucket();
      }
      return buckets;

    }



    @Override
    public void clear() {
        buckets=createTable(tableActualSize);
        size=0;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key)!= null;
    }

    @Override
    public V get(K key) {
        if (key != null) {
            int positiveHashcode = Math.floorMod(key.hashCode(), tableActualSize);
            for (Node node : buckets[positiveHashcode]) {
                if (node.key.equals(key)) {
                    return node.value;
                }
            }

        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(K key, V value) {

        //size will increase if no duplicates, just update the value
        if(!containsKey(key)){


            //insert the key to the hashset
            mySet.add(key);

            Node newNode=createNode(key,value);
            if(givenMaxLoad == 0 && (size+1)/tableActualSize >=defaultMaxLoad){
                tableActualSize=tableActualSize*2;
                Collection<Node>[] newBuckets=createTable(tableActualSize);
                for(int i=0;i<tableActualSize/2;i++){
                    for(Node node:buckets[i]){
                        int reCalHashcode=Math.floorMod(key.hashCode(),tableActualSize);
                        newBuckets[reCalHashcode].add(node);
                    }
                }
                int newHashCode=Math.floorMod(key.hashCode(),tableActualSize);
                newBuckets[newHashCode].add(newNode);
                buckets=newBuckets;
                size++;

            }
            else if(givenMaxLoad != 0 && (size+1)/tableActualSize >=givenMaxLoad){

                tableActualSize=tableActualSize*2;
                Collection<Node>[] newBuckets=createTable(tableActualSize);
                for(int i=0;i<tableActualSize/2;i++){
                    for(Node node:buckets[i]){
                        int reCalHashcode=Math.floorMod(key.hashCode(),tableActualSize);
                        newBuckets[reCalHashcode].add(node);
                    }
                }
                int newHashCode=Math.floorMod(key.hashCode(),tableActualSize);
                newBuckets[newHashCode].add(newNode);
                buckets=newBuckets;
                size++;

            }


            else{
                int positiveHashcode=Math.floorMod(key.hashCode(),tableActualSize);
                buckets[positiveHashcode].add(newNode);
                size++;
            }

        }
        else{
            //update the value
            int positiveHashcode=Math.floorMod(key.hashCode(),tableActualSize);
            for(Node node :buckets[positiveHashcode]){
                if(node.key.equals(key)){
                    node.value=value;
                }
            }
        }



    }


    /*  may return the keys in any order.
    * create a HashSet instance variable to hold all my keys */
    @Override
    public Set<K> keySet() {
        return mySet;
    }


    /** below two methods are not required for lab 8 */
    @Override
    public V remove(K key) {
        return (V) new UnsupportedOperationException();
    }

    @Override
    public V remove(K key, V value) {
        return (V) new UnsupportedOperationException();
    }


    /*  returns an Iterator that iterates over the stored keys.
    Both of these functions may return the keys in any order.  */
    @Override
    public Iterator<K> iterator() {
        return mySet.iterator();
    }


}