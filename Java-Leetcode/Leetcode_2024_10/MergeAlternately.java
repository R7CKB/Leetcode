/**
 * Title: MergeAlternately
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/31 09:40
 * Description: Leetcode 1768 easy
 */
// leetcode: https://leetcode.cn/problems/merge-strings-alternately/
public class MergeAlternately {
    // 自己的方法
//    public String mergeAlternately(String word1, String word2) {
//        StringBuilder sb = new StringBuilder();
//        int i = 0;
//        while (i < word1.length() && i < word2.length()) {
//            sb.append(word1.charAt(i));
//            sb.append(word2.charAt(i));
//            i++;
//        }
//        if (i < word1.length()) {
//            sb.append(word1.substring(i));
//        } else if (i < word2.length()) {
//            sb.append(word2.substring(i));
//        }
//        return sb.toString();
//    }

    // 上述方法的更加简洁的写法
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n = word1.length();
        int m = word2.length();
        int len = Math.min(n, m);
        for (int i = 0; i < len; i++) {
            sb.append(word1.charAt(i)).append(word2.charAt(i));
        }
        sb.append(n == len ? word2.substring(n, m) : word1.substring(len, n));
        return sb.toString();
    }

    // 双指针法
//    public String mergeAlternately(String word1, String word2) {
//        int i = 0;
//        int j = 0;
//        StringBuilder sb = new StringBuilder();
//        while (i < word1.length() && j < word2.length()) {
//            sb.append(word1.charAt(i));
//            sb.append(word2.charAt(j));
//            i++;
//            j++;
//        }
//        while (i < word1.length()) {
//            sb.append(word1.charAt(i));
//            i++;
//        }
//        while (j < word2.length()) {
//            sb.append(word2.charAt(j));
//            j++;
//        }
//        return sb.toString();
//    }

    // 灵神的方法
//    public String mergeAlternately(String word1, String word2) {
//        int n = word1.length();
//        int m = word2.length();
//        StringBuilder sb = new StringBuilder(n + m); // 预分配空间
//        for (int i = 0; i < n || i < m; i++) {
//            if (i < n) {
//                sb.append(word1.charAt(i));
//            }
//            if (i < m) {
//                sb.append(word2.charAt(i));
//            }
//        }
//        return sb.toString();
//    }

    // 三叶的方法,写法上更加简洁
//    public String mergeAlternately(String word1, String word2) {
//        int n = word1.length();
//        int m = word2.length();
//        int i = 0;
//        int j = 0;
//        StringBuilder sb = new StringBuilder();
//        while (i < n || j < m) {
//            if (i < n) sb.append(word1.charAt(i++));
//            if (j < m) sb.append(word2.charAt(j++));
//        }
//        return sb.toString();
//    }
}
