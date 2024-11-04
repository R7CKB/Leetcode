import java.util.*;

/**
 * @Title: FindWinningPlayer
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/24 08:02
 * @Description: Leetcode 3175 medium
 */
// leetcode:https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/
public class FindWinningPlayer {
    // 暴力模拟,使用队列实现,时间复杂度过大
//    public int findWinningPlayer(int[] skills, int k) {
//        Queue<Integer> queue = new LinkedList<>();
//        int winnerIndex = 0;
//        int win = 0;
//        for (int i = 1; i < skills.length; i++) {
//            queue.offer(i);
//        }
//        while (win < k) {
//            if (skills[winnerIndex] > skills[queue.peek()]) {
//                win++;
//                queue.offer(queue.poll());
//            } else {
//                queue.offer(winnerIndex);
//                winnerIndex = queue.peek();
//                queue.remove(winnerIndex);
//                win = 1;
//            }
//        }
//        return winnerIndex;
//    }

    // 评论区有和我一样的老哥,说这题是脑筋急转弯,只需要遍历一遍,
    // 这一轮有人赢到k次那就是这个人,如果没人赢到k次也不要紧,
    // 此时的赢家肯定是最大值,他迟早会赢到k次的
    // 确实,明白题意就好理解了
//    public int findWinningPlayer(int[] skills, int k) {
//        int win = 0;
//        int winnerIndex = 0;
//        for (int i = 1; i < skills.length; i++) {
//            if (skills[winnerIndex] > skills[i]) {
//                win++;
//            } else {
//                win = 1;
//                winnerIndex = i;
//            }
//            if (win == k)//如果到达k次说明赢家就是他
//                return winnerIndex;
//        }
//        return winnerIndex;//如果一轮遍历后没赢到k次 此时游戏高手肯定是最大的那个 迟早他会赢到k次的
//    }

    // 灵神的做法
    public int findWinningPlayer(int[] skills, int k) {
        int maxI = 0;
        int win = 0;
        // 将win的条件限制到for循环中节省代码空间
        for (int i = 1; i < skills.length && win < k; i++) {
            if (skills[i] > skills[maxI]) { // 打擂台，发现新的最大值
                maxI = i;
                win = 0;
            }
            win++; // 获胜回合 +1
        }
        // 如果 k 很大，那么 maxI 就是 skills 最大值的下标，毕竟最大值会一直赢下去
        return maxI;
    }


    public static void main(String[] args) {
        FindWinningPlayer findWinningPlayer = new FindWinningPlayer();
        int[] skills = new int[]{4, 2, 6, 3, 9};
        System.out.println(findWinningPlayer.findWinningPlayer(skills, 2));
    }

}
