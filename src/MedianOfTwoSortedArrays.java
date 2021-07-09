public class MedianOfTwoSortedArrays {

    public static double attempt1(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        if (merged.length % 2 != 0) {
            return (double) merged[merged.length/2];
        }
        return (merged[merged.length/2 - 1] + merged[merged.length/2])/2.0;
    }

    /**
     * Helper function to merge two sorted arrays together
     */
    public static int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int num1Index = 0, num2Index = 0, mergedIndex = 0;
        while (num1Index < nums1.length && num2Index < nums2.length) {
            if (nums1[num1Index] <= nums2[num2Index]) {
                merged[mergedIndex] = nums1[num1Index];
                num1Index++;
            } else {
                merged[mergedIndex] = nums2[num2Index];
                num2Index++;
            }
            mergedIndex++;
        }
        if (num1Index < nums1.length) {
            for (; num1Index < nums1.length; num1Index++) {
                merged[mergedIndex] = nums1[num1Index];
                mergedIndex++;
            }
        } else if (num2Index < nums2.length) {
            for (; num2Index < nums2.length; num2Index++) {
                merged[mergedIndex] = nums2[num2Index];
                mergedIndex++;
            }
        }
        return merged;
    }

    public static void main(String[] args) {
        int[] one = new int[]{1, 3};
        int[] two = new int[]{2};
        int[] merged = merge(one, two);
        for (Integer i : merged) {
            System.out.print(i + " ");
        }
    }

    // 1 2 7 9 10 16 18
    // 3 5 8 9
}
