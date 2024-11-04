/**
 * Title: NumberOfSteps
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/29 09:47
 * Description: Leetcode 1342 easy
 */
// leetcode
public class NumberOfSteps {
    // 使用递归
//    public int numberOfSteps(int num) {
//        if (num == 0) return 0;
//        if (num % 2 == 0) return 1 + numberOfSteps(num / 2);
//        else return 1 + numberOfSteps(num - 1);
//    }

    // 使用迭代方法
//    public int numberOfSteps(int num) {
//        int res = 0;
//        while (num != 0 && ++res >= 0) num = (num % 2 == 0)? num / 2 : num - 1;
//        return res;
//    }

    // 使用数学方法
    // 目的是使得最终结果的二进制表示均为 0，
    // 两种操作对二进制数的影响分别为「整体右移」和「消减最低位的 1」。
    // 因此整个模拟过程其实是：如果当前的 num 最低位不为 1（偶数），
    // 则不断进行右移，直到最低位为 1（奇数），然后再对最低位的 1 进行消减，
    // 直到二进制表示中的所有 1 均被消减完（结果为 0），模拟过程结束。
    // 换句话说，总的操作次数为 = 右移次数 + 消减次数 ：
    // 右移次数：num 中最高位 1 的所在的位置；
    // 消减次数：num 中 1 的个数。
//    public int numberOfSteps(int num) {
//        return Math.max(getLoc(num) + getCnt(num) - 1, 0);
//    }
//
//    int getLoc(int x) {
//        for (int i = 31; i >= 0; i--) {
//            if (((x >> i) & 1) == 1) return i + 1;
//        }
//        return -1; // never
//    }
//
//    int getCnt(int x) {
//        int ans = 0;
//        for (int i = 31; i >= 0; i--) {
//            if (((x >> i) & 1) == 1) ans++;
//        }
//        return ans;
//    }

    // Leetcode题解
//    public int numberOfSteps(int num) {
//        int ret = 0;
//        while (num > 0) {
//            ret += (num > 1 ? 1 : 0) + (num & 0x01);
//            num >>= 1;
//        }
//        return ret;
//    }

    // Leetcode的直接计算法
    public int numberOfSteps(int num) {
        return num == 0 ? 0 : length(num) - 1 + count(num);
    }

    public int length(int num) {
        int clz = 0;
        if ((num >> 16) == 0) {
            clz += 16;
            num <<= 16;
        }
        if ((num >> 24) == 0) {
            clz += 8;
            num <<= 8;
        }
        if ((num >> 28) == 0) {
            clz += 4;
            num <<= 4;
        }
        if ((num >> 30) == 0) {
            clz += 2;
            num <<= 2;
        }
        if ((num >> 31) == 0) {
            clz += 1;
        }
        return 32 - clz;
    }

    public int count(int num) {
        num = (num & 0x55555555) + ((num >> 1) & 0x55555555);
        num = (num & 0x33333333) + ((num >> 2) & 0x33333333);
        num = (num & 0x0F0F0F0F) + ((num >> 4) & 0x0F0F0F0F);
        num = (num & 0x00FF00FF) + ((num >> 8) & 0x00FF00FF);
        num = (num & 0x0000FFFF) + ((num >> 16) & 0x0000FFFF);
        return num;
    }

}
