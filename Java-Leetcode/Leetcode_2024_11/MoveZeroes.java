/**
 * Title: MoveZeroes
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/7 09:19
 * Description: Leetcode 283 easy
 */
public class MoveZeroes {
    // 双指针法，将非零元素放到前面，零元素放到后面
    // 时间复杂度O(n^2),空间复杂度O(1)
    // 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, index, i);
                index++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
