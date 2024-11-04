import java.util.HashSet;
import java.util.Set;

/**
 * Title: IsSubstringPresent
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/3 11:47
 * Description: Leetcode 3083 easy
 */
public class IsSubstringPresent {
    // 笨方法,使用两个哈希表
//    public boolean isSubstringPresent(String s) {
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < s.length() - 1; i++) {
//            set.add(s.substring(i, i + 2));
//        }
//        StringBuilder sb = new StringBuilder(s);
//        String reverseS = sb.reverse().toString();
//        Set<String> set2 = new HashSet<>();
//        for (int i = 0; i < reverseS.length() - 1; i++) {
//            set2.add(reverseS.substring(i, i + 2));
//        }
//        for (String str : set2) {
//            if (set.contains(str)) {
//                return true;
//            }
//        }
//        return false;
//    }

    // 灵神的方法
    // 用一个 26×26 的布尔数组（或哈希表）vis 记录是否遇到了 vis[x][y]，
    // 其中 x 和 y 是一对相邻字母 (s[i−1],s[i])。
    // 如果 vis[y][x] 为真，则说明 x+y 在反转后的字符串中。
//    public boolean isSubstringPresent(String s) {
//        char[] chars = s.toCharArray();
//        boolean[][] vis = new boolean[26][26];
//        for (int i = 1; i < s.length(); i++) {
//            int x = chars[i - 1] - 'a';
//            int y = chars[i] - 'a';
//            vis[x][y] = true;
//            if (vis[y][x]) {
//                return true;
//            }
//        }
//        return false;
//    }

    // 还可以使用位运算,把 vis 数组的第二维压缩成二进制数
    public boolean isSubstringPresent(String s) {
        char[] chars = s.toCharArray();
        int[] vis = new int[26];
        for (int i = 1; i < chars.length; i++) {
            int x = chars[i - 1] - 'a';
            int y = chars[i] - 'a';
            vis[x] |= 1 << y;
            if ((vis[y] >> x & 1) > 0) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        IsSubstringPresent isSubstringPresent = new IsSubstringPresent();
        System.out.println(isSubstringPresent.isSubstringPresent("leetcode"));
    }
}
