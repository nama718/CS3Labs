import java.util.*;
import java.io.*;

class Disk implements Comparable<Disk> {
  ArrayList<Integer> f = new ArrayList<>();
  int space = 1000000, id = 0;
  public int compareTo(Disk other) {
    if(this.id == other.id) return 0;
    return this.space < other.space ? 1 : -1;
  }
  public Disk(int i) { this.id = i; }
}


