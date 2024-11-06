/**
 * Title: FindTheDifference
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/6 10:20
 * Description: Leetcode 389 easy
 */
public class FindTheDifference {
    // 笨办法,使用哈希表
//    public char findTheDifference(String s, String t) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        HashMap<Character, Integer> map2 = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (char c : t.toCharArray()) {
//            map2.put(c, map2.getOrDefault(c, 0) + 1);
//        }
//        for (char c : map2.keySet()) {
//            if (!Objects.equals(map2.get(c), map.get(c)) || map.get(c) == null) {
//                return c;
//            }
//        }
//        return ' ';
//    }

    // 数组计数法
//    public char findTheDifference(String s, String t) {
//        int[] count = new int[26];
//        for (char c : s.toCharArray()) {
//            count[c - 'a']++;
//        }
//        for (char c : t.toCharArray()) {
//            count[c - 'a']--;
//        }
//        for (int i = 0; i < 26; i++) {
//            if (count[i] != 0) {
//                return (char) (i + 'a');
//            }
//        }
//        // impossible
//        return ' ';
//    }

    // 还有简单的方法,求和
//    public char findTheDifference(String s, String t) {
//        int as = 0;
//        int at = 0;
//        for (char c : s.toCharArray()) {
//            as += c;
//        }
//        for (char c : t.toCharArray()) {
//            at += c;
//        }
//        return (char) (at - as);
//    }

    // 位运算的方法
    public char findTheDifference(String s, String t) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res ^= c;
        }
        for (char c : t.toCharArray()) {
            res ^= c;
        }
        return (char) res;
    }
}
