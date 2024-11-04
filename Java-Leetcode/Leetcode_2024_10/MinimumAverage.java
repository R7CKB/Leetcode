import java.util.Arrays;

/**
 * @Title: MinimumAverage
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/16 10:54
 * @Description: Leetcode 3194 easy
 */
// leetcode: https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/description/
public class MinimumAverage {
    // 暴力方法
//    public double minimumAverage(int[] nums) {
//        int N = nums.length; // N为偶数
//        double[] average = new double[nums.length / 2];
//        Arrays.sort(nums); // 对数组进行排序
//        for (int i = 0; i < N / 2; i++) {
//            // 遍历数组，取偶数位的元素
//            average[i] = (double) (nums[i] + nums[N - 1 - i]) / 2;
//        }
//        Arrays.sort(average); // 对数组进行排序
//        return average[0];
//    }

    // 灵神的方法
//    public double minimumAverage(int[] nums) {
//        Arrays.sort(nums);
//        int ans = Integer.MAX_VALUE;
//        int n = nums.length;
//        for (int i = 0; i < n / 2; i++) {
//            ans = Math.min(ans, nums[i] + nums[n - 1 - i]);
//        }
//        return ans / 2.0;
//    }

    // 滑动窗口的方法
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        int L = 0;
        int R = nums.length - 1;
        while (L < R) {
            res = Math.min(res, nums[L++] + nums[R--]);
        }
        return res / 2.0;
    }

    public static void main(String[] args) {
        MinimumAverage m = new MinimumAverage();
        System.out.println(m.minimumAverage(new int[]{1, 9, 8, 3, 10, 5}));
    }
}

