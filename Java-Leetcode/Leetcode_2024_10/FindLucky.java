import java.util.HashMap;

/**
 * @Title: FindLucky
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/8 18:22
 * @description: Leetcode 1394 easy
 */
// leetcode: https://leetcode.cn/problems/find-lucky-integer-in-an-array/
public class FindLucky {
    // 暴力方法,使用哈希表,两层循环,时间复杂度O(n^2)
//    public int findLucky(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int lucky = -1;
//        for (int i : arr) {
//            map.put(i, map.getOrDefault(i, 0) + 1);
//        }
//        for (int i : arr) {
//            if (map.get(i) == i) {
//                lucky = Math.max(lucky, i);
//            }
//        }
//        return lucky;
//    }

    // 因为题目中说明数组的长度只有500,所以可以使用数组来代替哈希表,时间复杂度O(n)
    public int findLucky(int[] arr) {
        int[] count = new int[501];
        int lucky = -1;
        for (int i : arr) {
            count[i]++;
        }
        for (int i = 1; i < 501; i++) {
            if (count[i] == i) {
                lucky = Math.max(lucky, i);
            }
        }
        return lucky;
    }
}
