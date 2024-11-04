/**
 * @Title: SumOfTheDigitsOfHarshadNumber
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/3 19:53
 * @description: Leetcode 3099 easy
 */
// leetcode: https://leetcode.cn/problems/harshad-number/
public class SumOfTheDigitsOfHarshadNumber {
//    public int sumOfTheDigitsOfHarshadNumber(int x) {
//        return x % getDigitSum(x) == 0 ? getDigitSum(x) : -1;
//    }
//
//    public int getDigitSum(int n) {
//        int sum = 0;
//        while (n > 0) {
//            int digit = n % 10;
//            n /= 10;
//            sum += digit;
//        }
//        return sum;
//    }

    // 将两个函数合成一个函数的方法
//    public int sumOfTheDigitsOfHarshadNumber(int x) {
//        int sum = 0;
//        for (int v = x; v > 0; v /= 10) {
//            sum += v % 10;
//        }
//        return x % sum == 0 ? sum : -1;
//    }

    // 灵神的做法
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int s = 0;
        for (int v = x; v > 0; v /= 10) {
            s += v % 10;
        }
        return x % s > 0 ? -1 : s;
    }
}
