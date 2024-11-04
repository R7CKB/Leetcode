/**
 * @Title: NumberOfEmployeesWhoMetTarget
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/21 09:01
 * @Description: Leetcode 2798 easy
 */
// leetcode: https://leetcode.cn/problems/number-of-employees-who-met-the-target/description/
public class NumberOfEmployeesWhoMetTarget {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }
        return count;
    }
}
