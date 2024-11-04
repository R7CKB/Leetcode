/**
 * @Title: MinOperations
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/18 09:44
 * @Description: Leetocde 3191 medium
 */
// leetcode: https://leetcode.cn/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/
public class MinOperations {
    // 灵神的方法
    // 因为反转就是0变成1,1变成0,所以可以使用异或来完成该操作
    // 其实挺简单的,就是从左到右一直反转,但是为什么这样做是对的呢?
    // 正确性:
    // 问：为什么这样做是对的？
    // 答：
    // 先操作 i 再操作 j（i!=j），和先操作 j 再操作 i 的结果是一样的，
    // 所以操作顺序不影响答案。既然操作顺序无影响，我们可以从左到右操作。
    // 或者说，假设某种操作顺序是最优的，那么总是可以把这个操作顺序重排成从左到右操作。
    // 对于同一个 i，操作两次等于没有操作，所以同一个 i 至多操作一次。
    // 注：操作 i 指的是反转 i,i+1,i+2 这三个位置。
    // 结合上述两点，既然同一个 i 至多操作一次，那么从左到右操作的过程中，
    // 遇到 1 一定不能操作，遇到 0 一定要操作，所以从左到右的操作方式有且仅有一种。
    // 既然操作方式是唯一的，我们只需模拟这个过程。
    // 问：题目要求的「最少」体现在哪里？
    // 答：对同一个 i 至多操作一次，就可以做到最少的操作次数。
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) { // 必须操作
                nums[i + 1] ^= 1;
                nums[i + 2] ^= 1;
                ans++;
            }
        }
        return nums[n - 2] != 0 && nums[n - 1] != 0 ? ans : -1;
    }
}
