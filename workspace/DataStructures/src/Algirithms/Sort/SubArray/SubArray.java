package Algirithms.Sort.SubArray;

public class SubArray {

   public static void main( String... strings ) {
      int [] A = { 13, -3, -25, 20, -3, -16, -23, 18, -20, 20 };
      SubArray obj = new SubArray();
      int [] returnedArr = obj.findMaximumSubArray( A, 0, A.length - 1 );
      for ( int i = 0; i < returnedArr.length; i++ ) {
         System.out.println( returnedArr[i] );
      }
   }

   public int [] findMaximumSubArray( int [] A, int start, int last ) {
      int [] returnedArray = null;
      if ( start == last ) {
         int [] retusrnedArray = { start, last, A[start] };
         return retusrnedArray;
      } else {
         int mid = ( start + last ) / 2;
         int [] rightArr = findMaximumSubArray( A, start, mid );
         int [] crossOverArr = maxCrossingSubArray( A, start, mid, last );
         int [] leftArr = findMaximumSubArray( A, mid + 1, last );
         if ( rightArr[2] >= crossOverArr[2] && rightArr[2] >= leftArr[2] ) {
            returnedArray = rightArr;
         } else if ( leftArr[2] >= crossOverArr[2] && leftArr[2] >= rightArr[2] ) {
            returnedArray = leftArr;
         } else {
            returnedArray = crossOverArr;
         }
      }

      return returnedArray;
   }

   public int [] maxCrossingSubArray( int [] A, int start, int mid, int last ) {
      int leftSum = Integer.MIN_VALUE;
      int sum = 0;
      int maxLeft = 0;
      for ( int i = mid; i >= start; i-- ) {
         sum = sum + A[i];
         if ( leftSum < sum ) {
            leftSum = sum;
            maxLeft = i;
            continue;
         }
         break;
      }

      int rightSum = Integer.MIN_VALUE;
      int maxRight = 0;
      sum = 0;
      for ( int i = mid + 1; i <= last; i++ ) {
         sum = sum + A[i];
         if ( sum > rightSum ) {
            rightSum = sum;
            maxRight = i;
            continue;
         }
         break;
      }
      int [] toReturn = { maxLeft, maxRight, ( leftSum + rightSum ) };
      return toReturn;
   }
}
