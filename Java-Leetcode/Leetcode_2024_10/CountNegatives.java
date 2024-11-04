/**
 * @Title: CountNegatives
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/16 11:24
 * @Description: Leetcode 1351 easy
 */
// leetcode: https://leetcode.cn/problems/count-negative-numbers-in-a-sorted-matrix/description/
public class CountNegatives {
    // 暴力方法
//    public int countNegatives(int[][] grid) {
//        int count = 0;
//        for (int i = grid.length - 1; i >= 0; i--) {
//            for (int j = grid[0].length - 1; j >= 0; j--) {
//                if (grid[i][j] < 0) {
//                    count++;
//                }
//                if (grid[i][j] >= 0) {
//                    break;
//                }
//            }
//        }
//        return count;
//    }

    // 二分查找法
//    public int countNegatives(int[][] grid) {
//        int count = 0;
//        for (int[] row : grid) {
//            int L = 0;
//            int R = row.length - 1;
//            int pos = -1;
//            while (L <= R) {
//                int mid = L + ((R - L) >> 1);
//                if (row[mid] < 0) {
//                    pos = mid;
//                    R = mid - 1;
//                } else {
//                    L = mid + 1;
//                }
//            }
//            if (pos != -1) {
//                count += row.length - pos;
//            }
//        }
//        return count;
//    }

    // 因为是每行每列都是递增的,可以采用分治算法
    // 不理解
//    private int solve(int l, int r, int L, int R, int[][] grid) {
//        if (l > r) return 0;
//        int mid = l + ((r - l) >> 1);
//        int pos = -1;
//        for (int i = L; i <= R; i++) {
//            if (grid[mid][i] < 0) {
//                pos = i;
//                break;
//            }
//        }
//        int res = 0;
//        if (pos != -1) {
//            res += grid[0].length - pos;
//            res += solve(l, mid - 1, pos, R, grid);
//            res += solve(mid + 1, r, L, pos, grid);
//        } else { // 说明[l..o-1]不会有负数，不用再去递归
//            res += solve(mid + 1, r, L, R, grid);
//        }
//        return res;
//    }
//
//    public int countNegatives(int[][] grid) {
//        return solve(0, grid.length - 1, 0, grid[0].length - 1, grid);
//    }

    // 倒序遍历
//    public int countNegatives(int[][] grid) {
//        int count = 0;
//        int m = grid[0].length;
//        int pos = grid[0].length - 1;
//        for (int[] row : grid) {
//            int i;
//            for (i = pos; i >= 0; i--) {
//                if (row[i] >= 0) {
//                    if (i + 1 < m) {
//                        pos = i + 1;
//                        count += m - pos;
//                    }
//                    break;
//                }
//            }
//            if (i == -1) {
//                count += m;
//                pos = -1;
//            }
//        }
//        return count;
//    }

    // 更加直观的倒序遍历
    public int countNegatives(int[][] grid) {
        /*
        [4,3,2,-1],
        [3,2,1,-1],
        [1,1,-1,-2],
        [-1,-1,-2,-3]
        从右上角开始遍历，i = 0, j = grid[0].length - 1
        如果当前值大于等于 0，那么前面的值肯定都非负，那么直接跳过，进入下一行, 即 i++
        如果当前值小于 0，那么当前值以及同列下的值都是小于 0 的，那么直接添加，然后进行下一列，即 j--
        */
        int count = 0;
        for(int i = 0, j = grid[0].length - 1; i < grid.length && j >= 0; ){
            if(grid[i][j] >= 0){
                i++;
            }else{
                count += grid.length - i;
                j--;
            }
        }
        return count;
    }
}
