import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Title: LastStoneWeight
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/3 11:35
 * Description: Leetcode 1046 easy
 */
public class LastStoneWeight {
    // 暴力排序法,Leetcode提示,使用堆排序
//    public int lastStoneWeight(int[] stones) {
//        // 降序排序的堆(最大堆)
//        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, (a, b) -> b - a);
//        for (int stone : stones) {
//            pq.offer(stone);
//        }
//        while (pq.size() > 1) {
//            int a = pq.poll();
//            int b = pq.poll();
//            if (a!= b) {
//                pq.offer(Math.abs(a - b));
//            }
//        }
//        return pq.isEmpty()? 0 : pq.poll();
//    }

    // 更快的方法
    public int lastStoneWeight(int[] stones) {
        // 先排序
        Arrays.sort(stones);
        for(int i = stones.length - 1; i > 0; i--) {
            stones[i - 1] = stones[i] - stones[i - 1];
            stones[i] = Integer.MAX_VALUE;
            Arrays.sort(stones);
        }
        return stones[0];
    }
}
