/**
 * @Title: CountCompleteDayPairs
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/22 08:18
 * @Description: Leetcode 3184 easy
 */
// leetcode: https://leetcode.cn/problems/count-pairs-that-form-a-complete-day-i/description/
public class CountCompleteDayPairs {
    // 暴力方法
    public int countCompleteDayPairs(int[] hours) {
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
