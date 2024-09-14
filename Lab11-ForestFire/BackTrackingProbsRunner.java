import java.util.*;

/**
 * Write a description of class BackTrackingProbsRunner here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BackTrackingProbsRunner
{
    public static void main(String[] args) {
        BackTrackingProbs b = new BackTrackingProbs();
                b.printBinary(3, "");
        b.climbStairs(4, "");
        b.campsite(2, 1, "");
        System.out.println(b.getMax(Arrays.asList(7, 30, 8, 22, 6, 1, 14), 19, 7, 0));
        

    }    

}
