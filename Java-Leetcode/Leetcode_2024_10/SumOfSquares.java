/**
 * @Title: SumOfSquares
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/24 20:18
 * @Description: Leetcode 2778 easy
 */
// leetcode: https://leetcode.cn/problems/sum-of-squares-of-special-elements/description/
public class SumOfSquares {
    // 灵神的方法
//    public int sumOfSquares(int[] nums) {
//        int sum = 0;
//        int N = nums.length;
//        for (int i = 1; i * i <= N; i++) {
//            if (N % i == 0) {
//                sum += nums[i - 1] * nums[i - 1];
//                if (i * i < N) { // 避免重复统计
//                    sum += nums[N / i - 1] * nums[N / i - 1];
//                }
//            }
//        }
//        return sum;
//    }

    // 暴力方法
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        int N = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (N % (i + 1) == 0) {
                sum += nums[i] * nums[i];
            }
        }
        return sum;
    }
}
