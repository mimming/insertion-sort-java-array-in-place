class Main {
  public static void main(String[] args) {
    int[] sorted = insertionSort(new int[]{1, 7, 6, 4, 5, 1, -1});
    for( int num : sorted) {
        System.out.println(num);
    }
  }
  
  public static int[] insertionSort(int[] arrayItems) {
      for(int i = 0; i < arrayItems.length; i++) {
          // Find the smallest element
          int smallestIndex = findSmallestIndex(arrayItems, i);
          
          // Copy it to a safe place
          int smallest = arrayItems[smallestIndex];
          
          // Make room at front, removing the smallest thing
          makeRoom(arrayItems, i, smallestIndex);
          
          // put it where it should go when sorted
          arrayItems[i] = smallest;
      }
      return arrayItems;
  }
  
  public static int findSmallestIndex(int[] array, int startIndex) {
      // initial case
      int smallest = array[startIndex];
      int smallestIndex = startIndex;

      // if there are other things to compare to
      if(array.length > startIndex + 1) {
          for(int i = startIndex + 1; i < array.length; i++) {
              if(array[i] < smallest) {
                  smallestIndex = i;
                  smallest = array[i];
              }
          }
      }
      
      return smallestIndex;
  }
  
  public static int[] makeRoom(int[] array, int makeRoomHereIndex, int indexToKill) {
      // Leave the beginning of the array alone, that's already sorted
      
      if(indexToKill == makeRoomHereIndex) {
          // We're already done
          return array;
      }
      
      // Otherwise, we need to do work :(

      assert indexToKill >= makeRoomHereIndex: "Should not make room in front of " + 
              " array or sadness happens - Make room " + makeRoomHereIndex + 
              " index to kill " + indexToKill;
      
      for(int i = indexToKill; i > makeRoomHereIndex; i--) {
          array[i] = array[i-1];
      }
      
      return array;
  }
}
