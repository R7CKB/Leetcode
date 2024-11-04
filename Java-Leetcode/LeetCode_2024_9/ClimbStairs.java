package LeetCode_2024_9;

// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
// leetcode链接:https://leetcode.cn/problems/climbing-stairs/description/
public class ClimbStairs {
    // 最简单的方法，递归求解,但是时间会超时
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    // 动态规划，用数组存储中间结果，避免重复计算
    public int climbStairsDp(int n) {
        // 测试用例有n=1,所以需要更改下
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        ClimbStairs cs = new ClimbStairs();
        System.out.println(cs.climbStairs(1));
        System.out.println(cs.climbStairsDp(1));
    }
}
