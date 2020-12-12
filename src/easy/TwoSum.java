package easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

//    Given an array of integers values and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.

    public int[] twoSum(int[] values, int target) {
        Map<Integer, Integer> data = new HashMap<>();
        for(int i = 0; i < values.length; i++) {
            int goldenNumber = target - values[i];
            if(data.containsKey(goldenNumber)) {
                return new int[] {data.get(goldenNumber), i};
            }
            data.put(values[i], i);
        }
        return null;
    }
}
