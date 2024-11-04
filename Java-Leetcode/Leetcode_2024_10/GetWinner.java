/**
 * @Title: GetWinner
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/24 17:24
 * @Description: Leetcode 1535 medium
 */
// leetcode:https://leetcode.cn/problems/find-the-winner-of-an-array-game/description/
public class GetWinner {
    // 这道题和FindWinningPlayer是一模一样的,都是打擂台的题目,
    // 如果当前数没打过就会换台主,如果没达到胜利的场次会一直打下去
//    public int getWinner(int[] arr, int k) {
//        int win = 0;
//        int winnerIndex = 0;
//        for (int i = 1; i < arr.length && win < k; i++) {
//            if (arr[i] > arr[winnerIndex]) {
//                winnerIndex = i;
//                win = 0;
//            }
//            win++;
//        }
//        return arr[winnerIndex];
//    }

    // 自己再使用笨拙的方法复刻一遍
    public int getWinner(int[] arr, int k) {
        int win = 0;
        int winnerIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[winnerIndex] > arr[i]) {
                win++;
            } else {
                winnerIndex = i;
                win = 1;
            }
            if (win == k) {
                return arr[winnerIndex];
            }
        }
        return arr[winnerIndex];
    }
}
