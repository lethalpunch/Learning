package Algirithms.Sort;

/*
 * WIP (Not Completed)
 * Inversion array is an array having same elements
but formed by satisfying the following comditions
for 0 <= i <= j <= n   A[i] > A[j]
*
*/

public class InversionArray {

   public static int inversionCount = 0;

   public void getNumberOfInversionArray( int [] inputArr, int initialIndex,
      int finalIndex ) {
      if ( initialIndex < finalIndex ) {
         int middleIndex = ( finalIndex + initialIndex ) / 2;
         this.getNumberOfInversionArray( inputArr, initialIndex, middleIndex );
         this.getNumberOfInversionArray( inputArr, middleIndex + 1, finalIndex );
         this.getCountFromMergeArray( inputArr, initialIndex, middleIndex,
            finalIndex );
      }
   }

   private void getCountFromMergeArray( int [] inputArr, int initialIndex,
      int middleIndex, int finalIndex ) {
      int [] rightArr = new int[middleIndex - initialIndex];
      int [] leftArr = new int[finalIndex - middleIndex + 1];
      for ( int i = initialIndex; i < middleIndex; i++ ) {
         rightArr[i] = inputArr[i + initialIndex];
      }
      for ( int i = middleIndex; i < finalIndex; i++ ) {
         leftArr[i] = inputArr[i + middleIndex];
      }
      int m = 0,n=0;
      for ( int i = initialIndex; i < finalIndex + 1; i++ ) {
         if ( m < middleIndex && n < finalIndex && rightArr[m] > leftArr[n] ) {
            InversionArray.inversionCount++;
            m++;
            continue;
         }
         n++;
      }
   }
}
