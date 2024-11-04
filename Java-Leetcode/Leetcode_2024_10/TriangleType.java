import java.util.Arrays;

/**
 * @Title: TriangleType
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/16 11:13
 * @Description: Leetcode 3024 easy
 */
// leetcode: https://leetcode.cn/problems/type-of-triangle/description/
public class TriangleType {
    // 暴力方法
//    public String triangleType(int[] nums) {
//        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[2] + nums[0] <= nums[1]) {
//            // 无法构成三角形
//            return "none";
//        } else if (nums[0] == nums[1] && nums[1] == nums[2]
//                ) {
//            // 三条边都相同
//            return "equilateral";
//        } else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[2] == nums[0]) {
//            // 两条边相同
//            return "isosceles";
//        } else {
//            // 三条边都不同
//            return "scalene";
//        }
//    }

    // 灵神的解法
    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        int x = nums[0];
        int y = nums[1];
        int z = nums[2];
        if (x + y <= z) { // 排序后，只需比较 x+y 和 z
            return "none";
        }
        if (x == z) { // 排序了，说明 y 也和 x z 相等
            return "equilateral";
        }
        if (x == y || y == z) {
            return "isosceles";
        }
        return "scalene";
    }

}
