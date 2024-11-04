/**
 * Title: ScoreOfString
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/25 17:26
 * Description: Leetcode 3110 easy
 */
// leetcode: https://leetcode.cn/problems/score-of-a-string/description/
public class ScoreOfString {
    // 暴力方法
//    public int scoreOfString(String s) {
//        char[] chars = s.toCharArray();
//        int score = 0;
//        for (int i = 1; i < chars.length; i++) {
//            score += Math.abs(chars[i] - chars[i - 1]);
//        }
//        return score;
//    }

    // 将字符串视为一个数组会更快
    public int scoreOfString(String s) {
        int result = 0;
        int N = s.length();
        int prev = s.charAt(0);
        for (int i = 1; i < N; i++) {
            char c = s.charAt(i);
            result += Math.abs(prev - c);
            prev = c;
        }
        return result;
    }
}
