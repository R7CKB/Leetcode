import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Title: MinRefuelStops
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/7 10:30
 * @description: Leetcode 871 hard
 */
// leetcode: https://leetcode.cn/problems/minimum-number-of-refueling-stops/description/

/**
 * 自己没想出来,就直接看灵神的做法了.
 * 思路:
 * 当汽车行驶到第 i 个加油站时，视作获取了一个装有 fuel[i]升汽油的油桶。
 * 在后续的行驶过程中，可以在没油时，把油桶中的油加到汽车中。
 * 选哪个（哪些）油桶？
 * 为了让加油次数尽量少，贪心地选油量多的油桶。
 * 由于有添加和删除操作，用最大堆维护这些油桶。
 * 细节:
 * 可以把终点 target 视作一个虚拟加油站，加到 stations 末尾，
 * 这样可以用同样的代码处理最后一段路程（从最后一个加油站到终点）。
 */
public class MinRefuelStops {
    // 灵神的解法1(看油够不够的方法)
    // 对每一个加油站进行遍历,如果走到当前加油站时,剩余油量小于0,则需要加油,
    // 则需要在当前加油站之前加油,将其记录进result
    // 使用一个变量来记录之前行驶的距离(prePosition),如果没有,则为0,每到一个加油站,prePosition就会更新为加油站的位置
    // 还使用一个变量来记录目标的距离,每一次目标位置都是下一个加油站的位置,如果没有加油站的话,则为target
    // 使用一个变量来记录当前的油量,初始为0,每到一个加油站,就会减去行驶所需的油量,如果小于0,则需要加油
    // 使用一个最大堆来维护可以选择的油桶,将每一次加油站的油桶加入堆中,如果当前油量小于0,
    // 则需要从堆中选油,选油量最多的油桶,并将其油量加到当前油量中,
    // 如果无法到达终点,则返回-1
    // 时间复杂度:O(NlogN), N为加油站的数量
    // 空间复杂度:O(1)
//    public int minRefuelStops(int target, int startFuel, int[][] stations) {
//        int N = stations.length;
//        int result = 0;
//        // 之前的位置prePosition,刚开始为0
//        int prePosition = 0;
//        int curFuel = startFuel;
//        // 最大堆
//        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); //创建一个最大堆
//        for (int i = 0; i <= N; i++) {
//            // 现在的位置position,如果i<N,则为stations[i][0],否则为target
//            // 因为每一次加油,都会到达加油站所在位置,所以position的位置即为加油站的位置
//            int position = i < N ? stations[i][0] : target;
//            curFuel -= position - prePosition;  // 每行驶 1 英里用掉 1 升汽油
//            while (!pq.isEmpty() && curFuel < 0) { // 没油了
//                curFuel += pq.poll(); // 选油量最多的油桶
//                result++;
//            }
//            if (curFuel < 0) { // 无法到达
//                return -1;
//            }
//            pq.offer(i < N ? stations[i][1] : 0); // 留着后面加油
//            prePosition = position;
//        }
//        return result;
//    }

    // 灵神的解法2(看距离够不够)
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        int ans = 0;
        int miles = startFuel;
        PriorityQueue<Integer> fuelHeap = new PriorityQueue<>((a, b) -> b - a); // 最大堆
        for (int i = 0; i <= n; i++) {
            int position = i < n ? stations[i][0] : target;
            while (!fuelHeap.isEmpty() && miles < position) { // 没有足够的油到达 position
                miles += fuelHeap.poll(); // 选油量最多的油桶
                ans++;
            }
            if (miles < position) { // 无法到达
                return -1;
            }
            fuelHeap.offer(i < n ? stations[i][1] : 0); // 留着后面加油
        }
        return ans;
    }

    public static void main(String[] args) {
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
//        int target = 100;
//        int startFuel = 50;
//        int[][] stations = {{40, 50}};
        MinRefuelStops minRefuelStops = new MinRefuelStops();
        int result = minRefuelStops.minRefuelStops(target, startFuel, stations);
        System.out.println(result);
    }
}
