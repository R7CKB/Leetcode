/**
 * @Title: NthPersonGetsNthSeat
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/4 16:25
 * @description: Leetcode 1227 medium
 */
// leetcode:https://leetcode.cn/problems/airplane-seat-assignment-probability/description/
public class NthPersonGetsNthSeat {
    // 第一个人找不到位置,会随便坐,有可能坐到自己的位置.
    // 换句话说,对于每一个人来说,就看第一个人是否坐到自己的位置,
    // 那么就只有两种情况,坐到和没有坐到,概率就将是0.5
    //    public double nthPersonGetsNthSeat(int n) {
//        // 根据数学推论可知答案
//        return n == 1 ? 1.0 : 0.5;
//    }
    // 是用动态规划来解决这个问题
    // 具体可以看灵神的图解
    // https://leetcode.cn/problems/airplane-seat-assignment-probability/solutions/2858975/tu-jie-mei-xiang-ming-bai-yi-zhang-tu-mi-8bn4/?envType=daily-question&envId=2024-10-04
    public double nthPersonGetsNthSeat(int n) {
        double[] dp = new double[n + 1];
        dp[1] = 1.0;
        dp[2] = 0.5;
        if (n <= 2) {
            return dp[n];
        } else {
            for (int i = 3; i <= n; i++) {
                dp[i] = (double) 1 / i + (((((double) 1 / i) * (i - 2)) / 2));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthPersonGetsNthSeat nthPersonGetsNthSeat = new NthPersonGetsNthSeat();
        System.out.println(nthPersonGetsNthSeat.nthPersonGetsNthSeat(1));
        System.out.println(nthPersonGetsNthSeat.nthPersonGetsNthSeat(2));
        System.out.println(nthPersonGetsNthSeat.nthPersonGetsNthSeat(3));
        System.out.println(nthPersonGetsNthSeat.nthPersonGetsNthSeat(4));
    }
}
