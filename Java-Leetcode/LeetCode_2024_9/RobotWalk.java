package LeetCode_2024_9;

// leetcode链接:https://leetcode.cn/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/description/
public class RobotWalk {
    int mod = (int) 1e9 + 7;

    // 递归版本,超时
    public int numberOfWays(int startPos, int endPos, int k) {
        if (k == 0) {
            return startPos == endPos ? 1 : 0;
        }
        return numberOfWays(startPos + 1, endPos, k - 1) +
                numberOfWays(startPos - 1, endPos, k - 1);
    }

    // 有两个可变参数,startPos和k,endPos是固定不变的.
    public int numberOfWaysDp(int startPos, int endPos, int k) {
        //先直接排除掉不可能的情况,根据其他答主的提示,可以排除掉最简单的情况,即用光k步也无法到达的情况
        // 还有一种情况就是起点和终点的奇偶性来判断的
        // 如果终点-起点的奇偶性和k的奇偶性不同,则无法到达终点,返回0
        // 这个可以很容易推断出来,如果k为奇数
        int distance = Math.abs(startPos - endPos);
        if (distance > k || distance % 2 != k % 2) {
            return 0;
        }
        // 构建dp数组,要注意的是数组范围,刚开始还不知道怎么设定范围(算法小白＞﹏＜)
        // 其实仔细一想就能知道,数组的最大长度肯定不会超过(startPos+k)*2+1
        // 因为最多只能走k步(无论向左还是向右),最多只能到达startPos+k步
        // 所以这里取(startPos+k)*2+1就行了,索引为[0,startPos+k]
        int[][] dp = new int[(startPos + k) * 2 + 1][k + 1];
        // 同理,因为可能会牵扯到负数,所以同时偏移起点和终点
        startPos += k;
        endPos += k;
        // dp表只有当startPos为endPos,且k为0时才有可能到达,所以初始化为1
        dp[endPos][0] = 1;
        // 当k=0时,只有endPos位置为1,其他位置为0,所以并不用管,只需要算从k=1开始的位置即可
        for (int rest = 1; rest <= k; rest++) {
            // 从最左侧直到最右侧初始化数组,需要注意不要越界
            for (int cur = startPos - k + 1; cur < startPos + k; cur++) {
                // 递推公式:dp[i][j] = dp[i-1][j-1] + dp[i+1][j-1]
                dp[cur][rest] = dp[cur - 1][rest - 1] + dp[cur + 1][rest - 1];
                // 因为数可能会很大,所以需要取模
                dp[cur][rest] %= mod;
            }
        }
        return dp[startPos][k];
    }

    public static void main(String[] args) {
        System.out.println(new RobotWalk().numberOfWays(989, 1000, 99));
        System.out.println(new RobotWalk().numberOfWays(1, 2, 3));
    }
}
