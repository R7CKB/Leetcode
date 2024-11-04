import java.util.Arrays;

/**
 * Title: PrefixCount
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/31 10:21
 * Description: Leetcode 2185 easy
 */
// leetcode: https://leetcode.cn/problems/counting-words-with-a-given-prefix/
public class PrefixCount {
    // 最暴力的方法,使用字符串的StartsWith方法进行判断
//    public int prefixCount(String[] words, String pref) {
//         int count = 0;
//         for (String word : words) {
//             if (word.startsWith(pref)) {
//                 count++;
//             }
//         }
//         return count;
//    }

//    // 优化的方法,使用数组存储每个单词的前缀,然后进行排序,然后遍历数组,判断是否存在该前缀
//    public int prefixCount(String[] words, String pref) {
//        int[] prefix = new int[words.length];
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < pref.length(); j++) {
//                if (j >= words[i].length() || words[i].charAt(j) != pref.charAt(j)) {
//                    break;
//                }
//                if (j == pref.length() - 1) {
//                    prefix[i] = 1;
//                    break;
//                }
//            }
//        }
//        Arrays.sort(prefix);
//        int count = 0;
//        for (int i = 0; i < prefix.length; i++) {
//            if (prefix[i] == 1) {
//                count++;
//            }
//        }
//        return count;
//    }


    // 简洁写法
//    public int prefixCount(String[] words, String pref) {
//        return Arrays.stream(words).mapToInt(item -> item.startsWith(pref) ? 1 : 0).sum();
//    }

    // 使用模拟的方法
    public int prefixCount(String[] words, String pref) {
        // 模拟
        int count = 0;
        for (String word : words) {
            // 若单词长度小于前缀长度,则跳过
            if (word.length() < pref.length()) {
                continue;
            }
            // 使用指针进行比较
            int i = 0;
            for (char c : word.toCharArray()) {
                if (i >= pref.length()) {
                    break;
                }
                if (c != pref.charAt(i)) {
                    break;
                }
                i++;
            }
            if (i == pref.length()) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PrefixCount p = new PrefixCount();
        String[] words = {"dog", "cat", "apple", "apricot", "fish"};
        String pref = "ap";
        System.out.println(p.prefixCount(words, pref));
    }
}
