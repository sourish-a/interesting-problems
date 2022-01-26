import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class LengthOfLongestSubstring {

    /**
     * Key Idea: The sliding window. After you hit a repeat character, update the starting index to the next valid start.
     * Good for checking constraints with consecutive values (like a substring).
     */

    
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

    // I realized I don't actually need the queue, what I need is the index of the first occurrence of the repeated element
    // The queue served this purpose by updating the new start without actually keeping track of any indices
    public static int attempt2(String s) {
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

    // If we are just using the extended ASCII character set, we can directly map character to index using an array
    public static int attempt3(String s) {
        int[] chars = new int[256];
        Arrays.fill(chars, -1);
        int currSubstringStart = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (chars[currChar] != -1) {
                maxCount = Math.max(i - currSubstringStart, maxCount);
                currSubstringStart = Math.max(chars[currChar] + 1, currSubstringStart);
                chars[currChar] = i;
            } else {
                chars[currChar] = i;
            }
        }
        maxCount = Math.max(s.length() - currSubstringStart, maxCount);
        return maxCount;
    }

    // Attempting a submission with regular 128 ASCII characters
    public static int attempt4(String s) {
        int[] chars = new int[128];
        Arrays.fill(chars, -1);
        int currSubstringStart = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (chars[currChar] != -1) {
                maxCount = Math.max(i - currSubstringStart, maxCount);
                currSubstringStart = Math.max(chars[currChar] + 1, currSubstringStart);
            }
            chars[currChar] = i;
        }
        maxCount = Math.max(s.length() - currSubstringStart, maxCount);
        return maxCount;
    }

    public static void main(String args[]) {
        System.out.println(attempt3("abba"));
        System.out.println(attempt3("abcabcbb"));
        System.out.println(attempt3("pwwkew"));
        System.out.println(attempt3("bbbbb"));
        System.out.println(attempt3(" "));
    }
}
