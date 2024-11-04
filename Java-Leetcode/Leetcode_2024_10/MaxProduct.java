import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Title: MaxProduct
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/10 19:25
 * @Description: Leetcode 1464 easy
 */
// leetcode: https://leetcode.cn/problems/maximum-product-of-two-elements-in-an-array/description/
public class MaxProduct {
    /**
     * 这个问题的本质就是寻找最大值和次大值的乘积,,只不过故意包装了一下,
     * 使其得出最大值-1和次大值-1的乘积
     *
     * @param nums 数组
     * @return 最大值和次大值的乘积
     */

    // 暴力方法,双层循环,时间复杂度O(n^2)
//    public int maxProduct(int[] nums) {
//        int result = 0;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                result = Math.max(result, (nums[i] - 1) * (nums[j] - 1));
//            }
//        }
//        return result;
//    }

    // 通过提示,可以用排序的方法,时间复杂度O(nlogn)
    // 先对数组进行排序,然后取数组的最后两个元素的乘积
//    public int maxProduct(int[] nums) {
//        Arrays.sort(nums);
//        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
//    }

    // 通过提示,还有一种方法就是使用堆
//    public int maxProduct(int[] nums) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//        for (int num : nums) {
//            pq.offer(num);
//        }
//        return (pq.poll()-1)* (pq.poll() - 1);
//    }

    // 以上三种方法都一般,还有一种方法可以实现O(n)时间复杂度,
    // 就是使用两个变量,一个记录最大值,一个记录次大值,然后遍历数组,
    // 如果当前元素大于最大值,则更新最大值;如果当前元素小于最大值,
    // 则更新次大值;如果当前元素等于最大值,则更新次大值;
    // 如果当前元素等于次大值,则什么都不做;最后返回最大值-1和次大值-1的乘积.
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max) {
                max2 = max;
                max = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return (max - 1) * (max2 - 1);
    }

}
