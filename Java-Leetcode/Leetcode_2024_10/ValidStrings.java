import java.util.ArrayList;
import java.util.List;

/**
 * Title: ValidStrings
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/29 08:31
 * Description: Leetcode 3211 medium
 */
// leetcode: https://leetcode.cn/problems/generate-binary-strings-without-adjacent-zeros/
public class ValidStrings {
//    // 暴力枚举法
//    // 生成所有长度为n的二进制字符串
//    public void generateBinaryStrings(int n, String current, List<String> res) {
//        if (current.length() == n) {
//            res.add(current);
//        } else {
//            generateBinaryStrings(n, current + "0", res);
//            generateBinaryStrings(n, current + "1", res);
//        }
//    }
//
//    // 检验该字符串是否是有效的字符串
//    public boolean isValidString(String s) {
//        for (int i = 0; i < s.length() - 1; i++) {
//            if (s.substring(i, i + 2).equals("00")) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public List<String> validStrings(int n) {
//        List<String> allString = new ArrayList<String>();
//        generateBinaryStrings(n, "", allString);
//        List<String> res = new ArrayList<String>();
//        for (String s : allString) {
//            if (isValidString(s)) {
//                res.add(s);
//            }
//        }
//        return res;
//    }

    // 灵神的回溯方法
//    public List<String> validStrings(int n) {
//        List<String> res = new ArrayList<>();
//        char[] path = new char[n];
//        dfs(0, n, path, res);
//        return res;
//    }
//
//    private void dfs(int i, int n, char[] path, List<String> res) {
//        if (i == n) {
//            res.add(new String(path));
//            return;
//        }
//        // 填 1
//        path[i] = '1';
//        dfs(i + 1, n, path, res);
//
//        // 填 0
//        if (i == 0 || path[i - 1] == '1') {
//            path[i] = '0'; // 直接覆盖
//            dfs(i + 1, n, path, res);
//        }
//    }

    // 位运算方法
    // 枚举 [0,2^n−1] 中的 i，如果 i 的长为 n 的二进制中，没有相邻的 0，那么将其二进制字符串加入答案。
    // 怎么判断二进制中是否有相邻的 0？
    // 我们可以把 i 取反（保留低 n 位），记作 x。问题变成：判断 x 中是否有相邻的 1。
    // 需要一个一个地遍历二进制数 x 的每一位吗？
    // 不需要，我们可以用 x & (x >> 1) 来判断，如果这个值不为零，
    // 则说明 x 中有相邻的 1，反之没有。例如 x=110，右移一位得 011，
    // 可以发现这两个二进制数的次低位都是 1，所以计算 AND 的结果必然不为 0。
    // 代码实现时，可以直接枚举取反后的值 x，如果 x & (x >> 1) 等于 0，
    // 就把 x 取反后的值（也就是 i）加入答案。
    //
    // 如何取反？
    // 创建一个低 n 位全为 1 的二进制数 mask = (1 << n) - 1。
    // 计算 x ^ mask，由于 0 和 1 异或后变成了 1，
    // 1 和 1 异或后变成了 0，所以 x 的低 n 位都取反了。
    //
    // NB!!!!!✨✨✨
    public List<String> validStrings(int n) {
        List<String> res = new ArrayList<>();
        int mask = (1 << n) - 1; // mask即为2^n-1
        for (int i = 0; i < (1 << n); i++) {
            if (((i >> 1) & i) == 0) {
                int x = ~i; // x即为i取反后的值
                // 一种生成前导零的写法：在 i 前面插入 1<<n，转成字符串后再去掉插入的 1<<n
                res.add(Integer.toBinaryString((1 << n) | x).substring(1));
            }
        }
        return res;
    }
}
