import org.junit.Assert;
import org.junit.Test;

public class ThreeSumClosestTst {

    @Test
    public void attempt1Tst() {
        //Assert.assertEquals(2, ThreeSumClosest.attempt1(new int[]{-1, 1, 2, 4}, 2));
        //Assert.assertEquals(2, ThreeSumClosest.attempt1(new int[]{-1, 1, 2, -4}, 1));
        //Assert.assertEquals(-2, ThreeSumClosest.attempt1(new int[]{-3,-2,-5,3,-4}, -1));
        Assert.assertEquals(2, ThreeSumClosest.attempt1(new int[]{-1,0,1,1,55}, 3));
    }
}
