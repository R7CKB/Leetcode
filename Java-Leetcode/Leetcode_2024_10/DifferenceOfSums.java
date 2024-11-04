/**
 * @Title: DifferenceOfSums
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/20 10:56
 * @Description: Leetcode 2894 easy
 */
// leetcode: https://leetcode.cn/problems/divisible-and-non-divisible-sums-difference/description/
public class DifferenceOfSums {
    // 自己的方法
//    public int differenceOfSums(int n, int m) {
//        int sum1 = 0;
//        int sum2 = 0;
//        for (int i = 1; i <= n; i++) {
//            if (i % m != 0) {
//                sum1 += i;
//            } else {
//                sum2 += i;
//            }
//        }
//        return sum1 - sum2;
//    }

    // 灵神的方法
    // 数学规律一行公式搞定
    //
    public int differenceOfSums(int n, int m) {
        return n * (n + 1) / 2 - n / m * (n / m + 1) * m;
    }
}
