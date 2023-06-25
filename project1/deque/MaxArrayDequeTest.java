package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {



    Comparator<Integer> c1=new Comparator<Integer>() {
          //from larger to smaller
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2){
                return -1;
            }
            else{
                if(o1>o2){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    };

    Comparator<Integer> c2=new Comparator<Integer>() {
        //from smaller to larger
        @Override
        public int compare(Integer o1, Integer o2) {
            if(o1<o2){
                return 1;
            }
            else{
                if(o1>o2){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    };

    /*
    * The Java String class compareTo() method compares the given string with the current string lexicographically.
    * It returns a positive number, negative number, or 0.
    * It compares strings on the basis of the Unicode value of each character in the strings.
    * If the first string is lexicographically greater than the second string,
    * it returns a positive number (difference of character value).
    * If the first string is less than the second string lexicographically,
    *  it returns a negative number, and if the first string is lexicographically equal to the second string,
    * it returns 0.*/
    Comparator<String> c3=new Comparator<String>() {
        //from smaller to larger
        @Override
        public int compare(String o1, String o2) {
            if(o1.compareTo(o2)<0){
                return 1;
            }
            else{
                if(o1.compareTo(o2)>0){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    };

    Comparator<String> c4=new Comparator<String>() {
        //from smaller to larger
        @Override
        public int compare(String o1, String o2) {
            if(o1.compareTo(o2)<0){
                return -1;
            }
            else{
                if(o1.compareTo(o2)>0){
                    return 1;
                }
                else{
                    return 0;
                }
            }
        }
    };
    @Test
    public void returnMaxIntegerTest() {


        MaxArrayDeque<Integer> mad1 = new MaxArrayDeque<Integer>(c1);

        mad1.addLast(10);
        mad1.addLast(9);
        mad1.addFirst(11);
        mad1.addLast(100);

        assertEquals(4,mad1.size());
        assertEquals((Object) 100, mad1.max());
        assertEquals((Object)9, mad1.max(c2));

        mad1.addLast(999);
        mad1.addFirst(1);

        assertEquals(6,mad1.size());
        assertEquals((Object) 999, mad1.max());
        assertEquals((Object)1, mad1.max(c2));

        mad1.removeLast();
        assertEquals((Object) 100, mad1.max());




    }
    @Test
    public void returnMaxStringTest() {


        MaxArrayDeque<String> mad2 = new MaxArrayDeque<String>(c3);

        mad2.addLast("bbb");
        mad2.addLast("aaa");
        mad2.addFirst("ccc");
        mad2.addLast("zzz");

        assertEquals(4,mad2.size());
        assertEquals((Object) "aaa", mad2.max());
        assertEquals((Object) "zzz", mad2.max(c4));


        mad2.addLast("eee");
        mad2.addFirst("yyy");

        assertEquals(6,mad2.size());
        assertEquals((Object) "aaa", mad2.max());
        assertEquals((Object) "zzz", mad2.max(c4));


        mad2.removeLast();
        mad2.removeLast();
        assertEquals((Object) "aaa", mad2.max());
        assertEquals((Object) "yyy", mad2.max(c4));




    }

}
