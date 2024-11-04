/**
 * Title: BuildArray
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/27 10:25
 * Description: Leetcode 1920 easy
 */
// leetcode: https://leetcode.cn/problems/build-array-from-permutation/description/
public class BuildArray {
    // 简单做法,好像也只有这一种做法
    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
