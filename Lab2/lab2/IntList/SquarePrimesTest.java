package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesMedium() {
        IntList lst = IntList.of(7,4,9,13,0);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("49 -> 4 -> 9 -> 169 -> 0", lst.toString());
        assertTrue(changed);
    }


    @Test
    public void testSquarePrimesHard() {
        IntList lst = IntList.of(0,2,4,9,12,16);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("0 -> 4 -> 4 -> 9 -> 12 -> 16", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesExtreme() {
        IntList lst = IntList.of(0,4,13,16);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("0 -> 4 -> 169 -> 16", lst.toString());
        assertTrue(changed);
    }
}
