/**
 * Title: CountTestedDevices
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/2 10:02
 * Description: Leetcode 2960 easy
 */
// leetcode: https://leetcode.cn/problems/count-tested-devices-after-test-operations/
public class CountTestedDevices {
    // 暴力模拟
//    public int countTestedDevices(int[] batteryPercentages) {
//        int res = 0;
//        for (int i = 0; i < batteryPercentages.length; i++) {
//            if (batteryPercentages[i] == 0) {
//                continue;
//            }
//            res++;
//            for (int j = i + 1; j < batteryPercentages.length; j++) {
//                batteryPercentages[j] = Math.max(0, batteryPercentages[j] - 1);
//            }
//        }
//        return res;
//    }

    // 灵神的方法(差分思想)
    // 初始化 dec=0，表示需要减一的次数。
    // 设 x=batteryPercentages[i]，那么该电池的实际百分比为 x−dec，
    // 如果 x−dec>0，即 x>dec，那么后面的数都要减一，根据差分数组的思想，把 dec 加一即可。
    // 答案就是 dec。因为每次遇到 x>dec 都把 dec 加一，这正是题目要求统计的。
    public int countTestedDevices(int[] batteryPercentages) {
        int dec = 0;
        for (int x : batteryPercentages) {
            if (x > dec) {
                dec++;
            }
        }
        return dec;
    }
}
