/**
 * Title: StrStr
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/6 10:31
 * Description: Leetcode 28 easy
 */
public class StrStr {
    // 其实就是寻找子串的第一个位置,使用简单的双指针实现
//    public int strStr(String haystack, String needle) {
//        int index1 = 0;
//        int index2 = 0;
//        int len1 = haystack.length();
//        int len2 = needle.length();
//        while (index1 < len1 && index2 < len2) {
//            if (haystack.charAt(index1) == needle.charAt(index2)) {
//                index1++;
//                index2++;
//            } else {
//                index1 = index1 - index2 + 1;
//                index2 = 0;
//            }
//        }
//        return index2 == len2 ? index1 - index2 : -1;
//    }

    // 三叶的朴素KMP算法实现
//    public int strStr(String ss, String pp) {
//        int n = ss.length(), m = pp.length();
//        char[] s = ss.toCharArray(), p = pp.toCharArray();
//        // 枚举原串的「发起点」
//        for (int i = 0; i <= n - m; i++) {
//            // 从原串的「发起点」和匹配串的「首位」开始，尝试匹配
//            int a = i, b = 0;
//            while (b < m && s[a] == p[b]) {
//                a++;
//                b++;
//            }
//            // 如果能够完全匹配，返回原串的「发起点」下标
//            if (b == m) return i;
//        }
//        return -1;
//    }


    // 三叶的经典KMP算法实现
    // KMP 算法
    // ss: 原串(string)  pp: 匹配串(pattern)
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) return 0;

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) return i - m;
        }

        return -1;
    }

}
