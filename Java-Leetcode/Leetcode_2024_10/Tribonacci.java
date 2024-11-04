/**
 * @Title: Tribonacci
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/21 09:03
 * @Description: Leetcode 1137 easy
 */
// leetcode: https://leetcode.cn/problems/n-th-tribonacci-number/description/
public class Tribonacci {
    // 先是采用递归方法计算
//    public int tribonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1 || n == 2) return 1;
//        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
//    }

    // 采用记忆法搜索方法
//    public int tribonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1 || n == 2) return 1;
//        int[] memo = new int[n + 1];
//        memo[0] = 0;
//        memo[1] = 1;
//        memo[2] = 1;
//        return tribonacciHelper(n, memo);
//    }
//    private int tribonacciHelper(int n, int[] memo) {
//        if (n == 0) return memo[0];
//        if (n == 1) return memo[1];
//        if (n == 2) return memo[2];
//        if (memo[n] != 0) {
//            return memo[n];
//        }
//        return memo[n] = tribonacciHelper(n - 1, memo) + tribonacciHelper(n - 2, memo) + tribonacciHelper(n - 3, memo);
//    }

    // 采用动态规划方法
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }
}
