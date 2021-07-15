public class LongestCommonPrefix {
    public String attempt1(String[] strs) {
        StringBuilder commonPrefix = new StringBuilder();
        char commonChar;
        for (int j = 0; j < strs[0].length(); j++) {
            commonChar = strs[0].charAt(j);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= j) {
                    return commonPrefix.toString();
                } else if (strs[i].charAt(j) != commonChar) {
                    return commonPrefix.toString();
                }
            }
            commonPrefix.append(commonChar);
        }
        return commonPrefix.toString();
    }
}
