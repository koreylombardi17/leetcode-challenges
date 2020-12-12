package hard;

public class FindMedianSortedArrays {

    // Given two sorted arrays nums1 and nums2 of size m and n respectively,
    // return the median of the two sorted arrays.
    // The overall run time complexity should be O(log (m+n)).


    public static void main(String[] args) {

        int[] list1 = {1,3};
        int[] list2 = {2};
        System.out.println(findMedianSortedArrays(list1, list2));
    }

    public static double findMedianSortedArrays(int[] A, int[] B) {
        // A must be have less elements than B
        if (A.length > B.length) {
            return findMedianSortedArrays(B, A);
        }
        int lengthA = A.length;
        int lengthB = B.length;
        int xMin = 0, xMax = lengthA, half = (lengthA + lengthB + 1) / 2;

        while (xMin <= xMax) {
            int x = (xMin + xMax) / 2;
            int y = half - x;

            // x is too small
            if (x < xMax && B[y-1] > A[x]){
                xMin = x + 1;
            }
            // x is too large
            else if(x > xMin && A[x-1] > B[y]){
                xMax = x - 1;
            }
            else{
                int maxLeft;
                if (x == 0){
                    maxLeft = B[y-1];
                }
                else if (y == 0){
                    maxLeft = A[x-1];
                } else {
                    maxLeft = Math.max(A[x-1], B[y-1]);
                }

                // odd number of elements
                if ((lengthA + lengthB) % 2 == 1){
                    return maxLeft;
                }
                // even number of elements
                int minRight;
                if (x == lengthA){
                    minRight = B[y];
                }else if (y == lengthB){
                    minRight = A[x];
                }
                else{
                    minRight = Math.min(B[y], A[x]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
}
