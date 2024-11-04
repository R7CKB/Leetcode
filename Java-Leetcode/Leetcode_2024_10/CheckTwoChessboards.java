/**
 * Title: CheckTwoChessboards
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/29 09:29
 * Description: Leetcode 3274 easy
 */
// leetcode:https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/
public class CheckTwoChessboards {
//    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
//        return ((coordinate1.charAt(0) - coordinate2.charAt(0)) + (coordinate1.charAt(1) - coordinate2.charAt(1))) % 2 == 0;
//    }

    // 灵神的方法
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int a = (coordinate1.charAt(0) + coordinate1.charAt(1)) % 2;
        int b = (coordinate2.charAt(0) + coordinate2.charAt(1)) % 2;
        return a == b;
    }
}
