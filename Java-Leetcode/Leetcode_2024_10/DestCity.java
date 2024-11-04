import java.util.*;

/**
 * @Title: DdestCity
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/8 16:30
 * @description: Leetcode 1436 easy
 */
// leetcode: https://leetcode.cn/problems/destination-city/description/
public class DestCity {
    // 暴力方法,使用哈希表解决问题,因为题目保证只会有一个终点
//    public String destCity(List<List<String>> paths) {
//        HashMap<String, String> map = new HashMap<>();
//        // 将所有的路径存入哈希表中
//        for (List<String> path : paths) {
//            map.put(path.get(0), path.get(1));
//        }
//        // 遍历哈希表,找到没有出现过的城市作为终点
//        for (String city : map.keySet()) {
//            if (!map.containsKey(map.get(city))) {
//                return map.get(city);
//            }
//        }
//        return null;
//    }

    // 灵神的做法1:两次遍历
//    public String destCity(List<List<String>> paths) {
//        Set<String> setA = new HashSet<>(paths.size()); // 预分配空间
//        for (List<String> p : paths) {
//            // 遍历 paths，把所有 cityA 保存到一个哈希集合 setA 中。
//            setA.add(p.get(0));
//        }
//        // 再次遍历 paths，如果发现 cityB  不在 setA 中，则立刻返回 cityB
//        for (List<String> p : paths) {
//            if (!setA.contains(p.get(1))) {
//                return p.get(1);
//            }
//        }
//        return null;
//    }

    // 灵神的做法2:一次遍历
    // 在方法一的基础上，额外维护一个哈希集合 setB，用来存储那些「可能是答案」的 cityB
    // 如果 cityA 在 setB 中，那么 cityA 必然不是答案，从 setB 中移除。
    // 代码实现时，可以简化为直接从 setB 中移除 cityA，无需检查其是否存在。
    // 如果 cityB 不在 setA 中，那么 cityB 有可能是答案，加到 setB 中。
    // 最后 setB 必然恰好剩下一个元素（题目保证），返回这个元素。
    public String destCity(List<List<String>> paths) {
        Set<String> setA = new HashSet<>(paths.size());
        Set<String> setB = new HashSet<>();
        for (List<String> p : paths) {
            String a = p.get(0);
            String b = p.get(1);
            setB.remove(a); // a 一定不是答案
            if (!setA.contains(b)) { // b 有可能是答案
                setB.add(b);
            }
            setA.add(a);
        }
        return setB.iterator().next();
    }

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("London", "New York"));
        paths.add(Arrays.asList("New York", "Lima"));
        paths.add(Arrays.asList("Lima", "Sao Paulo"));
        System.out.println(new DestCity().destCity(paths));

    }
}
