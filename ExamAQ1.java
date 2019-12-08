class Solution {
  /**
   * Checks for a String represented as a SLList whether this String is a palindrome.
   * This is done by using a stack.
   *
   * An empty String or null should return true.
   *
   * @param list
   *     SLList used to represent a String
   * @return true if the String represented as a SLList is a palindrome, otherwise false
   */
  public static boolean checkPalindrome(SLList list) {
    
    LibraryStack<Character> stack = new LibraryStack<>();
    if (list == null) {
      return true;
    }
    if (list.size() == 1) {
      return true;
    }
    int n = list.size();
    boolean flag = false;
    if(list.size() % 2 != 0) {
      flag = true;
    }
    for(int i = 0; i < n/2 ; i++) {
      stack.push(list.removeFirst());
    }
    if (flag) {
      list.removeFirst();
    }
    while(stack.isEmpty() == false) {
      if(stack.pop() != list.removeFirst()) {
        return false;
      }
    }
    return true;
  }
}


