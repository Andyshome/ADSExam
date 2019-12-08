class SLList<T> {
  class Node {
    // Each Node object has these two fields
    private T element;
    private Node next;

    // Constructor: Creates a Node object with element = e and next = n
    Node(T e, Node n) {
      element = e;
      next = n;
    }

    // This function gets T e as input and sets e as the element of the Node
    public void setElement(T e) {
      element = e;
    }

    // This function returns the element variable of the Node
    public T getElement() {
      return element;
    }

    // This function gets Node n as input and sets the next variable of the current Node object as n.
    public void setNext(Node n) {
      next = n;
    }

    // This function returns the next Node
    public Node getNext() {
      return next;
    }
  }

  // Each object in SLList has one field head, which points to the starting Node of SLList.
  private Node head;

  /**
   * Constructor: initialises the head field as null
   */
  public SLList() {
    head = null;
  }

  /**
   * @return The element in the first Node of this SLL. If the list is empty, this method returns null.
   */
  public T getFirst() {
    if (head == null)
      return null;
    return head.getElement();
  }

  /**
   * Adds element e in a new Node to the head of the list.
   *
   * @param e
   *     The element to add.
   */
  public void addFirst(T e) {
    head = new Node(e,head);
  }

  /**
   * Remove the first Node in the list and return its element.
   *
   * @return The element of the first Node. If the list is empty, this method returns null.
   */
  public T removeFirst() {
    if (head == null) {
      return null;
    }
    Node temp = head;
    head = head.next;
    return temp.element;
  }

  /**
   * Combine this list with the other list.
   * Each element of the resulting list is a Pair object holding one element of this list
   * and the corresponding element at the same position of the other list.
   * If one list is longer than the other, any extra elements should be dropped.
   * Example: Zipping [1, 2] with [5, 6, 7] results in [(1, 5), (2, 6)], where (x, y) denotes a Pair object.
   *
   * @param other
   *     The other list to combine elements with. Is treated as an empty list if it is null.
   * @return A new list with alternated elements of this list and the other list.
   */
  public SLList<Pair<T, T>> zip(SLList<T> other) {
    if (other == null) {
      return new SLList<Pair<T, T>>();
    }
    SLList<T> tempList = new SLList<T>();
    SLList<Pair<T, T>> result = new SLList<Pair<T, T>>();
    SLList<Pair<T, T>> tempResult = new SLList<Pair<T, T>>();
    while(getFirst() != null && other.getFirst()!= null){
      T a = removeFirst();
      T b = other.removeFirst();
      tempList.addFirst(a);
      Pair<T, T> temp = new Pair<T, T>(a,b);
      result.addFirst(temp);
    }
    while(result.getFirst()!= null) {
      tempResult.addFirst(result.removeFirst());
    }
    while(tempList.getFirst()!= null) {
      addFirst(tempList.removeFirst());
    }
    return tempResult;
  }

  /**
   * Appends another SLL to this SLL.
   *
   * @param other
   *     The list to append to this list. Is treated as an empty list if it is null.
   */
  public void append(SLList<T> other) {
    if (other == null) {
      return;
    }
    SLList<T> tempList = new SLList<T>();
    while(getFirst() != null) {
      tempList.addFirst(removeFirst());
    }
    while(other.getFirst()!= null) {
      tempList.addFirst(other.removeFirst());
    }
    while(tempList.getFirst()!= null) {
      addFirst(tempList.removeFirst());
    }
  }

  /**
   * Removes all elements at the even positions in this list.
   * Note that the head of the list is element number 0, which is an even position.
   */
  public void dropEven() {
    if(getFirst() == null) {
      return;
    }
    int i = 0;
    SLList<T> tempList = new SLList<T>();
    while(getFirst() != null) {
      if ( i % 2 == 0) {
        removeFirst();
        i++;
        continue;
      }
      tempList.addFirst(removeFirst());
      i++;
    }
    while (tempList.getFirst() != null) {
      addFirst(tempList.removeFirst());
    }
  }
}


