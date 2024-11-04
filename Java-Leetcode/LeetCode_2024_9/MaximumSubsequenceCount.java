package LeetCode_2024_9;

/**
 * @Title: MaximumSubsequenceCount
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/24 11:10
 * @description: One question per day
 */
// leetcode: https://leetcode.cn/problems/maximize-number-of-subsequences-in-a-string/description/
public class MaximumSubsequenceCount {
    // 实际上只有插入text最前面和text最后面是最佳的选择,其余都一般
    // 应该把pattern[0]放在尽可能更靠前的位置,patter[1]放在尽可能靠后的位置
    // 还有一种情况需要注意的就是pattern[0]和pattern[1]可能是一样的字符
    // 这样可以使得pattern[0]和pattern[1]都出现在text的最前面或最后面,从而使得子序列的数量最大
    public long maximumSubsequenceCount(String text, String pattern) {
        // space complexity: O(1)
        // time complexity: O(n)
        char p1 = pattern.charAt(0);
        char p2 = pattern.charAt(1);
        long result = 0;
        // count1和count2统计pattern[0]和pattern[1]在text中出现的次数
        int count1 = 0;
        int count2 = 0;
        for (char c : text.toCharArray()) {
            if (c == p2) {
                result += count1;
                count2++;
            } 
            if (c == p1) {
                count1++;
            }
        }
        return result + Math.max(count1, count2);
    }

    public static void main(String[] args) {
        String text = "abcabc";
        String pattern = "ab";
        System.out.println(new MaximumSubsequenceCount().maximumSubsequenceCount(text, pattern));
    }
}
