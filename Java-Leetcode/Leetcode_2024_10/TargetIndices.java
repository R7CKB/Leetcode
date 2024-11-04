import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Title: TargetIndices
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/25 17:06
 * Description: Leetcode 2089 easy
 */
// leetcode: https://leetcode.cn/problems/find-target-indices-after-sorting-array/description/
public class TargetIndices {
    // 暴力方法,笨方法
//    public List<Integer> targetIndices(int[] nums, int target) {
//        Arrays.sort(nums);
//        List<Integer> res = new ArrayList<Integer>();
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == target) {
//                res.add(i);
//            }
//        }
//        return res;
//    }

    // 也可以使用一次遍历,不需要排序即可得出答案
    public List<Integer> targetIndices(int[] nums, int target) {
        int N = nums.length;
        int small = 0;
        int equal = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (nums[i] < target) {
                small++;
            } else if (nums[i] == target) {
                equal++;
            }
        }
        if (equal == 0) {
            return result;
        }
        for (int i = 0; i < equal; i++) {
            result.add(small++);
        }
        return result;
    }
}
