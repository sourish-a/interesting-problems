import org.junit.Assert;
import org.junit.Test;

public class RegularExpressionMatchingTst {

    @Test
    public void attempt1Tst() {
        String s = "aa", p = "a*";
        Assert.assertTrue(RegularExpressionMatching.attempt1(s, p));
    }
}
