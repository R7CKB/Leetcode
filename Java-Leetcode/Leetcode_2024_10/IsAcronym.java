import java.util.ArrayList;
import java.util.List;

/**
 * @Title: IsAcronym
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/24 20:27
 * @Description: Leetcode 2828 easy
 */
// leetcode:
public class IsAcronym {
    // 暴力模拟
//    public boolean isAcronym(List<String> words, String s) {
//        String res = "";
//        for (int i = 0; i < words.size(); i++) {
//            res += words.get(i).charAt(0);
//        }
//        return s.equals(res);
//    }

    // 使用数组方法,只能确保次数而不能确保出现顺序
    // 所以排除

    // 增加一个长度判断
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsAcronym isAcronym = new IsAcronym();
        ArrayList<String> words = new ArrayList<>();
        words.add("alice");
        words.add("bob");
        words.add("charlie");
        System.out.println(isAcronym.isAcronym(words, "abc"));
    }
}
