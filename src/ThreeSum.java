import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ThreeSum {

    public static List<List<Integer>> attempt1(int[] nums) {
        List<List<Integer>> rval = new ArrayList<>();
        Set<Set<Integer>> triples = new HashSet<>();
        Map<Integer, Integer> numToCount = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToCount.containsKey(nums[i])) {
                numToCount.put(nums[i], numToCount.get(nums[i]) + 1);
            } else {
                numToCount.put(nums[i], 1);
            }
        }
        int currNum;
        for (int i = 0; i < nums.length; i++) {
            currNum = nums[i];
            numToCount.put(currNum, numToCount.get(currNum) - 1);
            Optional<List<List<Integer>>> remaingTwosOp = attempt1Helper(numToCount, 0 - currNum);
            if (remaingTwosOp.isPresent()) {
                List<List<Integer>> remaingTwos = remaingTwosOp.get();
                for (int j = 0; j < remaingTwos.size(); j++) {
                    List<Integer> currTriple = new ArrayList<>();
                    currTriple.add(currNum);
                    currTriple.addAll(remaingTwos.get(j));
                    Set<Integer> currTripleSet = new HashSet<>();
                    currTripleSet.addAll(currTriple);
                    if (!triples.contains(currTripleSet)) {
                        triples.add(currTripleSet);
                        rval.add(currTriple);
                    }
                }
            }
            numToCount.put(currNum, numToCount.get(currNum) + 1);
        }
        return rval;
    }

    public static Optional<List<List<Integer>>> attempt1Helper(Map<Integer, Integer> numToCount, int target) {
        List<List<Integer>> rval = new ArrayList<>();
        for (Integer num : numToCount.keySet()) {
            if (numToCount.get(num) > 0) {
                numToCount.put(num, numToCount.get(num) - 1);
                if (numToCount.getOrDefault(target - num, 0) > 0) {
                    List<Integer> twoVals = new ArrayList<>();
                    twoVals.add(num);
                    twoVals.add(target - num);
                    rval.add(twoVals);
                }
                numToCount.put(num, numToCount.get(num) + 1);
            }
        }
        return rval.size() > 0 ? Optional.of(rval) : Optional.empty();
    }

    /**
     * I realized I can reduce the amount of duplicates calculated in the first place by iterating more efficiently.
     * @param nums
     * @return
     */
    public static List<List<Integer>> attempt2(int[] nums) {
        List<List<Integer>> rval = new ArrayList<>();
        Set<Set<Integer>> seenTriples = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> remainingTwos = attempt2Helper(nums, i + 1, 0 - nums[i], nums[i], seenTriples);
            rval.addAll(remainingTwos);
        }
        // rval = attempt2Helper2(rval);
        return rval;
    }

    /* TwoSum helper function for remainder of nums array starting from startIndex */
    public static List<List<Integer>> attempt2Helper(int[] nums, int startIndex, int target, int firstNum, Set<Set<Integer>> seenTriples) {
        Set<Integer> seen = new HashSet<>();
        List<List<Integer>> rval = new ArrayList<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (seen.contains(target - nums[i])) {
                List<Integer> currTriple = new ArrayList<>();
                currTriple.add(target - nums[i]);
                currTriple.add(nums[i]);
                currTriple.add(firstNum);
                Set<Integer> currTripleSet = new HashSet<>();
                currTripleSet.addAll(currTriple);
                if (!seenTriples.contains(currTripleSet)) {
                    seenTriples.add(currTripleSet);
                    rval.add(currTriple);
                }
                seen.remove(target - nums[i]);
            } else {
                seen.add(nums[i]);
            }
        }
        return rval;
    }

    /**
     * I realized I don't need set logic at all to prevent duplicate computation, I can sort the array first
     */
    public static List<List<Integer>> attempt3(int[] nums) {
        List<List<Integer>> rval = new ArrayList<>();
        Set<Integer> startVals = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (startVals.contains(nums[i])) {
                continue;
            }
            startVals.add(nums[i]);
            int prev = nums[i];
            int target = 0 - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target || (prev == nums[left] && left != i+1)) {
                    left++;
                } else if (sum == target) {
                    List<Integer> currTriple = new ArrayList<>();
                    currTriple.add(nums[i]);
                    currTriple.add(nums[left]);
                    currTriple.add(nums[right]);
                    rval.add(currTriple);
                    prev = nums[left];
                    left++; right--;
                } else {
                    right--;
                }
            }
        }
        return rval;
    }

    /**
     * I realized I can improve the memory usage by removing the Set for startVals, and instead just using the "prev"
     * logic for the outer loop as well
     */
    public static List<List<Integer>> attempt4(int[] nums) {
        List<List<Integer>> rval = new ArrayList<>();
        if (nums.length == 0) return rval;
        Arrays.sort(nums);
        int outerPrev = nums[0] + 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == outerPrev) continue;
            outerPrev = nums[i];
            int target = 0 - nums[i], left = i + 1, right = nums.length - 1;
            int prev = nums[left] + 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target || prev == nums[left]) {
                    prev = nums[left];
                    left++;
                } else if (sum == target) {
                    rval.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    prev = nums[left];
                    left++; right--;
                } else {
                    right--;
                }
            }
        }
        return rval;
    }
}
