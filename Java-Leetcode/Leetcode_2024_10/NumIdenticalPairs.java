import java.util.HashMap;
import java.util.Map;

/**
 * Title: NumIdenticalPairs
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/28 08:59
 * Description: Leetcode 1512 easy
 */
// leetcode: https://leetcode.cn/problems/number-of-good-pairs/
public class NumIdenticalPairs {
    // 暴力方法,枚举所有可能的组合,时间复杂度O(n^2)
//    public int numIdenticalPairs(int[] nums) {
//        int n = nums.length;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (nums[i] == nums[j]) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }

    // 另一种思路,改题目可以进行化简:
    // 这个算法实现原理是最简单自然的一个, 一点都不难理解, 看完我的解释后你就明白为啥这么说了:
    // 首先, 这个算法的题目里面有个容易误导人的地方, 就是要求 i<j 的限制,
    // 在解题的时候肯定要遍历数组的, 而遍历顺序就是从前往后的,
    // i<j 是个很自然的隐含条件, 遍历的过程本身就已经满足这个条件了,
    // 也就是说, 这个题目可以进行化简, 化简后的题目可以描述为:
    // 统计一个数组中重复的数字个数. ( 对, 这就是化简后的题目, 当然, 统计规则有特殊要求 )
    // 统计规则是这样的: 假如用 [1,1,1,1] 这样一个数组作为给定输入,
    // 第一次遇到1的时候, 统计数+=0, 第二次遇到1的时候, 统计数+=1,
    // 第三次遇到1的时候, 统计数+=2, 第四次遇到1的时候, 统计数+=3,
    // ( 所有不同的数字都按照这个规律以此类推.... )
    // 最后的统计结果为 0+1+2+3 = 6 ( 正确答案就这么统计出来了! )
    //上面描述的统计规则正是这个算法的实现原理, 再看这个算法的实现就好懂了.
//    public int numIdenticalPairs(int[] nums) {
//        int res = 0;
//        int[] temp = new int[100];
//        for (int num : nums) {
//             /*
//            这行代码可以写成
//            ans+=temp[num - 1];
//            temp[num - 1]++;
//            */
//            res += temp[num - 1]++;
//        }
//        return res;
//    }

    // 还可以使用哈希表实现,Leetcode题解:
//    public int numIdenticalPairs(int[] nums) {
//        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
//        for (int num : nums) {
//            m.put(num, m.getOrDefault(num, 0) + 1);
//        }
//
//        int ans = 0;
//        // 用哈希表统计每个数在序列中出现的次数，假设数字 k 在序列中出现的次数为 v，
//        // 那么满足题目中所说的 nums[i]=nums[j]=k(i<j) 的 (i,j) 的数量就是
//        // (v*(v−1))/2,即 k 这个数值对答案的贡献是(v*(v−1))/2。
//        // 我们只需要把所有数值的贡献相加，即可得到答案。
//        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
//            int v = entry.getValue();
//            ans += v * (v - 1) / 2;
//        }
//
//        return ans;
//    }

    // 还可以不用遍历map,直接一步实现
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int valve = map.getOrDefault(num, 0);
            count += valve;
            map.put(num, valve + 1);
        }
        return count;
    }
}
