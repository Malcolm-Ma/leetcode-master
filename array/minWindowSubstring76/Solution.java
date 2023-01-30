package array.minWindowSubstring76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<Character, Integer>();
        Map<Character, Integer> window = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            char cur = t.charAt(i);
            target.put(cur, target.getOrDefault(cur, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (target.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }

            while (valid == target.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (target.containsKey(d)) {
                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }

        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
