/**
 * Title: IsArraySpecial
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/26 09:22
 * Description: Leetcode 3151 easy
 */
// leetcode:https://leetcode.cn/problems/special-array-i/
public class IsArraySpecial {
    // 暴力方法,直接一次遍历
//    public boolean isArraySpecial(int[] nums) {
//        if (nums.length < 2) return true;
//        for (int i = 1; i < nums.length; i++) {
//            // 两个偶数或者连续的两个奇数都会返回false
//            if ((nums[i] % 2 == 0 && nums[i - 1] % 2 == 0) ||
//                    (nums[i] % 2 == 1 && nums[i - 1] % 2 == 1)) return false;
//        }
//        return true;
//    }

    // 还可以更加简化判断条件
    public boolean isArraySpecial(int[] nums) {
        if (nums.length < 2) return true;
        for (int i = 1; i < nums.length; i++) {
            // 两个偶数或者连续的两个奇数都会返回false
            if (nums[i] % 2 == nums[i - 1] % 2) return false;
        }
        return true;
    }
}
