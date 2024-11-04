package LeetCode_2024_9;

import java.util.*;

/**
 * @Title: DistinctNames
 * @Author R7CKB
 * @Package LeetCode
 * @Date 2024/9/25 18:39
 * @description: Leetcode
 */
public class DistinctNames {
    // time complecity: O(n^2)
    // space complexity: O(1)
    // 暴力解法:就是按照题目描述的一步一步来,时间复杂度是O(n^2),空间复杂度是O(1)
//    public long distinctNames(String[] names) {
//        HashSet<String> set = new HashSet<>();
//        // 先将初始的所有名称加入set
//        Collections.addAll(set, names);
//        int count = 0;
//        // 最后返回的是set的大小减去初始的名称个数
//        for (String s : names) {
//            for (String name : names) {
//                String[] swapped = swapFirstAlphabet(s, name);
//                if (!set.contains(swapped[0]) && !set.contains(swapped[1])) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
//    public String[] swapFirstAlphabet(String s1, String s2) {
//        String first1 = s1.charAt(0) + "";
//        String first2 = s2.charAt(0) + "";
//        s1 = s1.replaceFirst(first1, first2);
//        s2 = s2.replaceFirst(first2, first1);
//        return new String[]{s1, s2};
//    }

    // 灵神的第一种方法:
    // 按照首字母分组,把 ideas 分成(至多)26组字符串。
    // 例如 ideas=[aa,ab,ac,bc,bd,be] 分成如下两组（只记录去掉首字母后的字符串）：
    // A 组（集合）：{a,b,c}。
    // B 组（集合）：{c,d,e}。
    // 分组后：
    // 从 A 中选一个不等于 c 的字符串，这有 2 种选法。
    // 从 B 中选一个不等于 c 的字符串，这有 2 种选法。
    // 考虑两个字符串的先后顺序（谁在左谁在右），有 2 种方法。
    // 根据乘法原理，有 2×2×2=8 对符合要求的字符串。
    // 由于无法选交集中的字符串，一般地，从 A 和 B 中可以选出
    // 2⋅(∣A∣−∣A∩B∣)⋅(∣B∣−∣A∩B∣)
    // 对符合要求的字符串。其中 ∣S∣ 表示集合 S 的大小。
    // 枚举所有组对，计算上式，累加到答案中。
//    public long distinctNames(String[] ideas) {
//        // 规定集合大小为26
//        Set<String>[] groups = new HashSet[26];
//        Arrays.setAll(groups, i -> new HashSet<>());
//        for (String s : ideas) {
//            groups[s.charAt(0) - 'a'].add(s.substring(1)); // 按照首字母分组
//        }
//
//        long ans = 0;
//        for (int a = 1; a < 26; a++) { // 枚举所有组对
//            for (int b = 0; b < a; b++) {
//                int m = 0; // 交集的大小
//                for (String s : groups[a]) {
//                    if (groups[b].contains(s)) {
//                        m++;
//                    }
//                }
//                ans += (long) (groups[a].size() - m) * (groups[b].size() - m);
//            }
//        }
//        return ans * 2; // 乘 2 放到最后
//    }

    // 第二种方法:
    // 下文把去掉首字母后的剩余部分称作后缀。
    //横看成岭侧成峰，换一个角度计算交集大小 ∣A∩B∣。
    //在遍历 ideas=[aa,ab,ac,bc,bd,be] 的过程中，当我们遍历到 bc 时，发现之前遍历过一个后缀也为 c 的字符串 ac，这就对交集大小 ∣A∩B∣ 产生了 1 的贡献，也就是交集大小 ∣A∩B∣ 增加 1。
    //具体来说，在遍历 ideas 的过程中，维护如下信息：
    //集合大小 size[a]。遍历到 s=ideas[i] 时，把 size[s[0]] 加一。
    //交集大小 intersection[a][b]。遍历到 s=ideas[i] 时，设 b=s[0]，把 intersection[a][b] 和 intersection[b][a] 加一，其中 a 是和 s 同后缀的其他字符串的首字母。
    //为了计算有哪些字符串和 s 有着相同的后缀，用一个哈希表 groups 维护，key 是后缀，value 是后缀对应的首字母列表。注意题目保证所有字符串互不相同。
    public long distinctNames(String[] ideas) {
        int[] size = new int[26]; // 集合大小
        int[][] intersection = new int[26][26]; // 交集大小
        Map<String, Integer> groups = new HashMap<>(); // 后缀 -> 首字母
        for (String s : ideas) {
            int b = s.charAt(0) - 'a';
            size[b]++; // 增加集合大小
            String suffix = s.substring(1);
            int mask = groups.getOrDefault(suffix, 0);
            groups.put(suffix, mask | 1 << b); // 把 b 加到 mask 中
            for (int a = 0; a < 26; a++) { // a 是和 s 有着相同后缀的字符串的首字母
                if ((mask >> a & 1) > 0) { // a 在 mask 中
                    intersection[b][a]++; // 增加交集大小
                    intersection[a][b]++;
                }
            }
        }

        long ans = 0;
        for (int a = 1; a < 26; a++) { // 枚举所有组对
            for (int b = 0; b < a; b++) {
                int m = intersection[a][b];
                ans += (long) (size[a] - m) * (size[b] - m);
            }
        }
        return ans * 2; // 乘 2 放到最后
    }

    public static void main(String[] args) {
        DistinctNames d = new DistinctNames();
        String[] names = {"coffee", "donuts", "time", "toffee"};
        System.out.println(d.distinctNames(names));
    }
}
