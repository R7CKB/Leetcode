/**
 * Title: FindIndices
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/27 10:08
 * Description: Leetcode 2903 easy
 */
// leetcode: https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/description/
public class FindIndices {
    // 暴力循环
//    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
//        int[] answer = new int[]{-1, -1};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (Math.abs(nums[i] - nums[j]) >= valueDifference
//                        && Math.abs(i - j) >= indexDifference) {
//                    answer[0] = i;
//                    answer[1] = j;
//                    return answer;
//                }
//            }
//        }
//        return answer;
//    }

    // 灵神的方法
    // 具体解析看:https://leetcode.cn/problems/find-indices-with-index-and-value-difference-i/solutions/2483162/on-zuo-fa-shuang-zhi-zhen-wei-hu-zui-da-rkbk9/
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIdx = 0;
        int minIdx = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            } else if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[maxIdx] - nums[j] >= valueDifference) {
                return new int[]{maxIdx, j};
            }
            if (nums[j] - nums[minIdx] >= valueDifference) {
                return new int[]{minIdx, j};
            }
        }
        return new int[]{-1, -1};
    }


}
