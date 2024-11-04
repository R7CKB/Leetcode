/**
 * @Title: FindNumbers
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/16 15:57
 * @Description: Leetcode 1295 easy
 */
// leetcode: https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/description/
public class FindNumbers {
    // nb,IDEA直接转成字符串更加方便操作
//    public int findNumbers(int[] nums) {
//        int count = 0;
//        for (int num : nums) {
//            if (String.valueOf(num).length() % 2 == 0) {
//                count++;
//            }
//        }
//        return count;
//    }

    // 试试我自己的暴力方法,因为数据量小,可以直接穷举
//    public int findNumbers(int[] nums) {
//        int count = 0;
//        for (int num : nums) {
//            // 双位数 >=10 && <=99
//            // 四位数 >=1000 && <=9999
//            // 六位数 >=100000 && <=999999
//            if ((num >= 10 && num <= 99) ||
//                (num >= 1000 && num <= 9999)||
//                (num >= 100000 && num <= 999999)) {
//                count++;
//            }
//        }
//        return count;
//    }

    // 还有一种方法是使用对数来进行判断,也比较快,是最好的算法
    // ✨✨✨
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if ((int) (Math.log10(num) + 1) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

}
