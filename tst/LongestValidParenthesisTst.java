import org.junit.Assert;
import org.junit.Test;

public class LongestValidParenthesisTst {
    @Test
    public void attempt1Tst1() {
        String input = "";
        Assert.assertEquals(0, LongestValidParenthesis.attempt1(input));

        input = "(()"; // "())"
        Assert.assertEquals(2, LongestValidParenthesis.attempt1(input));

        input = ")()())";
        Assert.assertEquals(4, LongestValidParenthesis.attempt1(input));

        input = "()(()";
        Assert.assertEquals(2, LongestValidParenthesis.attempt1(input));

        input = "())()";
        Assert.assertEquals(2, LongestValidParenthesis.attempt1(input));
    }
}
