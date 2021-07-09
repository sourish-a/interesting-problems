import org.junit.Assert;
import org.junit.Test;

public class ZigZagConversionTst {
    ZigZagConversion converter = new ZigZagConversion();

    @Test
    public void attempt1Tst() {
        String t1 = "PAYPALISHIRING";
        Assert.assertEquals("PAHNAPLSIIGYIR", converter.attempt1(t1, 3));
        Assert.assertEquals("PINALSIGYAHRPI", converter.attempt1(t1, 4));
    }

    @Test
    public void attempt2Tst() {
        String t1 = "PAYPALISHIRING";
        Assert.assertEquals("PAHNAPLSIIGYIR", ZigZagConversion.attempt2(t1, 3));
        Assert.assertEquals("PINALSIGYAHRPI", ZigZagConversion.attempt2(t1, 4));
    }
}
