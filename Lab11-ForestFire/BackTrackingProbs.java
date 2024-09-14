 

import java.util.*;


public class BackTrackingProbs
{
 
    
    
        public static void printBinary(int length, String s) {
        if(length == 0) System.out.print(s + " ");
        else {
            printBinary(length -1 ,  s + "0");
            printBinary(length-1, s + "1");
        }
        
    }
    static void climbStairs(int steps, String s) {
        if(steps == 0) System.out.println(s);
        else if(steps == 1) System.out.println(s + (s.length() > 0 ? ", 1" : "1"));
        else {
            climbStairs(steps - 1, s + (s.length() > 0 ? ", 1" : "1"));
            climbStairs(steps - 2, s + (s.length() > 0 ? ", 2" : "2"));
        }
    }
    static void campsite(int X, int Y, String s) {
        if(X == 0 && Y == 0) System.out.println(s);
        else {
            if(X != 0) campsite(X - 1, Y, s + "E ");
            if(Y != 0) campsite(X, Y - 1, s + "N ");
            if(X != 0 && Y != 0) campsite(X - 1, Y - 1, s + "NE " );
        }
            }
    static int getMax(List<Integer> nums, int limit, int size, int curSum) {
        if(size == 0) return (curSum > limit ? -1 : curSum);
        int max = -1;
        max = Math.max(getMax(nums, limit, size - 1, curSum + nums.get(size - 1)), getMax(nums, limit, size - 1, curSum));    
        return max;
    }
    
     
     
}