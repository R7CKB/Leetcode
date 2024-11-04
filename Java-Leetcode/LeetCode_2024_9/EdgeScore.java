package LeetCode_2024_9;

// leetcode链接:https://leetcode.cn/problems/node-with-highest-edge-score/description/
public class EdgeScore {
    // 先用笨方法来做
    // 因为数组长度可能会非常大,所以需要使用long类型来存储度数
    // 然后遍历数组,计算每个节点的度数,并更新最大度数和对应的节点
    public int edgeScore(int[] edges) {
        int N = edges.length;
        long max = 0;
        int res = 0;
        long[] degree = new long[N];
        for (int i = 0; i < N; i++) {
            degree[edges[i]] += i;
        }
        for (int i = 0; i < N; i++) {
            if (degree[i] > max) {
                max = degree[i];
            }
        }
        for (int i = 0; i < N; i++) {
            if (degree[i] == max) {
                res = i;
                break;
            }
        }
        return res;
    }

    // 优化方法
    public int edgeScore2(int[] edges) {
        int N = edges.length;
        int res = 0;
        long[] degree = new long[N];
        for (int i = 0; i < N; i++) {
            int index = edges[i];
            degree[index] += i;
            // 一步判断,直接优化
            // 如果当前节点度数大于最大度数或者等于最大度数且当前节点编号小于最大度数对应的节点编号,则更新最大度数和对应的节点编号
            if (degree[index] > degree[res] || degree[index] == degree[res] && index < res) {
                res = edges[i];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        EdgeScore edgeScore = new EdgeScore();
//        long[] edges = new long[]{1, 0, 0, 0, 0, 7, 7, 5};
        int[] edges = new int[]{1,0,0,0,0,7,7,5};
        edgeScore.edgeScore2(edges);
    }
}
