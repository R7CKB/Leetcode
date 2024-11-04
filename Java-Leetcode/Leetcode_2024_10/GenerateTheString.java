import java.util.Arrays;

/**
 * Title: GenerateTheString
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/29 21:31
 * Description: Leetcode 1374 easy
 */
// leetcode: https://leetcode.cn/problems/generate-a-string-with-characters-that-have-odd-counts/
public class GenerateTheString {
    // leetcode题解
    // 自己的方法
    // 不够快
//    public String generateTheString(int n) {
//        if (n % 2 == 0) {
//            return "a".repeat(n - 1) + "b";
//        } else {
//            return "a".repeat(n);
//        }
//    }

    // 三叶的方法
    // n为偶数,第一个字符是a,n-1个字符是b
    // n为奇数,n个字符全是b
    // 这个方法也不够快
//    public String generateTheString(int n) {
//        StringBuilder sb = new StringBuilder();
//        if (n % 2 == 0 && --n >= 0) sb.append('a');
//        while (n-- > 0) sb.append('b');
//        return sb.toString();
//    }

    // 使用数组的方法
    public String generateTheString(int n) {
        char[] chars = new char[n];
        if ((n & 1) == 1) { // n为奇数
            Arrays.fill(chars, 'a');
        } else { // n为偶数
            Arrays.fill(chars, 'a');
            chars[chars.length - 1] = 'b';
        }
        return new String(chars);
    }
}
