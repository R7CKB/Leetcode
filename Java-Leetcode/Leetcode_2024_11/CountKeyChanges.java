/**
 * Title: CountKeyChanges
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/4 09:31
 * Description: Leetcode 3019 easy
 */
public class CountKeyChanges {
    // 暴力方法
//    public int countKeyChanges(String s) {
//        s = s.toLowerCase();
//        int count = 0;
//        // 只能采用遍历,不能使用哈希表的方法
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.charAt(i) != s.charAt(i + 1)) {
//                count++;
//            }
//        }
//        return count;
//    }

    // 灵神的位运算方法
    // 由于同一字母的大小写，ASCII码的低5位是相同的，我们只需要统计
    // s[i−1]&31!=s[i]&31的个数。
    //其中&31表示取二进制的低5位。
    public int countKeyChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            if ((s.charAt(i - 1) & 31) != (s.charAt(i) & 31)) {
                ans++;
            }
        }
        return ans;
    }
}
