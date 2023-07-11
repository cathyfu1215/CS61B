package bstmap;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable,V> implements Map61B {

    private int size=0;

    private BSTNode root=null;



    public class BSTNode{
        K key;
        V val;
        BSTNode left;
        BSTNode right;

        public BSTNode(K key,V val){
            this.key=key;
            this.val=val;
            this.left=null;
            this.right=null;
        }


    }
    @Override
    public void clear() {
        size=0;
        root=null;

    }

    @Override
    public boolean containsKey(Object key) {
        if(key == null){
            throw new IllegalArgumentException("key should not be null");
        }
        return treeContains(root,key);
    }

    private boolean treeContains(BSTNode treeRoot,Object key) {
        if(treeRoot == null){
            return false;
        }
        if(treeRoot.key.compareTo(key)>0){ //search left
            return treeContains(treeRoot.left,key);
        }
        else{
            if(treeRoot.key.compareTo(key)<0){ //search right
                return treeContains(treeRoot.right,key);
            }
            else{ //equals
                return true;
            }
        }


    }

    @Override
    public Object get(Object key) {
        if(key == null){
            throw new IllegalArgumentException("key should not be null");
        }

        return treeGet(root,key);

    }

    private Object treeGet(BSTNode treeRoot, Object key) {
        if(treeRoot == null){
            return null;
        }

        if(treeRoot.key.compareTo(key)>0){ //search left
             return treeGet(treeRoot.left,key);
        }
        else{
            if(treeRoot.key.compareTo(key)<0){ //search right
                return treeGet(treeRoot.right,key);
            }
            else{ //equals
                return treeRoot.val;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void put(Object key, Object value) {
        if(key == null){
            throw new IllegalArgumentException("key should not be null");
        }

        if(size ==0 ){
            root=new BSTNode((K) key, (V) value);
            size++;
        }
        else{
            BSTNode node =new BSTNode((K) key, (V) value);
            treePut(root,node);

        }

    }

    private void treePut(BSTNode treeRoot, BSTNode node) {

            if(treeRoot.key.compareTo(node.key)>0){ //put to the left
                if(treeRoot.left !=null){
                    treePut(treeRoot.left,node);
                }
                else{
                    treeRoot.left=new BSTNode(node.key, node.val);
                    size++;
                }

            }
            else{
                if(treeRoot.key.compareTo(node.key)<0){ //put to the right
                    if(treeRoot.right !=null){
                        treePut(treeRoot.right,node);
                    }
                    else{
                        treeRoot.right=new BSTNode(node.key, node.val);
                        size++;
                    }

                }
                else{ // overwrite the value
                    treeRoot.val=node.val;
                }
            }


    }


    /* will not implement these methods for lab 7 */
    @Override
    public Set keySet() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object remove(Object key, Object value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
