import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSumClosest {
    public static int attempt1(int[] nums, int target) {
        int closestSoFar = Integer.MAX_VALUE;
        int dist = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int outerPrev = nums[0] + 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == outerPrev) continue;
            outerPrev = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) {
                    return target;
                } else {
                    int currDist = Math.abs(sum - target);
                    if (currDist < dist) {
                        closestSoFar = sum;
                        dist = currDist;
                    }
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return closestSoFar;
    }
}
