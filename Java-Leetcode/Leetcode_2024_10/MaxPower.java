import java.util.Arrays;

/**
 * Title: MaxPower
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/30 09:25
 * Description: Leetcode 1446 easy
 */
// leetcode: https://leetcode.cn/problems/consecutive-characters/
public class MaxPower {
    // 使用数组方法
//    public int maxPower(String s) {
//        int[] alphabet = new int[s.length()];
//        Arrays.fill(alphabet, 1);
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) == s.charAt(i + 1)) {
//                alphabet[i + 1] = alphabet[i] + 1;
//            }
//        }
//        for (int i = 0; i < s.length(); i++) {
//            max = Math.max(max, alphabet[i]);
//        }
//        return max;
//    }

    // 不采用数组,采用变量方法.会更加简单一点
//    public int maxPower(String s) {
//        int res = 1;
//        int count =1;
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == s.charAt(i - 1)) {
//                count++;
//                res = Math.max(res, count);
//            }else{
//                count = 1;
//            }
//        }
//        return res;
//    }

    // 双指针方法,三叶的方法
    // ✨✨✨
    public int maxPower(String s) {
        int n = s.length();
        int res = 1;
        for (int i = 0; i < n; ) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            res = Math.max(res, j - i);
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        MaxPower m = new MaxPower();
        System.out.println(m.maxPower("leetcode"));
        System.out.println(m.maxPower("abbcccddddeeeeedcba"));
    }
}
