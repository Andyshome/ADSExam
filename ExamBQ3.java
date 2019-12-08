class Solution {
  /**
   * Takes an array and sorts it in an ascending order.
   * This has to be done by using merge sort.
   *
   * If the array is null, the metod should stop.
   *
   * @param arr
   *     - the array that needs to be sorted.
   */
  public static void mergeSort(int[] arr) {
    if (arr == null ){
      return;
    }
    int[] temp = mergeSortHelper(arr);
    for (int i = 0 ; i< temp.length ; i++) {
      arr[i] = temp[i];
    }
  }
  
   public static int[] mergeSortHelper(int[] arr) {
    if (arr.length <= 1){
      return arr;
    }
    int n = arr.length/2;
    int[] a = new int[n];
    int[] b = new int[arr.length - n];
    for(int i = 0; i < a.length ; i++) {
      a[i] = arr[i];
    }
    for (int j = 0; j < b.length; j++) {
      b[j] = arr[j + n];
    }
    return merge(mergeSortHelper(a),mergeSortHelper(b));
  }
  
  
  public static int[] merge(int[] a, int[] b){
    
    int[] result = new int[a.length + b.length];
    int i = 0;
    int j = 0;
    int index = 0;
    while(i < a.length && j < b.length) {
      if (a[i] > b[j]) {
        result[index] = b[j];
        j++;
        index++;
      } else {
        result[index] = a[i];
        i++;
        index++;
      }
    }
    while(i < a.length) {
      result[index] = a[i];
      i++;
      index++;
    }
    while(j < b.length) {
      result[index] = b[j];
      j++;
      index++;
    }
    return result;
  }
}


