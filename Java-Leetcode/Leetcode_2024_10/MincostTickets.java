/**
 * @Title: MincostTickets
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/1 18:32
 * @description: leetcode 983
 */
// leetcode : https://leetcode.cn/problems/minimum-cost-for-tickets/description/
public class MincostTickets {
    // 题解:https://leetcode.cn/problems/minimum-cost-for-tickets/solutions/233336/java-dong-tai-gui-hua-si-lu-bu-zou-cong-hou-xiang-/?envType=daily-question&envId=2024-10-01
    // 思路:
    // 如果今天不需要出门，不用买票
    // 今天如果要出门，需要买几天？
    // 看往后几天（最多 30 天内）要不要出门
    // 30 天内都没有要出行的，那只买今天就好
    // 有要出门的（不同决策）
    //      这次 和 后面几次 分开买更省
    //      这次 和 后面几次 一起买更省
    // 上述思路显而易见，最关键在于：「今天买多少，得看后几天怎么安排」，即「前面依赖后面」——从后向前来买。
    // 因此，我们可以用动态规划来解决这个问题。
//    public int mincostTickets(int[] days, int[] costs) {
//        int N = days.length;
//        int maxDay = days[N - 1];
//        int minDay = days[0];
//        int[] dp = new int[maxDay + 31]; // 31 天的预留空间,省的数组空间不足
//        // 先看最后一天,从后面往前来买
//        for (int day = maxDay, index = N - 1; day >= minDay; day--) {
//            if (day == days[index]) {
//                dp[day] = Math.min(dp[day + 30] + costs[2], Math.min(dp[day + 1] + costs[0], dp[day + 7] + costs[1])); // 这次和后面几次分开买
//                index--;
//            } else {
//                dp[day] = dp[day + 1]; //不需要出门
//            }
//        }
//        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
//    }

    // 还可以再进行优化:
    // 当 d != days[i] 时，可直接将 d = days[i] 以快速跳到前一个需要出发的 d
    // 若如此，则需将中间跳过的 dp[d] 都补上总费用累计
    public int mincostTickets(int[] days, int[] costs) {
        int N = days.length;
        int maxDay = days[N - 1];
        int minDay = days[0];
        int[] dp = new int[maxDay + 31]; // 31 天的预留空间,省得数组空间不足
        // 先看最后一天,从后面往前来买
        int day = maxDay;
        int index = N - 1;
        while (day >= minDay) {
            if (day == days[index]) {
                dp[day] = Math.min(dp[day + 30] + costs[2],
                          Math.min(dp[day + 1] + costs[0],
                                   dp[day + 7] + costs[1])); // 这次和后面几次分开买
                index--;
                day--;
            } else {
                int temp = day;
                day = days[index]; // 跳到前一个需要出发的 day,days[index]一定小于等于temp
                // 这个for循环是为了补上中间跳过的dp[day]都补上总费用累计
                for (int i = temp; i > day; i--) {
                    dp[i] = dp[i + 1]; // 补上总费用累计
                }
            }
        }
        return dp[minDay]; // 从后向前遍历，返回最前的 minDay
    }

    public static void main(String[] args) {
        MincostTickets mincostTickets = new MincostTickets();
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        int result = mincostTickets.mincostTickets(days, costs);
        System.out.println(result);
    }

}
