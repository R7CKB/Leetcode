/**
 * @Title: SmallestRangeI
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/20 09:42
 * @Description: Leetcode 908 easy
 */
// leetcode: https://leetcode.cn/problems/smallest-range-i/description/?envType=daily-question&envId=2024-10-20
public class SmallestRangeI {
    // 数学问题:
    // 如果最大值和最小值的差值大于2*k,那么分数就为最大值减去最小值减去2*k
    // 否则就为0
    public int smallestRangeI(int[] nums, int k) {
        int N = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}
