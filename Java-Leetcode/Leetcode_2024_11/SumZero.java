/**
 * Title: SumZero
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/1 10:49
 * Description: Leetcode 1304 easy
 */
// leetcode: https://leetcode.cn/problems/find-n-unique-integers-sum-up-to-zero/
public class SumZero {
    // 暴力方法,太笨了
//    public int[] sumZero(int n) {
//        int[] res = new int[n];
//        if (n % 2 == 0) {
//            for (int i = 0; i < n / 2; i++) {
//                res[i] = -n / 2 + i;
//            }
//            for (int i = n / 2; i < n; i++) {
//                res[i] = n / 2 - (i - n / 2);
//            }
//        } else {
//            for (int i = 0; i < (n / 2) + 1; i++) {
//                res[n / 2] = 0;
//                res[n / 2 + i] = i;
//                res[n / 2 - i] = -i;
//            }
//        }
//        return res;
//    }

    // 正负数以0为中心对称
//    public int[] sumZero(int n) {
//        int[] res = new int[n];
//        int index = 0;
//        for (int i = 1; i <= n / 2; i++) {
//            res[index++] = i;
//            res[index++] = -i;
//        }
//        return res;
//    }

    // 回看一下题目的限制条件，n 的取值范围是 [1,1000]，
    // 全部加在一起求和是 500500，
    // 是一个安全的 int32 整数。于是一个方案孕育而生，
    // 我们直接添加 n - 1 个连续的数字，然后把它们求和的负数放进去即可。
//    public int[] sumZero(int n) {
//        int[] res = new int[n];
//        for (int i = 1; i < n; i++) {
//            res[i] = i;
//        }
//        res[0] = -(((1 + n) * n / 2) - n);
//        return res;
//    }

    // 数学公式法
    public int[] sumZero(int n) {
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = (i * 2) - n + 1;
        }
        return res;
    }

}
