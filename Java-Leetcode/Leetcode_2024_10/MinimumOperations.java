/**
 * @Title: MinimumOperations
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/16 15:47
 * @Description: Leetcode 3190 easy
 */
// leetcode: https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/
public class MinimumOperations {
    // 看上去是求被3整除的数,实际上考的是取余
//    public int minimumOperations(int[] nums) {
//        int count = 0;
//        for (int num : nums) {
//            if (num % 3 == 0) {
//                continue;
//            } else {
//                count++;
//            }
//        }
//        return count;
//    }

    // 灵神的方法
    public int minimumOperations(int[] nums) {
        int count = 0;
        for (int num : nums) {
            count += (num % 3 == 0 ? 0 : 1);
        }
        return count;
    }
}
