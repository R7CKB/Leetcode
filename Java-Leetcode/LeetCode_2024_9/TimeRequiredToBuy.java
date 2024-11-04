package LeetCode_2024_9;

/**
 * @Title: TimeRequiredToBuy
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/29 16:35
 * @description: Leetcode
 */
// leetcode: https://leetcode.cn/problems/time-needed-to-buy-tickets/description/
public class TimeRequiredToBuy {
    // 暴力方法
//    public static int timeRequiredToBuy(int[] tickets, int k) {
//        Queue<int[]> queue = new LinkedList<>();
//        int time = 0;
//        for (int i = 0; i < tickets.length; i++) {
//            queue.add(new int[]{tickets[i], i});
//        }
//        while (!queue.isEmpty()) {
//            int[] cur = queue.poll();
//            cur[0]--;
//            time++;
//            if (cur[1] == k && cur[0] == 0) {
//                return time;
//            }
//            if (cur[0] > 0) {
//                queue.add(new int[]{cur[0], cur[1]});
//            }
//        }
//        return time;
//    }

    // 灵神的做法
    // 思路如下:
    // 如果这个人初始在第 k 个人的前方，或者这个人恰好为第 k 个人，即 i≤k，
    // 此时在第 k 个人买完票之前他最多可以购买 tickets[k] 张。考虑到他想要购买的票数，
    // 那么他买票所需时间即为 min(tickets[k],tickets[i])；
    //
    // 如果这个人初始在第 k 个人的后方，即 i>k，此时在第 k 个人买完票之前他最多可以购买 tickets[k]−1 张。
    //考虑到他想要购买的票数，那么他买票所需时间即为 min(tickets[i],tickets[k]−1,)。
    public static int timeRequiredToBuy(int[] tickets, int k) {
        int res = 0;
        int ticket_k = tickets[k];
        for (int i = 0; i < tickets.length; i++) {
            res += Math.min(tickets[i], (i <= k ? ticket_k : ticket_k - 1));
        }
        return res;
    }

}
