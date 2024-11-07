/**
 * Title: RepeatedSubstringPattern
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/7 08:58
 * Description: Leetcode 459 easy
 */
public class RepeatedSubstringPattern {
    // 假设字符串s是由s1+s2组成的，s+s后，str就变成了s1+s2+s1+s2，
    // 去掉首尾，破环了首尾的s1和s2，变成了s3+s2+s1+s4,此时str中间就是s2+s1,
    // 如果s是循环字串，也就是s1=s2,所以str中间的s2+s1就和原字符串相等。
    // 如果s不是循环字串，s1!=s2，那么s1+s2是不等于s2+s1的，也就是str中间不包含s
    // 所以可以直接判断 str 中去除首尾元素之后，是否包含自身元素。如果包含。则表明存在重复子串。
    // 简单的暴力方法
//    public boolean repeatedSubstringPattern(String s) {
//        String str = s + s;
//        return str.substring(1, str.length() - 1).contains(s);
//    }

    // 还有一种是思路相同的字符串匹配算法，但是更加高效。
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    // 还有更复杂的暴力方法(枚举法)
    // Leetcode题解
    // 如果一个长度为 n 的字符串 s 可以由它的一个长度为 n′的子串 s′重复多次构成，
    // 那么：n 一定是 n′的倍数；
    // s′一定是 s 的前缀；
    // 对于任意的 i∈[n′,n)，有 s[i]=s[i−n′]。
    // 也就是说，s 中长度为 n′的前缀就是 s′，并且在这之后的每一个位置上的字符 s[i]，
    // 都需要与它之前的第 n′个字符 s[i−n′] 相同。
    // 因此，我们可以从小到大枚举 n′，并对字符串 s 进行遍历，
    // 进行上述的判断。注意到一个小优化是，因为子串至少需要重复一次，
    // 所以 n′不会大于 n 的一半，我们只需要在 [1,n/2] 的范围内枚举 n′即可。
//    public boolean repeatedSubstringPattern(String s) {
//        int n = s.length();
//        for (int i = 1; i * 2 <= n; ++i) {
//            if (n % i == 0) {
//                boolean match = true;
//                for (int j = i; j < n; ++j) {
//                    if (s.charAt(j) != s.charAt(j - i)) {
//                        match = false;
//                        break;
//                    }
//                }
//                if (match) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
