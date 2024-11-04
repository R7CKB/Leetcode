import java.util.Arrays;

/**
 * @Title: GetConcatenation
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/14 18:34
 * @Description: Leetcode 1929 easy
 */
// leetcode: https://leetcode.cn/problems/concatenation-of-array/description/
public class GetConcatenation {
    // 暴力解法,一个循环直接解决
    // 模拟方法,将数组拼接,返回新的数组
//    public int[] getConcatenation(int[] nums) {
//        int[] result = new int[nums.length * 2];
//        for (int i = 0; i < nums.length; i++) {
//            result[i] = nums[i];
//            result[i + nums.length] = nums[i];
//        }
//        return result;
//    }

    // STL(Standard Template Library)
    // 数组拼接,返回新的数组
    public int[] getConcatenation(int[] nums) {
        int N = nums.length;
        int[] result = Arrays.copyOf(nums, N * 2);
        System.arraycopy(nums, 0, result, N, N);
        return result;
    }
}
