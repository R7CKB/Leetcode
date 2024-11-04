/**
 * Title: PercentageLetter
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/28 09:36
 * Description: Leetcode 2278 easy
 */
// leetcode: https://leetcode.cn/problems/percentage-of-letter-in-string/
public class PercentageLetter {
    // 暴力方法,直接循环字符串,统计字母出现的次数,然后计算百分比
//    public int percentageLetter(String s, char letter) {
//        int count = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == letter) {
//                count++;
//            }
//        }
//        return (count * 100) / s.length();
//    }

    // 使用数组来统计字母出现的次数,然后计算百分比
    public int percentageLetter(String s, char letter) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        return (count[letter - 'a'] * 100) / s.length();
    }

    public static void main(String[] args) {
        PercentageLetter p = new PercentageLetter();
        System.out.println(p.percentageLetter("foobar", 'o'));
    }
}
