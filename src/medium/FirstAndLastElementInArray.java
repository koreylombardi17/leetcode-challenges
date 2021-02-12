package medium;

public class FirstAndLastElementInArray {

    // Given an array of integers nums sorted in ascending order, find the starting and
    // ending position of a given target value.
    //
    //If target is not found in the array, return [-1, -1].

    public int binarySearch(int[] nums, int target, boolean left) {

        int low = 0;
        int high = nums.length;
        int mid = 1;

        // If low is greater than high, value is not in array
        while(low < high) {

            // Middle index of search
            mid = (low + high) / 2;

            // Drop left side
            if (nums[mid] < target) {
                low = mid + 1;
            }
            // Drop right side
            else if (nums[mid] > target) {
                high = mid;
            }
            // Found target
            else {

                // Finding leftmost index of target
                if (left) {

                    // Keep moving left until index not equal to target, or index reaches 0
                    while(  (mid > 0) && (nums[mid - 1] == target)  ) {
                        mid--;
                    }

                    return mid;
                }
                // Finding rightmost index of target
                else {

                    // Keep moving right until index not equal to target, or index reaches (length-1)
                    while(  (mid < (nums.length - 1)) && (nums[mid + 1] == target)  ) {
                        mid++;
                    }
                }

                return mid;
            }
        }

        // Value is not in array
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        // Empty array
        if (nums.length == 0) {
            return new int[]{-1,-1};
        }

        // Search for left most index of target
        int leftIndex = binarySearch(nums, target, true);

        // If leftmost index = -1, target does not exist in array
        if (leftIndex == -1) {
            return new int[]{-1,-1};
        }

        // Search for right most index of target
        else {
            int rightIndex = binarySearch(nums, target, false);
            return new int[]{leftIndex, rightIndex};
        }
    }
}
