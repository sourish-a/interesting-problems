import org.junit.Assert;
import org.junit.Test;

public class LongestPalindromicSubstringTst {

    @Test
    public void attempt1Tst() {

        String t1 = "babad";
        String t2 = "cbbd";
        String t3 = "a";
        String t4 = "ac";
        String t5 = " ";
        String t6 = "abcbdeffe";
        String t7 = "ccc";

        Assert.assertEquals("bab", LongestPalindromicSubstring.attempt1(t1));
        Assert.assertEquals("bb", LongestPalindromicSubstring.attempt1(t2));
        Assert.assertEquals("a", LongestPalindromicSubstring.attempt1(t3));
        Assert.assertEquals("a", LongestPalindromicSubstring.attempt1(t4));
        Assert.assertEquals(" ", LongestPalindromicSubstring.attempt1(t5));
        Assert.assertEquals("effe", LongestPalindromicSubstring.attempt1(t6));
        Assert.assertEquals("ccc", LongestPalindromicSubstring.attempt1(t7));
        Assert.assertEquals("aaaa", LongestPalindromicSubstring.attempt1("aaaa"));
    }
}
