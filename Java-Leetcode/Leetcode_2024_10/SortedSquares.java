import java.util.Arrays;

/**
 * @Title: SortedSquares
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/11 17:01
 * @Description: Leetcode 977 easy
 */
// leetcode: https://leetcode.cn/problems/squares-of-a-sorted-array/description/
public class SortedSquares {
    // 给定的数组按递增序列排序，返回排序后的数组。
    // 暴力解法
//    public int[] sortedSquares(int[] nums) {
//        int N = nums.length;
//        int[] res = new int[N];
//        for (int i = 0; i < N; i++) {
//            res[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(res);
//        return res;
//    }

    // 双指针法,从数组两端向中间合并
    // 时间复杂度O(N),空间复杂度O(1)
//    public int[] sortedSquares(int[] nums) {
//        int N = nums.length;
//        int[] res = new int[N];
//        // 设立两个指针，分别指向数组的左右两端
//        // 从两遍开始向中间合并
//        int L = 0;
//        int R = N - 1;
//        for (int i = N - 1; i >= 0; i--) {
//            int x = Math.abs(nums[R] * nums[R]);
//            int y = Math.abs(nums[L] * nums[L]);
//            if (x > y) {
//                res[i] = x;
//                R--;
//            } else {
//                res[i] = y;
//                L++;
//            }
//        }
//        return res;
//    }

    // 优雅的解法,不管是全是整数还是全是负数,都可以很好地实现排序
    // 时间复杂度O(N),空间复杂度O(1)
    public int[] sortedSquares(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        // 设立两个指针，分别指向数组的左右两端
        // 从两遍开始向中间合并
        int L = 0;
        int R = N - 1;
        for (int i = N - 1; i >= 0; i--) {
            int x = nums[L];
            int y = nums[R];
            if (-x > y) {
                res[i] = x * x;
                L++;
            } else {
                res[i] = y * y;
                R--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        SortedSquares sortedSquares = new SortedSquares();
        int[] res = sortedSquares.sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }

}
