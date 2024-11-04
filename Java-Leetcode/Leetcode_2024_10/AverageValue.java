/**
 * @Title: AverageValue
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/23 09:01
 * @Description: Leetcode 2455 easy
 */
// leetcode: https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/description/
public class AverageValue {
    public int averageValue(int[] nums) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 6 == 0) {
                sum += nums[i];
                count++;
            }
        }
        return sum == 0 ? 0 : sum / count;
    }
}
