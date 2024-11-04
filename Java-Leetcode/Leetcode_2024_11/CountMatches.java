import java.util.List;

/**
 * Title: CountMatches
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/4 09:23
 * Description: Leetcode 1773 easy
 */
public class CountMatches {
    // 暴力方法
//    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
//        int res = 0;
//        for (List<String> item : items) {
//            if(ruleKey.equals("type") && ruleValue.equals(item.get(0))){
//                res++;
//            }else if(ruleKey.equals("color") && ruleValue.equals(item.get(1))){
//                res++;
//            }else if(ruleKey.equals("name") && ruleValue.equals(item.get(2))){
//                res++;
//            }
//        }
//        return res;
//    }

    // 三叶的方法
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int ans = 0, idx = ruleKey.charAt(0) == 't' ? 0 : ruleKey.charAt(0) == 'c' ? 1 : 2;
        for (List<String> item : items) {
            if (item.get(idx).equals(ruleValue)) ans++;
        }
        return ans;
    }
}
