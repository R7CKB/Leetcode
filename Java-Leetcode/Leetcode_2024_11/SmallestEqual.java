/**
 * Title: SmallestEqual
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/1 14:42
 * Description: Leetcode 2057 easy
 */
// leetcode: https://leetcode.cn/problems/smallest-index-with-equal-value/
public class SmallestEqual {
    // 暴力方法
//    public int smallestEqual(int[] nums) {
//        int res = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (i % 10 == nums[i]) {
//                res = Math.min(res, i);
//            }
//        }
//        return res == Integer.MAX_VALUE ? -1 : res;
//    }

    // 优化方法
    public int smallestEqual(int[] nums) {
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                return i;
            }
        }
        return -1;
    }


}
