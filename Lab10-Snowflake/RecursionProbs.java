import java.util.*;

public class RecursionProbs {
    
    static double sumReciprocals(int n) {
        return (n==1? 1 : 1.0 / n + sumReciprocals(n-1));
    }
    static int productOfEvens(int n) {
        return (n == 1 ? 2 : 2 * n * productOfEvens(n-1));
    }
    static String conversion(int n, int base) {
        return (n < base ? "" + n : conversion(n  / base, base) + n % base);
    }
    static int matchingDigits(int a, int b) {
        if(a == 0 || b == 0){
            
        return (a%10 == b%10 ? 1 : 0);
        }
        if(b / 10 == 0 || a / 10 == 0){
            
        return(a%10 == b%10 ? 1 : 0);
        }
        else{
            
        return ((a%10 == b%10 ?  1 : 0) + matchingDigits(a / 10, b / 10));
    }
    }
    static void doubleUp(Stack<Integer> nums) {
        int n = nums.pop();
        if(nums.size() > 0)
        {
            doubleUp(nums);
        }
        nums.push(n); 
        nums.push(n);
         }
    static void printThis(int n) {
        if(n == 1)
        {
        System.out.print("*");
        }
        else if(n == 2) 
        {
        System.out.print("**");
        }
        else {
            System.out.print("<"); 
            printThis(n-2);
            System.out.print(">");
        }
    }
    static void printnums2(int n) {
        if(n == 1) 
        {
        System.out.print(1 + " ");
        }
        else if(n == 2) 
        {
        System.out.print("1 1 ");
        }
        else {
            System.out.print((n+1) / 2 + " ");
            printnums2(n - 2);
            System.out.print((n+1) / 2 + " ");
        }
    }
    

}

