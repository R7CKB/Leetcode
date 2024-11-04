/**
 * @Title: GetDecimalValue
 * @Author R7CKB
 * @Package PACKAGE_NAME
 * @Date 2024/10/23 09:05
 * @Description: Leetcode 1290 easy
 */
// leetcode: https://leetcode.cn/problems/convert-binary-number-in-a-linked-list-to-integer/description/
public class GetDecimalValue {


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // 暴力方法,遍历链表将所有的值都存储在字符串,然后再进行转换
//    public int getDecimalValue(ListNode head) {
//        StringBuilder str = new StringBuilder();
//        while (head != null) {
//            str.append(head.val);
//            head = head.next;
//        }
//        return Integer.valueOf(str.toString(), 2);
//    }

    // 暴力方法,遍历链表将所有的值都存储在数组中,然后再进行转换
//    public int getDecimalValue(ListNode head) {
//        int[] nums = new int[40];
//        int sum = 0;
//        int index = 0;
//        int m = 0;
//        while (head != null) {
//            nums[index++] = head.val;
//            head = head.next;
//        }
//        for (int i = index - 1; i >= 0; i--) {
//            sum += (int) (nums[i] * Math.pow(2, m));
//            m++;
//        }
//        return sum;
//    }

    // 使用移位运算符来解决问题
    public int getDecimalValue(ListNode head) {
        int res = 0;
        while (head != null) {
            res = (res << 1) + head.val;
            head = head.next;
        }
        return res;
    }
}
