 


import java.util.ArrayList;
import java.util.List;

public class GemList
{
    Node h = null;
    private class Node {
        private Gem gem;
        private Node next;
        public Node(Gem g) { this.gem = g; }
    }
    int size() {
        Node c = h;
        int size = 0;
        while(c != null) {
            ++size;
            c = c.next;
        }
        return size;
    }
    void draw(double y) {
        Node c = h;
        int index = 0;
        while(c != null) {
            c.gem.draw(GemGame.indexToX(index), y);
            c = c.next; ++index;
        }
    }
    public String toString() {
        String result = "";
        Node c = h;
        while(c != null) {
            result += "[" + c.gem + "]" + (c.next != null ? " -> " : "");
            c = c.next;
        }
        return result;
    }

    void insertBefore(Gem gem, int index) {
        int size = this.size();
        index = Math.min(index, size);
        Node e = new Node(gem);

        if(index == 0) {
            e.next = this.h;
            this.h = e;
        } else {
            Node c = this.h;
            for(int i = 0; i <= size; ++i) {
                if(i == index-1) {
                    e.next = c.next;
                    c.next = e;
                    return;
                }
                c = c.next;
            }
        }
    }

    int score() {
        Node c = h;
        int answer = 0, sum = 0, multi = 0;
        GemType last = null;
        while(c != null) {
            if(last != null && c.gem.color == last) {
                sum +=c.gem.getPoints();
                ++multi;
            } else {
                answer += sum * multi;
                multi = 1;
                sum = c.gem.getPoints();
                last = c.gem.color;
            }
            c = c.next;
        }
        answer += sum * multi;
        return answer;
    }

    
    public static void main(String [] args)
    {
        GemList list = new GemList();
        System.out.println(list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.9);

        list.insertBefore(new Gem(GemType.BLUE, 10), 0);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.8);

        list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.7);

        list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.6);

        list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.5);

        list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.4);

        list.insertBefore(new Gem(GemType.GREEN, 50), 2);
        System.out.println("\n" + list);
        System.out.println("size = " + list.size() + ", score = " + list.score());
        list.draw(0.3);
    }    
}