/**
 * Title: FindMajorityElement
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/31 15:31
 * Description: 武汉佰钧成 Java工程师 Topic1
 */

/**
 * 题目描述:
 * 给一个长度为 n 的数组，数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组[1,2,3,2,2,2,5,4,2]。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2，如果不存在，则输出0。
 * 说明：数组输入非空，且有正解，无需考虑特殊情况
 * 数据范围：n<=50000，数组中元素的值 0<=val<=100000
 * <p>
 * 示例1:
 * 输入：[1,2,3,2,2,2,5,4,2]
 * 输出：2
 * <p>
 * 示例2:
 * 输入：[3,3,3,3,2,2,2]
 * 输出：3
 * <p>
 * 示例3:
 * 输入：[1]
 * 输出：1
 */
public class FindMajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int[] nums2 = {3, 3, 3, 3, 2, 2, 2};
        int[] nums3 = {1};
        System.out.println(findMajorityElement(nums1));
        System.out.println(findMajorityElement(nums2));
        System.out.println(findMajorityElement(nums3));
    }

    public static int findMajorityElement(int[] nums) {
        int majority = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
                count++;
            } else if (majority == num) {
                count++;
            } else {
                count--;
            }
        }


        int countMajority = 0;
        for (int num : nums) {
            if (num == majority) {
                countMajority++;
            }
        }
        if (countMajority > nums.length / 2) {
            return majority;
        } else {
            return 0;
        }
    }
}