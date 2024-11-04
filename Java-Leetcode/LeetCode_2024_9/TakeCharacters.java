package LeetCode_2024_9;

/**
 * @Title: TakeCharacters
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/27 16:33
 * @description: Leetcode
 */
// leetcode:
// https://leetcode.cn/problems/take-k-of-each-character-from-left-and-right/description
// 这个思想是最重要的:
// 将左边的字符和右边的字符取走之后,源字符串还剩下一个连续的区间
// 其实就是求这个最长的区间(即最长子串),然后使用总长度减去这个区间的长度就是结果
public class TakeCharacters {
    // leetcode官方做法:
//    public int takeCharacters(String s, int k) {
//        // 因为str只会包含abc三个字符，所以可以用一个数组来记录频率
//        int[] freq = new int[3];
//        int N = s.length();
//        int res = N;
//        // 首先计算每个字符的频率
//        // 时间复杂度O(n)
//        for (int i = 0; i < N; i++) {
//            freq[s.charAt(i) - 'a']++;
//        }
//        // 查看频率并检查是否可能
//        if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
//            res = Math.min(res, N);
//        } else {
//            return -1;
//        }
//        // 通过双指针来建立滑动窗口
//        int L = 0;
//        for (int R = 0; R < N; R++) {
//            freq[s.charAt(R) - 'a']--;
//            while (L < R && (freq[0] < k || freq[1] < k || freq[2] < k)) {
//                freq[s.charAt(L) - 'a']++;
//                L++;
//            }
//            if (freq[0] >= k && freq[1] >= k && freq[2] >= k) {
//                res = Math.min(res, N - (R - L + 1));
//            }
//
//        }
//        return res;
//    }

    // 灵神做法:
    // 与其维护窗口内的字母个数，不如直接维护窗口外的字母个数，这也是我们取走的字母个数。
    //
    //一开始，假设我们取走了所有的字母。或者说，初始窗口是空的，窗口外的字母个数就是 s 的每个字母的出现次数。
    //右端点字母进入窗口后，该字母取走的个数减一。
    //如果减一后，窗口外该字母的个数小于 k，说明子串太长了，或者取走的字母个数太少了，那么就不断右移左端点，把左端点字母移出窗口，相当于我们取走移出窗口的字母，直到该字母个数等于 k，退出内层循环。
    //内层循环结束后，用窗口长度 right−left+1 更新子串长度的最大值。
    //最后，原问题的答案为 n 减去子串长度的最大值。
    //
    //特别地，如果 s 中某个字母的个数不足 k，那么无法满足题目要求，返回 −1。
    public int takeCharacters(String s, int k) {
        char[] chars = s.toCharArray();
        int N = s.length();
        int[] freq = new int[3];
        // 先初始化数组
        for (char c : chars) {
            freq[c - 'a']++;
        }
        // 字母个数小于k的情况,直接返回-1
        if (freq[0] < k || freq[1] < k || freq[2] < k) {
            return -1;
        }
        // 子串的最大长度
        int mx = 0;
        int L = 0;
        // 建立滑动窗口
        for (int R = 0; R < N; R++) {
            int c = chars[R] - 'a';
            // 移入窗口
            freq[c]--;
            // 窗口之外的c不足k个,移出窗口
            while (freq[c] < k) {
                // 移出窗口
                freq[chars[L] - 'a']++;
                L++;
            }
            mx = Math.max(mx, R - L + 1);
        }
        return s.length() - mx;
    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(new TakeCharacters().takeCharacters(s, k));
    }
}
