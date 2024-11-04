package LeetCode_2024_9;

/**
 * @Title: DifferenceOfSum
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/26 20:54
 * @description: Leetcode
 */
// leetcode: https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/
public class DifferenceOfSum {
    public int differenceOfSum(int[] nums) {
        int arrSum = 0;
        int digitSum = 0;
        for (int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
            while (nums[i] != 0) {
                digitSum += nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return Math.abs(arrSum - digitSum);
    }

    // 根据灵神的代码修改,可以只使用一个变量来进行记录,然后一直减即可
    // 根本原理在于元素值一定不小于数位和
    public int differenceOfSum2(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            while (nums[i] != 0) {
                res -= nums[i] % 10;
                nums[i] /= 10;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DifferenceOfSum differenceOfSum = new DifferenceOfSum();
        System.out.println(differenceOfSum.differenceOfSum(new int[]{1, 15, 6, 3}));
    }
}
