/**
 * Title: NeighborSum
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/10 08:48
 * Description: Leetcode 3242 easy
 */
//public class NeighborSum {
//
//    int[][] grid;
//    int N;
//
//    public NeighborSum(int[][] grid) {
//        this.grid = grid;
//        N = grid.length;
//    }
//
//    /**
//     * 返回value在数组中的位置
//     *
//     * @param value value为数组中的某个元素
//     * @return value在数组中的位置
//     */
//    public int valuePosition(int value) {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (grid[i][j] == value) {
//                    return i * N + j;
//                }
//            }
//        }
//        return -1;
//    }
//
//    /**
//     * 返回value的上下左右四个方向的和
//     *
//     * @param value value为数组中的某个元素,不是下标
//     * @return 上下左右四个方向的和
//     */
//    public int adjacentSum(int value) {
//        int index = valuePosition(value);
//        int sum = 0;
//        // 上
//        if (index >= N) {
//            sum += grid[index / N - 1][index % N];
//        }
//        // 下
//        if (index < N * N - N) {
//            sum += grid[index / N + 1][index % N];
//        }
//        // 左
//        if (index % N > 0) {
//            sum += grid[index / N][index % N - 1];
//        }
//        // 右
//        if (index % N < N - 1) {
//            sum += grid[index / N][index % N + 1];
//        }
//        return sum;
//    }
//
//    public int diagonalSum(int value) {
//        int index = valuePosition(value);
//        int sum = 0;
//        // 左上
//        if (index >= N && index % N > 0) {
//            sum += grid[index / N - 1][index % N - 1];
//        }
//        // 右上
//        if (index >= N && index % N < N - 1) {
//            sum += grid[index / N - 1][index % N + 1];
//        }
//        // 左下
//        if (index < N * N - N && index % N > 0) {
//            sum += grid[index / N + 1][index % N - 1];
//        }
//        // 右下
//        if (index < N * N - N && index % N < N - 1) {
//            sum += grid[index / N + 1][index % N + 1];
//        }
//        return sum;
//    }
//
//    public static void main(String[] args) {
//        int[][] grid = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
//        NeighborSum neighborSum = new NeighborSum(grid);
//        System.out.println(neighborSum.adjacentSum(1)); // 6
//        System.out.println(neighborSum.adjacentSum(4)); // 16
//        System.out.println(neighborSum.diagonalSum(4)); // 16
//        System.out.println(neighborSum.diagonalSum(8)); // 4
//    }
//}

// 灵神的方法
// 用一个长为 8 的数组存放偏移向量，前 4 个表示上下左右四个方向，后 4 个表示斜向的四个方向。
// 用一个大小为 n^2×2 的数组 s 预处理元素和，其中 s[v][0] 为 adjacentSum(v) 的结果，
// s[v][1] 为 diagonalSum(v) 的结果。这可以在初始化时，遍历 grid[i][j] 以及偏移向量，
// 累加每个元素的相邻元素之和计算出来。
public class NeighborSum {
    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};

    private final int[][] s;

    public NeighborSum(int[][] grid) {
        int n = grid.length;
        s = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = grid[i][j];
                for (int k = 0; k < 8; k++) {
                    int x = i + DIRS[k][0];
                    int y = j + DIRS[k][1];
                    if (0 <= x && x < n && 0 <= y && y < n) {
                        s[v][k / 4] += grid[x][y];
                    }
                }
            }
        }
    }

    public int adjacentSum(int value) {
        return s[value][0];
    }

    public int diagonalSum(int value) {
        return s[value][1];
    }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
