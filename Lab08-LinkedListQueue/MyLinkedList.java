 
import java.util.*;
import java.util.stream.*;


public class MyLinkedList<U> implements Iterable<U>{
	private ListNode<U> head, tail;
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
	public MyLinkedList() { this.head = null; this.tail = null;}
	public MyLinkedList(U val) { this.head = new ListNode<U>(val); this.tail = this.head; }
	public MyLinkedList(U... vals) {
		this();
		for(U e : vals)
			this.add(e);
	}
	boolean contains(U target) {
		return this.indexOf(target) != -1;
	}
	U get(int index) {
		return this.getRef(index).val;
	} 
	ListNode<U> getRef(int index) {
		ListNode<U> cur = this.head;
		int curIndex = 0;
		while(cur != null) {
			if(curIndex == index) return cur;
			cur = cur.next;
			++curIndex;
		}
		throw new IndexOutOfBoundsException();
	}
	int indexOf(U target) {
		ListNode<U> cur = this.head;
		int index = 0;
		while(cur != null) {
			if(cur.val.equals(target)) return index;
			cur = cur.next;
			++index;
		}
		return -1;
	}
	private U removeIndex(ListNode<U> target) {
		ListNode<U> cur = this.head;
		int index = 0;
		while(cur != null) {
			if(cur == target) return this.remove(index);
			cur = cur.next;
			++index;
		}
		throw new NullPointerException();
	}
	void set(U val, int index) {
		this.getRef(index).val = val;
	}
	int size() {
		return this.size;
	}
	int sizeRecursive(ListNode<U> cur) {
		if(cur == null) return 0;
		return 1 + sizeRecursive(cur.next);
	}
	boolean isEmpty() {
		return this.size() == 0;
	}
	U remove(int index) {
		if(this.size() <= index) throw new IndexOutOfBoundsException();
		--size;
		ListNode<U> cur = this.getRef(index), prev = index > 0 ? this.getRef(index-1) : null;
		if(index == 0) {
			this.head = (this.size() > 0) ? this.getRef(1) : null;
			this.tail = (this.size() > 0 ? this.tail : null);
		} else {
			if(cur == this.tail) this.tail = prev;
			prev.next = cur.next;
		}
		return cur.val;
	}
	void add(U newVal, int index) {
		if(index > this.size()) throw new IndexOutOfBoundsException();
		ListNode<U> e = new ListNode<>(newVal);
		if(index == 0) {
			e.next = this.head;
			this.head = e;
		} else {
			if(index != this.size())
				e.next = this.getRef(index);
			this.getRef(index-1).next = e;
		}
		if(index == this.size()) 
			this.tail = e;
		++size;
	}
	void add(U val) {
		this.add(val, this.size);
	}
	@Override
	public String toString() {
		String res = "[";
		ListNode<U> cur = this.head;
		while(cur != null) {
			res += (cur) + (cur.next != null ? ", " : "");
			cur = cur.next;
		}
		return res + "]";
	}
	public boolean cycle() {
		ListNode<U> slow = this.head, fast = this.head;
		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if(fast == slow) return true;
		}
		return false;
	}
	ListNode mergeK(ListNode[] heads) {
		MyLinkedList list = new MyLinkedList<>();
		PriorityQueue<ListNode> rem = new PriorityQueue<>((a, b) -> Integer.compare((Integer)a.val, (Integer)b.val));
		for(ListNode c : heads) rem.add(c);
		while(rem.size() > 0) {
			ListNode top = rem.poll();
			list.add(top.val);
			if(top.next != null) rem.add(top.next);
		}
		return list.head;
	}
	private class LinkedListIterator implements Iterator<U> {
	        ListNode<U> cur;
	        public LinkedListIterator() { cur = head; }
	        @Override
	        public boolean hasNext() { return cur != null; }
	        @Override
	        public U next() { 
	        	U e = cur.val;
	        	cur = cur.next;
	        	return e;
	        }
	        @Override
	        public void remove() { removeIndex(cur); }
	    }
	    public Iterator<U> iterator() { return new LinkedListIterator(); }
}