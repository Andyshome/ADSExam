class Solution {
  /**
   * Checks for a String represented as a SLList whether this String is a palindrome.
   * This is done by using a queue.
   *
   * An empty String or null should return true.
   *
   * @param list
   *     SLList used to represent a String
   * @return true if the String represented as a SLList is a palindrome, otherwise false
   */
  public static boolean checkPalindrome(SLList list) {
    if(list == null) {
      return true;
    }
    LibraryQueue<Entry> queue = new LibraryQueue<>();
    int n = list.size();
    for (int i = 0; i < n /2 ; i++) {
      Entry entry = new Entry(i,list.removeFirst());
      queue.enqueue(entry);
    }
    if (n % 2 != 0) {
      list.removeFirst();
    }
    for(int i = 0;i < n/2 ; i++) {
      if (queue.dequeue().getElement() != list.removeFirst()) {
        return false;
      }
      
    }
    return true;
    

  }
}


