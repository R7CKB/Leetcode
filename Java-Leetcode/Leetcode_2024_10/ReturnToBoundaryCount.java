/**
 * @Title: ReturnToBoundaryCount
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/8 18:05
 * @description: Leetcode 3028 easy
 */
// leetcode: https://leetcode.cn/problems/ant-on-the-boundary/description/
public class ReturnToBoundaryCount {
    // 感觉挺简单的的,就是检查前缀和数组中有几个元素等于0即可
    // 有几个零就说明返回边界的次数,返回边界的次数就是前缀和数组中等于0的元素个数
    public int returnToBoundaryCount(int[] nums) {
        int[] sum = new int[nums.length];
        int count = 0;
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
            if (sum[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
