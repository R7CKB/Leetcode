import java.util.Arrays;

/**
 * Title: ResultsArray
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/6 09:11
 * Description: Leetcode 3254 medium
 */
public class ResultsArray {
    // 暴力方法,没想出来,不能实现,使用滑动窗口解决
//    public int[] resultsArray(int[] nums, int k) {
//        int[] res = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//            int j = i + k - 1;
//            // 连续上升主要满足条件是每一个减去前一个数等于前一个减去前前一个数.
//            if (nums[j] - nums[j - 1] == nums[j - 1] - nums[j - 2]
//                    && nums[j] > nums[j - 1]) {
//                res[i] = nums[j];
//            } else {
//                res[i] = -1;
//            }
//        }
//        return res;
//    }

    //滑动窗口,有些笨不过做得出来.
//    public int[] resultsArray(int[] nums, int k) {
//        int N = nums.length;
//        // k=1时直接返回nums
//        if (k == 1 || N == 1) return nums;
//        int[] res = new int[N - k + 1];
//        int L = 0;
//        int R = k - 1;
//        //到达边界时停止,边界的条件为N-K
//        while (L <= N - k) {
//            int max = Integer.MIN_VALUE;
//            for (int i = R; i >= L + 1; i--) {
//                max = Math.max(max, nums[i]);
//                if (nums[i] - nums[i - 1] == 1) {
//                    res[L] = Math.max(nums[i], max);
//                } else {
//                    res[L] = -1;
//                    break;
//                }
//            }
//            L++;
//            R++;
//        }
//        return res;
//    }

    // DeepSeek稍微优化了一下,只适用于简单的题目,数据量一多就不行了.
//    public int[] resultsArray(int[] nums, int k) {
//        int N = nums.length;
//        // k=1时直接返回nums
//        if (k == 1 || N == 1) return nums;
//        int[] res = new int[N - k + 1];
//        int L = 0;
//        int R = k - 1;
//
//        // 到达边界时停止,边界的条件为N-K
//        while (L <= N - k) {
//            int max = Integer.MIN_VALUE;
//            boolean valid = true;
//            for (int i = L; i < R; i++) {
//                if (nums[i + 1] - nums[i] != 1) {
//                    valid = false;
//                    break;
//                }
//                max = Math.max(max, nums[i + 1]);
//            }
//            res[L] = valid ? max : -1;
//            L++;
//            R++;
//        }
//        return res;
//    }

    // 灵神的题解
    // 核心思路：找连续上升的段。如果段长至少是 k，那么这段中的所有长为 k 的子数组都是符合要求的，
    // 子数组的最后一个元素是最大的。
    // 具体来说，遍历数组的同时，用一个计数器 cnt 统计连续递增的元素个数：
    // 初始化 cnt=0。
    // 如果 i=0 或者 nums[i]=nums[i−1]+1，把 cnt 增加 1；否则，把 cnt 置为 1。
    // 如果发现 cnt≥k，那么下标从 i−k+1 到 i 的这个子数组的能量值为 nums[i]，即 ans[i−k+1]=nums[i]。
    // 优雅!!!✨✨✨
    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            cnt = i == 0 || nums[i] == nums[i - 1] + 1 ? cnt + 1 : 1;
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 3, 2, 5};
        int[] nums2 = {2, 2, 2, 2, 2};
        int m = 4;
        int k = 3;
        int[] res = new ResultsArray().resultsArray(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
