/**
 * Title: CanAliceWin
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/29 09:41
 * Description: Leetcode 3232 easy
 */
// leetcode: https://leetcode.cn/problems/find-if-digit-game-can-be-won/
public class CanAliceWin {
//    public boolean canAliceWin(int[] nums) {
//        // 数组中数字总和
//        int sum = 0;
//        int alice = 0;
//        for (int num : nums) {
//            sum += num;
//            if (num < 10) {
//                alice += num;
//            }
//        }
//        return alice != (sum - alice);
//    }

    // 灵神的解法
    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num < 10 ? num : -num;
        }
        return sum != 0;
    }
}
