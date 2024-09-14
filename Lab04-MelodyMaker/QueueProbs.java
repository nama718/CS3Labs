import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProbs
{
    

    /**
     * Constructor for objects of class QueueProbs
     */
    public QueueProbs()
    {
        
    }
    public Queue<Integer> evenFirst(Queue<Integer> nums)
    {
        
         Queue<Integer> fill = new LinkedList<>();
        int s = nums.size();
        for(int i = 0; i < s; ++i) {
            if(nums.peek() % 2 == 0) fill.offer(nums.poll());
            else nums.offer(nums.poll());
        }
        while(nums.size() > 0) fill.offer(nums.poll());
        return fill;
    }
    Stack<Integer> seive(int N) {
        Queue<Integer> nums = new LinkedList<>();
        Stack<Integer> primes = new Stack<>();
        for(int i = 2; i <= N; i++) nums.offer(i);
        while(nums.size() > 0) {
            primes.push(nums.poll());
            int num = primes.peek();
            Queue<Integer> temp = new LinkedList<>();
            while(nums.size() > 0) {
                int x = nums.poll();
                if(x % num == 0) temp.offer(x);
            }
        }
        return primes;
    }
}

