package deque;

import org.junit.Test;

import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {


        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

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



        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
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



        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
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
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {


        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();

    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());


    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {


        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }


    }


    @Test
    public void getIndexTest() {
        LinkedListDeque<String> lld1 = new LinkedListDeque<>();
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
        assertEquals(lld1.getRecursive(0),"-1");
        assertEquals(lld1.get(1),"0");
        assertEquals(lld1.getRecursive(1),"0");
        assertEquals(lld1.get(2),"first");
        assertEquals(lld1.getRecursive(2),"first");
        assertEquals(lld1.get(3),"second");
        assertEquals(lld1.getRecursive(3),"second");
        assertEquals(lld1.get(4),"third");
        assertEquals(lld1.getRecursive(4),"third");
        assertEquals(lld1.get(5),null);
        assertEquals(lld1.getRecursive(5),null);

    }
    @Test
    public void equalsTest(){
        LinkedListDeque<Integer> lld1=new LinkedListDeque<>();
        LinkedListDeque<Integer> lld2=new LinkedListDeque<>();
        LinkedListDeque<Integer> lld3=new LinkedListDeque<>();
        LinkedListDeque<Integer> lld4=new LinkedListDeque<>();
        ArrayDeque<Integer> lld5= new ArrayDeque<>();

        lld1.addFirst(10);
        lld1.addLast(19);
        lld1.addFirst(9);

        lld2.addFirst(10); //exact same object
        lld2.addLast(19);
        lld2.addFirst(9);

        lld3.addFirst(100); //contains different value
        lld3.addLast(19);
        lld3.addFirst(9);

        lld4.addFirst(100); //of different size
        lld4.addLast(19);
        lld4.addFirst(9);
        lld4.addFirst(99);

        lld5.addFirst(10); //contains same value, but belong to different class
        lld5.addLast(19);
        lld5.addFirst(9);

        assertEquals(true,lld1.equals(lld2));
        assertEquals(false,lld1.equals(lld3));
        assertEquals(false,lld1.equals(lld4));
        assertEquals(false,lld1.equals(lld5));


    }

}
