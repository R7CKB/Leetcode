import java.util.Arrays;

/**
 * Title: FinalValueAfterOperations
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/30 09:19
 * Description: Leetcode 2011 easy
 */
// leetcode: https://leetcode.cn/problems/final-value-of-variable-after-performing-operations/
public class FinalValueAfterOperations {
    // 自己的方法, 不够快
//    public int finalValueAfterOperations(String[] operations) {
//        int res = 0;
//        for (String operation: operations) {
//            if (operation.contains("++")) {
//                res++;
//            } else if (operation.contains("--")) {
//                res--;
//            }
//        }
//        return res;
//    }

    // 另一种思路
//    public int finalValueAfterOperations(String[] operations) {
//        int res = 0;
//        for (String operation: operations) {
//            res += operation.charAt(1) == '+' ? 1 : -1;
//        }
//        return res;
//    }

    // 极致的精简法
    public int finalValueAfterOperations(String[] operations) {
        return Arrays.stream(operations).mapToInt(s -> 44 - s.charAt(1)).sum();
    }
}
