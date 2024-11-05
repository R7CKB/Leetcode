import java.util.PriorityQueue;

/**
 * Title: GetFinalState
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/5 09:34
 * Description: Leetcode 3264 easy
 */
public class GetFinalState {
    // 暴力方法,嵌套循环
//    public int[] getFinalState(int[] nums, int k, int multiplier) {
//        int N = nums.length;
//        int min = N - 1;
//        while (k > 0) {
//            for (int i = N - 1; i >= 0; i--) {
//                min = nums[i] <= nums[min] ? i : min;
//            }
//            nums[min] *= multiplier;
//            k--;
//            min = N - 1;
//        }
//        return nums;
//    }

    // 这道题还有困难版本,以后再记录...

    // 大佬的做法
    // 当 multiplier=1 时，数组 nums 中的任何元素乘以 1 之后保持不变，
    // 因此等价于不执行操作，直接返回数组 nums。以下只考虑 multiplier>1 的情况。
    // 可以模拟对数组 nums 执行的 k 次操作。
    // 为了能快速定位到数组 nums 中的元素值最小且下标最小的元素，
    // 需要使用优先队列存储数组 nums 中的每个元素与下标组成的二元组，
    // 优先队列的队首元素是元素值最小的二元组，
    // 如果有多个元素值并列最小则优先队列的队首元素是元素值最小且下标最小的二元组。
    //
    // 首先遍历数组 nums 将每个元素与下标组成的二元组加入优先队列，
    // 然后执行 k 次操作。每次执行操作的做法如下。
    //
    // 取出优先队列的队首二元组，将该二元组中的下标记为 index。
    // 将 nums[index] 的值更新为 nums[index]×multiplier。
    // 将二元组 [nums[index],index] 加入优先队列。
    // 执行 k 次操作之后，数组 nums 即为结果数组。
    // 用 n 表示数组 nums 的长度。上述做法中，将数组 nums 中的每个元素与下标组成的二元组加入优先队列的时间是 O(nlogn)，执行每次操作的时间是 O(logn)，因此时间复杂度是 O((n+k)logn)。
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        if (multiplier == 1) {
            return nums;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
                (a, b) -> a[0] != b[0] ?
                        Integer.compare(a[0], b[0]) :
                        Integer.compare(a[1], b[1]));
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        while (k > 0) {
            int[] pair = pq.poll();
            int index = pair[1];
            nums[index] *= multiplier;
            pq.offer(new int[]{nums[index], index});
            k--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6};
        System.out.println(new GetFinalState().getFinalState(nums, 5, 2));
    }
}