/**
 * Title: CommonFactors
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/2 10:20
 * Description: Leetcode 2427 easy
 */
public class CommonFactors {
    // 暴力方法
//    public int commonFactors(int a, int b) {
//        int count = 0;
//        for (int i = 1; i <= Math.min(a, b); i++) {
//            if (a % i == 0 && b % i == 0) {
//                count++;
//            }
//        }
//        return count;
//    }

    // 灵神的方法
    public int commonFactors(int a, int b) {
        int count = 0;
        int g = gcd(a, b);
        for (int i = 1; i * i <= g; ++i)
            if (g % i == 0) {
                ++count; // i 是公因子
                if (i * i < g)
                    ++count; // g/i 是公因子
            }
        return count;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
