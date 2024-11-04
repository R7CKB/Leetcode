/**
 * @Title: MinimumDifference
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/9 20:17
 * @Description: Leetcode 3171 hard cheated
 */
// leetcode: https://leetcode.cn/problems/find-subarray-with-bitwise-or-closest-to-k/description/
public class MinimumDifference {

    // 自己写的暴力方法,确实没问题,就是时间复杂度太高了,超时
//    public int minimumDifference(int[] nums, int k) {
//        // 遍历所有子数组,然后再求绝对值最小
//        int N = nums.length;
//        int sumOr = 0;
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < N; i++) {
//            sumOr = 0;
//            for (int j = i; j < N; j++) {
//                sumOr = sumOr | nums[j];
//                result = Math.min(result, Math.abs(sumOr - k));
//            }
//        }
//        return result;
//    }

    // 灵神的第一种解法也是暴力方法,时间复杂度也是O(N^2),根据灵神的优化一下
    public int minimumDifference(int[] nums, int k) {
        // 遍历所有子数组,然后再求绝对值最小
        int N = nums.length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int x = nums[i];
            // 应对数组中只有一个数的情况,算出结果
            result = Math.min(result, Math.abs(x - k));
            // 灵神的优化在这个循环里
            // 即对于两个二进制数 a 和 b，如果 a ∣ b=a，那么 b 对应的集合是 a 对应的集合的子集。
            for (int j = i; j < N && (nums[j] | result) != nums[j]; j++) {
                nums[j] |= x;
                result = Math.min(result, Math.abs(nums[j] - k));
            }
        }
        return result;
    }


    // 灵神的方法
//    public int minimumDifference(int[] nums, int k) {
//
//    }
    public static void main(String[] args) {
        MinimumDifference md = new MinimumDifference();
        System.out.println(md.minimumDifference(new int[]{1,2,4,5}, 3));
    }
}
