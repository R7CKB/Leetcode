/**
 * @Title: CountCompleteDayPairsⅡ
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/22 08:24
 * @Description: Leetcode 3185 medium
 */
// leetcode: https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-ii/description/
public class CountCompleteDayPairs2 {
    // 使用暴力方法会超时
//    public long countCompleteDayPairs(int[] hours) {
//        long count = 0;
//        for (int i = 0; i < hours.length; i++) {
//            for (int j = i + 1; j < hours.length; j++) {
//                if ((hours[i] + hours[j]) % 24 == 0) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // leetcode 官方题解 || 灵神的题解
    // hours[i]+hours[j] 能够被 24 整除，
    // 只需 hours[i] 除以 24 的余数与 hours[j] 除以 24 的余数之和能够被 24 整除。
    // 我们可以枚举 hours[i]，每一个 hours[i] 对答案的贡献就是能与其成对的 hours[j] 的数量。
    // 如果暴力查找能够成对的 hours[j]，则每次都需要遍历一遍 hours 数组中剩余的元素。
    // 我们可以使用一个长度为 24 的数组 cnt 记录每个余数的出现次数，
    // 从而快速查询能够与 hours[i] 成对的元素数量。
    // 注意，哈希表记录的是位于我们当前枚举的 hours[i] 左边的元素，
    // 也就是说我们是在枚举右边值的同时维护左边的元素。

    // 灵神的思路:
    // 举几个例子：
    // 如果 hours[i]=1，那么需要知道左边有多少个模 24 是 23 的数，这些数加上 1 都是 24 的倍数。
    // 如果 hours[i]=2，那么需要知道左边有多少个模 24 是 22 的数，这些数加上 2 都是 24 的倍数。
    // 如果 hours[i]=26，那么需要知道左边有多少个模 24 是 22 的数，这些数加上 26 都是 24 的倍数。
    // 一般地，对于 hours[i]，需要知道左边有多少个模 24 是 24−hours[i]mod24 的数。
    // 特别地，如果 hours[i] 模 24 是 0，那么需要知道左边有多少个模 24 也是 0 的数。
    // 这两种情况可以合并为：累加左边(24−hours[i]mod24)mod24的出现次数。
    // 代码实现时，用一个长为 24 的数组 cnt 维护 hours[i]mod24 的出现次数。

    public long countCompleteDayPairs(int[] hours) {
        final int H = 24;
        long ans = 0;
        int[] cnt = new int[H];
        for (int hour : hours) {
            // 先查询 cnt，再更新 cnt，因为题目要求 i < j
            // 如果先更新，再查询，就把 i = j 的情况也考虑进去了
            ans += cnt[(H - hour % H) % H];
            cnt[hour % H]++;
        }
        return ans;
    }
    // 对于有两个变量的题目，通常可以枚举其中一个变量，把它视作常量，从而转化成只有一个变量的问题。
}
