import java.util.Arrays;

/**
 * Title: MaxTotalReward
 * Author: R7CKB
 * Package PACKAGE_NAME
 * Date: 2024/10/25 09:33
 * Description: Leetcode 3180 medium
 */
// leetcode: https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/
public class MaxTotalReward {
    // 根据灵神的思路得出的结果

//    public int maxTotalReward(int[] rewardValues) {
//        // 对于 rewardValues 中的数，如果先选大的，就没法再选小的，所以按照从小到大的顺序选是最优的。
//        // 定义 f[i][j] 表示能否从 rewardValues 的前 i 个数中得到总奖励 j。
//        // 设 rewardValues 的第 i 个数为 v，考虑 v 选或不选：
//        //     不选 v，问题变成能否从前 i−1 个数中得到总奖励 j，即 f[i][j]=f[i−1][j]。
//        //     选 v，问题变成能否从前 i−1 个数中得到总奖励 j−v，即 f[i][j]=f[i−1][j−v]，
//        //     前提是 j 满足 j≥v 且 j−v<v，即 v≤j<2v。
//        //
//        // 选或不选满足其一即可，所以有
//        // f[i][j]=f[i−1][j]∨f[i−1][j−v]
//        // 其中 ∨ 即编程语言中的 ||。
//        // 初始值 f[0][0]=true。
//        // 答案为最大的满足 f[n][j]=true 的 j。
//        Arrays.sort(rewardValues);
//        int N = rewardValues.length;
//        // 要最大和，我们的最大单数为2000，那么前面和为1999时，加上2000最大。所以01背包范围是3999
//        int M = 2 * rewardValues[N - 1];
//        boolean[][] dp = new boolean[N + 1][M];
//        dp[0][0] = true;
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j < M; j++) {
//                int v = rewardValues[i - 1];
//                dp[i][j] = dp[i - 1][j] || (j >= v && j < 2 * v && dp[i - 1][j - v]);
//            }
//        }
//        for (int i = M - 1; i >= 0; i--) {
//            if (dp[N][i]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    // 以上的方法还可以进行优化
    // 没必要每次都把j从0到m遍历一遍（因为不满足j∈[v,2v)的dp[i][j]一定等于dp[i-1][j]），
    // 可以直接先复制dp[i-1]行，然后再考虑j∈[v,2v)的情况：
//    public int maxTotalReward(int[] rewardValues) {
//        Arrays.sort(rewardValues);
//        int N = rewardValues.length;
//        int M = 2 * rewardValues[N - 1];
//        boolean[][] dp = new boolean[N + 1][M];
//        dp[0][0] = true;
//        for (int i = 1; i <= N; i++) {
//            dp[i] = dp[i - 1];
//            int v = rewardValues[i - 1];
//            for (int j = v; j < 2 * v; j++) {
//                if (dp[i - 1][j - v]) {
//                    dp[i][j] = true;
//                }
//            }
//        }
//        for (int i = M - 1; i >= 0; i--) {
//            if (dp[N][i]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    // 最后可以看出可以直接删除第一个维度,更加节省空间和时间
    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        int N = rewardValues.length;
        int M = 2 * rewardValues[N - 1];
        boolean[] dp = new boolean[M];
        dp[0] = true;
        for (int i = 1; i <= N; i++) {
            int v = rewardValues[i - 1];
            for (int j = v; j < 2 * v; j++) {
                if (dp[j - v]) {
                    dp[j] = true;
                }
            }
        }
        for (int i = M - 1; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}
