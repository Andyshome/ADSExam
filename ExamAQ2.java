class Solution {
  /**
   * @param heap
   *     the Heap to check, can be null. If not null, this heap will always contain at least one Node.
   * @return the Node corresponding to the middle element in the last layer of the Heap, or null if the Heap is null.
   * In case the last layer contains an even number of elements, returns the element just left of the middle (see test).
   */
  public static Heap.Node findMiddleInLastLayer(Heap heap) {
    if(heap == null) {
      return null;
    }
    int index = heap.size() -1 ;
    int height = 0;
    int flag = 1;
    Heap.Node temp = heap.getRoot();
    while(heap.hasLeft(temp) == true) {
      index = index - flag; 
      flag = flag * 2;
      height++;
      temp = heap.getLeft(temp);
    }
    int mask = 1 << (height-1);
    index = index / 2;
    temp = heap.getRoot();
    for (int i = 0; i < height ; i++) {
      int result = index & mask;
      mask = mask >> 1;
      if (result == 0) {
        temp = heap.getLeft(temp);
      } else {
        temp = heap.getRight(temp);
      }
    }
    return temp;
    
    
  }
}


