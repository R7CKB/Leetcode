import java.util.Arrays;

/**
 * Title: AddedInteger
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/27 10:28
 * Description: Leetcode 3131 easy
 */
// leetcode: https://leetcode.cn/problems/find-the-integer-added-to-array-i/
public class AddedInteger {
    // 暴力方法,排序数组
//    public int addedInteger(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Arrays.sort(nums2);
//        return nums2[0] - nums1[0];
//    }

    // 更加简单的方法,找到两个数组的最小值相减即为答案
//    public int addedInteger(int[] nums1, int[] nums2) {
//        return min(nums2) - min(nums1);
//    }
//
//    private int min(int[] nums) {
//        int res = Integer.MAX_VALUE;
//        for (int num : nums) {
//            res = Math.min(res, num);
//        }
//        return res;
//    }

    // 还有一种方法是使用Java的API
    public int addedInteger(int[] nums1, int[] nums2) {
        return Arrays.stream(nums2).min().getAsInt() + Arrays.stream(nums1).min().getAsInt();
    }
}
