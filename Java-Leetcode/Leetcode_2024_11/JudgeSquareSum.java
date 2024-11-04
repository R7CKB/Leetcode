/**
 * Title: JudgeSquareSum
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/4 08:40
 * Description: Leetcode 633 medium
 */
public class JudgeSquareSum {
    // 暴力方法.超时
//    public boolean judgeSquareSum(int c) {
//        for (int i = 0; i * i <= c; i++) {
//            for (int j = 0; j * j <= c; j++) {
//                if ((i * i + j * j) == c) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }


    // 双指针法,刚开始是int的问题,改成long后就能过了.
//    public boolean judgeSquareSum(int c) {
//        long left = 0;
//        long right = (long) Math.sqrt(c);
//        while (left <= right) {
//            long sum = left * left + right * right;
//            if (sum == c) {
//                return true;
//            } else if (sum < c) {
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return false;
//    }

    // Leetcode官方的枚举解法,也会超时,绷不住了🤣🤣🤣
//    public boolean judgeSquareSum(int c) {
//        for (int i = 0; i * i <= c; i++) {
//            double j = Math.sqrt(c - i * i);
//            if (j == (int) j) {
//                return true;
//            }
//        }
//        return false;
//    }

    // 数学方法
    // 费马平方和定理告诉我们：
    // 一个非负整数 c 如果能够表示为两个整数的平方和，
    // 当且仅当 c 的所有形如 4k+3 的质因子的幂均为偶数。
    // 因此我们需要对 c 进行质因数分解，再判断所有形如 4k+3 的质因子的幂是否均为偶数即可。
//    public boolean judgeSquareSum(int c) {
//        for (int base = 2; base * base <= c; base++) {
//            // 如果不是因子，枚举下一个
//            if (c % base != 0) {
//                continue;
//            }
//
//            // 计算 base 的幂
//            int exp = 0;
//            while (c % base == 0) {
//                c /= base;
//                exp++;
//            }
//
//            // 根据 Sum of two squares theorem 验证
//            if (base % 4 == 3 && exp % 2 != 0) {
//                return false;
//            }
//        }
//
//        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
//        // 因此在退出循环以后需要再做一次判断
//        return c % 4 != 3;
//    }

    // 灵神的方法,其实和Leetcode官方的枚举做法感觉是一样的,但是他的思路更加巧妙,更加简洁.
    public boolean judgeSquareSum(int c) {
        for (int a = 0; a * a <= c / 2; a++) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new JudgeSquareSum().judgeSquareSum(2147483600));
    }
}
