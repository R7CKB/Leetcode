/**
 * @Title: SuperEggDrop
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/14 17:17
 * @Description: Leetcode 887 hard
 */
// leetcode: https://leetcode.cn/problems/super-egg-drop/description/
public class SuperEggDrop {
    // 自己写的方法,时间复杂度太高了
    // 看李永乐老师的视频写出的代码
    //  https://www.bilibili.com/video/av96214853/
    // 这里写一个通解,对于T层楼,N个鸡蛋的解法:
    // M为最少操作次数,M只与T,N有关,所以我们可以用动态规划来求解
    // 但是这个时间复杂度太高,并不好用,具体可以看另一个类:SuperEggDrop.java
    public int NEggDrop(int floor, int eggs) {
        // 0的位置我们都忽略不计
        int[][] dp = new int[floor + 1][eggs + 1];
        // 对于T层楼,1个鸡蛋,最少需要T次
        for (int i = 1; i <= floor; i++) {
            dp[i][1] = i;
        }
        // 对于1层楼,N个鸡蛋,最少需要1次
        for (int j = 1; j <= eggs; j++) {
            dp[1][j] = 1;
        }
        // 对dp数组填充,动态规划求解
        for (int i = 2; i <= floor; i++) {
            for (int j = 2; j <= eggs; j++) {
                // 这里求当第一个鸡蛋从k = 1一直到k = i层扔时的情况
                int[] M_k = new int[i + 1];
                for (int k = 1; k <= i; k++) {
                    // 对于第k层楼,如果鸡蛋碎了,那么就只能在1~k-1层扔第二枚,
                    // 所以dp[k-1][j-1]就是在k层扔第二枚鸡蛋的最少操作次数
                    // 对于第k层楼,如果鸡蛋没碎,那么就只能在k+1~i层扔第二枚,
                    // 所以dp[i-k][j]就是在k层扔第二枚鸡蛋的最少操作次数
                    // 所以dp[k-1][j-1] + dp[i-k][j]就是在k层扔第二枚鸡蛋的最少操作次数
                    // 又因为在k层扔了一次,所以需要加1,所以dp[k-1][j-1] + dp[i-k][j] + 1
                    // 为什么是dp[k-1][j-1]?
                    M_k[k] = Math.max(dp[k - 1][j - 1], dp[i - k][j]) + 1;
                }
                // 挑出M_k的最小值,即为dp[i][j]
                // 不为0,因为从1层开始填充
                int min = M_k[1];
                for (int k = 1; k <= i; k++) {
                    min = Math.min(min, M_k[k]);
                }
                // 选择M_k的最小值,填充dp[i][j]
                dp[i][j] = min;
            }
        }
        return dp[floor][eggs];
    }

    // k为鸡蛋数，n为楼层数
    // 直接看灵神的题解:https://leetcode.cn/problems/super-egg-drop/solutions/2949779/jiao-ni-yi-bu-bu-si-kao-dpcong-ji-yi-hua-xkbx/
    // 第一种方法,记忆化搜索
//    public int superEggDrop(int k, int n) {
//        int[][] memo = new int[n + 1][];
//        for (int i = 1; ; i++) {
//            memo[i] = new int[k + 1]; // 动态创建 memo
//            if (dfs(i, k, memo) >= n) {
//                return i;
//            }
//        }
//    }
//
//    // i为楼层数,j为鸡蛋数,memo为记忆数组
//    // 递归函数,返回在i层楼扔j个鸡蛋最少需要的操作次数
//    // 记忆化搜索,避免重复计算
//    private int dfs(int i, int j, int[][] memo) {
//        if (i == 0 || j == 0) {
//            return 0;
//        }
//        if (memo[i][j] != 0) { // 之前计算过
//            return memo[i][j];
//        }
//        // dfs(i-1, j, memo)为鸡蛋没碎的情况
//        // dfs(i-1, j-1, memo)为鸡蛋碎了的情况,再加上当前的这一层
//        return memo[i][j] = dfs(i - 1, j, memo) + dfs(i - 1, j - 1, memo) + 1;
//    }

    // 灵神的第二种方法,将记忆化搜索改成递推
    // k是鸡蛋,n是楼层数
//    public int superEggDrop(int k, int n) {
//        int[][] f = new int[n + 1][k + 1];
//        for (int i = 1; ; i++) {
//            for (int j = 1; j <= k; j++) {
//                f[i][j] = f[i - 1][j] + f[i - 1][j - 1] + 1;
//            }
//            if (f[i][k] >= n) {
//                return i;
//            }
//        }
//    }

    // 灵神的第三种方法,对空间进行优化
    public int superEggDrop(int k, int n) {
        int[] f = new int[k + 1];
        for (int i = 1; ; i++) {
            for (int j = k; j > 0; j--) {
                f[j] += f[j - 1] + 1;
            }
            if (f[k] >= n) {
                return i;
            }
        }
    }
}
