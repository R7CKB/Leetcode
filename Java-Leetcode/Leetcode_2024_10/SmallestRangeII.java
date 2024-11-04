import java.util.Arrays;

/**
 * @Title: SmallestRangeII
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/20 10:10
 * @Description: Leetcode 910 medium
 */
// leetcode: https://leetcode.cn/problems/smallest-range-ii/description/
public class SmallestRangeII {
    // 和上一个差差不多,唯一不同的是对数组中的每一个数都必须要进行变化
    // 暴力方法,创建两个数组,分别存储nums[i]+k和nums[i]-k,然后遍历数组,找出最小的差值
    // 时间复杂度O(n^2)
    // 要使得max-min最小,需要使得max最小,min最大
    // 小的变大,大的变小
    public int smallestRangeII(int[] nums, int k) {
        int N = nums.length;
        // 先将数组进行排序
        Arrays.sort(nums);
        // 刚开始的ans对应着把所有数都变大或者把所有数都变小的情况
        int ans = nums[N - 1] - nums[0];
        // 遍历数组,找出最小的差值
        for (int i = 1; i < N; i++) {
            int min = Math.min(nums[0] + k, nums[i] - k);
            int max = Math.max(nums[N - 1] - k, nums[i - 1] + k);
            ans = Math.min(ans, max - min);
        }
        return ans;
    }
}
