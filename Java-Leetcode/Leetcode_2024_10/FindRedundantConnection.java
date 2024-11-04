import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Title: FindRedundantConnection
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/27 08:55
 * Description: Leetcode 684 medium
 */
// leetcode: https://leetcode.cn/problems/redundant-connection/
public class FindRedundantConnection {
    class Union {
        int[] parent;
        int[] rank;

        public Union(int n) {
            parent = new int[n];
            rank = new int[n];
            Arrays.fill(parent, -1);
            Arrays.fill(rank, 1);
        }

        // O(1)
        public int find(int x) {
            // 如果是-1的话,说明他是孤立的,所以直接返回它的序号即可
            if (parent[x] == -1) {
                return x;
            }
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        // O(1)
        public void union(int x, int y) {
            int p1 = find(x);
            int p2 = find(y);
            if (p1 == p2) {
                return;
            }
            if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else {
                // 相等时怎么样都可以,看自己的习惯
                parent[p2] = p1;
                rank[p1]++;
            }
        }
    }

    // 并查集结构,使用数组表示的并查集结构
    // spaceComplexity:O(2N)
    // timeComplexity:O(N)
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;
        // 因为是从1开始的,不是从0
        Union union = new Union(N + 1);
        for (int i = 0; i < N; i++) {
            int[] path = edges[i];
            int from = path[0];
            int to = path[1];
            if (union.find(to) != union.find(from)) {
                union.union(from, to);
            } else {
                return new int[]{from, to};
            }
        }
        return new int[]{};
    }
}
