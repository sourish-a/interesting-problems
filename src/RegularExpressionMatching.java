public class RegularExpressionMatching {
    public static boolean attempt1(String s, String p) {
        // base case
        if (p.isEmpty() || (s.isEmpty() && p.length()==2 && p.charAt(1)=='*'))
            return s.isEmpty();
        boolean cond = (s.charAt(0) == p.charAt(0) || s.charAt(0) == '.');
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (cond && attempt1(s.substring(1), p)) || attempt1(s, p.substring(2));
        }
        return cond && attempt1(s.substring(1), p.substring(1));
    }


}
