/**
 * @Title: MinSpeedOnTime
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/2 11:05
 * @description: Leetcode 1870
 */
public class MinSpeedOnTime {
    // 提示是使用二分方法，但是我不知道怎么用二分法来解决这个问题
    // 刚开始搞一个特别大的速度?
    // 因为速度只能是整数，所以只能在1到最大速度之间进行搜索
    // 暴力方法,呆呆的
//    public int minSpeedOnTime(int[] dist, double hour) {
//        // 最小正整数就是1,所以从一开始搜索
//        // 题目中给出了最大速度是10000000，所以搜索范围是[1, 10000000]
//        // 对于第一趟列车，直接计算其行驶时间（距离除以速度），不需要考虑等待时间。
//        // 对于接下来的每一趟列车，如果前一趟列车在非整点到达，你需要将到达时间向上取整到下一个整点，这表示你在等待到下一个整点才能乘坐下一趟列车。
//        // 对于最后一趟列车，只需加上其行驶时间，不需要考虑等待时间，因为到达办公室后不需要再乘坐下一趟列车。
//        // 首先，由于除了最后一趟列车，前面的每趟列车至少花费 1 小时（算上等待时间），
//        // 且最后一趟列车花费的时间严格大于 0，
//        // 因此 hour 必须严格大于 n−1。若不满足则返回 −1。
//        if (dist.length > Math.ceil(hour)) {
//            return -1;
//        }
//        int L = 1;
//        int R = 10000000;
//        // 二分法搜索
//        while (L <= R) {
//            int M = L + ((R - L) >> 1);
//            // 先算出第一趟列车的行驶时间
//            double time = dist[0] / (double) M;
//            // 接下来算出后面的每一趟列车的行驶时间,除了最后一辆列车不用等待，
//            // 其他列车都要等待到下一个整点,所以要取上整
//            for (int i = 1; i < dist.length; i++) {
//                time = Math.max(time, Math.ceil(time));
//                // 如果是最后一趟列车的话，直接加上行驶时间即可
//                if (i == dist.length - 1) {
//                    time += dist[i] / (double) M;
//                    break;
//                }
//                time += dist[i] / (double) M;
//            }
//            // time小,说明时间快,缩小R范围
//            if (time <= hour) {
//                R = M - 1;
//            } else {
//                L = M + 1;
//            }
//        }
//        return L;
//    }

    // 灵神的方法
    // 灵神直接将hour乘100,从而避免了浮点数的运算，直接使用整数运算

    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        long h100 = Math.round(hour * 100); // 下面不会用到任何浮点数
        long delta = h100 - (n - 1) * 100;
        if (delta <= 0) { // 无法到达终点
            return -1;
        }

        int maxDist = 0;
        for (int d : dist) {
            maxDist = Math.max(maxDist, d);
        }
        if (h100 <= n * 100) { // 特判
            // 见题解中的公式
            return Math.max(maxDist, (int) ((dist[n - 1] * 100 - 1) / delta + 1));
        }

        int left = 0;
        int h = (int) (h100 / (n * 100));
        int right = (maxDist - 1) / h + 1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(mid, dist, h100)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int v, int[] dist, long h100) {
        int n = dist.length;
        long t = 0;
        for (int i = 0; i < n - 1; i++) {
            t += (dist[i] - 1) / v + 1;
        }
        return (t * v + dist[n - 1]) * 100 <= h100 * v;
    }


    public static void main(String[] args) {
        MinSpeedOnTime minSpeedOnTime = new MinSpeedOnTime();
        int[] dist = {1, 3, 2};
        double hour = 1.9;
        int result = minSpeedOnTime.minSpeedOnTime(dist, hour);
        System.out.println(result);
    }
}
