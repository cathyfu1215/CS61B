package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class comparisonTest {

    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> correct = new AListNoResizing<>();
        BuggyAList<Integer> broken = new BuggyAList<>();

        correct.addLast(5);
        correct.addLast(10);
        correct.addLast(15);

        broken.addLast(5);
        broken.addLast(10);
        broken.addLast(15);

        assertEquals(correct.size(), broken.size());

        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
        assertEquals(correct.removeLast(), broken.removeLast());
    }

    @Test
    public void randomizedTest(){
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggy=new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);

                buggy.addLast(randVal);

            } else if (operationNumber == 1) {
                // size
                int size = L.size();

                int buggySize= buggy.size();

            }
            else if(operationNumber == 2){
                if(L.size()>0){
                   L.getLast();
                }
                if(buggy.size()>0){
                   buggy.getLast();
                }
            }

            else{
                if(L.size()>0) {
                   L.removeLast();
                }
                if(buggy.size()>0) {
                    buggy.removeLast();
                }
            }
        }
    }

}
