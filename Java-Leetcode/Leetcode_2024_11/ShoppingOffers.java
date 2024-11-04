import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title: ShoppingOffers
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/3 10:58
 * Description: Leetcode 638 medium
 */
// leetcode: https://leetcode.cn/problems/shopping-offers/
public class ShoppingOffers {
    // 对于某个 need[i] 而言，既可以「单买」也可以使用「礼包形式购买」，
    // 同时两种购买方式都存在对「份数」的决策（单买多少份/买多少个相应的礼包）。
    // 利用物品数量和礼包数量数据范围都较少，我们可以先对「单买」情况进行预处理，
    // 将其转换为「礼包」形式。若 price[0]=100，则使用礼包 [1,0,0,...,0,100] 来代指。
    // 然后再预处理每个礼包最多选多少个，并使用哈希表进行存储。
    // 最后使用 DFS 对每个「礼包」如何选择进行爆搜即可。


    int ans = 0x3f3f3f3f;
    List<Integer> price, needs;
    List<List<Integer>> special;
    Map<Integer, Integer> map = new HashMap<>();
    int n, m;

    public int shoppingOffers(List<Integer> price,
                              List<List<Integer>> special,
                              List<Integer> needs) {
        this.price = price;
        this.special = special;
        this.needs = needs;
        n = price.size();
        // 初始化temp数组
        List<Integer> temp = new ArrayList<>();
        // temp数组存的是「单买」情况
        for (int i = 0; i < n; i++) temp.add(0);
        // 将所有单买情况转换为礼包形式
        for (int i = 0; i < n; i++) {
            List<Integer> clone = new ArrayList<>(temp);
            clone.set(i, 1);
            clone.add(price.get(i));
            special.add(clone);
        }
        // m为礼包数量
        m = special.size();
        for (int i = 0; i < m; i++) {
            List<Integer> x = special.get(i);
            int k = 0;
            for (int j = 0; j < n; j++) {
                int a = x.get(j), b = needs.get(j);
                // 如果某个物品栏数量为0，则该礼包不适用,直接跳过
                if (a == 0 || b == 0) continue;
                if (a > b) {
                    k = 0;
                    break;
                }
                k = k == 0 ? b / a : Math.min(k, b / a);
            }
            map.put(i, k);
        }
        dfs(0, needs, 0);
        return ans;
    }

    void dfs(int u, List<Integer> list, int cur) {
        if (cur >= ans) return;
        int cnt = 0;
        for (int i = 0; i < n; i++) cnt += list.get(i);
        if (cnt == 0) {
            ans = cur;
            return;
        }
        if (u == m) return;
        List<Integer> x = special.get(u);
        out:
        for (int k = 0; k <= map.get(u); k++) {
            List<Integer> clist = new ArrayList<>(list);
            for (int i = 0; i < n; i++) {
                int a = x.get(i), b = clist.get(i);
                if (a * k > b) break out;
                clist.set(i, b - a * k);
            }
            dfs(u + 1, clist, cur + k * x.get(n));
        }
    }
}
