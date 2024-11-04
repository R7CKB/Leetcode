/**
 * @Title: RunningSum
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/3 20:03
 * @description: Leetcode 1480 easy
 */
// leetcode: https://leetcode.cn/problems/running-sum-of-1d-array/description/
public class RunningSum {
    public int[] runningSum(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        return sums;
    }
}
