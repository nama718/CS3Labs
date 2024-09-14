 

import java.util.*;

public class MyBST {
  BSTNode r;
  HashMap<BSTNode, Integer> h = new HashMap<>();
  private class BSTNode {
    Integer val;
    Integer depth;
    BSTNode left;
    BSTNode right;
    public BSTNode(Integer val) {
      this.val = val;
      left = right;
    depth = -1;
    }
    public String toString() {
      return "" + this.val;
    }
  }
  int size() { 
      return size(r); 
    } 
  int size(BSTNode s) {
    if(s == null) return 0;
    return 1 + size(s.left) + size(s.right);
  }
  void insert(Integer val) {
    if(r == null) r = new BSTNode(val);
    else insert(val, r);
  } 
  void insert(Integer val, BSTNode s) {
    if(val <= s.val) {
      if(s.left == null) s.left = new BSTNode(val);
      else insert(val, s.left);
    } else {
      if(s.right == null) s.right = new BSTNode(val);
      else insert(val, s.right);
    }
  }

  boolean contains(Integer v) { 
      return contains(v, r);
    }
    
  boolean contains(Integer v, BSTNode s) {
    if(s == null) return false;
    if(s.val.equals(v)) return true;
    else return contains(v, s.left) || contains(v, s.right);
  }
  Integer getMax() { return getAbsolute(r, 1); }
  Integer getMin() { Integer min = getAbsolute(r, -1); return (min == null ? null : min * -1); }
  Integer getAbsolute(BSTNode n, int z) {
    if(n == null) 
    return null;
    else return Math.max(n.val * z, Math.max((n.right == null ? n.val * z : getAbsolute(n.right, z)), (n.left == null ? n.val * z : getAbsolute(n.left, z))));
  }
  void delete(Integer v) {
      delete(v, r, null); 
    }
  void delete(Integer val, BSTNode n, BSTNode p) {
    if(n == null) return;
    if(val.equals(n.val)) {
      if(n.left == null && n.right == null) {
        if(n == r) r = null;
        else if(p.left == n) p.left = null;
        else p.right = null;
      }
      else if(n.right == null) {
        if(r == n) r = n.left;
        else if(p.left == n) p.left = n.left;
        else p.right = n.left;
      }
      else if(n.left == null) {
        if(n == r) r = n.right;
        else if(p.left == n) p.left = n.right;
        else p.right = n.right;
      } else {
        Integer min = getAbsolute(n, -1) * -1;
        delete(min, n, null);
        n.val = min;
      }
    } else {
      delete(val, n.left, n);
      delete(val, n.right, n);
    }
  }
  void inOrder() { 
      inOrder(r); 
    }
  void inOrder(BSTNode n) {
    if(n == null) return;
    inOrder(n.left);
    System.out.print(n.val + " ");
    inOrder(n.right);
    if(n == r) System.out.println();
  }
  int top(BSTNode n, int depth) {
    if(n == null) 
    return 0;
    n.depth = depth;
    h.put(n, 1 + Math.max(top(n.left, depth + 1), top(n.right, depth + 1)));
    return h.get(n);
  }

  void print() {
    int top = top(r, 0);
    int current = 0, currentSize = 0;
    if(top > 0) {
      Queue<BSTNode> bfs = new LinkedList<>();
      bfs.add(r);
      while(bfs.size() > 0) { 
        BSTNode t = bfs.poll();
        if(t == null) {
          if(current < top) {
            bfs.add(null);
            System.out.print(s(5));
          }
        }
        if(t != null) {
          System.out.print(s(h.get(t) * 3) + t.val + s(h.get(t) * 3));
          bfs.add(t.left);
          bfs.add(t.right);
        }
        if(currentSize++ == (1 << current)) {
          current++;
          currentSize = 0;
          System.out.println("\n\n");
        }
      }
    }
  }
  private String s(int n) {
    String answer = "";
    for(int i = 0; i < n - 1; ++i) answer += ' ';
    return answer;
  }
}