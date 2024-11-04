/**
 * Title: SortArrayByParityII
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/3 15:25
 * Description: Leetcode 922 easy
 */
public class SortArrayByParityII {
    // 使用双指针，分别指向奇数和偶数的位置，然后交换
//    public int[] sortArrayByParityII(int[] nums) {
//        int i = 0;
//        int j = 1;
//        while (i < nums.length && j < nums.length) {
//            if (nums[i] % 2 == 0) {
//                i += 2;
//            } else if (nums[j] % 2 == 1) {
//                j += 2;
//            } else {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//                i += 2;
//                j += 2;
//            }
//        }
//        return nums;
//    }

    // 两次遍历的暴力方法
    public int[] sortArrayByParityII(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        int i = 0;
        int j = 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                res[i] = num;
                i += 2;
            } else {
                res[j] = num;
                j += 2;
            }
        }
        return res;
    }
}
