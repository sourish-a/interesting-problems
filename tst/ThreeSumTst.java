import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ThreeSumTst {

    @Test
    public void attempt1Tst1() {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4, -1};
        List<List<Integer>> nums1Expected = new ArrayList<>();
        List<Integer> nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(2);
        nums1Expected.add(nums1ExpectedTemp);
        nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(0); nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(1);
        nums1Expected.add(nums1ExpectedTemp);
        Assert.assertEquals(nums1Expected, ThreeSum.attempt1(nums1));
    }


    @Test
    public void attempt1Tst2() {
        int[] nums2 = new int[]{1, 2, -2, -1};
        List<List<Integer>> nums2Expected = new ArrayList<>();
        Assert.assertEquals(nums2Expected, ThreeSum.attempt1(nums2));
    }

    @Test
    public void attempt2Tst1() {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4, -1};
        List<List<Integer>> nums1Expected = new ArrayList<>();
        List<Integer> nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(0); nums1ExpectedTemp.add(1); nums1ExpectedTemp.add(-1);
        nums1Expected.add(nums1ExpectedTemp);
        nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(2); nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(-1);
        nums1Expected.add(nums1ExpectedTemp);
        Assert.assertEquals(nums1Expected, ThreeSum.attempt2(nums1));
    }

    @Test
    public void attempt3Tst1() {
        int[] nums1 = new int[]{-1, 0, 1, 2, -1, -4, -1};
        List<List<Integer>> nums1Expected = new ArrayList<>();
        List<Integer> nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(2);
        nums1Expected.add(nums1ExpectedTemp);
        nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(-1); nums1ExpectedTemp.add(0); nums1ExpectedTemp.add(1);
        nums1Expected.add(nums1ExpectedTemp);
        Assert.assertEquals(nums1Expected, ThreeSum.attempt3(nums1));
    }

    @Test
    public void attempt3Tst2() {
        int[] nums1 = new int[]{-2,0,0,2,2};
        List<List<Integer>> nums1Returned = ThreeSum.attempt3(nums1);
        List<List<Integer>> nums1Expected = new ArrayList<>();
        List<Integer> nums1ExpectedTemp = new ArrayList<>();
        nums1ExpectedTemp.add(-2); nums1ExpectedTemp.add(0); nums1ExpectedTemp.add(2);
        nums1Expected.add(nums1ExpectedTemp);
        Assert.assertEquals(nums1Expected, nums1Returned);
    }
}
