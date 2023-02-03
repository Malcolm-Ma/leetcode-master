package array.permutationInString567;

import java.util.HashMap;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> window = new HashMap<Character, Integer>();
        HashMap<Character, Integer> need = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            need.put(a, need.getOrDefault(a, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (need.get(d).equals(window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }
}
