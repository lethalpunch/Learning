package Algirithms.Sort;

public class MergeSort {

   public void divideArrayToSort( int [] arrayToSort, int initialIndex,
      int finalIndex ) {
      if ( initialIndex < finalIndex ) {
         int middleIndex = ( initialIndex + finalIndex ) / 2;
         divideArrayToSort( arrayToSort, initialIndex, middleIndex );
         divideArrayToSort( arrayToSort, middleIndex + 1, finalIndex );
         mergeArray( arrayToSort, initialIndex, middleIndex, finalIndex );
      }
   }
   

   public void mergeArray( int [] arrayToMerge, int initialIndex,
      int middleIndex, int finalIndex ) {
      int leftArrLength = middleIndex - initialIndex + 1;
      int rightArrLength = finalIndex - middleIndex;
      int [] leftArr = new int[leftArrLength + 1];
      int [] rightArr = new int[rightArrLength + 1];
      for ( int i = 0; i < leftArrLength; i++ ) {
         leftArr[i] = arrayToMerge[initialIndex + i];
      }
      leftArr[leftArrLength] = 99999999;
      for ( int i = 0; i < rightArrLength; i++ ) {
         rightArr[i] = arrayToMerge[middleIndex + i + 1];
      }
      rightArr[rightArrLength] = 9999999;
      int i = 0;
      int j = 0;
      for ( int k = initialIndex; k < finalIndex+1; k++ ) {
         if ( leftArr[i] < rightArr[j] ) {
            arrayToMerge[k] = leftArr[i];
            i++;
         } else if ( rightArr[j] != 9999999 ) {
            arrayToMerge[k] = rightArr[j];
            j++;
         }
      }
   }

   public static void main( String... strings ) {
      int [] A = { 1, 5, 856, 546, 5436, 5463, 5213, 5486, 25143, 145 };
      MergeSort ms = new MergeSort();
      ms.divideArrayToSort( A, 0, A.length - 1 );
      for ( int i = 0; i < A.length; i++ ) {
         System.out.print( A[i] + ", " );
      }
   }
}
