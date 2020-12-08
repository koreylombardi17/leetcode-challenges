package medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    // Given a string s, find the length of the longest
    // substring without repeating characters.

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int longest = 0;

        for(int left = 0, right = 0; right < s.length(); right++) {
            if (!chars.containsKey(s.charAt(right))) {
                chars.put(s.charAt(right), right);
            }
            else if(chars.get(s.charAt(right)) < left){
                chars.put(s.charAt(right), right);
            }
            else{
                left = chars.get(s.charAt(right)) + 1;
                chars.put(s.charAt(right), right);
            }
            longest = Math.max(longest, (right - left) + 1);
        }
        return longest;
    }

}
