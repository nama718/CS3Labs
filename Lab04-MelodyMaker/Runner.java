import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

public class Runner
{
    public static void main (String[]args)
    {
        QueueProbs q = new QueueProbs();
        Queue<Integer> f = new LinkedList<Integer>();
        f.add(12);
        f.add(7);
        f.add(6);
        f.add(17);
        f.add(4);
        System.out.println(q.evenFirst(f));
        System.out.println(q.seive(21));
    }
}
