import java.util.Arrays;
import java.util.HashSet;

/**
 * @Title: CanBeEqual
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/24 17:33
 * @Description: Leetcode 1460 easy
 */
// leetcode: https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-subarrays/
public class CanBeEqual {
    // 第一反应是使用集合来存储数据,但是发现不对,集合元素会有重复的
    // leetcode提示是使用排序来判断两个集合是否相同
//    public boolean canBeEqual(int[] target, int[] arr) {
//        Arrays.sort(target);
//        Arrays.sort(arr);
//        for (int i = 0; i < target.length; i++) {
//            if (target[i] != arr[i]) return false;
//        }
//        return true;
//    }

    // ✨✨✨
    // 三叶的方法
    // 当两数组词频相同，且翻转次数不受限制时，
    // 我们至少能通过「逐个调整」将一数组变为另一数组
    // （以当前需要调整的位置作为待翻转子数组的左端点，目标数值所在位置作为右端点）。
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = arr.length, tot = 0;
        int[] cnt = new int[1010];  // 1010为值域范围
        for (int i = 0; i < n; i++) {
            // cnt[target[i]] 表示 target[i] 这个元素在 target 数组中出现的次数。
            // 每次遇到 target[i]，就将 cnt[target[i]] 加 1。
            // 如果 cnt[target[i]] 从 0 变为 1，说明这个元素是第一次出现，因此 tot 加 1。
            //
            //cnt[arr[i]] 表示 arr[i] 这个元素在 arr 数组中出现的次数。
            // 每次遇到 arr[i]，就将 cnt[arr[i]] 减 1。
            // 如果 cnt[arr[i]] 从 1 变为 0，说明这个元素在 arr 数组中已经没有剩余，因此 tot 减 1。
            if (++cnt[target[i]] == 1) tot++;
            if (--cnt[arr[i]] == 0) tot--;
        }
        return tot == 0;
    }

    public static void main(String[] args) {
        CanBeEqual canBeEqual = new CanBeEqual();
        System.out.println(canBeEqual.canBeEqual(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
    }
}
