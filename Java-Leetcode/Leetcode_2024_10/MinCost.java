import java.util.*;

/**
 * @Title: MinCost
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/3 16:28
 * @description: Leetcode 1928 hard
 */
// leetcode: https://leetcode.cn/problems/minimum-cost-to-reach-destination-in-time/description/
// 视频链接: https://www.bilibili.com/video/BV1S945e7EjR
// cheated
public class MinCost {
    // 因为题目中给出不含有自环的图，而且边的权值是非负的，所以可以用Dijkstra算法求解
    // 我们需要维护两个数组,一个是distance数组,一个是cost数组,需要保证费用的最小
    // 比较器使用堆排序,堆排序使用递归方式费用的比较,所以需要自定义比较器
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<int[]>[] graph = new ArrayList[n]; // 用邻接表存储图
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], time = edge[2];
            graph[u].add(new int[] { v, time }); // 添加边 u -> v
            graph[v].add(new int[] { u, time }); // 添加边 v -> u
        }

        int[][] dist = new int[n][maxTime + 1]; // 初始化距离数组
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = passingFees[0]; // 起点费用

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[] { dist[0][0], 0, 0 }); // (最小费用, 当前节点, 累计时间)

        while (!pq.isEmpty()) {
            int cost = pq.peek()[0];
            int city = pq.peek()[1];
            int curTime = pq.peek()[2];
            pq.poll();

            for (int[] neighbor : graph[city]) {
                int nextCity = neighbor[0];
                int edgeTime = neighbor[1];
                int newCost = cost + passingFees[nextCity]; // 通行费
                int newTime = curTime + edgeTime; // 总时间

                if (newTime <= maxTime && newCost < dist[nextCity][newTime]) {
                    dist[nextCity][newTime] = newCost;
                    pq.offer(new int[] { newCost, nextCity, newTime });
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= maxTime; i++) {
            res = Math.min(res, dist[n - 1][i]);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
