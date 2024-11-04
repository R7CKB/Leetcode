/**
 * Title: FindPermutationDifference
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/26 09:10
 * Description: Leetcode 3146 easy
 */
// leetcode: https://leetcode.cn/problems/permutation-difference-between-two-strings/description/
public class FindPermutationDifference {
    // 暴力方法,使用双重循环来进行判断
//    public int findPermutationDifference(String s, String t) {
//        char[] sChars = s.toCharArray();
//        char[] tChars = t.toCharArray();
//        int res = 0;
//        for (int i = 0; i < sChars.length; i++) {
//            for (int j = 0; j < sChars.length; j++) {
//                if (sChars[i] == tChars[j]) {
//                    res += Math.abs(i - j);
//                }
//            }
//        }
//        return res;
//    }

    // 灵神的更简单的方法,只需要一次遍历
    public int findPermutationDifference(String s, String t) {
        // 使用数组来存储每个字母的不同的位置
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        int res = 0;
        for (int i = 0; i < t.length(); i++) {
            res += Math.abs(i - pos[t.charAt(i) - 'a']);
        }
        return res;
    }

    public static void main(String[] args) {
        FindPermutationDifference f = new FindPermutationDifference();
        System.out.println(f.findPermutationDifference("abc", "bac"));
    }
}
