import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Title: NumberOfPairs2
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/10 11:26
 * @Description: Leetcode 3164 medium
 */
// leetcode: https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/description/
public class NumberOfPairs2 {
    // 这个是NumberOfPairs的升级版，数据量变大就成为了中等题目了
    // 感觉能想到的只有循环方法,除了循环没有其他方法了
    // 提示使用哈希表
    // 灵神的第一种解法: https://www.bilibili.com/video/BV17t421N7L6/?vd_source=35b5681fc62a8c45f1f678f6239f74ff
    // 思路:(统计因子个数)
    // 1. 如果X被d整除,那么X有一个因子是等于d的
    // 时间复杂度为O(n*sqrt(U)+M) U=max(nums1)
//    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
//        // 创建了一个哈希表
//        Map<Integer, Integer> map = new HashMap<>();
//        for (int x : nums1) {
//            // 如果x不能整除k,则跳过
//            // 这里就是一个小加速
//            if (x % k != 0) {
//                continue;
//            }
//            x /= k;
//            // 枚举x的因子d
//            for (int d = 1; d * d <= x; d++) {
//                // 如果x被d整除,那么x有一个因子是等于d的
//                // 如果d不是x的因子,则跳过
//                if (x % d > 0) {
//                    // 记录x/d和d的个数
//                    continue;
//                }
//                // Integer::sum：一个函数，用于在键已经存在时合并旧值和新值。
//                // Integer::sum 是 Integer 类的静态方法引用，表示将两个整数相加。
//                // 如果d是x的因子，则将其记录在哈希表中,如果没有键,则创建键值对,如果有键,则将值加1
//                map.merge(d, 1, Integer::sum);
//                // 防止出现平方和的情况从而导致重复计数
//                if (d * d < x) {
//                    map.merge(x / d, 1, Integer::sum);
//                }
//            }
//        }
//        // 注意这里不能使用int类型,因为题目要求返回long类型,所以应该是long类型
//        long count = 0;
//        for (int x : nums2) {
//            // 枚举x的因子d
//            count += map.getOrDefault(x, 0);
//        }
//        return count;
//    }

    // 第二种解法: https://www.bilibili.com/video/BV17t421N7L6/?vd_source=35b5681fc62a8c45f1f678f6239f74ff
    // 枚举倍数
    // 思路:
    // 以nums2[j]为主视角,寻找nums[j]在nums1中的倍数
    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt1 = new HashMap<>();
        // 先将nums1中所有能整除k的数统计出来
        for (int x : nums1) {
            if (x % k == 0) {
                cnt1.merge(x / k, 1, Integer::sum); // cnt1[x/k]++
            }
        }
        // 如果nums1中没有能整除k的数,则直接返回0
        if (cnt1.isEmpty()) {
            return 0;
        }

        // 再遍历nums2,统计nums2中每个数的倍数个数
        Map<Integer, Integer> cnt2 = new HashMap<>();
        for (int x : nums2) {
            cnt2.merge(x, 1, Integer::sum); // cnt2[x]++
        }

        // 进行处理
        long ans = 0;
        // u为nums1中最大的能整除k的数
        int u = Collections.max(cnt1.keySet());
        // 遍历nums2,枚举每个数x
        for (Map.Entry<Integer, Integer> e : cnt2.entrySet()) {
            int x = e.getKey();
            int cnt = e.getValue();
            int s = 0; // nums1中有多少个数/k是x的倍数
            for (int y = x; y <= u; y += x) { // 枚举 x 的倍数
                if (cnt1.containsKey(y)) {
                    s += cnt1.get(y);
                }
            }
            ans += (long) s * cnt;
        }
        return ans;
    }
}
