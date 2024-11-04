import java.util.HashSet;

/**
 * Title: RepeatedCharacter
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/27 09:54
 * Description: Leetcode 2351 easy
 */
// leetcode: https://leetcode.cn/problems/first-letter-to-appear-twice/
public class RepeatedCharacter {
    // 使用集合或者是数组来存储26个英文字母

    // 使用集合来存储
//    public char repeatedCharacter(String s) {
//        HashSet<Character> set = new HashSet<>();
//        for (char c : s.toCharArray()) {
//            if (set.contains(c)) return c;
//            set.add(c);
//        }
    // Won't go this way
//        return 'a';
//    }

    // 使用数组
//    public char repeatedCharacter(String s) {
//        int[] alphabet = new int[26];
//        for (char c : s.toCharArray()) {
//            if (alphabet[c - 'a'] == 1) {
//                return Character.toLowerCase(c);
//            }
//            alphabet[c - 'a']++;
//        }
    // impossible
//        return 'a';
//    }

    // 使用int整型来存储这26个字母
//    public char repeatedCharacter(String s) {
//        int mask = 0;
//        for (char c : s.toCharArray()) {
//            int x = c - 'a';
//            if ((mask & (1 << x)) != 0) {
//                return c;
//            }
//            mask |= 1 << x;
//        }
//        // impossible
//        return ' ';
//    }

    // 使用位运算,其实就是使用int整型
    public char repeatedCharacter(String s) {
        int mask = 0;
        for (char c : s.toCharArray()) {
            if ((mask >> (c - 'a') & 1) > 0) return c;
            mask |= (1 << (c - 'a'));
        }
        return ' ';
    }


    public static void main(String[] args) {
        RepeatedCharacter repeatedCharacter = new RepeatedCharacter();
        System.out.println(repeatedCharacter.repeatedCharacter("abccbaacz"));
    }
}
