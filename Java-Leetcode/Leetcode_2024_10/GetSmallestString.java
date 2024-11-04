/**
 * Title: GetSmallestString
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/30 08:40
 * Description: Leetcode 3216 easy
 */
// leetcode: https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/
public class GetSmallestString {
    // 灵神的解法
//    public String getSmallestString(String s) {
//        char[] chars = s.toCharArray();
//        for (int i = 1; i < chars.length; i++) {
//            char x = chars[i - 1];
//            char y = chars[i];
//            if (x > y && x % 2 == y % 2) {
//                chars[i] = x;
//                chars[i - 1] = y;
//                break;
//            }
//        }
//        return new String(chars);
//    }

    // 稍微化简一下
    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] > chars[i + 1] && chars[i] % 2 == chars[i + 1] % 2) {
                char temp = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = temp;
                break;
            }
        }
        return new String(chars);
    }
}
