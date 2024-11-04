/**
 * @Title: SmallestEvenMultiple
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/22 08:43
 * @Description: Leetcode 2413 easy
 */
// leetcode: https://leetcode.cn/problems/smallest-even-multiple/description/
public class SmallestEvenMultiple {
    // 求2和n的最小公倍数
//    public int smallestEvenMultiple(int n) {
//        return n % 2 == 0 ? n : n * 2;
//    }

    // 简单一点的寻找数学规律,使用位运算
//    public int smallestEvenMultiple(int n) {
//        return n << (n & 1);
//    }

//    public int smallestEvenMultiple(int n) {
//        return n * (1 + n % 2);
//    }

    // 寻找两个数的公倍数的通用函数
    public int smallestEvenMultiple(int n) {
        int gcd = gcd(2, n);
        return 2 * n / gcd;
    }

    // 迭代求最大公因数
//    private int gcd(int a, int b) {
//        return b == 0 ? a : gcd(b, a % b);
//    }

    // 递归求最大公因数
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

}
