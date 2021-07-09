
public class LongestPalindromicSubstring {
    public static String attempt1(String s) {
        if (s.length() <= 1) {
            return s;
        }
        String longestPalindromeSubstring = "", currPalindrome, currPalindrome2;
        for (int i = 0; i < s.length() - 1; i++) {
            currPalindrome = expandHelper(s, i, i);
            longestPalindromeSubstring = currPalindrome.length()>longestPalindromeSubstring.length() ?
                    currPalindrome :
                    longestPalindromeSubstring;
            currPalindrome = expandHelper(s, i, i+1);
            longestPalindromeSubstring = currPalindrome.length()>longestPalindromeSubstring.length() ?
                    currPalindrome :
                    longestPalindromeSubstring;
        }
        return longestPalindromeSubstring;
    }

    public static String expandHelper(String s, int middleStart, int middleEnd) {
        int frontIndex = middleStart, backIndex = middleEnd;
        while (frontIndex >= 0 && backIndex < s.length()) {
            if (s.charAt(frontIndex)==s.charAt(backIndex)) {
                if (frontIndex == 0 || backIndex == s.length() - 1)
                    break;
                else {
                    frontIndex--; backIndex++;
                }
            } else {
                frontIndex++; backIndex--;
                break;
            }
        }
        backIndex++;
        return s.substring(frontIndex, backIndex);
    }

    public static void main(String[] args) {
        String test = "abcbd";
        String test2 = "abcde";
        //System.out.println(expandHelper(test, 2));
        System.out.println(attempt1("ccc"));
    }


    //            if (frontIndex==backIndex) {
//                if (frontIndex + 1 < s.length() && frontIndex - 1 >= 0 && s.charAt(frontIndex - 1) == s.charAt(frontIndex + 1)) {
//                    frontIndex--; backIndex++;
//                    continue;
//                } else if (frontIndex + 1 < s.length() && s.charAt(frontIndex) == s.charAt(frontIndex + 1)) {
//                    backIndex++;
//                    continue;
//                } else if (frontIndex - 1 >= 0 && s.charAt(frontIndex - 1)==s.charAt(frontIndex)) {
//                    frontIndex--;
//                    continue;
//                }
//            }
}
