 

class MinHeap {
  int size = 0;
  static final int DEFAULT_CAPACITY= 8;
  Integer[] heap = new Integer[DEFAULT_CAPACITY];
  public MinHeap(){}
  public MinHeap(Integer[] v) {
    buildHeap(v);
  }
  void buildHeap(Integer[] v) {
    for(Integer k : v)
      this.insert(k);
  }

  int getsize() {
    return this.size;
  }
  boolean isEmpty() { 
      return this.size == 0; 
    }
  Integer peekMinimum() {
      return !this.isEmpty() ? this.heap[1] : null; 
    }
  int getLeftChildIndex(int i) { 
      return i * 2; 
    }
  int getRightChildIndex(int i) { 
      return 2 * i + 1;
    }
  int getParentIndex(int i) {
      return i / 2;
    }
  private void doubleCapacity() {
    int length = this.heap.length * 2;
    Integer[] heaptwo = new Integer[length];
    for(int i = 0; i < length/ 2; ++i)
      heaptwo[i] = heap[i];
    heap= heaptwo;
  }
  void insert(Integer u) {
    if(this.getsize() + 1 == this.heap.length) doubleCapacity();
    this.heap[++this.size] = u;
    this.bubbleUp(this.size);
  }
  void bubbleUp(int index) {
    if(index > 1 && heap[getParentIndex(index)] > heap[index]) {
      int start = heap[getParentIndex(index)];
      heap[getParentIndex(index)] = heap[index];
      heap[index] = start;
      bubbleUp(getParentIndex(index));
    }
  }

  Integer popMinimum() {
    int v = peekMinimum();
    if(size > 1) {
      heap[1] = heap[size];
      heap[size] = null;
      --size;
      siftdown(1);
    }
    return v;
  }
  void siftdown(int index) {
    Integer left = heap[this.getLeftChildIndex(index)];
    Integer right = heap[this.getRightChildIndex(index)];
    Integer current = heap[index];
    int ind = -1;
    if(left != null && current > left && (right == null || left <= right))
      ind = getLeftChildIndex(index);
    else if(right != null && current > right && (right == null || right <= left))
      ind = getLeftChildIndex(index);
    if(ind != -1) {
      int start = heap[ind];
      heap[ind] = heap[index];
      heap[index] = start;
      siftdown(ind);
    }
  }
  public String toString() {
    String output = "";
    for(int i = 1; i <= getsize(); ++i)
      output += heap[i] + ", ";
    return output.substring(0, output.lastIndexOf(","));
  }
  public void display() {
    int nBlanks = 32, itemsPerRow = 1, column = 0, j = 1;
    String dots = "...............................";
    System.out.println(dots + dots);
    while (j <= this.getsize()){
      if (column == 0)
        for (int k = 0; k < nBlanks; k++)
          System.out.print(' ');
      System.out.print((heap[j] == null)? "" : heap[j]);
      if (++column == itemsPerRow) {
        nBlanks /= 2;
        itemsPerRow *= 2;
        column = 0;
        System.out.println();
      }
      else
        for (int k = 0; k < nBlanks * 2-2; k++)
          System.out.print(' ');
      j++;
    }
    System.out.println("\n" + dots + dots);
  }
}