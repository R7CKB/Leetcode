import java.util.Arrays;

/**
 * @Title: FindNonMinOrMax
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/22 09:10
 * @Description: Leetcode 2733 easy
 */
// leetcode: https://leetcode.cn/problems/neither-minimum-nor-maximum/description/
public class FindNonMinOrMax {
    // 时间复杂度O(1)
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;
        //给前三个排序
        Arrays.sort(nums, 0, 3);
        //拿中间的
        return nums[1];
    }
}
