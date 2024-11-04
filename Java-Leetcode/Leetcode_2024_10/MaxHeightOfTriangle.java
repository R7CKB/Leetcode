/**
 * @Title: MaxHeightOfTriangle
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/15 10:18
 * @Description: Leetcode 3200 easy
 */
// leetcode : https://leetcode.cn/problems/maximum-height-of-a-triangle/description/
public class MaxHeightOfTriangle {
    // 一眼就能看出，这是一个数学问题,先使用暴力求解法，再优化 0
    // 递归的笨方法
//    public int maxHeightOfTriangle(int red, int blue) {
//        return Math.max(height(red, blue, 1, true), height(red, blue, 1, false));
//    }
//
//    private int height(int red, int blue, int need, boolean isRed) {
//        if (isRed) {
//            if (red < need) {
//                return 0;
//            } else {
//                red -= need;
//                need += 1;
//                return 1 + height(red, blue, need, false);
//            }
//        } else {
//            if (blue < need) {
//                return 0;
//            } else {
//                blue -= need;
//                need += 1;
//                return 1 + height(red, blue, need, true);
//            }
//        }
//    }

    // 灵神的解法1: 枚举方法
//    public int maxHeightOfTriangle(int red, int blue) {
//        int[] cnt = new int[2];
//        for (int i = 1; ; i++) {
//            cnt[i % 2] += i;
//               // 红球为顶是否满足和蓝球为顶是否满足,如果不满足,则返回i-1
//            if ((cnt[0] > red || cnt[1] > blue) && (cnt[0] > blue || cnt[1] > red)) {
//                return i - 1;
//            }
//        }
//    }

    // 灵神的解法2: 数学解法
    // 解法详细: https://www.bilibili.com/video/BV16w4m1e7y3/?vd_source=35b5681fc62a8c45f1f678f6239f74ff
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(f(red, blue), f(blue, red));
    }

    private int f(int n, int m) {
        int odd = (int) Math.sqrt(n);
        int even = (int) ((Math.sqrt(m * 4 + 1) - 1) / 2);
        return odd > even ? even * 2 + 1 : odd * 2;
    }



    public static void main(String[] args) {
        MaxHeightOfTriangle maxHeightOfTriangle = new MaxHeightOfTriangle();
        System.out.println(maxHeightOfTriangle.maxHeightOfTriangle(2, 4));
    }
}
