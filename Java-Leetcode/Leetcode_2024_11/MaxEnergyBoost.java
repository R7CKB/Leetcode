import java.util.Arrays;

/**
 * Title: MaxEnergyBoost
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/1 09:11
 * Description: Leetcode 3259 medium
 */
// leetcode: https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/
public class MaxEnergyBoost {
    /**
     * 做题思路:
     * 最后一个数必须要选,所以我们可以从最后一个数开始考虑,
     * 假设最后一个元素是A,我们可以从后往前考虑,而且只有两种策略:
     * 1. 我们可以选择A之前的第一个元素,
     * 2. 或是另一个数组同等位置之前的第二个元素,
     * 这样子就会把一个复杂的问题拆分成两个简单的子问题,
     * 对于每个子问题,我们又可以进行拆分,一直到只剩下两个元素,
     */

    // Leetcode题解
//    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
//        int N = energyDrinkA.length;
//        long[] dpA = new long[N];
//        long[] dpB = new long[N];
//        dpA[0] = energyDrinkA[0];
//        dpA[1] = dpA[0] + energyDrinkA[1];
//        dpB[0] = energyDrinkB[0];
//        dpB[1] = dpB[0] + energyDrinkB[1];
//        for (int i = 2; i < N; i++) {
//            dpA[i] = Math.max(dpA[i - 1], dpB[i - 2]) + energyDrinkA[i];
//            dpB[i] = Math.max(dpB[i - 1], dpA[i - 2]) + energyDrinkB[i];
//        }
//        return Math.max(dpA[N - 1], dpB[N - 1]);
//    }

    // 灵神的方法1:记忆法搜索
//    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
//        int n = energyDrinkA.length;
//        // c数组下标0表示a,下标1表示b
//        int[][] c = {energyDrinkA, energyDrinkB};
//        // 记忆数组
//        long[][] memo = new long[n][2];
//        // j=0表示喝a,j=1表示喝b
//        return Math.max(dfs(n - 1, 0, c, memo), dfs(n - 1, 1, c, memo));
//
//    }
//
//    // dfs(i,j)表示在下标[0,i]中选数
//    // 且下标i选的数是a[i](j=0)还是b[i](j=1)
//    // 在这种情况下,所选数字之和的最大值
//    // j=0时要变成1,j=1时要变成0,所以使用j^1
//    private long dfs(int i, int j, int[][] c, long[][] memo) {
//        if (i < 0) {
//            return 0;
//        }
//        if (memo[i][j] > 0) { // 之前计算过
//            return memo[i][j];
//        }
//        return memo[i][j] = Math.max(dfs(i - 1, j, c, memo),
//                dfs(i - 2, j ^ 1, c, memo)) + c[j][i];
//    }

    // 灵神的方法2:将记忆法搜索翻译成递推
//    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
//        int N = energyDrinkA.length;
//        long[][] f = new long[N + 2][2];
//        for (int i = 0; i < N; i++) {
//            f[i + 2][0] = Math.max(f[i + 1][0], f[i][1]) + energyDrinkA[i];
//            f[i + 2][1] = Math.max(f[i + 1][1], f[i][0]) + energyDrinkB[i];
//        }
//        return Math.max(f[N + 1][0], f[N + 1][1]);
//    }

    // 只需要考虑相邻的元素即可
//    public long maxEnergyBoost(int[] a, int[] b) {
//        long fa = 0, fb = 0;
//        for (int i = 0; i < a.length; i++) {
//            long tmp = fa;
//            fa = Math.max(fa + a[i], fb);
//            fb = Math.max(fb + b[i], tmp);
//        }
//        return Math.max(fa, fb);
//    }

    // Terry的更加详细的方法(可读性更好)
    int[] energyDrinkA;
    int[] energyDrinkB;
    long[][] memo;

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        this.energyDrinkA = energyDrinkA;
        this.energyDrinkB = energyDrinkB;
        int n = energyDrinkA.length;
        memo = new long[n][2];
        for (long[] r : memo)
            Arrays.fill(r, -1);
        return Math.max(dfs(n - 1, 0), dfs(n - 1, 1));
    }

    private long dfs(int i, int j) {
        //i == 座标
        //j == 0 -> drink A, j == 1 -> drink B
        if (i < 0)
            return 0;
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        //继续喝
        //因为下一杯会喝同一种，所以这一杯的能量可以拿到
        long res1 = dfs(i - 1, j) + (j == 0 ? energyDrinkA[i] : energyDrinkB[i]);
        //换一杯
        //因为知道要换一杯喝，所以现在这一杯的能量直接不拿
        long res2 = dfs(i - 1, j ^ 1);
        memo[i][j] = Math.max(res1, res2);
        return memo[i][j];
    }

}
