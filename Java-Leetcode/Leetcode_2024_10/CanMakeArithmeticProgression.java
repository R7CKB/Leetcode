import java.util.Arrays;

/**
 * Title: CanMakeArithmeticProgression
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/10/26 09:36
 * Description: Leetcode 1502 easy
 */
// leetcode: https://leetcode.cn/problems/can-make-arithmetic-progression-from-sequence/
public class CanMakeArithmeticProgression {
    // 排序方法
//    public boolean canMakeArithmeticProgression(int[] arr) {
//        Arrays.sort(arr);
//        int diff = arr[1] - arr[0];
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] - arr[i - 1] != diff) {
//                return false;
//            }
//        }
//        return true;
//    }

    // 大佬的方法
    public boolean canMakeArithmeticProgression(int[] arr) {
        /*
           arr = a1, a2, a3, a4
           假设arr是一个长度len为4的等差数列，元素的公差为d,即d=a4-a3=a3-a2=a2-a1
           最大值(max)-最小值(min)=(len-1)*d 即：a4-a1 = (4-1)*d -> d = (max - min) / (len -1)
           所以(max - min) % (len -1)一定等于0
         */
        int max = arr[0]; // 最大值
        int min = arr[0]; // 最小值
        for (int num : arr) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int diff = max - min;
        if (diff == 0){ // 最大值最小值差为零，说明数列的元素都相同，是公差为零的等差数列
            return true;
        }

        int len = arr.length; // 数列长度
        if (diff % (len - 1) != 0) { // 不满足(max - min) % (len -1) = 0，不是等差数列
            return false;
        }

        int d = (max - min) / (len - 1); // 求出公差
        /*
          给数列的每个元素都减去最小值 -> arr-min = 0, d, 2d, 3d
          数列的每个元素都会被d整除，(arr-min)/d = 0, 1, 2, 3
          可以看到(arr-min)/d结果是：0, 1, 2, 3 即 0, 1, 2 ··· len-2, len-1
          我们可以声明一个长度为len的数组arrSorted，初始值都为0
          遍历数组arr，令arrSorted[(arr[i]-min)/d]++，可得arrSorted的每个元素都会是1
         */
        int[] arrSorted = new int[len];

        for (int num : arr) {
            diff = num - min;
            if (diff % d != 0) { // 不能被整除，不是等差数列
                return false;
            }
            if (arrSorted[diff/d] > 0) { // arrSorted[(arr[i]-min)/d]大于0说明元素重复，不是等差数列
                return false;
            }
            arrSorted[diff/d]++; // 计数
        }

        return true; // 满足条件，是等差数列
    }
}
