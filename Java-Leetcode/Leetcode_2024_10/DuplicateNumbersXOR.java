
/**
 * @Title: DuplicateNumbersXOR
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/12 18:52
 * @Description: Leetcode 3258 easy
 */
// leetcode: https://leetcode.cn/problems/find-the-xor-of-numbers-which-appear-twice/description/
public class DuplicateNumbersXOR {
    // 暴力方法,数据量小可以用,数据量大不行
    // 时间复杂度O(n^2),空间复杂度O(1)
//    public int duplicateNumbersXOR(int[] nums) {
//        int[] result = new int[51]; // 数字范围是1~50
//        int xor = 0;
//        for (int num : nums) {
//            result[num]++;
//        }
//        for (int i = 1; i <= 50; i++) {
//            if (result[i] == 2) {
//                xor ^= i;
//            }
//        }
//        return xor;
//    }

    // 使用哈希表实现,其实也和使用数组实现一样的,干虐可能会比数组更加浪费时间
    // 时间复杂度O(n^2),空间复杂度O(n)
//    public int duplicateNumbersXOR(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int xor = 0;
//        for (int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        for (int num : map.keySet()) {
//            if (map.get(num) == 2) {
//                xor ^= num;
//            }
//        }
//        return xor;
//    }

    // 能否在一次循环中就找出答案?
    // 评论中有使用一次循环的方法,将整数数组改为布尔数组即可实现
    // 时间复杂度O(n),空间复杂度O(1)
//    public int duplicateNumbersXOR(int[] nums) {
//        boolean[] seen = new boolean[51]; // 数字范围是1~50
//        int xor = 0;
//        for (int num : nums) {
//            if (!seen[num]) {
//                seen[num] = true;
//            } else {
//                xor ^= num;
//            }
//        }
//        return xor;
//    }

    // 灵神的做法
    // 因为nums的范围小,所以可以使用一个整数来记录出现的数字,
    // 时间复杂度O(n),空间复杂度O(1)
    public int duplicateNumbersXOR(int[] nums) {
        int res = 0;
        long seen = 0; //long有64位,可以记录50个数字的状态
        for (int num : nums) {
            if ((seen >> num & 1) > 0) { // num在seen中出现过
                res ^= num;
            } else {
                seen |= 1L << num;  // 把num加入seen,有些数只会加入一次
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3};
        System.out.println(new DuplicateNumbersXOR().duplicateNumbersXOR(nums));
    }

}
