import java.util.Arrays;

/**
 * @Title: MaxProductDifference
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/21 09:24
 * @Description: Leetcode 1913 easy
 */
// leetcode: https://leetcode.cn/problems/maximum-product-difference-between-two-pairs/
public class MaxProductDifference {
    // 数组中的数都是正数,先对数组排序,然后取两个最小的数和两个最大的数的乘积的差
    // 时间复杂度O(nlogn)
    // 空间复杂度O(1)
    // 最笨的方法,但是能过
//    public int maxProductDifference(int[] nums) {
//        Arrays.sort(nums);
//        int N = nums.length;
//        return nums[N - 1] * nums[N - 2] - nums[0] * nums[1];
//    }

    // 还有一种方法就是直接寻找最大的两个数和最小的两个数,然后乘积再相减
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    // 最优的方法
    public int maxProductDifference(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return (max1 * max2) - (min1 * min2);
    }
}
