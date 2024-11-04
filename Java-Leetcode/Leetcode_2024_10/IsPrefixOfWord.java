/**
 * @Title: IsPrefixOfWord
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/10 19:46
 * @Description: Leetcode 1455 easy
 */
// leetcode: https://leetcode.cn/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/description/
public class IsPrefixOfWord {
    // 投机取巧,使用API进行判断
    // 这个方法太复杂了,应该还有更加简单的方法
//    public int isPrefixOfWord(String sentence, String searchWord) {
//        if (!sentence.contains(searchWord)) {
//            return -1;
//        }
//        String[] words = sentence.split(" ");
//        int index = 0;
//        for (String word : words) {
//            if (word.startsWith(searchWord)) {
//                return index + 1;
//            }
//            index++;
//        }
//        return -1;
//    }

    // 优化代码
//    public int isPrefixOfWord(String sentence, String searchWord) {
//        String[] words = sentence.split(" ");
//        int index = 0;
//        for (String word : words) {
//            if (word.startsWith(searchWord)) {
//                return index + 1;
//            }
//            index++;
//        }
//        return -1;
//    }

    // 采用不同的方法进行计算
    // leetcode题解,使用双指针法
    // 思路:
    // 使用 start 记录单词的起始，end 记录单词结尾的下一个位置。
    // 我们遍历字符串 sentence 并不断地分割单词，对于区间 [start,end) 对应的单词，
    // 判断它是否存在某一前缀等于 searchWord，
    // 如果存在直接返回该单词对应的下标 index；如果遍历完所有单词都不符合条件，返回 −1。
    // 时间复杂度：O(n)，其中 n 是 sentence 的长度。
    // 空间复杂度：O(1)，只使用了常数个变量。
    public int isPrefixOfWord(String sentence, String searchWord) {
        // n是整个字符串的长度，index是当前单词的下标，start和end是当前单词的起始和结尾位置
        int n = sentence.length(), index = 1, start = 0, end = 0;
        while (start < n) {
            // 找到当前单词的结尾位置
            while (end < n && sentence.charAt(end) != ' ') {
                end++;
            }
            if (isPrefix(sentence, start, end, searchWord)) {
                return index;
            }

            index++;
            end++;
            start = end;
        }
        return -1;
    }

    // 判断区间 [start,end) 对应的单词是否存在某一前缀等于 searchWord
    public boolean isPrefix(String sentence, int start, int end, String searchWord) {
        for (int i = 0; i < searchWord.length(); i++) {
            if (start + i >= end || sentence.charAt(start + i) != searchWord.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IsPrefixOfWord isPrefixOfWord = new IsPrefixOfWord();
        String sentence = "i love eating burger";
        String searchWord = "burg";
        System.out.println(isPrefixOfWord.isPrefixOfWord(sentence, searchWord));
    }

}
