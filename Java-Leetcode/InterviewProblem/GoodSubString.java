import java.util.Scanner;

/**
 * Title: GoodSubString
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/30 19:37
 * Description: 中国平安 Java工程师 Topic2
 */

/**
 * 题目描述:
 * 小红拿到了一个字符串，她定义：若删除一个连续子串（不能是原字符串）后，
 * 剩下的部分拼接起来是回文串，那么该子串为“好子串”。
 * 小红想知道，这个字符串有多少个“好子串”？
 * <p>
 * 输入格式:
 * 输入第一行包含一个字符串 s，字符串由小写字母组成，长度不超过10^5。
 * <p>
 * 输出格式:
 * 输出一个整数，表示字符串 s 中有多少个“好子串”。
 * <p>
 * 输入样例:
 * aba
 * <p>
 * 输出样例:
 * 3
 * <p>
 * 解释:
 * 删除子字符串"ab","b","ba"后，剩下的部分拼接起来是回文串，所以它们都是“好子串”。
 */
public class GoodSubString {
    // GPT的回答
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int count = countGoodSubstrings(s);
//        System.out.println(count);
//    }
//
//    // 和DeepSeek的思想是一样的,但是实现上有点区别
//    private static int countGoodSubstrings(String s) {
//        int n = s.length();
//        int count = 0;
//
//        // 遍历所有可能的子串 [i, j]
//        for (int i = 0; i < n; i++) {
//            for (int j = i; j < n; j++) {
//                // 删除子串 s[i...j]
//                if (i == 0 && j == n - 1) {
//                    continue; // 删除整个字符串，不算
//                }
//
//                // 检查剩余部分是否为回文
//                String leftPart = s.substring(0, i);
//                String rightPart = s.substring(j + 1);
//
//                if (isPalindrome(leftPart + rightPart)) {
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }
//
//    // 辅助函数：检查一个字符串是否为回文
//    private static boolean isPalindrome(String str) {
//        // 也是采用双指针法,滑动窗口来判断一个字符串是否为回文字符串
//        int left = 0, right = str.length() - 1;
//        while (left < right) {
//            if (str.charAt(left) != str.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }

    // DeepSeek的回答, 理解了DeepSeek的回答
    // 检查字符串是否是回文串
    // ✔️✔️✔️
//    private static boolean isPalindrome(String s) {
//        // 使用滑动窗口来判断回文串,背会这个做法,并不难.
//        int left = 0;
//        int right = s.length() - 1;
//        while (left < right) {
//            if (s.charAt(left) != s.charAt(right)) {
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//
//    // 计算好子串的数量
//    public static int countGoodSubstrings(String s) {
//        int n = s.length();
//        int count = 0;
//
//        // 枚举所有可能的子串
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j <= n; j++) {
//                // 删除子串 s[i:j]
//                String remaining = s.substring(0, i) + s.substring(j);
//                // 检查剩下的部分是否是回文串
//                if (!remaining.isEmpty() && isPalindrome(remaining)) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int result = countGoodSubstrings(s);
//        System.out.println("字符串 \"" + s + "\" 中有 " + result + " 个好子串。");
//    }
}
