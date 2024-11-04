import java.util.HashSet;
import java.util.Random;

/**
 * Title: RepeatedNTimes
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/28 09:17
 * Description: Leetcode 961 easy
 */
// leetcode: https://leetcode.cn/problems/n-repeated-element-in-size-2n-array/
public class RepeatedNTimes {
    // 暴力方法.使用哈希表
//    public int repeatedNTimes(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return num;
//            }
//            set.add(num);
//        }
//        return -1;
//    }

    // 还是暴力方法,使用数组
//    public int repeatedNTimes(int[] nums) {
////        int[] count = new int[10001];
////        for (int num : nums) {
////            if (count[num] == 1) {
////                return num;
////            }
////            count[num]++;
////        }
////        return -1;
//        int[] cnts = new int[10010];
//        for (int x : nums) {
//            if (++cnts[x] > 1) return x;
//        }
//        return -1;
//    }

    // 规律法
    // 假设重复出现的数字是 x，数字 x 重复了 n 次，要将这 n 个相同的 x 间隔开，
    // 需要 n−1 个额外数字，而实际上我们除 x 以外还有 n 个额外数字（数字总数为 n+1 个），
    // 因此在我们所能构造出的所有排列方式中，最多 使相邻 x 之间间隔了 2 个额外数字。
    // 对于每个 nums[i] 而言，我们检查往前的三个位置（若有），
    // 如果有重复相等情况，说明当前的 nums[i] 即是答案。
//    public int repeatedNTimes(int[] nums) {
//        int N = nums.length;
//        for (int i = 0; i < N; i++) {
//            int temp = nums[i];
//            if (i - 1 >= 0 && nums[i - 1] == temp) return temp;
//            if (i - 2 >= 0 && nums[i - 2] == temp) return temp;
//            if (i - 3 >= 0 && nums[i - 3] == temp) return temp;
//        }
//        return -1;
//    }

    // 还有一种随机选择方法
    // 随机选择两个数字，如果这两个数字相同，则重复出现，否则继续随机选择，直到找到重复的数字。
    // 选择两个相同元素的概率为 (n/2*n) * (n-1/2*n) ~= 1/4
    // 因此期望 4 次结束循环。
    public int repeatedNTimes(int[] nums) {
        int N = nums.length;
        Random random = new Random();
        while (true) {
            int x = random.nextInt(N);
            int y = random.nextInt(N);
            if (x != y && nums[x] == nums[y]) {
                return nums[x];
            }
        }
    }
}
