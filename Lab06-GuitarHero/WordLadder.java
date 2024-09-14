import java.util.*;
import java.io.*;

public class WordLadder
{

    
    public static void WordLadder() throws java.io.FileNotFoundException
    {
        File dict = new File("dictionary.txt");
        Scanner d = new Scanner(dict);
        Scanner i = new Scanner(new File("input.txt"));
        
        HashSet<String> diction = new HashSet<>();
        HashSet<String> holder = new HashSet<>();
        while(d.hasNext()) diction.add(d.nextLine().toLowerCase());
        {
        while(i.hasNext()) {
        String[] arr = i.nextLine().split(" ");

        String first = arr[0];
        String last = arr[1];
        boolean f = false;
        if(!f)
        {
        System.out.println("No Ladder found between " + first + " and " + last);
        diction.addAll(holder); holder.clear();
    }
        if(!diction.contains(first))
        {
        System.out.println("No Ladder found between " + first + " and " + last);
    }
            else if(first.equals(last))
            {
            System.out.println("Ladder Found! (size 1) >>> [" + first + "]"); 
        }
            else {
                Queue<Stack<String>> key = new LinkedList<>(); 
                Stack<String> init = new Stack<>();
                init.push(first); 
                key.offer(init); 
                holder.add(first); 
                diction.remove(first);
                while(key.size() > 0) {
                    Stack<String> t = key.poll();
                    String second = t.peek();
                    if(second.equals(last)) {
                        String a = "]"; int size = t.size();
                        while(t.size() > 0) a = t.pop() + (a.length() > 1 ? ", "  : "") + a;
                        System.out.println("Ladder Found! (size " + size + ") >>> [" + a);
                        f = true; 
                        break;
                    } else {
                        char[] word = second.toCharArray();
                        for(int r = 0; r < word.length; r++)
                            for(int j = 1; j < 27; j++) {
                                word[r] = (char)(((word[r]+1) - 97)%26 + 97);
                                String ladder = String.valueOf(word);
                                if(diction.contains(ladder)) {
                                    diction.remove(ladder); holder.add(ladder);
                                    Stack<String> letter = new Stack<String>();
                                    letter.addAll(t); 
                                    letter.push(ladder); 
                                    key.offer(letter);
                                }
                            }
                    }
                }
                
            }
        }
}
}
}
        
    

    
    

