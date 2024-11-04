/**
 * @Title: TwoEggDrop
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/13 16:04
 * @Description: Leetcode 1884 medium
 */
// leetcode: https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/description/
public class TwoEggDrop {
    /**
     * 问题描述:
     * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
     * 已知存在楼层 f ，满足 0 <= f <= n ，
     * 任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
     * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
     * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，
     * 则可以在之后的操作中 重复使用 这枚鸡蛋。
     * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
     */


    /**
     * 双蛋问题.假设有100层楼
     * 如果只有一个蛋的话,最少需要100次才能确定楼层
     * 如果有无限个蛋的话,就可以使用二分法来求解,最少次数是log2(100)
     * 如果有两个蛋的话,我们就可以使用一个蛋来确定楼层范围,另一个蛋来确定楼层的高度
     * 如果第一个蛋碎了的话,我们就回到了只剩下一个蛋的情况,只能一楼一楼的去试,
     * 而又要保证操作次数最少,所以我们需要将第一个蛋从低往高扔下.然后接着分析第二个蛋应该怎么扔.
     * <p>
     * 如果第一个蛋没碎的情况下,我们就可以将第一个蛋分别在10,20,30,40...100层扔下,
     * 然后从1~9,11~19,21~29,31~39...99层中选出最少的层数,,
     * 这样的操作次数就比较少了,这样最少需要2次,最多需要19次.
     * <p>
     * 但是这样临界楼层靠后的话,第一个蛋扔的次数就会变多,第二个蛋的间隔是不变的.
     * 所以我们能不能想一种方法,将第一个蛋的间隔扩大,那么第二个蛋的间隔就会缩小.
     * 即第一个蛋每多扔一次,第二个蛋的间隔就缩短一点,这样就可以减少操作次数.
     * 这样的策略就是双蛋问题的解法.
     * <p>
     * 如果不是两个蛋的话,就需要使用递归的思想来解决问题.
     * T层,N个蛋,最少的操作次数M
     */


    // 灵神的方法1,记忆法搜索
    // 枚举第一枚鸡蛋在 j=1,2,3,⋯,i 楼扔下，分类讨论：
    // 如果鸡蛋碎了，那么接下来只能依次在 1,2,3,j−1 楼扔第二枚鸡蛋，
    // 最坏情况下，总共要操作 1+(j−1)=j 次。
    // 如果鸡蛋没碎，那么接下来可以在 j+1 到 i 楼中继续扔第一枚鸡蛋，
    // 这等价于在一栋有 i−j 层楼的建筑中扔鸡蛋的子问题，即 dfs(i−j)，将其加一即为总操作次数。
//    private static final int[] memo = new int[1001];
//
//    public int twoEggDrop(int n) {
//        if (n == 0) {
//            return 0;
//        }
//        if (memo[n] > 0) { // 之前计算过
//            return memo[n];
//        }
//        int res = Integer.MAX_VALUE;
//        for (int j = 1; j <= n; j++) {
//            res = Math.min(res, Math.max(j, twoEggDrop(n - j) + 1));
//        }
//        return memo[n] = res; // 记忆化
//    }

    // 灵神的方法2,翻译成递推
//    private static final int[] f = new int[1001];
//
//    static {
//        for (int i = 1; i < f.length; i++) {
//            f[i] = Integer.MAX_VALUE;
//            for (int j = 1; j <= i; j++) {
//                f[i] = Math.min(f[i], Math.max(j, f[i - j] + 1));
//            }
//        }
//    }
//
//    public int twoEggDrop(int n) {
//        return f[n];
//    }

    // 灵神的方法3:纯数学方法
    // 证明过程在这:https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/solutions/2945577/liang-chong-fang-fa-dong-tai-gui-hua-shu-hd4i/
//    public int twoEggDrop(int n) {
//        return (int) Math.ceil((Math.sqrt(n * 8 + 1) - 1) / 2);
//    }

    // 投机取巧法,看评论看出来的
//    public int twoEggDrop(int n) {
//        int k = 1;
//        while (k < n) {
//            n -= k;
//            k += 1;
//        }
//        return k;
//    }


    public int twoEggDrop(int n) {
        return NEggDrop(n, 2);
    }

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

    public static void main(String[] args) {
        TwoEggDrop twoEggDrop = new TwoEggDrop();
        int res = twoEggDrop.twoEggDrop(100);
        System.out.println(res);
    }
}
