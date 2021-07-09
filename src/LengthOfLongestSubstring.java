import java.util.Queue;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;

public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> chars = new HashSet<>();
        Queue<Character> substrings = new LinkedList<>();
        int currCount = 0, maxCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (chars.contains(s.charAt(i))) {
                maxCount = Math.max(currCount, maxCount);
                //System.out.println(maxCount);
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
            //System.out.println(currCount);
            //System.out.print(substrings + " "); System.out.println(chars);
        }
        return maxCount;
    }

    public static void main(String args[]) {
        System.out.println(lengthOfLongestSubstring("abcabcabcbb"));
    }
}
