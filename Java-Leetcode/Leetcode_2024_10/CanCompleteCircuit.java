/**
 * @Title: CanCompleteCircuit
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/6 09:36
 * @description: Leetcode 134 medium
 */
// leetcode: https://leetcode.cn/problems/gas-station/description/
public class CanCompleteCircuit {
    // 使用滑动窗口来解决这个问题,时间复杂度为O(N)
    // 滑动窗口
//    public int canCompleteCircuit(int[] gas, int[] cost) {
//        // 先判断是否有解,如果gas的总和小于等于cost的总和,存在唯一解,且只有一个起点,
//        // 但是如果gas的总和大于cost的总和,则无解
//        // 遍历一遍数组,时间复杂度为O(N)
//        int sum = 0;
//        for (int i = 0; i < gas.length; i++) {
//            sum += gas[i] - cost[i];
//        }
//        if (sum < 0) {
//            return -1;
//        }
//        // 在有解的情况下考虑问题的解决方案,将gas和cost都设为二倍长度,在这样就解决了数组越界和取余的问题
//        // 这样子做虽然可以,但是会增加时间,尤其对于大数组来说,时间复杂度会很高,所以抛弃这种方法,还是采用取余
//        int N = gas.length;
////        int[] newGas = new int[N * 2];
////        int[] newCost = new int[N * 2];
////        // 创建新数组,将gas和cost扩大两倍,这样就不会出现数组越界和取余的问题,时间复杂度为O(N)
////        for (int i = 0; i < N; i++) {
////            newGas[i] = gas[i];
////            newCost[i] = cost[i];
////            newGas[N + i] = gas[i];
////            newCost[N + i] = cost[i];
////        }
//        int curGas = 0;
//        int start = 0;
//        // 使用滑动窗口来解决这个问题,
//        for (int i = 0; i < N * 2; i++) {
//            // 计算每一回的curGas,这个curGas指的是能否从i到i+1号站点
//            curGas += gas[i % N] - cost[i % N];
//            if (curGas < 0) {
//                // 如果curGas小于0,说明不能到达下一个站点,需要重新开始计数
//                // 所以需要将start设置为i+1,curGas设置为0,重新开始计数
//                curGas = 0;
//                start = i + 1;
//            }
//            // if条件可以通过题目的例子得出,如果能到达最后一个站点,则返回start,否则返回-1
//            // 所以这里需要i-start+1==N来判断是否到达最后一个站点
//            if (i - start + 1 == N) {
//                return start;
//            }
//        }
//        return -1;
//    }


    // 灵神的方法
    // https://leetcode.cn/problems/gas-station/solutions/2933132/yong-zhe-xian-tu-zhi-guan-li-jie-pythonj-qccr/?envType=daily-question&envId=2024-10-06
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 根据作图可知找到油量最低时所处的加油站(3号加油站)，即为答案.
        int ans = 0;
        int minS = 0; // 最小油量
        // 刚开始的最小油量设置为 0
        int s = 0; // 油量
        for (int i = 0; i < gas.length; i++) { // 只需要循环一遍数组即可找出答案
            s += gas[i] - cost[i]; // 在 i 处加油，然后从 i 到 i+1
            // 如果s小于最小油量,说明从 i 到 i+1 之间不能到达下一个站点,需要重新开始计数
            if (s < minS) {
                minS = s; // 更新最小油量
                ans = i + 1; // 注意 s 减去 c 之后，汽车在 i+1 而不是 i
            }
        }
        // 循环结束后，s 即为 gas 之和减去 cost 之和
        // 如果有可行的答案的话,循环一遍数组,油量和花费的总和一定是0,否则为-1
        return s < 0 ? -1 : ans;
    }


    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        CanCompleteCircuit canCompleteCircuit = new CanCompleteCircuit();
        int result = canCompleteCircuit.canCompleteCircuit(gas, cost);
        System.out.println(result);
    }
}
