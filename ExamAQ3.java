import java.util.*;

class Solution {
  /**
   * Takes a list and returns a new list sorted in descending order.
   * This is done by using the priority queue `queue`.
   *
   * Return null if list is null.
   *
   * @param list
   *     the array that needs to be sorted.
   */
  public static List<Integer> pqSort(List<Integer> list) {
    if(list == null) {
      return null;
    }
    LibraryPQ queue = new SolutionPQ();
    List<Integer> result = new ArrayList<>();
    int n = list.size();
    for (int i = 0; i < n; i++) {
      queue.insert(list.get(i));
    }
    for(int i = 0; i < n; i++) {
      result.add(queue.removeMax());
    }
    return result;
  }
}

class SolutionPQ extends LibraryPQ {
  /**
   * Restores the heap property in a heap represented as an arraylist.
   * The method compares the node to its parent and swaps if necessary.
   *
   * @param i
   *     index of the node
   */
  @Override
  public void upHeap(int i) {
    while (i >= 1){
      int j = (i -1 )/2;
      if (getInHeap(j) > getInHeap(i)) {
        break;
      }
      swap(j,i);
      i = j;
    }
    
  }
}


