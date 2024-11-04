import java.util.HashSet;
import java.util.Set;

/**
 * @Title: NumberOfSpecialChars
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/9/30 18:37
 * @description: 3120
 */
// leetcode :https://leetcode.cn/problems/count-the-number-of-special-characters-i/description/
public class NumberOfSpecialChars {
    // 1. 暴力方法
//    public int numberOfSpecialChars(String word) {
//        int[] alphabet = new int[100];
//        for (int i = 0; i < word.length(); i++) {
//            alphabet[word.charAt(i) - 'A']++;
//        }
//        int count = 0;
//        for (int i = 0; i < 100; i++) {
//            if (alphabet[i] > 0 && alphabet[i + 32] > 0) {
//                count++;
//            }
//        }
//        return count;
//    }

    // 3. 集合方法
//    public int numberOfSpecialChars(String word) {
//        Set<Character> lower = new HashSet<>();
//        Set<Character> upper = new HashSet<>();
//        int count = 0;
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (Character.isLowerCase(c)) {
//                lower.add(c);
//            } else if (Character.isUpperCase(c)) {
//                upper.add(Character.toLowerCase(c));
//            }
//        }
//        // 计算两个集合的交集
//        // java内健库不支持直接求集合的交集,只能采用循环的方式求
//        for (char c : lower) {
//            if (upper.contains(c)) {
//                count++;
//            }
//        }
//        return count;
//    }
    // 2. 灵神的做法
    // 先知道原理
    // 对于大写英文字母：其二进制从右往左第 6 个比特值一定是 0。
    //对于小写英文字母：其二进制从右往左第 6 个比特值一定是 1。
    // 这样子就可以新建一个数组来区分一个字符是大写字符或者是小写字符
    //对于任何英文字母：其小写字母二进制低 5 位，一定和其大写字母二进制低 5 位相等。

    /**
     * ASCII 编码中，大小写字母之间的关系是非常规律的。它们的二进制表示中，除了最高的三位不同，剩余的五位是相同的。
     * 举个例子，我们用二进制来比较小写字母 'a' 和大写字母 'A' 的 ASCII 编码：
     * 'a' 的 ASCII 码值是 97，二进制表示为 01100001。
     * 'A' 的 ASCII 码值是 65，二进制表示为 01000001。
     * 它们的二进制表示的最高位之间的区别就是 32，即 2^5，这是因为 ASCII 编码中大小写字母之间相差的固定值。
     */
    public int numberOfSpecialChars(String word) {
        int[] mask = new int[2];
        for (char c : word.toCharArray()) {
            // 对于字符串中的每个字符,对其进行位运算
            // 1. c >> 5 & 1 计算 c 的第 6 位是否为 1，如果为 1，则为小写字母，否则为大写字母
            // 大写字母为 0，小写字母为 1
            // 2. c & 31 计算 c 是第几个字母
            // 3. mask[c >> 5 & 1] |= 1 << (c & 31) 将c这个字母加到数组里面去了
            mask[c >> 5 & 1] |= 1 << (c & 31);
        }
        // 最后的mask数组中，mask[0]和mask[1]分别代表了小写字母和大写字母的掩码
        // 我们只需要计算两个掩码的交集的1的个数即可
        // 交集可以使用位运算来计算交集的1的个数
        // 因为再mask数组中每一个1的位置代表的是一个数,所以可以这样子计算:
        int num= mask[0] & mask[1];
        return Integer.bitCount(mask[0] & mask[1]);
    }


    public static void main(String[] args) {
        String word = "fN";
        NumberOfSpecialChars nsc = new NumberOfSpecialChars();
        int count = nsc.numberOfSpecialChars(word);
        System.out.println(count);
    }
}

