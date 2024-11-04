import java.util.Arrays;

/**
 * Title: RowAndMaximumOnes
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/4 09:10
 * Description: Leetcode 2643 easy
 */
public class RowAndMaximumOnes {
    // 暴力方法,笨方法
//    public int[] rowAndMaximumOnes(int[][] mat) {
//        int[] res = new int[2];
//        int count = 0;
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//                if (mat[i][j] == 1) {
//                    count++;
//                }
//            }
//            if (count > res[1]) {
//                res[0] = i;
//                res[1] = count;
//            }
//            count = 0;
//        }
//        return res;
//    }

    // 优化方法,直接对每一行求和,然后找最大的和,既是最多的1的行
    // 但是这个方法并不快
//    public int[] rowAndMaximumOnes(int[][] mat) {
//        int[] res = new int[2];
//        for (int i = 0; i < mat.length; i++) {
//            int sum = Arrays.stream(mat[i]).sum();
//            if (sum > res[1]) {
//                res[0] = i;
//                res[1] = sum;
//            }
//        }
//        return res;
//    }

    // 最快的方法,直接遍历每一行,求和,然后找最大的和,既是最多的1的行
    public int[] rowAndMaximumOnes(int[][] mat) {
        int[] ans = new int[2];
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sum += mat[i][j];
            }
            if (sum > ans[1]) {
                ans[0] = i;
                ans[1] = sum;
            }
        }
        return ans;
    }

}
