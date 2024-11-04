/**
 * Title: MinChanges
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/2 09:14
 * Description: Leetcode 3226 easy
 */
// leetcode: https://leetcode.cn/problems/number-of-bit-changes-to-make-two-integers-equal/
public class MinChanges {
    // 使用JavaAPI,将十进制转换为二进制
    // 然后暴力模拟.笨方法
//    public int minChanges(int n, int k) {
//        StringBuilder nBinary = new StringBuilder(Integer.toBinaryString(n));
//        StringBuilder kBinary = new StringBuilder(Integer.toBinaryString(k));
//        int N = nBinary.length();
//        int K = kBinary.length();
//        if (N < K) {
//            for (int i = 0; i < K - N; i++) {
//                nBinary.insert(0, '0');
//            }
//        } else if (N > K) {
//            for (int i = 0; i < N - K; i++) {
//                kBinary.insert(0, '0');
//            }
//        }
//        int res = 0;
//        for (int i = 0; i < nBinary.length(); i++) {
//            if (nBinary.charAt(i) != kBinary.charAt(i) && nBinary.charAt(i) == '1') {
//                res++;
//                nBinary.setCharAt(i, '0');
//            }
//        }
//        return nBinary.toString().contentEquals(kBinary) ? res : -1;
//    }

    // 灵神的方法1
    // 从集合的角度理解，每次操作相当于去掉集合 n 中的一个元素。
    // 要能把 n 变成 k，k 必须是 n 的子集。如果不是，返回 −1。
    // 如果 k 是 n 的子集，答案为从 n 中去掉 k 后的集合大小，即 n⊕k 的二进制中的 1 的个数。
    // 如果 n 和 k 的交集是 k，那么 k 就是 n 的子集。
    // 交集就是位运算中的 AND（&）。

    // 另一种解释方法是
    // 如果 n 和 k 的按位与结果不等于 k，说明 k 存在某一位为 1，
    // 而 n 对应的位为 0，此时无法通过改变 n 的某一位使得 n 等于 k，
    // 返回 −1；否则，我们统计 n⊕k 的二进制表示中 1 的个数即可。
//    public int minChanges(int n, int k) {
//        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
//    }

    // 灵神的写法2
    // 如果 n 和 k 的并集是 n，那么 k 就是 n 的子集。
    // 并集就是位运算中的 OR（|）。
//    public int minChanges(int n, int k) {
//        return (n | k) != n ? -1 : Integer.bitCount(n ^ k);
//    }

    // 灵神的写法3
    // 如果 k 去掉 n 中所有元素后，变成了空集，那么 k 就是 n 的子集。
    // 写成代码，如果 (k & ~n) == 0，那么 k 就是 n 的子集。
//    public int minChanges(int n, int k) {
//        return (k & ~n) > 0 ? -1 : Integer.bitCount(n ^ k);
//    }

    // Leetcode模拟
    public int minChanges(int n, int k) {
        int res = 0;
        while (n > 0 || k > 0) {
            if ((n & 1) == 0 && (k & 1) == 1) {
                return -1;
            }
            if ((n & 1) == 1 && (k & 1) == 0) {
                res++;
            }
            n >>= 1;
            k >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        MinChanges m = new MinChanges();
        System.out.println(m.minChanges(44, 2));
    }
}
