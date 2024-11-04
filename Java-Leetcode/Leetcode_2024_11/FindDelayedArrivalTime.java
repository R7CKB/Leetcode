/**
 * Title: FindDelayedArrivalTime
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/2 09:59
 * Description: Leetcode 2651 easy
 */
// leetcode: https://leetcode.cn/problems/calculate-delayed-arrival-time/
public class FindDelayedArrivalTime {
    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
