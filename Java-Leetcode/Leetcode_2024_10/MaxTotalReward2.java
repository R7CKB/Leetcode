import java.math.BigInteger;
import java.util.Arrays;

/**
 * Title: MaxTotalReward2
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/25 10:51
 * Description: Leetcode 3181 hard
 */
// leetcode: https://leetcode.cn/problems/maximum-total-reward-using-operations-ii/description/
public class MaxTotalReward2 {
    // 使用之前一题的做法会使得时间复杂度过大
//    public int maxTotalReward(int[] rewardValues) {
//        Arrays.sort(rewardValues);
//        int N = rewardValues.length;
//        int M = 2 * rewardValues[N - 1];
//        boolean[] dp = new boolean[M];
//        dp[0] = true;
//        for (int i = 1; i <= N; i++) {
//            int v = rewardValues[i - 1];
//            for (int j = v; j < 2 * v; j++) {
//                if (dp[j - v]) {
//                    dp[j] = true;
//                }
//            }
//        }
//        for (int i = M - 1; i >= 0; i--) {
//            if (dp[i]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    // 使用BigInteger解答,这个方法也会爆
//    public int maxTotalReward(int[] rewardValues) {
//        BigInteger f = BigInteger.ONE;
//        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
//            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
//            f = f.or(f.and(mask).shiftLeft(v));
//        }
//        return f.bitLength() - 1;
//    }

    public int maxTotalReward(int[] rewardValues) {
        int m = 0;
        for (int v : rewardValues) {
            m = Math.max(m, v);
        }
        for (int v : rewardValues) {
            if (v == m - 1) {
                return m * 2 - 1;
            }
        }

        BigInteger f = BigInteger.ONE;
        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
        }
        return f.bitLength() - 1;
    }


}
