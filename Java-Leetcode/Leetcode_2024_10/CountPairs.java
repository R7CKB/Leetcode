import java.util.Collections;
import java.util.List;

/**
 * Title: CountPairs
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/31 09:17
 * Description: Leetcode 2824 easy
 */
// leetcode: https://leetcode.cn/problems/count-pairs-whose-sum-is-less-than-target/
public class CountPairs {
    // 自己的做法(最简单的做法,暴力双层循环)
//    public int countPairs(List<Integer> nums, int target) {
//        int count = 0;
//        for (int i = 0; i < nums.size() - 1; i++) {
//            for (int j = i + 1; j < nums.size(); j++) {
//                if (nums.get(i) + nums.get(j) < target) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // 题目相当于从数组中选两个数，我们只关心这两个数的和是否小于 target，
    // 由于 a+b=b+a，无论如何排列数组元素，都不会影响加法的结果，所以排序不影响答案。
    // 排序+双指针滑动窗口
//    public int countPairs(List<Integer> nums, int target) {
//        Collections.sort(nums);
//        int res = 0;
//        int left = 0, right = nums.size() - 1;
//        while (left < right) {
//            if (nums.get(left) + nums.get(right) < target) {
//                res += right - left;
//                left++;
//            } else {
//                right--;
//            }
//        }
//        return res;
//    }

    // 排序+二分查找
    // 这是一种「遍历右端点，在右端点左侧找最大合法左端点」做法。
    // 遍历右端点 i，然后在 [0,i−1] 范围内进行二分，
    // 找到最大的满足 nums[j]+nums[i]<target 的位置 j。
    //
    // 若存在这样左端点 j，说明以 nums[i] 为右端点时，
    // 共有 j+1 个（范围为 [0,j] ）个合法左端点，需要被统计。
//    public int countPairs(List<Integer> nums, int target) {
//        Collections.sort(nums);
//        int n = nums.size(), ans = 0;
//        for (int i = 1; i < n; i++) {
//            int l = 0, r = i - 1;
//            while (l < r) {
//                int mid = l + r + 1 >> 1;
//                if (nums.get(mid) + nums.get(i) < target) l = mid;
//                else r = mid - 1;
//            }
//            if (nums.get(r) + nums.get(i) < target) ans += r + 1;
//        }
//        return ans;
//    }

    // 更具有可读性的二分查找
    public int countPairs(List<Integer> nums, int target) {

        Collections.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.size(); i++)
            count += binarySearch(nums, 0, i - 1, target - nums.get(i));
        return count;
    }

    public int binarySearch(List<Integer> nums, int left, int right, int target) {

        while (left <= right) {
            int mid = left + right >> 1;
            if (nums.get(mid) >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
