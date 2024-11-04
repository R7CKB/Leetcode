/**
 * @Title: BusyStudent
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/11 16:39
 * @Description: Leetcode 1450 easy
 */
// leetcode: https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/description/
public class BusyStudent {
    // 暴力方法,使用一遍循环即可得出答案
//    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
//        int result = 0;
//        for (int i = 0; i < startTime.length; i++) {
//            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
//                result++;
//            }
//        }
//        return result;
//    }

    // 可以在上述代码上做一个小加速
//    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
//        int result = 0;
//        for (int i = 0; i < startTime.length; i++) {
//            if (endTime[i] < queryTime) {
//                continue;
//            } else if (startTime[i] > queryTime) {
//                continue;
//            } else {
//                result++;
//            }
//        }
//        return result;
//    }

    // 思考题,假设数组长度都变为10^5,那么就会不能采用上述的方法了,因为时间复杂度太高,所以需要优化
    // 使用差分数组的思想
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int[] a = new int[100000];
        for (int i = 0; i < startTime.length; ++i) {
            a[startTime[i]]++;
            a[endTime[i] + 1]--;
        }
        int ans = 0;
        for (int i = 1; i <= queryTime; ++i) ans += a[i];

        return ans;
    }
}
