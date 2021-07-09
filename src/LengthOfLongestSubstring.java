import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class LengthOfLongestSubstring {

    public static int attempt1(String s) {
        Set<Character> chars = new HashSet<>();
        Queue<Character> substrings = new LinkedList<>();
        int currCount = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars.contains(s.charAt(i))) {
                maxCount = Math.max(currCount, maxCount);
                char temp = substrings.poll();
                chars.remove(temp);
                currCount--;
                while (temp != s.charAt(i)) {
                    temp = substrings.poll();
                    chars.remove(temp);
                    currCount--;
                }
            }
            chars.add(s.charAt(i));
            substrings.add(s.charAt(i));
            currCount++;
        }
        return maxCount;
    }

    public static int attempt2(String s) {
        // I realized I don't actually need the queue, what I need is the index of the first occurrence of the repeated element
        Map<Character, Integer> chars = new HashMap<>();
        int currSubstringStart = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (chars.containsKey(currChar)) {
                maxCount = Math.max(i - currSubstringStart, maxCount);
                currSubstringStart = Math.max(chars.get(currChar) + 1, currSubstringStart);
                chars.put(currChar, i);
            } else {
                chars.put(currChar, i);
            }
        }
        maxCount = Math.max(s.length() - currSubstringStart, maxCount);
        return maxCount;
    }

    public static void main(String args[]) {
        System.out.println(attempt2("abba"));
        System.out.println(attempt2("abcabcbb"));
        System.out.println(attempt2("pwwkew"));
        System.out.println(attempt2("bbbbb"));
        System.out.println(attempt2(" "));
    }
}
