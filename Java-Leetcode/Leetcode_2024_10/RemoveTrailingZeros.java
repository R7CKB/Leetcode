
/**
 * Title: RemoveTrailingZeros
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/30 09:10
 * Description: Leetcode 2710 easy
 */
// leetcode:https://leetcode.cn/problems/remove-trailing-zeros-from-a-string/
public class RemoveTrailingZeros {
    // 使用StringBuilder来实现
//    public String removeTrailingZeros(String num) {
//        StringBuilder sb = new StringBuilder(num);
//        while (sb.charAt(sb.length() - 1) == '0') {
//            sb.deleteCharAt(sb.length() - 1);
//        }
//        return sb.toString();
//    }

    // 使用字符串截取的方式来实现
//    public String removeTrailingZeros(String num) {
//        int i = num.length() - 1;
//        while (i >= 0 && num.charAt(i) == '0') {
//            i--;
//        }
//        return num.substring(0, i + 1);
//    }

    // 灵神的做法
    // "0+$" 是一个正则表达式：
    // 0+ 表示一个或多个零（0）。
    // $ 表示字符串的结尾。
    // 这个正则表达式用来匹配字符串末尾的一个或多个零。
    // "" 表示将匹配到的部分替换为空字符串，也就是删除它们。
    public String removeTrailingZeros(String num) {
        return num.replaceAll("0+$", "");
    }
}
