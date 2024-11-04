package LeetCode_2024_9;

// leetcode: https://leetcode.cn/problems/find-the-town-judge/description/
public class FindJudge {
    public int findJudge(int N, int[][] trust) {
        // 小镇只有一个人, 且他不信任任何人, 则他是法官
        if (trust.length == 0 && N == 1) {
            return 1;
        }
        // 因为法官不信任任何人, 所以如果trust数组的长度等于N, 则不存在法官
        if (N == trust.length) {
            return -1;
        }
        // 将这个问题转换成为图的问题
        // trustCount为每个点的入度, notTrustCount为每个点的出度
        int[] trustCount = new int[N + 1];
        int[] notTrustCount = new int[N + 1];
        // 统计每个人信任的人数
        for (int[] t : trust) {
            notTrustCount[t[0]]++;
            trustCount[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            // 每个人(除了小镇法官)都信任这位小镇法官
            if (trustCount[i] == N - 1 && notTrustCount[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
