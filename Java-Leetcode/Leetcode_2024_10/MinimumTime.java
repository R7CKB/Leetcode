/**
 * @Title: MinimumTime
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/5 15:17
 * @description: Leetcode 2187 medium
 */
// leetcode : https://leetcode.cn/problems/minimum-time-to-complete-trips/description/

//这个感觉和之前那个minSpeedOnTime有点像,都是二分法，不过这次是求最小时间,而且数据范围比较大
// 因为该题目有单调性,所以可以使用二分法进行求解
// 当我们使用二分法进行求解的时候,题解的做法一般都是使用一个check函数来判断当前的M是否满足题目要求
public class MinimumTime {
    // 自己的做法
//    public long minimumTime(int[] time, int totalTrips) {
//        long L = 1;
//        long R = (long) 1e14; //就这块比较搞心态,看评论知道1e14即可
//        while (L < R) {
//            long M = L + ((R - L) >> 1);
//            if (check(M, time, totalTrips)) {
//                R = M;
//            } else {
//                L = M + 1;
//            }
//        }
//        return L;
//    }
//
//    // 判断t时间内是否可以完成 totalTrips次旅行
//    public boolean check(long t, int[] time, int totalTrips) {
//        long sum = 0;
//        for (int j : time) {
//            sum += t / j;
//        }
//        return sum >= totalTrips;
//    }


    // 灵神的做法
    // 具体可以看:
    // https://leetcode.cn/problems/minimum-time-to-complete-trips/solutions/1295955/er-fen-da-an-python-yi-xing-gao-ding-by-xwvs8/
    public long minimumTime(int[] time, int totalTrips) {
        // 刚开始做了优化，先求出最小和最大时间，然后求出平均时间，然后用二分法找出最小时间
        // 优化：先求出最大时间，然后求出平均时间，然后用二分法找出最小时间
        int minT = Integer.MAX_VALUE;
        int maxT = 0;
        for (int t : time) {
            minT = Math.min(minT, t);
            maxT = Math.max(maxT, t);
        }
        int avg = (totalTrips - 1) / time.length + 1;
        // 循环不变量：check(left) 恒为 false
        long left = (long) minT * avg - 1;
        // 循环不变量：check(right) 恒为 true
        long right = Math.min((long) maxT * avg, (long) minT * totalTrips);
        // 开区间 (left, right) 不为空
        while (left + 1 < right) {
            long mid = (left + right) >>> 1;
            if (check(mid, time, totalTrips)) {
                // 缩小二分区间为 (left, mid)
                right = mid;
            } else {
                // 缩小二分区间为 (mid, right)
                left = mid;
            }
        }
        // 此时 left 等于 right-1
        // check(left) = false 且 check(right) = true，所以答案是 right
        return right; // 最小的 true
    }

    private boolean check(long x, int[] time, int totalTrips) {
        long sum = 0;
        for (int t : time) {
            sum += x / t;
            if (sum >= totalTrips) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MinimumTime minimumTime = new MinimumTime();
        System.out.println(minimumTime.minimumTime(new int[]{10000}, 10000000));
    }
}
