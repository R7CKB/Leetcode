/**
 * Title: SingleNonDuplicate
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/10 09:20
 * Description: Leetcode 540 medium
 */
public class SingleNonDuplicate {
    // 左神的方法,直接使用位运算,秒杀
    // 但是时间复杂度为O(n),空间复杂度为O(1)
    // 题目要求O(logn)时间复杂度,空间复杂度为O(1)
//    public int singleNonDuplicate(int[] nums) {
//        int res = 0;
//        for (int num : nums) {
//            res ^= num;
//        }
//        return res;
//    }

    // 三叶的遍历方法,因为是有序数组,所以可以这样做,但如果是一般的数组的话,就不能这样子做了
//    public int singleNonDuplicate(int[] nums) {
//        int n = nums.length;
//        for (int i = 0; i < n - 1; i += 2) {
//            if (nums[i] != nums[i + 1]) return nums[i];
//        }
//        return nums[n - 1];
//    }

    // 三叶的二分查找方法,时间复杂度为O(logn),空间复杂度为O(1)

    /**
     * 这道题的「二段性」分析需要一点点「脑筋急转弯」。
     * 由于给定数组有序且常规元素总是两两出现，因此如果不考虑“特殊”的单一元素的话，
     * 我们有结论：成对元素中的第一个所对应的下标必然是偶数，
     * 成对元素中的第二个所对应的下标必然是奇数。
     * 然后再考虑存在单一元素的情况，假如单一元素所在的下标为 x，
     * 那么下标 x 之前（左边）的位置仍满足上述结论，
     * 而下标 x 之后（右边）的位置由于 x 的插入，导致结论翻转。
     * 存在这样的二段性，指导我们根据当前二分点 mid 的奇偶性进行分情况讨论：
     * mid 为偶数下标：根据上述结论，正常情况下偶数下标的值会与下一值相同，
     * 因此如果满足该条件，可以确保 mid 之前并没有插入单一元素。
     * 正常情况下，此时应该更新 l=mid，否则应当让 r=mid−1，
     * 但需要注意这样的更新逻辑，会因为更新 r 时否决 mid 而错过答案，
     * 我们可以将否决 mid 的动作放到更新 l 的一侧，即需要将更新逻辑修改为 l=mid+1 和 r=mid ；
     * mid 为奇数下标：同理，根据上述结论，正常情况下奇数下标的值会与上一值相同，
     * 因此如果满足该条件，可以确保 mid 之前并没有插入单一元素，相应的更新 l 和 r。
     *
     * @param nums 数组
     * @return 单一元素
     */
//    public int singleNonDuplicate(int[] nums) {
//        int n = nums.length;
//        int l = 0, r = n - 1;
//        while (l < r) {
//            int mid = l + r >> 1;
//            if (mid % 2 == 0) {
//                if (mid + 1 < n && nums[mid] == nums[mid + 1]) l = mid + 1;
//                else r = mid;
//            } else {
//                if (mid - 1 >= 0 && nums[mid - 1] == nums[mid]) l = mid + 1;
//                else r = mid;
//            }
//        }
//        return nums[r];
//    }

    // 除此之外还有一种更加巧妙的方法,也是二分方法,不过使用了异或技巧
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] == nums[mid ^ 1]) l = mid + 1;
            else r = mid;
        }
        return nums[r];
    }



}
