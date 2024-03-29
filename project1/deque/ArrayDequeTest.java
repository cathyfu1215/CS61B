package deque;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test

    public void addIsEmptySizeTest() {


        ArrayDeque<String> lld1 = new ArrayDeque<String>();

        assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

        lld1.addLast("middle");
        assertEquals(2, lld1.size());

        lld1.addLast("back");
        assertEquals(3, lld1.size());

        lld1.addFirst("start");
        assertEquals(4, lld1.size());

        System.out.println("Printing out deque: ");
        lld1.printDeque();

    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {



        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
        // should be empty
        assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.removeFirst();
        // should be empty
        assertTrue("lld1 should be empty after removal", lld1.isEmpty());

        lld1.addFirst(100);
        // should not be empty
        assertFalse("lld1 should contain 1 item", lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        assertEquals(2, lld1.size());

        lld1.addFirst(10);
        // should not be empty
        assertEquals(3, lld1.size());

        lld1.removeFirst();
        assertEquals(2, lld1.size());

        lld1.removeFirst();
        assertEquals(1, lld1.size());

        lld1.removeFirst();
        assertEquals(0, lld1.size());

        lld1.removeFirst();
        assertTrue("should be empty", lld1.isEmpty());


    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {



        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);

    }

    @Test

    public void multipleParamTest() {


        ArrayDeque<String>  lld1 = new ArrayDeque<String>();
        ArrayDeque<Double>  lld2 = new ArrayDeque<Double>();
        ArrayDeque<Boolean> lld3 = new ArrayDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty ArrayDeque. */
    public void emptyNullReturnTest() {


        ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigArrayDequeTest() {


        ArrayDeque<Integer> ad1 = new ArrayDeque<Integer>();
        for (int i = 0; i < 10000; i++) {
            ad1.addLast(i);
        }

        for (double i = 0; i < 5000; i++) {
            assertEquals("Should have the same value", i, (double) ad1.removeFirst(), 0.0);
        }

        for (double i = 9999; i > 5000; i--) {
            assertEquals("Should have the same value", i, (double) ad1.removeLast(), 0.0);
        }


    }


    @Test
    public void getIndexTest() {
        ArrayDeque<String> lld1 = new ArrayDeque<>();
        lld1.addFirst("first");
        lld1.addFirst("zero");
        lld1.addLast("second");
        lld1.addLast("third");
        assertEquals(lld1.get(2),"second");
        assertEquals(lld1.get(0),"zero");
        assertEquals(lld1.get(1),"first");
        assertEquals(lld1.get(3),"third");
        lld1.removeFirst();
        lld1.addFirst("0");
        lld1.addFirst("-1");

        assertEquals(lld1.get(0),"-1");
        //assertEquals(lld1.getRecursive(0),"-1");
        assertEquals(lld1.get(1),"0");
        //assertEquals(lld1.getRecursive(1),"0");
        assertEquals(lld1.get(2),"first");
       // assertEquals(lld1.getRecursive(2),"first");
        assertEquals(lld1.get(3),"second");
       // assertEquals(lld1.getRecursive(3),"second");
        assertEquals(lld1.get(4),"third");
       // assertEquals(lld1.getRecursive(4),"third");
        assertEquals(lld1.get(5),null);
       // assertEquals(lld1.getRecursive(5),null);

    }

    public void equalsTest(){
        ArrayDeque<Integer> ad1 =new ArrayDeque<>();
        ArrayDeque<Integer> ad2 =new ArrayDeque<>();
        ArrayDeque<Integer> ad3 =new ArrayDeque<>();
        ArrayDeque<Integer> ad4 =new ArrayDeque<>();
        LinkedListDeque<Integer> ad5 =new LinkedListDeque<>();



        ad1.addFirst(10);
        ad1.addLast(19);
        ad1.addFirst(9);

        ad2.addFirst(10); //exact same object
        ad2.addLast(19);
        ad2.addFirst(9);

        ad3.addFirst(100); //contains different value
        ad3.addLast(19);
        ad3.addFirst(9);

        ad4.addFirst(100); //of different size
        ad4.addLast(19);
        ad4.addFirst(9);
        ad4.addFirst(99);

        ad5.addFirst(10); //contains same value, but belong to different class
        ad5.addLast(19);
        ad5.addFirst(9);

        assertEquals(true,ad1.equals(ad2));
        assertEquals(false,ad1.equals(ad3));
        assertEquals(false,ad1.equals(ad4));
        assertEquals(false,ad1.equals(ad5));


    }



}
