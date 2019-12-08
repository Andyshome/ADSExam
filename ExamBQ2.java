
class Solution {
  /**
   * @param heap
   *     the Heap to check, can be null. If not null, this heap will always contain at least one Node.
   * @return the Node corresponding to the last position in the Heap, or null if the Heap is null.
   */
  public static Heap.Node findLastPosition(Heap heap) {
    if (heap == null) {
      return null;
    }
    int totalNumber = heap.size()-1;
    int flag = 1;
    int height = 1;
    Heap.Node temp = heap.getRoot();
    while(heap.hasLeft(temp) != false) {
      totalNumber = totalNumber - flag;
      flag = flag * 2;
      temp = heap.getLeft(temp);
      height++;
    }
    int mask = 1 << (height-2);
    temp = heap.getRoot();
    for(int i =0 ; i < height-1 ; i++) {
      int now = mask & totalNumber;
      mask = mask >> 1;
      if (now == 0) {
        temp = heap.getLeft(temp);
      } else {
        temp = heap.getRight(temp);
      }
    }
    return temp;
  }
}


