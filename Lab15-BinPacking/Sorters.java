import java.util.*;
import java.io.*;

class Sorters {
  public void BestFit(ArrayList<Integer> f) {
    Collections.sort(f);  Collections.reverse(f);
    TreeSet<Disk> ts = new TreeSet<>((x, y) -> x.compareTo(y));
    int id = 0, sum = 0;
    Disk temporary = new Disk(-1);
    for(int i = 0; i < f.size(); ++i) {
      temporary.space = f.get(i);
      Disk v = ts.floor(temporary), u;
      if(v == null) u = new Disk(id++);
      else {
        ts.remove(v); u = v;
      }
      u.f.add(f.get(i));  u.space -= f.get(i);
      ts.add(u);
      sum += f.get(i);
    }
    if(ts.size() < 100) {
      System.out.print("Total size = " + (double)sum / 1000000 + " GB" + "\nDisks req'd = " +  ts.size());
      while(ts.size() > 0) {
        Disk u = ts.pollFirst();
        System.out.print("\n   " + u.id + " " + u.space + ": ");
        for(int v : u.f) System.out.print(v + " ");
      }
    }
  }
    
    public void WorstFit(ArrayList<Integer> f) {
    PriorityQueue<Disk> q = new PriorityQueue<>((x, y) -> x.compareTo(y));
    int current = 0, sum = 0;
    for(int i = 0; i < f.size(); ++i) {
      sum += f.get(i);
      Disk u;
      if(q.size() > 0 && q.peek().space >= f.get(i)) u = q.poll();
      else u = new Disk(current++);
      u.space -= f.get(i);  u.f.add(f.get(i));
      q.add(u);
    }
    if(q.size() < 100) {
      System.out.print("Total size = " + (double)sum / 1000000 + " GB" + "\nDisks required = " +  q.size());
      while(q.size() > 0) {
        Disk u = q.poll();
        System.out.print("\n    " + u.id + " " + u.space + ": ");
        for(int v : u.f) System.out.print(v + " ");
      }
    }
  }

  public void DecreasingFit(ArrayList<Integer> f) {
    Collections.sort(f);
    Collections.reverse(f);
    WorstFit(f);
  }

  
}