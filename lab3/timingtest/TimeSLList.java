package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE

        AList<Integer> NS=new AList<>();
        AList<Double>  times=new AList<>();
        AList<Integer>  opCounts=new AList<>();

        SLList<Integer> sample=new SLList<>();


        for(int num=1000;num<=64000;num*=2){
            int op=10000;
            NS.addLast(num);
            opCounts.addLast(op);
            for(int start=0;start<num;start++){
                sample.addLast(start);
            }
            Stopwatch sw = new Stopwatch();
            while(op>=0) {
                sample.getLast();
                op--;
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(NS,times,opCounts);
    }

}
