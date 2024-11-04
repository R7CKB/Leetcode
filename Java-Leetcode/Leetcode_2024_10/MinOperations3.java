/**
 * @Title: MinOperations3
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/23 08:56
 * @Description: Leetcode 3065 easy
 */
// leetcode: https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-i/description/
public class MinOperations3 {
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < k) {
                count++;
            }
        }
        return count;
    }
}
