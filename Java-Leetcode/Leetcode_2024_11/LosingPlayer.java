/**
 * Title: LosingPlayer
 * Author: R7CKB
 * Package: PACKAGE_NAME
 * Date: 2024/11/5 09:09
 * Description: Leetcode 3222 easy
 */
public class LosingPlayer {
    // 只能是1个75和4个10元
    // 设 k=min(x,⌊y/4⌋)，这是能玩的回合数。
    // 判断 k 的奇偶性，奇数 Alice 胜，偶数 Bob 胜。
    public String losingPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 != 0 ? "Alice" : "Bob";
    }
}
