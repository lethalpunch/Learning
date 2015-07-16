package Algirithms.Sort;

public class InsertionSort {

   public static void main( String... strings ) {
      int [] inputArr = { 5, 2, 4, 6, 1, 3 };
      for ( int i = 1; i < inputArr.length; i++ ) {
         int key = inputArr[i];
         int j = i - 1;
         while ( j >= 0 && key < inputArr[j] ) {
            inputArr[j + 1] = inputArr[j];
            j--;
         }
         inputArr[j + 1] = key;
         for ( int m = 0; m < inputArr.length; m++ ) {
            System.out.print( inputArr[m] + ", " );
         }
         System.out.println();
      }
      for ( int m = 0; m < inputArr.length; m++ ) {
         System.out.print( inputArr[m] + ", " );
      }
   }

}
