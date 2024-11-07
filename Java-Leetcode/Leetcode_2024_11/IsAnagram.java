import java.util.HashMap;
import java.util.Map;

/**
 * Title: IsAnagram
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/7 08:27
 * Description: Leetcode 242 easy
 */
public class IsAnagram {
    // 使用数组记录每个字符出现的次数
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) {
//            return false;
//        }
//        int[] count = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            count[s.charAt(i) - 'a']++;
//            count[t.charAt(i) - 'a']--;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (count[i] != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 使用哈希表记录每个字符出现的次数
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c1 = s.charAt(i);
//            char c2 = t.charAt(i);
//            if (map.containsKey(c1)) {
//                map.put(c1, map.get(c1) + 1);
//            } else {
//                map.put(c1, 1);
//            }
//            if (map.containsKey(c2)) {
//                map.put(c2, map.get(c2) - 1);
//            } else {
//                map.put(c2, -1);
//            }
//        }
//        for (int count : map.values()) {
//            if (count != 0) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 但如果要存的是Unicode字符，则需要使用哈希表记录每个字符出现的次数
    // 进阶问题的核心点在于「字符是离散未知的」，因此我们用哈希表维护对应字符的频次即可。
    // 同时读者需要注意 Unicode 一个字符可能对应多个字节的问题，不同语言对于字符串读取处理的方式是不同的。
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if (map.get(t.charAt(i)) < 0) return false;
        }
        return true;
    }

    // 还可以直接使用字符串排序方法
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        char[] sArray = s.toCharArray();
//        char[] tArray = t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        return Arrays.equals(sArray, tArray);
//    }
}
