package LeetCode_2024_9;

/**
 * @Title: MaxScoreSightseeingPair
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/23 10:53
 * @description: One question per day
 */
// leetcode: https://leetcode.cn/problems/best-sightseeing-pair/description/
public class MaxScoreSightseeingPair {
    // 因为最大值是values[i] + values[j] + i - j
    // 可以化简为values[i] + i + values[j] - j
    // 我们将values[i] + i的最值表示为max
    // 则只需要一个循环即可完成答案
    public int maxScoreSightseeingPair(int[] values) {
        int N = values.length;
        int maxScore = values[0];
        int res = 0;
        // 初始化dp数组
        for (int j = 1; j < N; j++) {
            res = res > maxScore + values[j] - j ? res : maxScore + values[j] - j;
            // 边维护边遍历
            maxScore = maxScore > values[j] + j ? maxScore : values[j] + j;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        MaxScoreSightseeingPair solution = new MaxScoreSightseeingPair();
        int result = solution.maxScoreSightseeingPair(values);
        System.out.println(result);
    }
}
