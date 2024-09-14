 
import java.util.*;
public class MyLinkedList<A> {
    private ListNode<A> head;
    private ListNode<A> tail;
    private int size;
    private class ListNode<T> {
        T val;
        ListNode<T> next;
        public ListNode(T val) {
            this.val = val;
            this.next = null;
        } 

        @Override
        public String toString() {
            return "" + this.val;
        }
    }
    public MyLinkedList() 
    {
        this.head = null; this.tail = null;
    }
    public MyLinkedList(A val) { 
        this.head = new ListNode<A>(val); this.tail = this.head; 
      }
    
    boolean contains(A target) {
        return this.indexOf(target) != -1;
    }
    A get(int index) {
        return this.getRef(index).val;
    } 
    ListNode<A> getRef(int index) {
        ListNode<A> top = this.head;
        int topIndex = 0;
        while(top != null) {
            if(topIndex == index) return top;
            ++topIndex;
            top = top.next;
            
        }
        throw new IndexOutOfBoundsException();
    }
    int indexOf(A target) {
        ListNode<A> top = this.head;
        int index = 0;
        while(top != null) {
            if(top.val == target) return index;
            top = top.next;
            index++;
        }
        return -1;
    }
    private A removeIndex(ListNode<A> target) {
        ListNode<A> top = this.head;
        int index = 0;
        while(top != null) {
            if(top == target) return this.remove(index);
            top = top.next;
            ++index;
        }
        throw null;
    }
    void set(A val, int index) {
        this.getRef(index).val = val;
    }
    int size() {
        return this.size;
    }
    int sizeRecursive(ListNode<A> top) {
        if(top == null) return 0;
        return 1 + sizeRecursive(top.next);
    }
    boolean isEmpty() {
        return this.size() == 0;
    }
    A remove(int index) {
        --size;
        ListNode<A> top = this.getRef(index), prev = index > 0 ? this.getRef(index-1) : null;
        if(index == 0) {
            this.head = (this.size() > 0) ? this.getRef(1) : null;
            this.tail = (this.size() > 0 ? this.tail : null);
        } else {
            if(top == this.tail) this.tail = prev;
            prev.next = top.next;
        }
        return top.val;
    }
    void add(A newVal, int index) {
        ListNode<A> q = new ListNode<>(newVal);
        if(index == 0) {
            q.next = this.head;
            this.head = q;
        } else {
            if(index != this.size())
                q.next = this.getRef(index);
            this.getRef(index-1).next = q;
        }
        if(index == this.size()) 
            this.tail = q;
        ++size;
    }
    void add(A val) {
        this.add(val,this.size);
    }
    @Override
    public String toString() {
        String res = "[";
        ListNode<A> top = this.head;
        while(top != null) {
            res += (top) + (top.next != null ? ", " : "");
            top = top.next;
        }
        return res + "]";
    }

    
}