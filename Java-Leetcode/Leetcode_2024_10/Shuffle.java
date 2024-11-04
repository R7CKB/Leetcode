/**
 * @Title: Shuffle
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/10 12:39
 * @Description: Leetcode 1470 easy
 */
// leetcode: https://leetcode.cn/problems/shuffle-the-array/description/
public class Shuffle {
    // 本来的代码
//    public int[] shuffle(int[] nums, int n) {
//        int[] res = new int[nums.length];
//        int x = 0;
//        int y = n;
//        for (int i = 0; i < nums.length; i += 2) {
//            res[i] = nums[x];
//            res[i + 1] = nums[y];
//            x++;
//            y++;
//        }
//        return res;
//    }

    // 优化代码,只使用一个指针实现
//    public int[] shuffle(int[] nums, int n) {
//        int[] res = new int[nums.length];
//        int pointer = 0;
//        for (int i = 0; i < n; i++) {
//            res[pointer] = nums[i];
//            res[pointer + 1] = nums[i + n];
//            pointer += 2;
//        }
//        return res;
//    }

    // 位运算代码: 空间复杂度O(1)
    // 思路: 数据范围1000，只用到10个比特位，利用int剩余的22个比特位，暂存数据
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < 2 * n; i++) {
            // j刚开始为xi下标,后来为yi下标
            int j = i < n ? 2 * i : 2 * (i - n) + 1;// i是原始数据，j是数据的新下标
            nums[j] |= ((nums[i] & 1023) << 10);// 从nums[i]低10位上取出原数据，用nums[j]的11-20bit位来存
        }
        for (int i = 0; i < 2 * n; i++) nums[i] >>= 10;//右移10位，高位补0，只留下重新排列后的数据
        return nums;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        int[] nums = new int[]{2, 5, 1, 3, 4, 7};
        shuffle.shuffle(nums, 3);
    }

}
