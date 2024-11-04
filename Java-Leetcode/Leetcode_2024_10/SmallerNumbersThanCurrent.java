import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Title: SmallerNumbersThanCurrent
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/25 10:58
 * Description: Leetcode 1365 easy
 */
// leetcode: https://leetcode.cn/problems/how-many-numbers-are-smaller-than-the-current-number/description/
public class SmallerNumbersThanCurrent {
    // 暴力模拟
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int[] res = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (nums[i] > nums[j] && i != j) {
//                    res[i]++;
//                }
//            }
//        }
//        return res;
//    }

    // 使用基本排序
    // 我们也可以将数组排序，并记录每一个数在原数组中的位置。
    // 对于排序后的数组中的每一个数，我们找出其左侧第一个小于它的数，
    // 这样就能够知道数组中小于该数的数量。
//    public int[] smallerNumbersThanCurrent(int[] nums) {
//        int N = nums.length;
//        int[][] data = new int[N][2];
//        for (int i = 0; i < N; i++) {
//            data[i][0] = nums[i];
//            data[i][1] = i;
//        }
//        Arrays.sort(data, new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
//
//        int[] res = new int[N];
//        int prev = -1;
//        for (int i = 0; i < N; i++) {
//            if (prev == -1 || data[i][0] != data[i - 1][0]) {
//                prev = i;
//            }
//            res[data[i][1]] = prev;
//        }
//        return res;
//    }


    // 还可以使用计数排序
    // 因为注意到数组元素的值域为 [0,100]，所以可以考虑建立一个频次数组 cnt ，
    // cnt[i] 表示数字 i 出现的次数。那么对于数字 i 而言，小于它的数目就为 cnt[0...i−1] 的总和。
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] cnt = new int[101];
        int N = nums.length;
        // 将nums中的所有数都统计到cnt中
        for (int num : nums) {
            cnt[num]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            // 因为没有处理cnt0的情况,所哟
            res[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return res;
    }


    public static void main(String[] args) {
        SmallerNumbersThanCurrent ss = new SmallerNumbersThanCurrent();
        int[] res = ss.smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3});
        System.out.println(res);
    }
}
