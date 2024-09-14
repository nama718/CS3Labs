import java.util.Stack;


public class rpRunner extends RecursionProbs
{
    public static void main(String[] args) {
        System.out.println(sumReciprocals(10));
        System.out.println(productOfEvens(4));
        System.out.println(conversion(1453, 8));
        System.out.println(matchingDigits(100, 1));
        Stack<Integer> d = new Stack<>(); d.push(3); d.push(7); d.push(12); d.push(9);
        System.out.print(d + " >>> ");
        doubleUp(d);
        System.out.println(d);
        printThis(7); System.out.println();
        printNums2(10); System.out.println();
    }
}