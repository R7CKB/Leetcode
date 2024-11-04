import java.util.HashSet;
import java.util.Set;

/**
 * Title: CheckIfPangram
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/31 09:54
 * Description: Leetcode 1832 easy
 */
// leetcode: https://leetcode.cn/problems/check-if-the-sentence-is-pangram/
public class CheckIfPangram {
    // 暴力循环遍历.使用boolean数组flag记录每个字母是否出现过.
//    public boolean checkIfPangram(String sentence) {
//        if (sentence.length() < 26) return false;
//        boolean[] flag = new boolean[26];
//        for (int i = 0; i < sentence.length(); i++) {
//            flag[sentence.charAt(i) - 'a'] = true;
//        }
//        for (boolean b : flag) {
//            if (!b) return false;
//        }
//        return true;
//    }

    // 优化: 使用HashSet.
//    public boolean checkIfPangram(String sentence) {
//        if (sentence.length() < 26) return false;
//        Set<Character> set = new HashSet<>();
//        for (int i = 0; i < sentence.length(); i++) {
//            set.add(sentence.charAt(i));
//        }
//        return set.size() == 26;
//    }

    // 使用位掩码,使用int类型mask记录每个字母是否出现过.
//    public boolean checkIfPangram(String sentence) {
//        if (sentence.length() < 26) return false;
//        int mask = 0;
//        for (int i = 0; i < sentence.length(); i++) {
//            mask |= 1 << sentence.charAt(i) - 'a';
//        }
//        return mask == (1 << 26) - 1;
//    }

    // 还可以直接使用数字数组
//    public boolean checkIfPangram(String sentence) {
//        if (sentence.length() < 26) return false;
//        int[] count = new int[26];
//        for (char c : sentence.toCharArray()) {
//            count[c - 'a']++;
//        }
//        for (int i : count) {
//            if (i == 0) return false;
//        }
//        return true;
//    }

    // 使用字符串的indexOf方法
    public boolean checkIfPangram(String sentence) {
        if (sentence.length() < 26) return false;
        for (char i = 'a'; i <= 'z'; i++) {
            if (sentence.indexOf(i) < 0) return false;
        }
        return true;
    }
}
