import java.util.Scanner;

/**
 * Title: PokerCardCombinations
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/30 19:24
 * Description: 中国平安 Java工程师 Topic1
 */

/**
 * 题目描述:
 * 小强在玩扑克牌，扑克牌（去掉大小王）是由数字1-13各四种花色组成的，
 * 但是小强觉得只有52张牌并不快乐，于是他决定创造一种牛牌，
 * 牛牌是由数字各四种花色组成的，但是小强手上只有一只黑色水笔画不出四种花色，
 * 因此他只能创造出数字1-n各四张牌。现在小强想知道，
 * 当他手上有m张牌时，这m张牌一共有多少种牌型。
 * （两种牌型不同当且仅当某个数字在两种牌型中的数量不同）
 * <p>
 * 输入描述:
 * 输入包括两行：
 * 1. 一个整数n，表示小强创造的牌的数量。
 * 2. 一个整数m，表示小强手上有多少张牌。
 * <p>
 * 数据范围:1<=n m<=1000
 * <p>
 * 输出描述:
 * 输出一个整数，表示小强手上这m张牌一共有多少种牌型。
 * <p>
 * 输入例子1:
 * 3 2
 * <p>
 * 输出例子1:
 * 6
 * 说明：小强手上有2张牌，有6种牌型：
 * {1,1}
 * {1,2}
 * {1,3}
 * {2,2}
 * {2,3}
 * {3,3}
 * <p>
 * 输入例子2:
 * 9 14
 * <p>
 * 输出例子2:
 * 118800
 */
public class PokerCardCombinations {
    // 常量定义
    private static final int MOD = 1000000007;

    // 代码如下:
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        System.out.println(countCombinations(n, m));
    }

    // GPT解题方法,更加直观一些.但是为什么这个题可以使用动态规划来解呢?
    // 画图理解会好一些
    private static long countCombinations(int n, int m) {
        // 使用动态规划来计算组合数
        long[][] dp = new long[n + 1][m + 1];

        // dp[i][j] 表示 i 种数字组成 j 张牌的方式
        dp[0][0] = 1; // 0 种数字组成 0 张牌的方式是 1 种

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // 不选第 i 种牌
                dp[i][j] = dp[i - 1][j] % MOD;
                // 选 1 张第 i 种牌
                if (j >= 1) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MOD;
                }
                // 选 2 张第 i 种牌
                if (j >= 2) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 2]) % MOD;
                }
                // 选 3 张第 i 种牌
                if (j >= 3) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 3]) % MOD;
                }
                // 选 4 张第 i 种牌
                if (j >= 4) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 4]) % MOD;
                }
            }
        }

        return dp[n][m];
    }

    // DeepSeek解题方法,也是使用动态规划,比GPT简化了一些.不过可读性不如GPT.
//    public static long countCombinations(int n, int m) {
//        // dp[i][j] 表示使用前 i 个数字，总共使用 j 张牌的不同牌型数
//        long[][] dp = new long[n + 1][m + 1];
//
//        // 初始条件
//        dp[0][0] = 1;
//
//        // 动态规划求解
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j <= m; j++) {
//                for (int k = 0; k <= 4; k++) {
//                    if (j >= k) {
//                        dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
//                    }
//                }
//            }
//        }
//
//        return dp[n][m];
//    }

}
