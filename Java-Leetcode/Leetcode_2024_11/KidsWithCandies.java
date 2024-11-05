import java.util.ArrayList;
import java.util.List;

/**
 * Title: KidsWithCandies
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/5 09:28
 * Description: Leetcode 1431 easy
 */
public class KidsWithCandies {
    // 暴力解法
//    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
//        int max = Integer.MIN_VALUE;
//        for (int candy : candies) {
//            if (candy > max) {
//                max = candy;
//            }
//        }
//        List<Boolean> result = new ArrayList<>();
//        for (int candy : candies) {
//            if (candy + extraCandies >= max) {
//                result.add(true);
//            } else {
//                result.add(false);
//            }
//        }
//        return result;
//    }

    // 灵神的简洁写法
    // 设 candies 的最大值为 mx。
    // 对于第 i 个孩子，如果把所有额外糖果都给他，满足
    // candies[i]+extraCandies≥mx 那么这个孩子就是有最多糖果的孩子。
    //代码实现时，为简化判断，可以计算出 k=mx−extraCandies，
    // 这样只要 candies[i]≥k 那么 ans[i] 就是 true。
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        int k = max - extraCandies;
        List<Boolean> res = new ArrayList<>(candies.length);
        for (int candy : candies) {
            res.add(candy >= k);
        }
        return res;
    }

}
