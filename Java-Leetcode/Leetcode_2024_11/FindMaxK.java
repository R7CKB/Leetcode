import java.util.Arrays;
import java.util.HashSet;

/**
 * Title: FindMaxK
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/1 11:14
 * Description: Leetcode 2441 easy
 */
// leetcode: https://leetcode.cn/problems/largest-positive-integer-that-exists-with-its-negative/
public class FindMaxK {
    // 暴力方法,使用哈希表
//    public int findMaxK(int[] nums) {
//        int res = -1;
//        HashSet<Integer> set = new HashSet<>();
//        Arrays.sort(nums);
//        for (int num : nums) {
//            set.add(num);
//        }
//        for (int num : nums) {
//            if (set.contains(-num)) {
//                res = Math.max(res, num);
//            }
//        }
//        return res;
//    }

    // 哈希表还可以优化,只需要一次遍历即可
//    public int findMaxK(int[] nums) {
//        int res = -1;
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(-num)) {
//                res = Math.max(res, Math.abs(num));
//            }
//            set.add(num);
//        }
//        return res;
//    }

    // 暴力枚举
//    public int findMaxK(int[] nums) {
//        int k = -1;
//        for (int x : nums) {
//            for (int y : nums) {
//                if (-x == y) {
//                    k = Math.max(k, x);
//                }
//            }
//        }
//        return k;
//    }

    // 空间换时间
//    public int findMaxK(int[] nums) {
//        boolean[] exist = new boolean[2001];
//        for (int num : nums) {
//            exist[num + 1000] = true;
//        }
//        for (int i = 0; i < exist.length / 2; i++) {
//            if (exist[i] && exist[2000 - i]) {
//                return 1000 - i;
//            }
//        }
//        return -1;
//    }

    // 还能更快
    public int findMaxK(int[] nums) {
        boolean[] exist = new boolean[2001];
        int max = 0;
        for (int num : nums) {
            exist[num + 1000] = true;
            if (exist[-num + 1000]) {
                max = Math.max(max, Math.abs(num));
            }
        }
        return max == 0 ? -1 : max;
    }

    // 双指针法,滑动窗口
//    public int findMaxK(int[] nums) {
//        int N = nums.length;
//        Arrays.sort(nums);
//        int left = 0, right = N - 1;
//        int res = -1;
//        while (left < right) {
//            if (nums[left] + nums[right] == 0) {
//                res = nums[right];
//                break;
//            } else if (nums[left] + nums[right] > 0) {
//                right--;
//            } else {
//                left++;
//            }
//        }
//        return res;
//    }
}
